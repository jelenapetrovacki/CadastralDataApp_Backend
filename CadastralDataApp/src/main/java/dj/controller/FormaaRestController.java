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
import dj.model.Formaa;
import dj.repository.FormaaRepository;

@CrossOrigin
@RestController
public class FormaaRestController {

	@Autowired
	private FormaaRepository formaaRepository;

	@Autowired
	private EmailSenderService service;

	
	@GetMapping("formaa")
	public Collection<Formaa> getFormeA() {
		return formaaRepository.findAll();
	}

	// insert
	@PostMapping("formaa")
	public Formaa insertFormaA(@RequestBody Formaa formaa) {
		if (!formaaRepository.existsById(formaa.getFormaaid())) {
			System.out.println("ovo");
			System.out.println(formaa.getKultura());
			System.out.println("ovo"+formaa.getKorisnik());
			Formaa formaAVracena = formaaRepository.save(formaa);
			//System.out.println(formaAVracena.getKorisnik().getKorisnikid());
			
			service.sendSimpleEmail("cadastralapp@gmail.com",
					formaAVracena.toString(),
					"Forma A - korisnik sa ID-em: "
								+formaAVracena.getKorisnik().getKorisnikid().toString());

			
			return formaAVracena;
		}
		return null;
	}

	//update
	@PutMapping("formaa")
	public ResponseEntity<Formaa> updateFormaA(@RequestBody Formaa formaa) {
		if (!formaaRepository.existsById(formaa.getFormaaid())) {
			formaaRepository.save(formaa);
			return new ResponseEntity<Formaa>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Formaa>(HttpStatus.OK);
	}

}
