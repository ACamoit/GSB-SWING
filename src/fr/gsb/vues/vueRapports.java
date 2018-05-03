package fr.gsb.vues;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import fr.gsb.controleurs.controleurRapports;
import fr.gsb.editeurs.editeurBoutonVoirRapports;
import fr.gsb.entites.Rapport;
import fr.gsb.entites.laVueRapports;
import fr.gsb.modeles.modeleSQL;
import fr.gsb.modeles.modeleTableRapport;
import fr.gsb.rendus.renduBoutonVoirRapport;
import fr.gsb.rendus.renduTableRapport;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class vueRapports extends JPanel {
	private JComboBox cbVisiteurs;
	private modeleSQL sql = new modeleSQL();
	private vueGSB gsb;
	private controleurRapports ctrl = new controleurRapports(this);
	private JPanel pTable = null;
	private List<Rapport> lesRapports = null;
	private modeleTableRapport modeleRapport;
	private JTable tableRapport;
	private JScrollPane scrollRapport;
	private laVueRapports verouillerVue;
	private JComboBox annee = new JComboBox();
	private JComboBox mois = new JComboBox();


	/**
	 * Create the panel.
	 */
	public vueRapports(vueGSB gsb) {
		
		this.gsb = gsb;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Rapports de visite");
		lblNewLabel.setForeground(new Color(248, 248, 255));
		lblNewLabel.setFont(new Font("Gentium", Font.BOLD, 31));
		lblNewLabel.setBounds(193, 12, 245, 46);
		add(lblNewLabel);
		
		cbVisiteurs = sql.selectVisiteurs();
		cbVisiteurs.setBounds(96, 300, 114, 24);
		cbVisiteurs.setMaximumRowCount(5);
		add(cbVisiteurs);
		
		
		
		for(int i = 2017 ; i>=2000 ; i--){
			annee.addItem(i);
		}
		annee.setBounds(292, 300, 70, 24);
		annee.setMaximumRowCount(5);
		add(annee);
		
		for(int i = 1 ; i<=12 ; i++){
			mois.addItem(i);
		}
		mois.setMaximumRowCount(5);
		mois.setBounds(223, 300, 58, 24);
		add(mois);
		
		lesRapports = sql.selectRapports("a",1,1);
		modeleRapport = new modeleTableRapport(lesRapports);
		tableRapport = new JTable(modeleRapport);
		tableRapport.setRowHeight(20);
		scrollRapport = new JScrollPane(tableRapport);
		scrollRapport.setPreferredSize(new Dimension(495, 150));
		scrollRapport.setBounds(52, 80, 495, 203);
		add(scrollRapport);
		
		JButton btnNewButton = new JButton("Rechercher");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				raffraichirTableau();
			}
		});
		btnNewButton.setBounds(374, 300, 117, 25);
		add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/home/developpeur/workspace/AppliRV/src/fr/gsb/img/8315_l.jpg"));
		label.setBounds(0, 0, 600, 400);
		add(label);
		

		
		
		
		verouillerVue.ouvrir(this);
	}
	
	public void raffraichirTableau(){
		remove(scrollRapport);
		lesRapports = sql.selectRapports(cbVisiteurs.getSelectedItem().toString(),
							Integer.parseInt(mois.getSelectedItem().toString()),
							Integer.parseInt(annee.getSelectedItem().toString()));
		modeleRapport = new modeleTableRapport(lesRapports);
		tableRapport = new JTable(modeleRapport);
		tableRapport.setRowHeight(20);
		tableRapport.setDefaultRenderer(Object.class, new renduTableRapport());
		scrollRapport = new JScrollPane(tableRapport);
		scrollRapport.setPreferredSize(new Dimension(495, 150));
		scrollRapport.setBounds(52, 80, 495, 203);
		tableRapport.getColumn("Button").setCellRenderer(new renduBoutonVoirRapport());
		tableRapport.getColumn("Button").setCellEditor(new editeurBoutonVoirRapports());
		add(scrollRapport);
	}
	
	public JComboBox getAnnee() {
		return annee;
	}

	public void setAnnee(JComboBox annee) {
		this.annee = annee;
	}

	public JComboBox getMois() {
		return mois;
	}

	public void setMois(JComboBox mois) {
		this.mois = mois;
	}
	
	public modeleSQL getSql() {
		return sql;
	}

	public void setSql(modeleSQL sql) {
		this.sql = sql;
	}

	public vueGSB getGsb() {
		return gsb;
	}

	public void setGsb(vueGSB gsb) {
		this.gsb = gsb;
	}

	public controleurRapports getCtrl() {
		return ctrl;
	}

	public void setCtrl(controleurRapports ctrl) {
		this.ctrl = ctrl;
	}

	public JPanel getpTable() {
		return pTable;
	}

	public void setpTable(JPanel pTable) {
		this.pTable = pTable;
	}

	public List<Rapport> getLesRapports() {
		return lesRapports;
	}

	public void setLesRapports(List<Rapport> lesRapports) {
		this.lesRapports = lesRapports;
	}

	public modeleTableRapport getModeleRapport() {
		return modeleRapport;
	}

	public void setModeleRapport(modeleTableRapport modeleRapport) {
		this.modeleRapport = modeleRapport;
	}

	public JTable getTableRapport() {
		return tableRapport;
	}

	public void setTableRapport(JTable tableRapport) {
		this.tableRapport = tableRapport;
	}

	public JScrollPane getScrollRapport() {
		return scrollRapport;
	}

	public void setScrollRapport(JScrollPane scrollRapport) {
		this.scrollRapport = scrollRapport;
	}

	public vueGSB getGSB(){
		return this.gsb;
	}

	public JComboBox getCbVisiteurs() {
		return cbVisiteurs;
	}

	public void setCbVisiteurs(JComboBox cbVisiteurs) {
		this.cbVisiteurs = cbVisiteurs;
	}
}
