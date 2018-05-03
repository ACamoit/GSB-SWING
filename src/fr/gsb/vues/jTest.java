package fr.gsb.vues;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;

import fr.gsb.entites.Rapport;
import fr.gsb.entites.Visiteur;
import fr.gsb.modeles.modeleSQL;
import javax.swing.JComboBox;

public class jTest extends JFrame {

	private JPanel contentPane;
	private JTextField tfMatriculeCU;
	private JTextField tfPwdCU;
	private JTextField tfNomVisSR;
	private JTextField tfMoisSR;
	private JTextField tfAnneeSR;
	private JTextField tfMatriculeSUR;
	private JTextField tfMatriculeCM;
	private JTextField tfPwdCM;
	private JTextField tfNumRapportEV;
	private modeleSQL sql = new modeleSQL();
	private JComboBox cbSV = sql.selectVisiteurs();;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jTest frame = new jTest();
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
	public jTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		tfMatriculeCU = new JTextField();
		tfMatriculeCU.setBounds(200, 15, 114, 19);
		contentPane.add(tfMatriculeCU);
		tfMatriculeCU.setColumns(10);
		
		tfPwdCU = new JTextField();
		tfPwdCU.setBounds(326, 15, 114, 19);
		contentPane.add(tfPwdCU);
		tfPwdCU.setColumns(10);
		
		
		
		tfNomVisSR = new JTextField();
		tfNomVisSR.setBounds(200, 87, 98, 19);
		contentPane.add(tfNomVisSR);
		tfNomVisSR.setColumns(10);
		
		tfMoisSR = new JTextField();
		tfMoisSR.setBounds(310, 87, 59, 19);
		contentPane.add(tfMoisSR);
		tfMoisSR.setColumns(10);
		
		tfAnneeSR = new JTextField();
		tfAnneeSR.setBounds(381, 87, 59, 19);
		contentPane.add(tfAnneeSR);
		tfAnneeSR.setColumns(10);
		
		
		
		tfMatriculeSUR = new JTextField();
		tfMatriculeSUR.setBounds(200, 124, 114, 19);
		contentPane.add(tfMatriculeSUR);
		tfMatriculeSUR.setColumns(10);
		
		
		
		
		
		tfMatriculeCM = new JTextField();
		tfMatriculeCM.setBounds(200, 161, 114, 19);
		contentPane.add(tfMatriculeCM);
		tfMatriculeCM.setColumns(10);
		
		tfPwdCM = new JTextField();
		tfPwdCM.setBounds(326, 161, 114, 19);
		contentPane.add(tfPwdCM);
		tfPwdCM.setColumns(10);
		
		
	
		
		tfNumRapportEV = new JTextField();
		tfNumRapportEV.setBounds(200, 198, 114, 19);
		contentPane.add(tfNumRapportEV);
		tfNumRapportEV.setColumns(10);
		
		final JLabel resultat = new JLabel("");
		resultat.setBounds(12, 232, 424, 15);
		contentPane.add(resultat);
		
		JButton btnSelectUnRapport = new JButton("selectUnRapport");
		btnSelectUnRapport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idRapport = Integer.parseInt(tfMatriculeSUR.getText());
				Rapport unRapport = sql.selectUnRapport(idRapport);
				if(unRapport != null){
					resultat.setText("Selection réussie.");
				}
				else{
					resultat.setText("Echec de selection.");
				}
			}
		});
		
		JButton btnChangermdp = new JButton("changerMdp");
		btnChangermdp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Visiteur avantModif = sql.selectVisiteur(tfMatriculeCM.getText());
				System.out.println("Avant modification : "+avantModif.toString());
				sql.changerMdp(tfPwdCM.getText(), tfMatriculeCM.getText());
				Visiteur apresModif = sql.selectVisiteur(tfMatriculeCM.getText());
				System.out.println("Après modification : "+apresModif.toString());
				//if(reussite){
					resultat.setText("Changement de mot de passe réussie.");
				//}
				//else{
				//	resultat.setText("Echec du changement de mot de passe.");
				//}
				
				
			}
		});
		btnChangermdp.setBounds(12, 158, 176, 25);
		contentPane.add(btnChangermdp);
		btnSelectUnRapport.setBounds(12, 121, 176, 25);
		contentPane.add(btnSelectUnRapport);
		
		JButton btnEstvu = new JButton("estVu");
		btnEstvu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sql.estVu(Integer.parseInt(tfNumRapportEV.getText()));
				//if(estVu){
					resultat.setText("Le rapport numéro "+tfNumRapportEV.getText()+" a été vu avec succès.");
				//}
				//{
				//	resultat.setText("Echec: ce rapport a déjà été vu.");
				//}
			}
		});
		btnEstvu.setBounds(12, 195, 176, 25);
		contentPane.add(btnEstvu);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(12, 232, 424, 32);
		contentPane.add(textPane);
		
		cbSV.setBounds(200, 46, 98, 24);
		contentPane.add(cbSV);
		
		JButton btnConnexionUser = new JButton("ConnexionUser");
		btnConnexionUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean resultatReq = sql.connexionUser(tfMatriculeCU.getText(), tfPwdCU.getText());
				if(resultatReq){
					resultat.setText("Connexion réussie");
				}
				else{
					resultat.setText("Connexion échouée");
				}
				
			}
		});
		btnConnexionUser.setBounds(12, 12, 176, 25);
		contentPane.add(btnConnexionUser);
		
		JButton btnSelectVisiteurs = new JButton("selectVisiteurs");
		btnSelectVisiteurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(cbSV != null ){
					resultat.setText("Selection réussie");
				}
				else{
					resultat.setText("Selection échouée");
				}
			}
		});
		btnSelectVisiteurs.setBounds(12, 47, 176, 25);
		contentPane.add(btnSelectVisiteurs);
		
		JButton btnSelectRapports = new JButton("selectRapports");
		btnSelectRapports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfNomVisSR.getText()!="" && tfMoisSR.getText()!="" && tfAnneeSR.getText()!=""){
					List<Rapport> lesRapports = sql.selectRapports(tfNomVisSR.getText(), Integer.parseInt(tfMoisSR.getText()), Integer.parseInt(tfAnneeSR.getText()));
					if(lesRapports.size()>0){
						resultat.setText("Rapports trouvés");
					}
					else{
						resultat.setText("Aucun rapport trouvé");
					}
				}
				else{
					resultat.setText("Champs non remplis");
				}
				
			}
		});
		btnSelectRapports.setBounds(12, 84, 176, 25);
		contentPane.add(btnSelectRapports);
		
		
		
		this.setLocationRelativeTo(null);
	}
}
