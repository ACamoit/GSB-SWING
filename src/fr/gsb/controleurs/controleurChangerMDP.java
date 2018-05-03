package fr.gsb.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import fr.gsb.techniques.Session;
import fr.gsb.vues.vueAccueil;
import fr.gsb.vues.vueGSB;
import fr.gsb.vues.vueModifierMDP;
import fr.gsb.vues.vueRapports;
import fr.gsb.modeles.modeleSQL;

public class controleurChangerMDP implements ActionListener {
	
	private vueGSB gsb;
	private vueModifierMDP vue;
	private Session session = Session.getSession();
	private modeleSQL sql = new modeleSQL();
	
	public controleurChangerMDP(vueModifierMDP vue){
		
		super();
		
		this.vue = vue;
		this.gsb = vue.getGsb();
		this.enregistrerEcouteur() ;
	}
	
	public void enregistrerEcouteur(){
		
		this.vue.getBtnAnnuler().addActionListener( this );
		this.vue.getBtnModifier().addActionListener( this );
	}

	
	
	public void actionPerformed(ActionEvent e) {
		Object sourceEvenement = e.getSource() ;
		
		if( sourceEvenement == this.vue.getBtnAnnuler() ){
			this.gsb.changerVue("vueAccueil");
		}
		
		if( sourceEvenement == this.vue.getBtnModifier() ){
			if(this.session.getLeVisiteur().getMdp().equals(this.vue.getTfAncienMDP().getText())){
				System.out.println("Ancien MDP: Ok");
				if(this.vue.getTfNouveauMDP1().getText().equals(this.vue.getTfNouveauMDP2().getText())){
					System.out.println("Nouveau MDP: Ok");
					this.sql.changerMdp(this.vue.getTfNouveauMDP1().getText(), session.getLeVisiteur().getMatricule());
					int reponse = JOptionPane.showConfirmDialog(this.vue,"Mot de passe changé avec succès","Quitter",JOptionPane.YES_OPTION) ;
					if( reponse == JOptionPane.YES_OPTION ){
						this.gsb.changerVue("vueAccueil");
					}
					
				}
				else{
					System.out.println("Nouveau MDP: Erreur");
				}
			}
			else{
				System.out.println("Ancien MDP: Erreur");
				System.out.println("Session : " + this.session.getLeVisiteur().getMdp());
				System.out.println("Textfield : " + this.vue.getTfAncienMDP().getText());
			}
		}
		
	} 
	
	
}
