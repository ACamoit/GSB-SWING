package fr.gsb.vues;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;

import fr.gsb.controleurs.controleurAuthentification;
import fr.gsb.controleurs.controleurChangerMDP;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class vueModifierMDP extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private vueGSB gsb;
	private JPasswordField tfAncienMDP;
	private JPasswordField tfNouveauMDP1;
	private JPasswordField tfNouveauMDP2;
	private JLabel lblNouveauMdp;
	private JLabel label_1;
	private JButton btnAnnuler;
	private JButton btnModifier;
	private controleurChangerMDP controleur;
	
	public vueModifierMDP(vueGSB gsb) {
		this.gsb = gsb;
		//this.controleur = new controleurChangerMDP(this);
		setLayout(null);
		
		JLabel lblChangementDeMot = new JLabel("Changement de mot de passe");
		lblChangementDeMot.setForeground(Color.WHITE);
		lblChangementDeMot.setBackground(Color.WHITE);
		lblChangementDeMot.setFont(new Font("Gentium", Font.BOLD, 31));
		lblChangementDeMot.setBounds(98, 43, 411, 46);
		add(lblChangementDeMot);
		
		tfAncienMDP = new JPasswordField();
		tfAncienMDP.setBounds(283, 149, 233, 19);
		add(tfAncienMDP);
		tfAncienMDP.setColumns(10);
		
		tfNouveauMDP1 = new JPasswordField();
		tfNouveauMDP1.setBounds(283, 180, 233, 19);
		add(tfNouveauMDP1);
		tfNouveauMDP1.setColumns(10);
		
		tfNouveauMDP2 = new JPasswordField();
		tfNouveauMDP2.setBounds(283, 211, 233, 19);
		add(tfNouveauMDP2);
		tfNouveauMDP2.setColumns(10);
		
		JLabel lblAncienMdp = new JLabel("Ancien mot de passe");
		lblAncienMdp.setForeground(Color.WHITE);
		lblAncienMdp.setBackground(Color.WHITE);
		lblAncienMdp.setFont(new Font("Gentium", Font.BOLD, 18));
		lblAncienMdp.setBounds(68, 147, 204, 19);
		add(lblAncienMdp);
		
		label_1 = new JLabel("Nouveau mot de passe");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Gentium", Font.BOLD, 18));
		label_1.setBounds(68, 213, 204, 15);
		add(label_1);
		
		lblNouveauMdp = new JLabel("Nouveau mot de passe");
		lblNouveauMdp.setFont(new Font("Gentium", Font.BOLD, 18));
		lblNouveauMdp.setForeground(Color.WHITE);
		lblNouveauMdp.setBounds(68, 180, 204, 15);
		add(lblNouveauMdp);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Gentium", Font.BOLD, 17));
		btnAnnuler.setBounds(152, 275, 117, 25);
		add(btnAnnuler);
		
		btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Gentium", Font.BOLD, 17));
		btnModifier.setBounds(333, 275, 117, 25);
		add(btnModifier);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/home/developpeur/Téléchargements/AppliRV/src/fr/gsb/img/8315_l.jpg"));
		label.setBounds(0, 0, 600, 400);
		add(label);
		
		controleur = new controleurChangerMDP(this);
	}

	public vueGSB getGsb() {
		return gsb;
	}

	public void setGsb(vueGSB gsb) {
		this.gsb = gsb;
	}

	public JPasswordField getTfAncienMDP() {
		return tfAncienMDP;
	}


	public JPasswordField getTfNouveauMDP1() {
		return tfNouveauMDP1;
	}


	public JPasswordField getTfNouveauMDP2() {
		return tfNouveauMDP2;
	}


	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}

	public void setBtnAnnuler(JButton btnAnnuler) {
		this.btnAnnuler = btnAnnuler;
	}

	public JButton getBtnModifier() {
		return btnModifier;
	}

	public void setBtnModifier(JButton btnModifier) {
		this.btnModifier = btnModifier;
	}
}
