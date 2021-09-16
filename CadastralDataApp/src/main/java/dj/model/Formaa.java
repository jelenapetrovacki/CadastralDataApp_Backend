package dj.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the formaa database table.
 * 
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler" })
@Entity
@NamedQuery(name="Formaa.findAll", query="SELECT f FROM Formaa f")
public class Formaa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FORMAA_FORMAAID_GENERATOR", sequenceName="FORMAA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FORMAA_FORMAAID_GENERATOR")
	private Integer formaaid;

	private Integer brdela;

	private String brlistanepokretnosti;

	private Integer brparcele;

	private String datumazurnosti;

	private String greska;

	private String katastarskaopstina;

	private String kultura;

	private Integer laksepopunjavanje;

	private String mbrkatastarskeopstine;

	private String mbropstine;

	private String obliksvojine1;

	private String obliksvojine2;

	private String opstina;

	private Integer podbrparcele;

	private Integer povrsina;

	private Integer povrsinadela;

	private Integer redosled;

	private String sluzba;

	private String udeo1;

	private String udeo2;

	private String ulica;

	private Integer vizuelniutisak;

	private String vlasnik1;

	private String vlasnik2;

	private String vremepopunjavanja;

	private String vrstaprava1;

	private String vrstaprava2;

	private String vrstazemljista;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	@JoinColumn(name="idkorisnik")
	private Korisnik korisnik;

	public Formaa() {
	}

	public Integer getFormaaid() {
		return this.formaaid;
	}

	public void setFormaaid(Integer formaaid) {
		this.formaaid = formaaid;
	}

	public Integer getBrdela() {
		return this.brdela;
	}

	public void setBrdela(Integer brdela) {
		this.brdela = brdela;
	}

	public String getBrlistanepokretnosti() {
		return this.brlistanepokretnosti;
	}

	public void setBrlistanepokretnosti(String brlistanepokretnosti) {
		this.brlistanepokretnosti = brlistanepokretnosti;
	}

	public Integer getBrparcele() {
		return this.brparcele;
	}

	public void setBrparcele(Integer brparcele) {
		this.brparcele = brparcele;
	}

	public String getDatumazurnosti() {
		return this.datumazurnosti;
	}

	public void setDatumazurnosti(String datumazurnosti) {
		this.datumazurnosti = datumazurnosti;
	}

	public String getGreska() {
		return this.greska;
	}

	public void setGreska(String greska) {
		this.greska = greska;
	}

	public String getKatastarskaopstina() {
		return this.katastarskaopstina;
	}

	public void setKatastarskaopstina(String katastarskaopstina) {
		this.katastarskaopstina = katastarskaopstina;
	}

	public String getKultura() {
		return this.kultura;
	}

	public void setKultura(String kultura) {
		this.kultura = kultura;
	}

	public Integer getLaksepopunjavanje() {
		return this.laksepopunjavanje;
	}

	public void setLaksepopunjavanje(Integer laksepopunjavanje) {
		this.laksepopunjavanje = laksepopunjavanje;
	}

	public String getMbrkatastarskeopstine() {
		return this.mbrkatastarskeopstine;
	}

	public void setMbrkatastarskeopstine(String mbrkatastarskeopstine) {
		this.mbrkatastarskeopstine = mbrkatastarskeopstine;
	}

	public String getMbropstine() {
		return this.mbropstine;
	}

	public void setMbropstine(String mbropstine) {
		this.mbropstine = mbropstine;
	}

	public String getObliksvojine1() {
		return this.obliksvojine1;
	}

	public void setObliksvojine1(String obliksvojine1) {
		this.obliksvojine1 = obliksvojine1;
	}

	public String getObliksvojine2() {
		return this.obliksvojine2;
	}

	public void setObliksvojine2(String obliksvojine2) {
		this.obliksvojine2 = obliksvojine2;
	}

	public String getOpstina() {
		return this.opstina;
	}

	public void setOpstina(String opstina) {
		this.opstina = opstina;
	}

	public Integer getPodbrparcele() {
		return this.podbrparcele;
	}

	public void setPodbrparcele(Integer podbrparcele) {
		this.podbrparcele = podbrparcele;
	}

	public Integer getPovrsina() {
		return this.povrsina;
	}

	public void setPovrsina(Integer povrsina) {
		this.povrsina = povrsina;
	}

	public Integer getPovrsinadela() {
		return this.povrsinadela;
	}

	public void setPovrsinadela(Integer povrsinadela) {
		this.povrsinadela = povrsinadela;
	}

	public Integer getRedosled() {
		return this.redosled;
	}

	public void setRedosled(Integer redosled) {
		this.redosled = redosled;
	}

	public String getSluzba() {
		return this.sluzba;
	}

	public void setSluzba(String sluzba) {
		this.sluzba = sluzba;
	}

	public String getUdeo1() {
		return this.udeo1;
	}

	public void setUdeo1(String udeo1) {
		this.udeo1 = udeo1;
	}

	public String getUdeo2() {
		return this.udeo2;
	}

	public void setUdeo2(String udeo2) {
		this.udeo2 = udeo2;
	}

	public String getUlica() {
		return this.ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public Integer getVizuelniutisak() {
		return this.vizuelniutisak;
	}

	public void setVizuelniutisak(Integer vizuelniutisak) {
		this.vizuelniutisak = vizuelniutisak;
	}

	public String getVlasnik1() {
		return this.vlasnik1;
	}

	public void setVlasnik1(String vlasnik1) {
		this.vlasnik1 = vlasnik1;
	}

	public String getVlasnik2() {
		return this.vlasnik2;
	}

	public void setVlasnik2(String vlasnik2) {
		this.vlasnik2 = vlasnik2;
	}

	public String getVremepopunjavanja() {
		return this.vremepopunjavanja;
	}

	public void setVremepopunjavanja(String vremepopunjavanja) {
		this.vremepopunjavanja = vremepopunjavanja;
	}

	public String getVrstaprava1() {
		return this.vrstaprava1;
	}

	public void setVrstaprava1(String vrstaprava1) {
		this.vrstaprava1 = vrstaprava1;
	}

	public String getVrstaprava2() {
		return this.vrstaprava2;
	}

	public void setVrstaprava2(String vrstaprava2) {
		this.vrstaprava2 = vrstaprava2;
	}

	public String getVrstazemljista() {
		return this.vrstazemljista;
	}

	public void setVrstazemljista(String vrstazemljista) {
		this.vrstazemljista = vrstazemljista;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	public String toString() {
			
			return formaaid +", " + brlistanepokretnosti+", "+mbropstine
				+","+opstina+","+mbrkatastarskeopstine+", "+katastarskaopstina+", "+datumazurnosti+
				", "+sluzba+", "+ulica+", "+brparcele+", "+podbrparcele+", "+povrsina+", "+brdela+
				", "+vrstazemljista+", "+kultura+", "+povrsinadela+", "+vlasnik1+", "+vrstaprava1+
				", "+obliksvojine1+", "+udeo1+", "+vlasnik2+", "+vrstaprava2+", "+obliksvojine2+
				", "+udeo2+", "+vremepopunjavanja+", "+greska+", "+redosled+", "+laksepopunjavanje+
				", "+vizuelniutisak+", "+korisnik.getKorisnikid();
			
		}

}