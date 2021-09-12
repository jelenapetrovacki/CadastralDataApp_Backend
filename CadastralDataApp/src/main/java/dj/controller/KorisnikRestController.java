package dj.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dj.model.Formab;
import dj.model.Korisnik;
import dj.repository.KorisnikRepository;

@CrossOrigin
@RestController
public class KorisnikRestController {

	@Autowired
	private KorisnikRepository korisnikRepository;


	@GetMapping("korisnik/{id}")
	public Korisnik getKorisnikByID(@PathVariable("id") Integer id) {
		return korisnikRepository.getOne(id);
	}

	// insert
	@PostMapping("korisnik")
	public ResponseEntity<Korisnik> insertorisnik(@RequestBody Korisnik korisnik) {
		System.out.print("pre ifa");
		if (!korisnikRepository.existsById(korisnik.getKorisnikid())) {
			korisnikRepository.save(korisnik);
			System.out.print(korisnik);
			return new ResponseEntity<Korisnik>(HttpStatus.OK);
		}
		return new ResponseEntity<Korisnik>(HttpStatus.CONFLICT);
	}

	// update
	@PutMapping("korisnik")
	public ResponseEntity<Korisnik> updateKorisnik(@RequestBody Korisnik korisnik) {
		if (!korisnikRepository.existsById(korisnik.getKorisnikid())) {
			korisnikRepository.save(korisnik);
			return new ResponseEntity<Korisnik>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Korisnik>(HttpStatus.OK);
	}
}
