package fr.gsb.vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.gsb.controleurs.controleurVoirRapport;
import fr.gsb.entites.Rapport;
import fr.gsb.modeles.modeleSQL;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class vueVoirRapport extends JFrame {

	private JPanel contentPane;
	private controleurVoirRapport controleur;
	private JButton btnQuitter = new JButton("Quitter");
	private modeleSQL sql = new modeleSQL();
	private Rapport unRapport;
	private JTextField tfNum;
	private JTextField tfVisiteur;
	private JTextField tfPraticien;
	private JTextField tfDate;
	private JTextField tfMotif;
	private JTextField tfBilan;
	private JTextField tfEvaluation;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vueVoirRapport frame = new vueVoirRapport();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public vueVoirRapport(int matricule) {
		this.unRapport = sql.selectUnRapport(matricule);
		this.sql.estVu(matricule);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnQuitter.setBounds(166, 237, 117, 25);
		contentPane.add(btnQuitter);
		
		tfNum = new JTextField();
		tfNum.setFont(new Font("Gentium", Font.PLAIN, 18));
		tfNum.setForeground(Color.BLACK);
		tfNum.setText(Integer.toString(unRapport.getNumRapport()));
		tfNum.disable();
		tfNum.setDisabledTextColor(Color.BLACK);
		tfNum.setBounds(69, 12, 95, 19);
		contentPane.add(tfNum);
		tfNum.setColumns(10);
		
		JLabel lblN = new JLabel("N°");
		lblN.setFont(new Font("Gentium", Font.BOLD, 18));
		lblN.setForeground(Color.WHITE);
		lblN.setBounds(22, 14, 70, 15);
		contentPane.add(lblN);
		
		JLabel lblVisiteur = new JLabel("Visiteur");
		lblVisiteur.setFont(new Font("Gentium", Font.BOLD, 18));
		lblVisiteur.setForeground(Color.WHITE);
		lblVisiteur.setBounds(219, 14, 70, 15);
		contentPane.add(lblVisiteur);
		
		tfVisiteur = new JTextField();
		tfVisiteur.setText(unRapport.getNomVisiteur());
		tfVisiteur.setFont(new Font("Gentium", Font.PLAIN, 18));
		tfVisiteur.setForeground(Color.BLACK);
		tfVisiteur.disable();
		tfVisiteur.setDisabledTextColor(Color.BLACK);
		tfVisiteur.setBounds(309, 12, 114, 19);
		contentPane.add(tfVisiteur);
		tfVisiteur.setColumns(10);
		
		tfPraticien = new JTextField();
		tfPraticien.setText(unRapport.getNomPraticien());
		tfPraticien.setFont(new Font("Gentium", Font.PLAIN, 18));
		tfPraticien.setForeground(Color.BLACK);
		tfPraticien.disable();
		tfPraticien.setDisabledTextColor(Color.BLACK);
		tfPraticien.setBounds(309, 43, 114, 19);
		contentPane.add(tfPraticien);
		tfPraticien.setColumns(10);
		
		JLabel lblPraticien = new JLabel("Praticien");
		lblPraticien.setFont(new Font("Gentium", Font.BOLD, 18));
		lblPraticien.setForeground(Color.WHITE);
		lblPraticien.setBounds(219, 45, 82, 15);
		contentPane.add(lblPraticien);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Gentium", Font.BOLD, 18));
		lblDate.setBounds(22, 45, 70, 15);
		contentPane.add(lblDate);
		
		tfDate = new JTextField();
		tfDate.setText(unRapport.getRapDate());
		tfDate.disable();
		tfDate.setDisabledTextColor(Color.BLACK);
		tfDate.setFont(new Font("Gentium", Font.PLAIN, 18));
		tfDate.setForeground(Color.BLACK);
		tfDate.setBounds(69, 43, 95, 19);
		contentPane.add(tfDate);
		tfDate.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Motif");
		lblNewLabel.setFont(new Font("Gentium", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(22, 89, 70, 15);
		contentPane.add(lblNewLabel);
		
		tfMotif = new JTextField();
		tfMotif.setText(unRapport.getRapMotif());
		tfMotif.setFont(new Font("Gentium", Font.PLAIN, 18));
		tfMotif.setForeground(Color.BLACK);
		tfMotif.disable();
		tfMotif.setDisabledTextColor(Color.BLACK);
		tfMotif.setBounds(79, 87, 344, 19);
		contentPane.add(tfMotif);
		tfMotif.setColumns(10);
		
		JLabel lblBilan = new JLabel("Bilan");
		lblBilan.setFont(new Font("Gentium", Font.BOLD, 18));
		lblBilan.setForeground(Color.WHITE);
		lblBilan.setBounds(22, 118, 70, 15);
		contentPane.add(lblBilan);
		
		tfBilan = new JTextField();
		tfBilan.setText(unRapport.getRapBilan());
		tfBilan.setFont(new Font("Gentium", Font.PLAIN, 18));
		tfBilan.setForeground(Color.BLACK);
		tfBilan.disable();
		tfBilan.setDisabledTextColor(Color.BLACK);
		tfBilan.setBounds(79, 118, 344, 52);
		contentPane.add(tfBilan);
		tfBilan.setColumns(10);
		
		tfEvaluation = new JTextField();
		tfEvaluation.setText(unRapport.getRapEval());
		tfEvaluation.setFont(new Font("Gentium", Font.PLAIN, 18));
		tfEvaluation.setForeground(Color.BLACK);
		tfEvaluation.disable();
		tfEvaluation.setDisabledTextColor(Color.BLACK);
		tfEvaluation.setBounds(266, 190, 157, 19);
		contentPane.add(tfEvaluation);
		tfEvaluation.setColumns(10);
		
		JLabel lblEvaluation = new JLabel("Evaluation");
		lblEvaluation.setFont(new Font("Gentium", Font.BOLD, 18));
		lblEvaluation.setForeground(Color.WHITE);
		lblEvaluation.setBounds(153, 192, 95, 15);
		contentPane.add(lblEvaluation);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/home/developpeur/workspace/AppRV/bin/fr/gsb/img/8315_l.jpg"));
		label.setBounds(0, 0, 448, 274);
		contentPane.add(label);
		controleur = new controleurVoirRapport(this);
		setLocationRelativeTo(null);
	}
	
	public JButton getBtnQuitter(){
		return btnQuitter;
	}
}
