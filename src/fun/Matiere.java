package fun;

public class Matiere {
	

	private  int idMatiere;
	private  String nom;
	private int idFiliere;

	public Matiere() {
		
	}
	
	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public  int getIdMatiere() {
		return idMatiere;
	}

	public  String getNom() {
		return nom;
	}

	public int getIdFiliere() {
		return idFiliere;
	}

	public void setIdFiliere(int idFiliere) {
		this.idFiliere = idFiliere;
	}

}
