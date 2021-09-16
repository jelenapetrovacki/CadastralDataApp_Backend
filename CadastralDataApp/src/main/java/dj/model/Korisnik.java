package dj.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the korisnik database table.
 * 
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler" })
@Entity
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="KORISNIK_KORISNIKID_GENERATOR", sequenceName="KORISNIK_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="KORISNIK_KORISNIKID_GENERATOR")
	private Integer korisnikid;

	private Integer brojsati;

	private Integer iskustvakatastar;

	private Integer iskustvaracunar;

	private String izabranaforma;

	private String komentar;

	private String pol;

	private Integer svakodnevnokoriscenje;

	//bi-directional many-to-one association to Formaa
	@JsonIgnore
	@OneToMany(mappedBy="korisnik")
	private List<Formaa> formaas;

	@JsonIgnore
	//bi-directional many-to-one association to Formab
	@OneToMany(mappedBy="korisnik")
	private List<Formab> formabs;

	//bi-directional many-to-one association to Starosnagrupa
	@ManyToOne
	@JoinColumn(name="idstarosnagrupa")
	private Starosnagrupa starosnagrupa;

	public Korisnik() {
	}

	public Integer getKorisnikid() {
		return this.korisnikid;
	}

	public void setKorisnikid(Integer korisnikid) {
		this.korisnikid = korisnikid;
	}

	public Integer getBrojsati() {
		return this.brojsati;
	}

	public void setBrojsati(Integer brojsati) {
		this.brojsati = brojsati;
	}

	public Integer getIskustvakatastar() {
		return this.iskustvakatastar;
	}

	public void setIskustvakatastar(Integer iskustvakatastar) {
		this.iskustvakatastar = iskustvakatastar;
	}

	public Integer getIskustvaracunar() {
		return this.iskustvaracunar;
	}

	public void setIskustvaracunar(Integer iskustvaracunar) {
		this.iskustvaracunar = iskustvaracunar;
	}

	public String getIzabranaforma() {
		return this.izabranaforma;
	}

	public void setIzabranaforma(String izabranaforma) {
		this.izabranaforma = izabranaforma;
	}

	public String getKomentar() {
		return this.komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}

	public String getPol() {
		return this.pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public Integer getSvakodnevnokoriscenje() {
		return this.svakodnevnokoriscenje;
	}

	public void setSvakodnevnokoriscenje(Integer svakodnevnokoriscenje) {
		this.svakodnevnokoriscenje = svakodnevnokoriscenje;
	}

	public List<Formaa> getFormaas() {
		return this.formaas;
	}

	public void setFormaas(List<Formaa> formaas) {
		this.formaas = formaas;
	}

	public Formaa addFormaa(Formaa formaa) {
		getFormaas().add(formaa);
		formaa.setKorisnik(this);

		return formaa;
	}

	public Formaa removeFormaa(Formaa formaa) {
		getFormaas().remove(formaa);
		formaa.setKorisnik(null);

		return formaa;
	}

	public List<Formab> getFormabs() {
		return this.formabs;
	}

	public void setFormabs(List<Formab> formabs) {
		this.formabs = formabs;
	}

	public Formab addFormab(Formab formab) {
		getFormabs().add(formab);
		formab.setKorisnik(this);

		return formab;
	}

	public Formab removeFormab(Formab formab) {
		getFormabs().remove(formab);
		formab.setKorisnik(null);

		return formab;
	}

	public Starosnagrupa getStarosnagrupa() {
		return this.starosnagrupa;
	}

	public void setStarosnagrupa(Starosnagrupa starosnagrupa) {
		this.starosnagrupa = starosnagrupa;
	}
	public String toString() {
			
			return korisnikid.toString()+","+pol+","+starosnagrupa.getStarosnagrupaid()+
					", "+iskustvaracunar+", "+brojsati+','+iskustvakatastar+
					", "+svakodnevnokoriscenje+","+izabranaforma;
			
	}


}