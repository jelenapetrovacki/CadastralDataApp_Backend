package dj.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the starosnagrupa database table.
 * 
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler" })
@Entity
@NamedQuery(name="Starosnagrupa.findAll", query="SELECT s FROM Starosnagrupa s")
public class Starosnagrupa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer starosnagrupaid;

	private Integer donjagr;

	private Integer gornjagr;

	//bi-directional many-to-one association to Korisnik
	@JsonIgnore
	@OneToMany(mappedBy="starosnagrupa")
	private List<Korisnik> korisniks;

	public Starosnagrupa() {
	}

	public Integer getStarosnagrupaid() {
		return this.starosnagrupaid;
	}

	public void setStarosnagrupaid(Integer starosnagrupaid) {
		this.starosnagrupaid = starosnagrupaid;
	}

	public Integer getDonjagr() {
		return this.donjagr;
	}

	public void setDonjagr(Integer donjagr) {
		this.donjagr = donjagr;
	}

	public Integer getGornjagr() {
		return this.gornjagr;
	}

	public void setGornjagr(Integer gornjagr) {
		this.gornjagr = gornjagr;
	}

	public List<Korisnik> getKorisniks() {
		return this.korisniks;
	}

	public void setKorisniks(List<Korisnik> korisniks) {
		this.korisniks = korisniks;
	}

	public Korisnik addKorisnik(Korisnik korisnik) {
		getKorisniks().add(korisnik);
		korisnik.setStarosnagrupa(this);

		return korisnik;
	}

	public Korisnik removeKorisnik(Korisnik korisnik) {
		getKorisniks().remove(korisnik);
		korisnik.setStarosnagrupa(null);

		return korisnik;
	}

}