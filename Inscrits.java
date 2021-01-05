package User;

public class Inscrits {

	private int idCours;
	private char NumEtu;
	private boolean surAttente;
	private boolean présence;
	
	
	
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



	public boolean isPrésence() {
		return présence;
	}



	public void setSurAttente(boolean surAttente) {
		this.surAttente = surAttente;
	}



	public void setPrésence(boolean présence) {
		this.présence = présence;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
