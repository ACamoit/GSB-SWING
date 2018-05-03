package fr.gsb.entites;

import java.sql.Date;

public class Rapport {
	
	private int numRapport;
	private String nomVisiteur;
	private String nomPraticien;
	private String rapDate;
	private String rapBilan;
	private String rapMotif;
	private String rapVille;
	private String rapEval;
	private String estVu;
	
	public Rapport(int numRapport, String nomVisiteur, String nomPraticien, String rapDate, String rapBilan,
			String rapMotif, String rapVille, String rapEval) {
		super();
		this.numRapport = numRapport;
		this.nomVisiteur = nomVisiteur;
		this.nomPraticien = nomPraticien;
		this.rapDate = rapDate;
		this.rapBilan = rapBilan;
		this.rapMotif = rapMotif;
		this.rapVille = rapVille;
		this.rapEval = rapEval;
	}
	
	public Rapport(int numRapport, String nomVisiteur, String nomPraticien, String rapDate, String rapBilan,
			String rapMotif, String rapVille, String rapEval, String estVu) {
		super();
		this.numRapport = numRapport;
		this.nomVisiteur = nomVisiteur;
		this.nomPraticien = nomPraticien;
		this.rapDate = rapDate;
		this.rapBilan = rapBilan;
		this.rapMotif = rapMotif;
		this.rapVille = rapVille;
		this.rapEval = rapEval;
		this.estVu = estVu;
	}
	public Boolean getEstVu() {
		if(estVu.equals("1")){
			return true;
		}
		else{
			return false;
		}
	}


	public int getNumRapport() {
		return numRapport;
	}
	public void setNumRapport(int numRapport) {
		this.numRapport = numRapport;
	}
	public String getNomVisiteur() {
		return nomVisiteur;
	}
	public void setNomVisiteur(String nomVisiteur) {
		this.nomVisiteur = nomVisiteur;
	}
	public String getNomPraticien() {
		return nomPraticien;
	}
	public void setNomPraticien(String nomPraticien) {
		this.nomPraticien = nomPraticien;
	}
	public String getRapDate() {
		return rapDate;
	}
	public void setRapDate(String rapDate) {
		this.rapDate = rapDate;
	}
	public String getRapBilan() {
		return rapBilan;
	}
	public void setRapBilan(String rapBilan) {
		this.rapBilan = rapBilan;
	}
	public String getRapMotif() {
		return rapMotif;
	}
	public void setRapMotif(String rapMotif) {
		this.rapMotif = rapMotif;
	}
	public String getRapVille() {
		return rapVille;
	}
	public void setRapVille(String rapVille) {
		this.rapVille = rapVille;
	}
	public String getRapEval() {
		return rapEval;
	}
	public void setRapEval(String rapEval) {
		this.rapEval = rapEval;
	}
	
	public String toString() {
		return "Rapport : Numéro : " + this.numRapport + " Visiteur : " + this.nomVisiteur + " Praticien : " + this.nomPraticien;
	}
	
	
}
