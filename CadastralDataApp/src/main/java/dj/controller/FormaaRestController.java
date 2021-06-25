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

import dj.model.Formaa;
import dj.repository.FormaaRepository;

@CrossOrigin
@RestController
public class FormaaRestController {

	@Autowired
	private FormaaRepository formaaRepository;

	@GetMapping("formaa")
	public Collection<Formaa> getFormeA() {
		return formaaRepository.findAll();
	}

	// insert
	@PostMapping("formaa")
	public ResponseEntity<Formaa> insertFormaA(@RequestBody Formaa formaa) {
		if (!formaaRepository.existsById(formaa.getFormaaid())) {
			formaaRepository.save(formaa);
			return new ResponseEntity<Formaa>(HttpStatus.OK);
		}
		return new ResponseEntity<Formaa>(HttpStatus.CONFLICT);
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
