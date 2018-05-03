package fr.gsb.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import fr.gsb.techniques.Session;
import fr.gsb.vues.vueGSB;

public class controleurGSB implements ActionListener  {
	
	private vueGSB vue;
	private Session session = Session.getSession();
	
	public controleurGSB(vueGSB vue){
		super() ;
		
		this.vue = vue ;
		this.enregistrerEcouteur() ;
	}
	
	/** Enregistrer le contrôleur en tant qu'écouteur
	 * 
	 */
	private void enregistrerEcouteur(){
		
		this.vue.getItemQuitter().addActionListener( this );
		this.vue.getMntmModifierMdp().addActionListener( this );
		this.vue.getMntmDeconnexion().addActionListener( this );
		this.vue.getMntmAccueil().addActionListener( this );
		this.vue.getMntmRapports().addActionListener( this );
		
	}

	
	
	public void actionPerformed(ActionEvent e) {
		Object sourceEvenement = e.getSource() ;

		if( sourceEvenement == this.vue.getItemQuitter() ){		
			int reponse = JOptionPane.showConfirmDialog(this.vue,"Voulez-vous vraiment quitter ?","Quitter",JOptionPane.YES_OPTION) ;
			if( reponse == JOptionPane.YES_OPTION ){
				System.exit(0) ;
			}
		}
		if( sourceEvenement == this.vue.getMntmAccueil() ){
			vue.changerVue("vueAccueil");
		}
		if( sourceEvenement == this.vue.getMntmDeconnexion() ){
			this.vue.changerVue("vueConnexion");
			session.fermer();	
			this.vue.setBarreMenusModeDeconnecte();
		}
		if( sourceEvenement == this.vue.getMntmModifierMdp() ){
			this.vue.changerVue("vueModifierMDP");
		}
		if( sourceEvenement == this.vue.getMntmRapports() ){
			vue.changerVue("vueRapports");
		}
		
	} 
}
