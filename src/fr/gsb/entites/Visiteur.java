package fr.gsb.entites;

import java.sql.Date;
import java.util.ArrayList;

import fr.gsb.modeles.modeleSQL;

public class Visiteur {
	
	private modeleSQL sql;
	private String matricule;
	private String nom;
	private String prenom;
	private String adresse;
	private String cp;
	private String ville;
	private String dateembauche;
	private String mdp;
	private String secCode = null;
	private String labCode = null;
	private static ArrayList<Visiteur> lesVisiteurs;
	private int objectif = 0;
	private int nbRapports = 0;
	
	public Visiteur(){
		this.peuplerVisiteur();
	}
	
	public Visiteur(String mat, String nom, String pre, String adr, String cp, String vil, String dat, String mdp, String lab, int objectif, int nbRapports){
		this.matricule = mat;
		this.nom = nom;
		this.prenom = pre;
		this.adresse = adr;
		this.cp = cp;
		this.ville = vil;
		this.dateembauche = dat;
		this.mdp = mdp;
		this.labCode = lab;
		this.objectif = objectif;
		this.nbRapports = nbRapports;
	}
	
	public Visiteur(String mat, String nom, String pre, String adr, String cp, String vil, String dat, String mdp, String lab){
		this.matricule = mat;
		this.nom = nom;
		this.prenom = pre;
		this.adresse = adr;
		this.cp = cp;
		this.ville = vil;
		this.dateembauche = dat;
		this.mdp = mdp;
		this.labCode = lab;
	}
	
	public Visiteur(String mat, String nom, String pre, String adr, String cp, String vil, String dat, String mdp){
		this.matricule = mat;
		this.nom = nom;
		this.prenom = pre;
		this.adresse = adr;
		this.cp = cp;
		this.ville = vil;
		this.dateembauche = dat;
		this.mdp = mdp;
	}
	
	
	
	public Visiteur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public modeleSQL getSql() {
		return sql;
	}

	public void setSql(modeleSQL sql) {
		this.sql = sql;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getDateembauche() {
		return dateembauche;
	}

	public void setDateembauche(String dateembauche) {
		this.dateembauche = dateembauche;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getSecCode() {
		return secCode;
	}

	public void setSecCode(String secCode) {
		this.secCode = secCode;
	}

	public String getLabCode() {
		return labCode;
	}

	public void setLabCode(String labCode) {
		this.labCode = labCode;
	}

	public ArrayList<Visiteur> getLesVisiteurs() {
		return lesVisiteurs;
	}

	public void setLesVisiteurs(ArrayList<Visiteur> lesVisiteurss) {
		lesVisiteurs = lesVisiteurss;
	}

	
	

	public int getObjectif() {
		return objectif;
	}

	public void setObjectif(int objectif) {
		this.objectif = objectif;
	}

	public int getNbRapports() {
		return nbRapports;
	}

	public void setNbRapports(int nbRapports) {
		this.nbRapports = nbRapports;
	}

	@Override
	public String toString() {
		return "Visiteur [matricule=" + matricule + ", nom=" + nom + ", mdp=" + mdp + "]";
	}

	private void peuplerVisiteur(){
		//this.lesVisiteurs = sql.selectVisiteurs();
	}
}
