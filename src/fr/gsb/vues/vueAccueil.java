package fr.gsb.vues;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import fr.gsb.controleurs.controleurAccueil;
import fr.gsb.techniques.Session;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;

public class vueAccueil extends JPanel {

	/**
	 * Create the panel.
	 */
	controleurAccueil controleur;
	private vueGSB gsb;
	JButton deconnecter = new JButton("Se déconnecter");
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup(); 
	private Session session = Session.getSession();
	private JButton btnListeDtaille = new JButton("Liste détaillée");
	private JButton btnPractiHsi = new JButton("Practiciens Hésitants");
	private JButton btnAlerteVisiteurs = new JButton("Alerte Visiteurs");
	
	public vueAccueil(final vueGSB gsb) {
		this.gsb = gsb;
		setBackground(new Color(245, 245, 245));
		setLayout(null);

		
		
		
		
		JLabel lblBonjourMonSeigneur = new JLabel("Bonjour " + session.getLeVisiteur().getPrenom() + " " + session.getLeVisiteur().getNom());
		
		
		lblBonjourMonSeigneur.setForeground(new Color(1, 1, 1));
		lblBonjourMonSeigneur.setFont(new Font("Gentium", Font.BOLD, 31));
		lblBonjourMonSeigneur.setBounds(101, 39, 499, 51);
		add(lblBonjourMonSeigneur);
		
		JLabel lblDerniersRapportsDe = new JLabel("Derniers rapports de visite");
		lblDerniersRapportsDe.setFont(new Font("Gentium", Font.BOLD, 18));
		lblDerniersRapportsDe.setForeground(new Color(1, 1, 1));
		lblDerniersRapportsDe.setBounds(22, 140, 240, 25);
		add(lblDerniersRapportsDe);
		
		btnListeDtaille.setFont(new Font("Gentium", Font.BOLD, 17));
		btnListeDtaille.setBounds(70, 321, 159, 25);
		add(btnListeDtaille);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBackground(new Color(255, 250, 240));
		panel_2.setBounds(323, 167, 254, 144);
		add(panel_2);
		panel_2.setLayout(null);
		
		panel_2.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
		
		JRadioButton rdbtnCoefDeConf = new JRadioButton("Coeficient de confiance");
		rdbtnCoefDeConf.setFont(new Font("Gentium", Font.BOLD, 18));
		buttonGroup.add(rdbtnCoefDeConf);
		rdbtnCoefDeConf.setForeground(new Color(248, 248, 255));
		rdbtnCoefDeConf.setOpaque(false);
		rdbtnCoefDeConf.setBackground(null);
		rdbtnCoefDeConf.setBounds(0, 8, 242, 23);
		panel_2.add(rdbtnCoefDeConf);
		
		JRadioButton rdbtnTempscoul = new JRadioButton("Temps écoulés");
		rdbtnTempscoul.setFont(new Font("Gentium", Font.BOLD, 18));
		buttonGroup.add(rdbtnTempscoul);
		rdbtnTempscoul.setOpaque(false);
		rdbtnTempscoul.setForeground(new Color(248, 248, 255));
		rdbtnTempscoul.setBackground(null);
		rdbtnTempscoul.setBounds(0, 35, 149, 23);
		panel_2.add(rdbtnTempscoul);
		
		JRadioButton rdbtnNotorit = new JRadioButton("Notoriété");
		rdbtnNotorit.setFont(new Font("Gentium", Font.BOLD, 18));
		buttonGroup.add(rdbtnNotorit);
		rdbtnNotorit.setOpaque(false);
		rdbtnNotorit.setForeground(new Color(248, 248, 255));
		rdbtnNotorit.setBackground(null);
		rdbtnNotorit.setBounds(0, 62, 149, 23);
		panel_2.add(rdbtnNotorit);
		
		
		btnPractiHsi.setFont(new Font("Gentium", Font.BOLD, 17));
		btnPractiHsi.setBounds(14, 107, 228, 25);
		panel_2.add(btnPractiHsi);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(22, 167, 253, 144);
		add(panel_3);
		panel_3.setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 0, 253, 144);
		panel_3.add(table);
		deconnecter.setFont(new Font("Gentium", Font.BOLD, 17));
		
		
		deconnecter.setBounds(373, 321, 159, 25);
		add(deconnecter);
		
		controleur = new controleurAccueil(this);
		
		
		btnAlerteVisiteurs.setFont(new Font("Gentium", Font.BOLD, 17));
		btnAlerteVisiteurs.setBounds(337, 126, 228, 25);
		add(btnAlerteVisiteurs);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/home/developpeur/workspace/AppliRV/src/fr/gsb/img/8315_l.jpg"));
		label.setBounds(0, 0, 600, 400);
		add(label);

	}
	
	public vueGSB getGSB(){
		return this.gsb;
	}
	
	public JButton getbDeconnecter(){
		return this.deconnecter;
	}
	
	public JButton getbAlerteVisiteurs(){
		return this.btnAlerteVisiteurs;
	}
	
	public JButton getbRapportListe(){
		return this.btnListeDtaille;
	}
	
	public JButton getbPratiHesitant(){
		return this.btnPractiHsi;
	}
}
