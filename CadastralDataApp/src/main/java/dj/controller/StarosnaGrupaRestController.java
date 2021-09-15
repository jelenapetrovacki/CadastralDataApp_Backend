package dj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dj.model.Starosnagrupa;
import dj.repository.StarosnaGrupaRepository;

@CrossOrigin
@RestController
public class StarosnaGrupaRestController {

	@Autowired
	private StarosnaGrupaRepository starosnaGrupaRepository;
	
	@GetMapping("/starosnaGrupa/{id}")
	public Starosnagrupa getStarosnaGrupaByID(@PathVariable("id") Integer id) {
		return starosnaGrupaRepository.getOne(id);
	}
}
