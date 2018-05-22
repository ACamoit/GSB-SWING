package fr.gsb.vues;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.gsb.controleurs.controleurGSB;
import fr.gsb.entites.Visiteur;
import fr.gsb.modeles.modeleSQL;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vueGSB extends JFrame {

	private vueConnexion pageConnexion;
	private vueAccueil pageAccueil;
	private vueRapports pageRapports;
	private vueModifierMDP pageModifierMDP;
	private vueAlerteVisiteur pageVisiteurs;
	public vueModifierMDP getPageModifierMDP() {
		return pageModifierMDP;
	}

	public void setPageModifierMDP(vueModifierMDP pageModifierMDP) {
		this.pageModifierMDP = pageModifierMDP;
	}

	private CardLayout clVues = new CardLayout(1,1) ;
	private Container conteneur;
	private controleurGSB controleur;
	private vueGSB gsb;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mnOptions = new JMenu("Options");
	private JMenu mnNavigation = new JMenu("Navigation");
	private JMenuItem mntmQuitter = new JMenuItem("Quitter");
	private JMenuItem mntmDeconnexion = new JMenuItem("Deconnexion");
	private JMenuItem mntmModifierMdp = new JMenuItem("Modifier MDP");
	private JMenuItem mntmAccueil = new JMenuItem("Accueil");
	private JMenuItem mntmRapports = new JMenuItem("Rapports");
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vueGSB frame = new vueGSB();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public vueGSB() {
		/////////////////
		
		
		
		/////////////////
		
		this.gsb = this;
		this.controleur = new controleurGSB(this);
		setBarreMenusModeDeconnecte();
		setBackground(new Color(105, 105, 105));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 410);
		Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		int height = tailleEcran.height;
		int width = tailleEcran.width;
		this.setResizable(false);
		this.setLocationRelativeTo(null) ;
		
		menuBar.setBackground(new Color(105, 105, 105));
		setJMenuBar(menuBar);
		
		
		mnOptions.setForeground(new Color(255, 250, 250));
		mnOptions.setFont(new Font("Dialog", Font.BOLD, 12));
		menuBar.add(mnOptions);
		
		
		mnOptions.add(mntmModifierMdp);
		
	
		mnOptions.add(mntmDeconnexion);
		
	
		mnOptions.add(mntmQuitter);
		
		
		mnNavigation.setForeground(Color.WHITE);
		menuBar.add(mnNavigation);
		
		
		mnNavigation.add(mntmAccueil);
		
		mnNavigation.add(mntmRapports);
		
		conteneur = this.getContentPane();
		
		conteneur.setLayout(clVues);
		
		pageConnexion = new vueConnexion(this);
		pageConnexion.setBackground(new Color(255, 255, 255));
		
		
		conteneur.add(pageConnexion,"vueConnexion");
		
		//setContentPane(conteneur);
		
		//pageConnexion.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(pageConnexion);
		//pageConnexion.setLayout(null);
	}
	
	public void changerVue(String nomVue){
		this.clVues.show(conteneur, nomVue);
	}
	

	
	public vueAccueil getPageAccueil(){
		return this.pageAccueil;
	}
	
	public void setPageAccueil(vueAccueil page){
		this.pageAccueil = page;
	}

	public vueRapports getPageRapports(){
		return this.pageRapports;
	}
	
	public void setPageRapports(vueRapports page){
		this.pageRapports = page;
	}
	
	
	public vueAlerteVisiteur getPageVisiteurs(){
		return this.pageVisiteurs;
	}
	
	public void setPageVisiteur(vueAlerteVisiteur page){
		this.pageVisiteurs = page;
	}

	public vueConnexion getPageConnexion() {
		return pageConnexion;
	}

	public void setPageConnexion(vueConnexion pageConnexion) {
		this.pageConnexion = pageConnexion;
	}

	public CardLayout getClVues() {
		return clVues;
	}

	public void setClVues(CardLayout clVues) {
		this.clVues = clVues;
	}

	public Container getConteneur() {
		return conteneur;
	}

	public void setConteneur(Container conteneur) {
		this.conteneur = conteneur;
	}

	public controleurGSB getControleur() {
		return controleur;
	}

	public void setControleur(controleurGSB controleur) {
		this.controleur = controleur;
	}
	
	public JMenuItem getItemQuitter(){
		return this.mntmQuitter;
	}
	
	public void setBarreMenusModeConnecte(){
		this.mnNavigation.setEnabled(true);
		this.mntmAccueil.setEnabled(true);
		this.mntmRapports.setEnabled(true);
		this.mntmDeconnexion.setEnabled(true);
		this.mntmModifierMdp.setEnabled(true);
	}
	
	public void setBarreMenusModeDeconnecte(){
		this.mnNavigation.setEnabled(false);
		this.mntmAccueil.setEnabled(false);
		this.mntmRapports.setEnabled(false);
		this.mntmDeconnexion.setEnabled(false);
		this.mntmModifierMdp.setEnabled(false);
	}

	public JMenuItem getMntmDeconnexion() {
		return mntmDeconnexion;
	}

	public void setMntmDeconnexion(JMenuItem mntmDeconnexion) {
		this.mntmDeconnexion = mntmDeconnexion;
	}

	public JMenuItem getMntmModifierMdp() {
		return mntmModifierMdp;
	}

	public void setMntmModifierMdp(JMenuItem mntmModifierMdp) {
		this.mntmModifierMdp = mntmModifierMdp;
	}

	public JMenuItem getMntmAccueil() {
		return mntmAccueil;
	}

	public void setMntmAccueil(JMenuItem mntmAccueil) {
		this.mntmAccueil = mntmAccueil;
	}

	public JMenuItem getMntmRapports() {
		return mntmRapports;
	}

	public void setMntmRapports(JMenuItem mntmRapports) {
		this.mntmRapports = mntmRapports;
	}
	
	
	
	
}
