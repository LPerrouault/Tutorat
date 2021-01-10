
import java.sql.Date;

public class Cours {
 
	private int idCours;
	private String nom;
	private Date date;
	private String salle;
	private int NbreElevMax;
	private String descriptif;
	private int idMatiere;
	
	
	public Cours() {
		
	}


	public int getIdCours() {
		return idCours;
	}


	public String getNom() {
		return nom;
	}


	public Date getDate() {
		return date;
	}


	public String getSalle() {
		return salle;
	}


	public int getNbreElevMax() {
		return NbreElevMax;
	}


	public String getDescriptif() {
		return descriptif;
	}


	public int getIdMatiere() {
		return idMatiere;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public void setSalle(String salle) {
		this.salle = salle;
	}


	public void setNbreElevMax(int nbreElevMax) {
		NbreElevMax = nbreElevMax;
	}


	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}


	public void setIdCours(int idCours) {
		this.idCours = idCours;
	}


	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}

}
