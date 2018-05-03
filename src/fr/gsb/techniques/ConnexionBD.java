package fr.gsb.techniques;
import java.sql.*;


public class ConnexionBD {

	private static Connection conn;
	private static boolean sessionOuverte;
	private static String url = "jdbc:mysql";
	
	public ConnexionBD(){
		

	}
	
	public static Connection ouvrirConnexion(String url, String user, String password){
		if(sessionOuverte){
			return null;
		}
		else{
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url, user, password);
			}
			catch(SQLException e){
				System.out.println(e.getMessage());
			}
			catch(ClassNotFoundException e){
				e.printStackTrace();
				System.err.println(e.getClass().getName()+": "+e.getMessage());
			}
			sessionOuverte = true;
			return conn;
		}
		
	}
	
	public static void fermerConnexion(){
		if(sessionOuverte){
			sessionOuverte = false;
			conn = null;
		}
	}
	

}

