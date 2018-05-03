package fr.gsb.controleurs;

import java.awt.event.ActionEvent;

import fr.gsb.modeles.modeleSQL;
import fr.gsb.techniques.Session;
import fr.gsb.vues.vueAccueil;
import fr.gsb.vues.vueGSB;
import fr.gsb.vues.vueRapports;

public class controleurRapports {
	
	
	
	private vueRapports vue ;
	private vueGSB gsb;
	private Session session = Session.getSession();
	private modeleSQL sql = new modeleSQL();
	
	/** Constructeur
	 * @param vue Vue associée
	 */
	public controleurRapports(vueRapports vue){
		super() ;
		
		this.vue = vue ;
		this.gsb = this.vue.getGSB();
		this.enregistrerEcouteur() ;
	}
	
	/** Enregistrer le contrôleur en tant qu'écouteur
	 * 
	 */
	private void enregistrerEcouteur(){
		
	}
	
	public void remplirCbVisiteurs(){
		this.vue.setCbVisiteurs(sql.selectVisiteurs());
	}

	
	
	public void actionPerformed(ActionEvent e) {
		Object sourceEvenement = e.getSource() ;
		
		//if( sourceEvenement == this.vue.getbDeconnecter() ){
			
		//}
		
	} 
}

