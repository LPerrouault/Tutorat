package fun;

public class Inscrits {

	private int idCours;
	private int numEtu;
	private boolean surAttente;
	private boolean presence;
	
	
	
	public Inscrits() {
		
	}
	
	public void setIdCours(int idCours) {
		this.idCours = idCours;
	}
	
	public void setNumEtu(int numEtu) {
		this.numEtu = numEtu;
	}

	public int getIdCours() {
		return idCours;
	}



	public int getNumEtu() {
		return numEtu;
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
