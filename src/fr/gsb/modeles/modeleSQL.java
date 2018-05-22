package fr.gsb.modeles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import fr.gsb.entites.Rapport;
import fr.gsb.entites.Visiteur;
import fr.gsb.techniques.ConnexionBD;
import fr.gsb.techniques.Session;

public class modeleSQL {
	
	ConnexionBD connexion = new ConnexionBD();
	String ipServeur = "192.168.42.28:5000";
	boolean useNetwork = false;
	
	
	public modeleSQL(){
		
	}
	
	public boolean connexionUser(String user, String pwd){
		if(useNetwork){
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet requete = new HttpGet( "http://"+ipServeur+"/connexion/"+user+"."+pwd);
			try{
				CloseableHttpResponse reponse = httpClient.execute( requete );
				System.out.println( "Code de statut : " + reponse.getStatusLine().getStatusCode());
				System.out.println( "Content-Type : " + reponse.getFirstHeader( "Content-Type" ).getValue());
				HttpEntity entite = reponse.getEntity();
				BufferedReader lecteur = new BufferedReader( new InputStreamReader( entite.getContent()));
				String corps = "";
				String ligne = lecteur.readLine();
				while( ligne != null ){
					corps = corps + ligne;
					ligne = lecteur.readLine();
				}
				lecteur.close();
				System.out.println( "Corps : " + corps );
				EntityUtils.consume( entite );
				reponse.close();
				if(corps.equals("[]")){
					return false;
				}
				else{
					GsonBuilder fabrique = new GsonBuilder();
					Gson gson = fabrique.create();
					ArrayList<Visiteur> visiteur = new ArrayList<Visiteur>();
					JsonParser parser = new JsonParser();
					JsonArray visiteurs = parser.parse(corps).getAsJsonArray();
					Session.ouvrir(gson.fromJson(visiteurs.get(0), Visiteur.class));
					
					System.out.println(Session.getSession().getLeVisiteur());
					return true;
				}
			}
			catch (IOException e){
				System.out.println( "Erreur Requête GET" );
				return false;
			}
		}
		else{
			boolean connexionAccepté = false;
			try{
				
				Connection conn = (Connection) connexion.ouvrirConnexion("jdbc:mysql://localhost/Gsb", "root", "azerty");
				
				String sql = "SELECT *"
							+" FROM VISITEUR"
							+" WHERE VIS_MATRICULE = ?"
							+" AND VIS_MDP = ?";
				
				PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
				pstm.setString(1, user);
				pstm.setString(2, pwd);
				ResultSet resultat = null;
				resultat = pstm.executeQuery();

				if(resultat.next()){
					Session.ouvrir(new Visiteur(resultat.getString("VIS_MATRICULE"), resultat.getString("VIS_NOM"), resultat.getString("VIS_PRENOM"), resultat.getString("VIS_ADRESSE"), resultat.getString("VIS_CP"), resultat.getString("VIS_VILLE"), resultat.getString("VIS_DATEEMBAUCHE"), resultat.getString("VIS_MDP"), resultat.getString("LAB_CODE")));
					connexionAccepté = true;
					
				}
				conn.close();
				connexion.fermerConnexion();
				
				
			}
			catch(SQLException e){
				System.out.println(e.getMessage());
			}
			return connexionAccepté;
		}
		
	}
	
