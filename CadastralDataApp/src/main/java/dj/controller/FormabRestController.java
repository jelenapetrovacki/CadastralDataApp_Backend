package dj.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dj.EmailSenderService;
import dj.model.Formab;
import dj.repository.FormabRepository;

@CrossOrigin
@RestController
public class FormabRestController {

	@Autowired
	private FormabRepository formabRepository;
	
	@Autowired
	private EmailSenderService service;

	@GetMapping("formab")
	public Collection<Formab> getFormeA() {
		return formabRepository.findAll();
	}

	@PostMapping("formab")
	public ResponseEntity<Formab> insertFormaB(@RequestBody Formab formab) {
		if (!formabRepository.existsById(formab.getFormabid())) {
			Formab formaBVracena=formabRepository.save(formab);
			
			service.sendSimpleEmail("cadastralapp@gmail.com",
					formaBVracena.toString(),
					"Forma B - korisnik sa ID-em: "+formaBVracena.getKorisnik().getKorisnikid().toString());
			
			return new ResponseEntity<Formab>(HttpStatus.OK);
		}
		return new ResponseEntity<Formab>(HttpStatus.CONFLICT);
	}


	//update
	@PutMapping("formab")
	public ResponseEntity<Formab> updateFormaB(@RequestBody Formab formab) {
		if (!formabRepository.existsById(formab.getFormabid())) {
			formabRepository.save(formab);
			return new ResponseEntity<Formab>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Formab>(HttpStatus.OK);
	}

}
