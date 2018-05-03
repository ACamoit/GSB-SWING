package fr.gsb.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import fr.gsb.entites.Visiteur;
import fr.gsb.entites.laVueRapports;
import fr.gsb.modeles.modeleGSB;
import fr.gsb.techniques.Session;
import fr.gsb.vues.vueConnexion;
import fr.gsb.vues.vueGSB;
import fr.gsb.vues.vueAccueil;

public class controleurAccueil implements ActionListener {
	
	
	
	private vueAccueil vue ;
	private vueGSB gsb;
	private Session session = Session.getSession();
	
	/** Constructeur
	 * @param vue Vue associée
	 */
	public controleurAccueil(vueAccueil vue){
		super() ;
		
		this.vue = vue ;
		this.gsb = this.vue.getGSB();
		this.enregistrerEcouteur() ;
	}
	
	/** Enregistrer le contrôleur en tant qu'écouteur
	 * 
	 */
	private void enregistrerEcouteur(){
		
		this.vue.getbDeconnecter().addActionListener( this );
		this.vue.getbRapportListe().addActionListener( this );
		this.vue.getbPratiHesitant().addActionListener( this );
	}

	
	
	public void actionPerformed(ActionEvent e) {
		Object sourceEvenement = e.getSource() ;
		
		if( sourceEvenement == this.vue.getbDeconnecter() ){	
			this.gsb.changerVue("vueConnexion");
			session.fermer();	
			this.gsb.setBarreMenusModeDeconnecte();
		}
		if( sourceEvenement == this.vue.getbRapportListe() ){
			gsb.changerVue("vueRapports");
			
		}
		
	} 
}