	public JComboBox selectVisiteurs(){
		if(useNetwork){
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet requete = new HttpGet( "http://"+ipServeur+"/cbVisiteurs");
			try{
				JComboBox cb = new JComboBox();
				String retour;
				CloseableHttpResponse reponse = httpClient.execute( requete );
				System.out.println( "Code de statut : " + reponse.getStatusLine().getStatusCode());
				System.out.println( "Content-Type : " + reponse.getFirstHeader( "Content-Type" ).getValue());
				HttpEntity entite = reponse.getEntity();
				BufferedReader lecteur = new BufferedReader( new InputStreamReader( entite.getContent()));
				String corps = "";
				String ligne = lecteur.readLine();
				while( ligne != null ){
					corps = corps + ligne;
					ligne = lecteur.readLine();
				}
				lecteur.close();
				System.out.println( "Corps : " + corps );
				EntityUtils.consume( entite );
				reponse.close();
				if(corps.equals("[]")){
					return null;
				}
				else{
					GsonBuilder fabrique = new GsonBuilder();
					Gson gson = fabrique.create();
					ArrayList<Visiteur> visiteur = new ArrayList<Visiteur>();
					JsonParser parser = new JsonParser();
					JsonArray visiteurs = parser.parse(corps).getAsJsonArray();
					
					for(int i = 0; i<visiteurs.size(); i++){
						retour = gson.fromJson(visiteurs.get(i), Visiteur.class).getNom() ;
						cb.addItem(retour);
					}
					System.out.println(gson.fromJson(visiteurs.get(0), Visiteur.class));
					return cb;
				}
			}
			catch (IOException e){
				System.out.println( "Erreur Requête GET" );
				return null;
			}
		}
		else{
			JComboBox cb = new JComboBox();
			Visiteur unVisiteur;
			String retour;
			try{
				Connection conn = (Connection) connexion.ouvrirConnexion("jdbc:mysql://localhost/Gsb", "root", "azerty");
				Statement stm = conn.createStatement();
				String sql = "SELECT DISTINCT(LEFT(VIS_PRENOM,1)) AS VIS_PRENOM, VIS_NOM "
							+"FROM VISITEUR";
				ResultSet resultat = null;
				resultat = stm.executeQuery(sql);
				while(resultat.next()){
					retour = resultat.getString("VIS_NOM");
					cb.addItem(retour);
				}
				connexion.fermerConnexion();
				conn.close();
			}
			catch(SQLException e){
				System.out.println(e.getMessage());
			}
			return cb;
		}
		
	}
	
	public Visiteur selectVisiteur(String matricule){
		if(useNetwork){
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet requete = new HttpGet( "http://"+ipServeur+"/visiteurs/"+matricule);
			try{
				Visiteur unVisiteur = null;
				CloseableHttpResponse reponse = httpClient.execute( requete );
				//System.out.println( "Code de statut : " + reponse.getStatusLine().getStatusCode());
				//System.out.println( "Content-Type : " + reponse.getFirstHeader( "Content-Type" ).getValue());
				HttpEntity entite = reponse.getEntity();
				BufferedReader lecteur = new BufferedReader( new InputStreamReader( entite.getContent()));
				String corps = "";
				String ligne = lecteur.readLine();
				while( ligne != null ){
					corps = corps + ligne;
					ligne = lecteur.readLine();
				}
				lecteur.close();
				
				EntityUtils.consume( entite );
				reponse.close();
				if(corps.equals("[]")){
					return null;
				}
				else{
					GsonBuilder fabrique = new GsonBuilder();
					Gson gson = fabrique.create();
					JsonParser parser = new JsonParser();
					JsonArray visiteurs = parser.parse(corps).getAsJsonArray();
					
						
					unVisiteur = (gson.fromJson(visiteurs.get(0), Visiteur.class));	
					
					return unVisiteur;
				}
			}
			catch (IOException e){
				System.out.println( "Erreur Requête GET" );
				return null;
			}
		}
		else{
			return null;
		}
		
	}

