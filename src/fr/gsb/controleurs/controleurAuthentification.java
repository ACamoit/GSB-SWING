package fr.gsb.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import fr.gsb.entites.Visiteur;
import fr.gsb.modeles.modeleGSB;
import fr.gsb.modeles.modeleSQL;
import fr.gsb.techniques.Session;
import fr.gsb.vues.vueConnexion;
import fr.gsb.vues.vueGSB;
import fr.gsb.vues.vueModifierMDP;
import fr.gsb.vues.vueRapports;
import fr.gsb.vues.vueAccueil;

public class controleurAuthentification implements ActionListener {
	
	
	
	private vueConnexion vue ;
	private vueGSB gsb;
	private modeleSQL sql = new modeleSQL();
	/** Constructeur
	 * @param vue Vue associée
	 */
	public controleurAuthentification(vueConnexion vue){
		super() ;
		
		this.vue = vue ;
		this.gsb = this.vue.getGSB();
		this.enregistrerEcouteur() ;
	}
	
	/** Enregistrer le contrôleur en tant qu'écouteur
	 * 
	 */
	private void enregistrerEcouteur(){
		
		this.vue.getbConnecter().addActionListener( this );
	}

	
	
	public void actionPerformed(ActionEvent e) {
		Object sourceEvenement = e.getSource() ;
		
		//Test de connexion
		if( sourceEvenement == this.vue.getbConnecter() ){
			if(sql.connexionUser(this.vue.getLogin(), this.vue.getPassword()) == true){
				
				this.vue.getChLogin().setText("");
				this.vue.getChPassword().setText("");
				Session session = Session.getSession();
				System.out.println(session.toString());
				System.out.println(session.getLeVisiteur().getNom());
				
				gsb.setPageRapports(new vueRapports(gsb));
				gsb.getConteneur().add(gsb.getPageRapports(),"vueRapports");
				gsb.setPageAccueil(new vueAccueil(gsb));
				gsb.getConteneur().add(gsb.getPageAccueil(),"vueAccueil");
				gsb.setPageModifierMDP(new vueModifierMDP(gsb));
				gsb.getConteneur().add(gsb.getPageModifierMDP(),"vueModifierMDP");
				this.gsb.setBarreMenusModeConnecte();
				this.gsb.changerVue("vueAccueil");
				
			}
			//Echec de connexion
			else{
				JOptionPane.showMessageDialog(this.vue, "Echec de l'authentification, veuillez réessayer.","Authentification",JOptionPane.ERROR_MESSAGE) ;
				this.vue.getChPassword().setText("");
				
				
			}
			
			
			
			
		}
		
	} 
}
