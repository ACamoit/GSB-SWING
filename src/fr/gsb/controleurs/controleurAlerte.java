package fr.gsb.controleurs;

import fr.gsb.modeles.modeleSQL;
import fr.gsb.techniques.Session;
import fr.gsb.vues.vueAlerteVisiteur;
import fr.gsb.vues.vueGSB;
import fr.gsb.vues.vueRapports;

public class controleurAlerte {

	private vueAlerteVisiteur vue ;
	private vueGSB gsb;
	private Session session = Session.getSession();
	private modeleSQL sql = new modeleSQL();
	
	public controleurAlerte(vueAlerteVisiteur vue){
		super();
		this.vue = vue;
		this.gsb = this.vue.getGSB();
	}
}