	public List<Visiteur> selectVisiteursAlerte(){
		Visiteur unVisiteur = null;
		List<Visiteur> lesVisiteurs = new ArrayList<Visiteur>();
		int nbProduits = 0;
		
		try{
			Connection conn = (Connection) connexion.ouvrirConnexion("jdbc:mysql://localhost/Gsb", "root", "azerty");
			Statement stm = conn.createStatement();
			String sql = "Select * from VISITEUR ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet resultat = null;
			resultat = pstmt.executeQuery();
			while(resultat.next()){
				
				unVisiteur = new Visiteur(resultat.getString("VIS_MATRICULE"),resultat.getString("VIS_NOM"),resultat.getString("VIS_PRENOM"),"4","5","6","7","8","9",resultat.getInt("VIS_OBJECTIF"),0);
				nbProduits = selectResultat(unVisiteur.getMatricule(), conn);
				unVisiteur.setNbRapports(nbProduits);
				if(unVisiteur.getNbRapports() < unVisiteur.getObjectif()){
					lesVisiteurs.add(unVisiteur
							);
				}
				
			}
			
			conn.close();
			connexion.fermerConnexion();
			pstmt.close();
			stm.close();
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return lesVisiteurs;
	}
	
	public int selectResultat(String matricule, Connection conn){
		int leresultat = 0;
		
		try{
			System.out.println(conn);
			Statement stm = conn.createStatement();
			System.out.println("Apres la connexion");
			String sql = "Select count(*) AS RESULTAT "
						+"From RAPPORT_VISITE "
						+"WHERE VIS_MATRICULE = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, matricule);
			System.out.println(pstmt);
			ResultSet resultat = null;
			resultat = pstmt.executeQuery();
			while(resultat.next()){
				System.out.println("Dans le next");
				leresultat = resultat.getInt("RESULTAT");
			}
			
			pstmt.close();
			stm.close();
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return leresultat;
	}
	public List<Rapport> selectRapports(String nomVis, int mois, int annee){
		
		if(useNetwork){
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet requete = new HttpGet( "http://"+ipServeur+"/rapports/"+nomVis+"."+mois+"."+annee);
			try{
				Rapport unRapport = null;
				List<Rapport> lesRapports = new ArrayList<Rapport>();
				CloseableHttpResponse reponse = httpClient.execute( requete );
				System.out.println( "Code de statut : " + reponse.getStatusLine().getStatusCode());
				System.out.println( "Content-Type : " + reponse.getFirstHeader( "Content-Type" ).getValue());
				HttpEntity entite = reponse.getEntity();
				BufferedReader lecteur = new BufferedReader( new InputStreamReader( entite.getContent()));
				String corps = "";
				String ligne = lecteur.readLine();
				while( ligne != null ){
					corps = corps + ligne;
					ligne = lecteur.readLine();
				}
				lecteur.close();
				System.out.println( "Corps : " + corps );
				EntityUtils.consume( entite );
				reponse.close();
				if(corps.equals("[]")){
					return null;
				}
				else{
					GsonBuilder fabrique = new GsonBuilder();
					Gson gson = fabrique.create();
					JsonParser parser = new JsonParser();
					JsonArray rapports = parser.parse(corps).getAsJsonArray();
					
					for(int i = 0; i<rapports.size(); i++){
						
						lesRapports.add(gson.fromJson(rapports.get(i), Rapport.class));
					}
					
					return lesRapports;
				}
			}
			catch (IOException e){
				System.out.println( "Erreur Requête GET" );
				return null;
			}
		}
		else{
			Rapport unRapport = null;
			List<Rapport> lesRapports = new ArrayList<Rapport>();
			
			try{
				Connection conn = (Connection) connexion.ouvrirConnexion("jdbc:mysql://localhost/Gsb", "root", "azerty");
				Statement stm = conn.createStatement();
				String sql = "Select r.RAP_NUM, v.VIS_NOM, p.PRA_NOM, r.RAP_DATE, r.RAP_BILAN, m.MOT_LIBELLE, v.VIS_VILLE, e.EVA_LIBELLE, r.ESTVU "
							+"From VISITEUR v INNER JOIN RAPPORT_VISITE r ON v.VIS_MATRICULE = r.VIS_MATRICULE "
							+"INNER JOIN PRATICIEN p ON r.PRA_NUM = p.PRA_NUM "
							+"INNER JOIN MOTIF m ON r.MOT_NUM = m.MOT_NUM "
							+"INNER JOIN EVALUATION e ON r.EVA_NUM = e.EVA_NUM "
							+"WHERE v.VIS_NOM = ? AND MONTH(r.RAP_DATE) = ? AND YEAR(r.RAP_DATE) = ? ";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, nomVis);
				pstmt.setInt(2, mois);
				pstmt.setInt(3, annee);
				ResultSet resultat = null;
				resultat = pstmt.executeQuery();
				while(resultat.next()){
					
					lesRapports.add(
							new Rapport(Integer.parseInt(resultat.getString("RAP_NUM")),
							resultat.getString("VIS_NOM"),
							resultat.getString("PRA_NOM"),
							resultat.getString("RAP_DATE"),
							resultat.getString("RAP_BILAN"),
							resultat.getString("MOT_LIBELLE"),
							resultat.getString("VIS_VILLE"),
							resultat.getString("EVA_LIBELLE"),
							resultat.getString("ESTVU")
					));
				}
				
				conn.close();
				connexion.fermerConnexion();
				pstmt.close();
				stm.close();
			}
			catch(SQLException e){
				System.out.println(e.getMessage());
			}
			return lesRapports;
		}
		
	}
	
	public Rapport selectUnRapport(int matricule){
		if(useNetwork){
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet requete = new HttpGet( "http://"+ipServeur+"/rapports/"+matricule);
			try{
				Rapport unRapport = null;
				CloseableHttpResponse reponse = httpClient.execute( requete );
				System.out.println( "Code de statut : " + reponse.getStatusLine().getStatusCode());
				System.out.println( "Content-Type : " + reponse.getFirstHeader( "Content-Type" ).getValue());
				HttpEntity entite = reponse.getEntity();
				BufferedReader lecteur = new BufferedReader( new InputStreamReader( entite.getContent()));
				String corps = "";
				String ligne = lecteur.readLine();
				while( ligne != null ){
					corps = corps + ligne;
					ligne = lecteur.readLine();
				}
				lecteur.close();
				System.out.println( "Corps : " + corps );
				EntityUtils.consume( entite );
				reponse.close();
				if(corps.equals("[]")){
					return null;
				}
				else{
					GsonBuilder fabrique = new GsonBuilder();
					Gson gson = fabrique.create();
					JsonParser parser = new JsonParser();
					JsonArray rapports = parser.parse(corps).getAsJsonArray();
					
						
					unRapport = (gson.fromJson(rapports.get(0), Rapport.class));	
					System.out.println(unRapport.toString());
					
					return unRapport;
				}
			}
			catch (IOException e){
				System.out.println( "Erreur Requête GET" );
				return null;
			}
		}
		else{
			Rapport unRapport = null;
			
			int rapNum;
			String visNom;
			String praNom;
			String rapDate;
			String rapBilan;
			String motLibelle;
			String visVille;
			String evaNum;
			try{
				Connection conn = (Connection) connexion.ouvrirConnexion("jdbc:mysql://localhost/Gsb", "root", "azerty");
				Statement stm = conn.createStatement();
				String sql = "Select r.RAP_NUM, v.VIS_NOM, p.PRA_NOM, r.RAP_DATE, r.RAP_BILAN, m.MOT_LIBELLE, v.VIS_VILLE, e.EVA_LIBELLE, r.ESTVU "
							+"From VISITEUR v INNER JOIN RAPPORT_VISITE r ON v.VIS_MATRICULE = r.VIS_MATRICULE "
							+"INNER JOIN PRATICIEN p ON r.PRA_NUM = p.PRA_NUM "
							+"INNER JOIN MOTIF m ON r.MOT_NUM = m.MOT_NUM "
							+"INNER JOIN EVALUATION e ON r.EVA_NUM = e.EVA_NUM "
							+"WHERE r.RAP_NUM = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, matricule);
				ResultSet resultat = null;
				resultat = pstmt.executeQuery();
				while(resultat.next()){
					
					unRapport =
							new Rapport(Integer.parseInt(resultat.getString("RAP_NUM")),
							resultat.getString("VIS_NOM"),
							resultat.getString("PRA_NOM"),
							resultat.getString("RAP_DATE"),
							resultat.getString("RAP_BILAN"),
							resultat.getString("MOT_LIBELLE"),
							resultat.getString("VIS_VILLE"),
							resultat.getString("EVA_LIBELLE"),
							resultat.getString("ESTVU")
					);
				}
				
				conn.close();
				connexion.fermerConnexion();
				pstmt.close();
				stm.close();
			}
			catch(SQLException e){
				System.out.println(e.getMessage());
			}
			return unRapport;
		}
		

	}
	
	public void changerMdp(String mdp, String matricule){
		if(useNetwork){
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPut requete = new HttpPut( "http://"+ipServeur+"/visiteurs/changerMdp/"+matricule+"."+mdp);
			String unChangementJSON = "[{\"Matricule\": \""+matricule+"\", \"Mot de passe\": \""+mdp+"\"}]"; 
			StringEntity entitePut;
			try{
				entitePut = new StringEntity(unChangementJSON);
				requete.setEntity(entitePut);
				CloseableHttpResponse reponse = httpClient.execute( requete );
				System.out.println( "Code de statut : " + reponse.getStatusLine().getStatusCode());
				System.out.println( "Content-Type : " + reponse.getFirstHeader( "Content-Type" ).getValue());
				HttpEntity entite = reponse.getEntity();
				BufferedReader lecteur = new BufferedReader( new InputStreamReader( entite.getContent()));
				String corps = "";
				String ligne = lecteur.readLine();
				while( ligne != null ){
					corps = corps + ligne;
					ligne = lecteur.readLine();
				}
				lecteur.close();
				System.out.println( "Corps : " + corps );
				EntityUtils.consume( entite );
				EntityUtils.consume( entitePut );
				reponse.close();
				/*if(reponse.getStatusLine().getStatusCode() == 200){
					return true;
				}
				else{
					return false;
				}*/
			}
			catch (IOException e){
				System.out.println( "Erreur Requête PUT" );
				//return false;
			}
			
		}
		else{
			try{
				Connection conn =  connexion.ouvrirConnexion("jdbc:mysql://localhost/Gsb", "root", "azerty");
				Statement stmt = conn.createStatement();
				
				String sql = "UPDATE VISITEUR "
							+"SET VIS_MDP = ? "
							+"WHERE VIS_MATRICULE = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mdp);
				pstmt.setString(2, matricule);
				pstmt.executeUpdate();
				stmt.close();
				conn.close();
				connexion.fermerConnexion();
			}
			catch(SQLException e){
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	public void estVu(int numRap){
		if(useNetwork){
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPut requete = new HttpPut( "http://"+ipServeur+"/rapports/estVu/"+numRap);
			String unChangementJSON = "[{\"numRapport\": \""+numRap+"\"}]"; 
			StringEntity entitePut;
			try{
				entitePut = new StringEntity(unChangementJSON);
				requete.setEntity(entitePut);
				CloseableHttpResponse reponse = httpClient.execute( requete );
				System.out.println( "Code de statut : " + reponse.getStatusLine().getStatusCode());
				System.out.println( "Content-Type : " + reponse.getFirstHeader( "Content-Type" ).getValue());
				HttpEntity entite = reponse.getEntity();
				BufferedReader lecteur = new BufferedReader( new InputStreamReader( entite.getContent()));
				String corps = "";
				String ligne = lecteur.readLine();
				while( ligne != null ){
					corps = corps + ligne;
					ligne = lecteur.readLine();
				}
				lecteur.close();
				System.out.println( "Corps : " + corps );
				EntityUtils.consume( entite );
				EntityUtils.consume( entitePut );
				reponse.close();
				/*if(reponse.getStatusLine().getStatusCode() == 200){
					return true;
				}
				else{
					return false;
				}*/
			}
			catch (IOException e){
				System.out.println( "Erreur Requête PUT" );
				//return false;
			}
		}
		else{
			try{
				Connection conn =  connexion.ouvrirConnexion("jdbc:mysql://localhost/Gsb", "root", "azerty");
				Statement stmt = conn.createStatement();
				
				String sql = "UPDATE RAPPORT_VISITE "
							+"SET ESTVU = TRUE "
							+"WHERE RAP_NUM = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, numRap);
				pstmt.executeUpdate();
				stmt.close();
				conn.close();
				connexion.fermerConnexion();
				System.out.println("EstVu terminé avec succès");
			}
			catch(SQLException e){
				System.out.println(e.getMessage());
			}
		}
		
	}
	
}
