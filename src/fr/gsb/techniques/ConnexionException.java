package fr.gsb.techniques;

public class ConnexionException extends Exception {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage(){
		return "Erreur de connexion BD" ;
	}
}
