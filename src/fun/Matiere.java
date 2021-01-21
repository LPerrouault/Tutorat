package fun;

public class Matiere {
	

	private  int idMatiere;
	private  String nom;
	private int idFiliere;

	public Matiere() {
		idFiliere=0;
		idMatiere=0;
		nom=null;
	}

	public int getIdMatiere() {
		return idMatiere;
	}

	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getIdFiliere() {
		return idFiliere;
	}

	public void setIdFiliere(int idFiliere) {
		this.idFiliere = idFiliere;
	}

	@Override
	public String toString() {
		return "Matiere{" +
				"idMatiere=" + idMatiere +
				", nom='" + nom + '\'' +
				", idFiliere=" + idFiliere +
				'}';
	}
}
