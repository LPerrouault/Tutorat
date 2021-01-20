package fun;

import java.sql.Date;
import java.util.ArrayList;

public class Cours {
 
	private int idCours;
	private String nom;
	private Date date;
	private String heur;
	private String salle;
	private int NbreElevMax;
	private String descriptif;
	private int idMatiere;
	public ArrayList<String> courList;


	public Cours() {

		this.idCours = idCours;
		this.nom = nom;
		this.date = date;
		this.salle = salle;
		this.NbreElevMax = NbreElevMax;
		this.descriptif = descriptif;
		this.idMatiere = idMatiere;
		courList= new ArrayList<>();
		courList.add(String.valueOf(getIdCours()));
		courList.add(getNom());
		courList.add(String.valueOf(getDate()));
		courList.add(getHeur());
		courList.add(getSalle());
	}

	public String getHeur() {
		return heur;
	}

	public void setHeur(String heur) {
		this.heur = heur;
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

	@Override
	public String toString() {
		return "Cours{" +
				"idCours=" + idCours +
				", nom='" + nom + '\'' +
				", date=" + date +
				", salle='" + salle + '\'' +
				", NbreElevMax=" + NbreElevMax +
				", descriptif='" + descriptif + '\'' +
				", idMatiere=" + idMatiere +
				'}';
	}
}
