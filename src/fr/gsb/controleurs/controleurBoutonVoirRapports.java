package fr.gsb.controleurs;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.gsb.modeles.modeleSQL;
import fr.gsb.modeles.modeleTableRapport;
import fr.gsb.rendus.renduBoutonVoirRapport;
import fr.gsb.rendus.renduTableRapport;
import fr.gsb.vues.vueRapports;
import fr.gsb.vues.vueVoirRapport;
import fr.gsb.editeurs.editeurBoutonVoirRapports;
import fr.gsb.entites.laVueRapports;

public class controleurBoutonVoirRapports implements ActionListener{

	private int row;
	private int matricule;
	private vueVoirRapport vue;
	private modeleSQL sql = new modeleSQL();
	private laVueRapports vueRapp = laVueRapports.getSession();
	private vueRapports vueR = vueRapp.getVueRapport();
	
	public void setRow(int row) {
		this.row = row;
	}
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}
	public void afficherMatricule(){
		System.out.println(this.matricule);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		afficherMatricule();
		this.vue = new vueVoirRapport(this.matricule) ;
		this.vue.setVisible(true);
		
		vueR.raffraichirTableau();
	}
		
	
}
