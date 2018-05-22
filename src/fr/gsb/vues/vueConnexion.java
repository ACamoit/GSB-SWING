package fr.gsb.vues;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import fr.gsb.controleurs.controleurAuthentification;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class vueConnexion extends JPanel {
	
	controleurAuthentification controleur;
	private JTextField textField;
	private JPasswordField textField_1;
	private JLabel lblLogin;
	private JLabel lblPassword;
	private JButton connecter = new JButton("Valider");;
	private vueGSB gsb;
	private JLabel lblNewLabel_1;
	

	/**
	 * Create the panel.
	 */
	public vueConnexion(vueGSB gsb) {
		this.gsb = gsb;
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Authentification GSB");
		lblNewLabel.setForeground(new Color(1, 1, 1));
		lblNewLabel.setFont(new Font("Gentium", Font.BOLD, 31));
		lblNewLabel.setBounds(156, 76, 309, 46);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField.setBackground(new Color(255, 250, 240));
		textField.setBounds(249, 170, 195, 19);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setFont(new Font("Gentium", Font.PLAIN, 17));
		textField_1.setBackground(new Color(255, 250, 240));
		textField_1.setBounds(249, 217, 195, 19);
		add(textField_1);
		textField_1.setColumns(10);
		
		lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Gentium", Font.BOLD, 18));
		lblLogin.setForeground(new Color(1, 1, 1));
		lblLogin.setBounds(156, 165, 70, 25);
		add(lblLogin);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Gentium", Font.BOLD, 18));
		lblPassword.setForeground(new Color(1, 1, 1));
		lblPassword.setBounds(156, 219, 90, 15);
		add(lblPassword);
		connecter.setFont(new Font("Gentium", Font.BOLD, 17));
		
		
		connecter.setBounds(249, 261, 117, 25);
		add(connecter);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/home/developpeur/workspace/AppliRV/src/fr/gsb/img/8315_l.jpg"));
		lblNewLabel_1.setBounds(0, 0, 600, 400);
		add(lblNewLabel_1);
		
		controleur = new controleurAuthentification(this);

	}
	
	public String getLogin(){
		return textField.getText();
	}
	
	public String getPassword(){
		return textField_1.getText();
	}
	
	public JTextField getChLogin(){
		return textField;
	}
	public JPasswordField getChPassword(){
		return textField_1;
	}
	
	public JButton getbConnecter(){
		return connecter;
	}
	
	public vueGSB getGSB(){
		return this.gsb;
	}
}
