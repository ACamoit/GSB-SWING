package fr.gsb.vues;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.gsb.controleurs.controleurAlerte;
import fr.gsb.entites.Visiteur;
import fr.gsb.entites.laVueAlerte;
import fr.gsb.modeles.modeleSQL;
import fr.gsb.modeles.modeleTableAlerte;

public class vueAlerteVisiteur extends JPanel {

	/**
	 * Create the panel.
	 */
	private modeleSQL sql = new modeleSQL();
	private JTable tableVisiteur;
	private JScrollPane scrollVisiteur;
	private laVueAlerte verouillerVue;
	private List<Visiteur> lesVisiteurs = null;
	private modeleTableAlerte modeleAlerte;
	private vueGSB gsb;
	private controleurAlerte ctrl = new controleurAlerte(this);
	
	public vueAlerteVisiteur(vueGSB gsb) {
		this.gsb = gsb;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alerte Visiteur");
		lblNewLabel.setForeground(new Color(1, 1, 1));
		lblNewLabel.setFont(new Font("Gentium", Font.BOLD, 31));
		lblNewLabel.setBounds(193, 12, 245, 46);
		add(lblNewLabel);
		
		lesVisiteurs  = sql.selectVisiteursAlerte();
		modeleAlerte = new modeleTableAlerte(lesVisiteurs);
		tableVisiteur = new JTable(modeleAlerte);
		tableVisiteur.setRowHeight(20);
		scrollVisiteur = new JScrollPane(tableVisiteur);
		scrollVisiteur.setPreferredSize(new Dimension(495, 150));
		scrollVisiteur.setBounds(52, 80, 495, 203);
		add(scrollVisiteur);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/home/developpeur/workspace/AppliRV/src/fr/gsb/img/8315_l.jpg"));
		label.setBounds(0, 0, 600, 400);
		add(label);

	}

	public modeleSQL getSql() {
		return sql;
	}

	public void setSql(modeleSQL sql) {
		this.sql = sql;
	}

	public JTable getTableVisiteur() {
		return tableVisiteur;
	}

	public void setTableVisiteur(JTable tableVisiteur) {
		this.tableVisiteur = tableVisiteur;
	}

	public JScrollPane getScrollVisiteur() {
		return scrollVisiteur;
	}

	public void setScrollVisiteur(JScrollPane scrollVisiteur) {
		this.scrollVisiteur = scrollVisiteur;
	}

	public laVueAlerte getVerouillerVue() {
		return verouillerVue;
	}

	public void setVerouillerVue(laVueAlerte verouillerVue) {
		this.verouillerVue = verouillerVue;
	}

	public modeleTableAlerte getModeleAlerte() {
		return modeleAlerte;
	}

	public void setModeleAlerte(modeleTableAlerte modeleAlerte) {
		this.modeleAlerte = modeleAlerte;
	}

	public vueGSB getGSB() {
		return gsb;
	}

	public void setGsb(vueGSB gsb) {
		this.gsb = gsb;
	}

	public controleurAlerte getCtrl() {
		return ctrl;
	}

	public void setCtrl(controleurAlerte ctrl) {
		this.ctrl = ctrl;
	}
	
	

}
