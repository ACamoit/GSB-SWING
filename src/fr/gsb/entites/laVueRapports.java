package fr.gsb.entites;

import fr.gsb.entites.Visiteur;
import fr.gsb.vues.vueAccueil;
import fr.gsb.vues.vueRapports;

public class laVueRapports {

	private static laVueRapports session = null;
	private vueRapports vue;
	
	private laVueRapports( vueRapports vue ){
		super();
		this.vue = vue;
	}
	
	public static void ouvrir( vueRapports vue ){
		laVueRapports.session = new laVueRapports(vue);
	}
	
	public static void fermer(){
		laVueRapports.session=null;
	}
	
	public static laVueRapports getSession(){
		return laVueRapports.session;
	}
	
	public vueRapports getVueRapport(){
		return this.vue ;
	}
	
	@Override
	public String toString(){
		return "Session [Vue Rapports=" + vue + "]";
	}
	
	
	
}