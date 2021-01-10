

public class Inscrits {

	private int idCours;
	private char NumEtu;
	private boolean surAttente;
	private boolean presence;
	
	
	
	public Inscrits() {
		
	}



	public int getIdCours() {
		return idCours;
	}



	public char getNumEtu() {
		return NumEtu;
	}



	public boolean isSurAttente() {
		return surAttente;
	}



	public boolean isPresence() {
		return presence;
	}



	public void setSurAttente(boolean surAttente) {
		this.surAttente = surAttente;
	}



	public void setPresence(boolean presence) {
		this.presence = presence;
	}

}
