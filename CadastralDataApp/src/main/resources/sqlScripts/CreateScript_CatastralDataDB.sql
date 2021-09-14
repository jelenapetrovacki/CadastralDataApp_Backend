DROP TABLE IF EXISTS formaa CASCADE;
DROP TABLE IF EXISTS formab CASCADE;
DROP TABLE IF EXISTS korisnik CASCADE;
DROP TABLE IF EXISTS starosnaGrupa CASCADE;
DROP SEQUENCE IF EXISTS formaa_seq;
DROP SEQUENCE IF EXISTS formab_seq;
DROP SEQUENCE IF EXISTS korisnik_seq;

create table formaA (
	formaAID integer primary key,
	brListaNepokretnosti varchar(10),
	mbrOpstine varchar(10),
	opstina varchar(20),
	mbrKatastarskeOpstine varchar(20),
	katastarskaOpstina varchar(20),
	datumAzurnosti varchar(15),
	sluzba varchar(20),
	ulica varchar(20),
	brParcele integer,
	podbrParcele integer,
	povrsina integer,
	brDela integer,
	vrstaZemljista varchar(40),
	kultura varchar(40),
	povrsinaDela integer,
	vlasnik1 varchar(30),
	vrstaPrava1 varchar(20),
	oblikSvojine1 varchar(20),
	udeo1 varchar(5),
	vlasnik2 varchar(30),
	vrstaPrava2 varchar(20),
	oblikSvojine2 varchar(20),
	udeo2 varchar(5),
	vremePopunjavanja varchar(10),
	greska varchar(10),
	redosled integer,
	laksePopunjavanje integer,
	vizuelniUtisak integer,
	idKorisnik integer
	
);
create table formaB (
	formaBID integer primary key,
	brListaNepokretnosti varchar(10),
	mbrOpstine varchar(10),
	opstina varchar(20),
	mbrKatastarskeOpstine varchar(20),
	katastarskaOpstina varchar(20),
	datumAzurnosti varchar(15),
	sluzba varchar(20),
	ulica varchar(20),
	brParcele integer,
	podbrParcele integer,
	povrsina integer,
	brDela integer,
	vrstaZemljista varchar(40),
	kultura varchar(40),
	povrsinaDela integer,
	vlasnik1 varchar(30),
	vrstaPrava1 varchar(20),
	oblikSvojine1 varchar(20),
	udeo1 varchar(5),
	vlasnik2 varchar(30),
	vrstaPrava2 varchar(20),
	oblikSvojine2 varchar(20),
	udeo2 varchar(5),
	vremePopunjavanja varchar(10),
	greska varchar(10),
	redosled integer,
	laksePopunjavanje integer,
	vizuelniUtisak integer,
	idKorisnik integer
	
);

create table korisnik (
	korisnikID integer primary key,
	pol varchar(1),
	idStarosnaGrupa integer,
	iskustvaRacunar integer,
	brojSati integer,
	iskustvaKatastar integer,
	svakodnevnoKoriscenje integer,
	izabranaForma varchar(10),
	komentar varchar(100)
	
);

create table starosnaGrupa (
	starosnaGrupaID integer primary key,
	donjaGr integer,
	gornjaGr integer
);
ALTER TABLE formaA ADD CONSTRAINT fk_formaA_korisnik FOREIGN KEY(idKorisnik) REFERENCES korisnik(korisnikID);
ALTER TABLE formaB ADD CONSTRAINT fk_formaB_korisnik FOREIGN KEY(idKorisnik) REFERENCES korisnik(korisnikID);
ALTER TABLE korisnik ADD CONSTRAINT fk_korisnik_starGr FOREIGN KEY(idStarosnaGrupa) REFERENCES starosnaGrupa(starosnaGrupaID);

CREATE SEQUENCE formaA_seq INCREMENT 1;
CREATE SEQUENCE formaB_seq INCREMENT 1;
CREATE SEQUENCE korisnik_seq INCREMENT 1;