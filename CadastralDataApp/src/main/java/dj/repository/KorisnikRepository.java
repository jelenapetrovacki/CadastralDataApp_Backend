package dj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dj.model.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {

}
