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
import fr.gsb.vues.vueVoirRapport;
import fr.gsb.vues.vueAccueil;

public class controleurVoirRapport implements ActionListener {
	
	
	
	private vueVoirRapport vue ;
	private vueGSB gsb;
	private modeleSQL sql = new modeleSQL();
	/** Constructeur
	 * @param vue Vue associée
	 */
	public controleurVoirRapport(vueVoirRapport vue){
		super() ;
		
		this.vue = vue ;
		this.enregistrerEcouteur() ;
	}
	
	/** Enregistrer le contrôleur en tant qu'écouteur
	 * 
	 */
	private void enregistrerEcouteur(){
		
		this.vue.getBtnQuitter().addActionListener( this );
	}

	
	
	public void actionPerformed(ActionEvent e) {
		Object sourceEvenement = e.getSource() ;

		if( sourceEvenement == this.vue.getBtnQuitter() ){
			this.vue.setVisible(false);
		}
		
	} 
}