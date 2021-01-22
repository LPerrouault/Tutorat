package fun;

public class User {
	private String NumEtu;
	private String nom;
	private String prenom;
	private String mail;
	private String passwd;
	private String statut;
	private int idFiliere;

	public User() {
		
	}
	
	public User(String NumEtu, String nom, String prenom, String mail, String passwd, String statut, int idFiliere) {
		this.NumEtu = NumEtu;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.passwd = passwd;
		this.statut = statut;
		this.idFiliere = idFiliere;
	}


	public String getNumEtu() {
		return NumEtu;
	}


	public String getNom() {
		return nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public String getMail() {
		return mail;
	}


	public String getPasswd() {
		return passwd;
	}


	public String getStatut() {
		return statut;
	}

	public int getIdFiliere() {
		return idFiliere;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	public void setNumEtu(String numetu) {
		NumEtu = numetu;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public void setIdFiliere(int idFiliere) {
		this.idFiliere = idFiliere;
	}
	
	@Override
	public boolean equals(Object obj) {
		User us = (User) obj;
		return (us.getNumEtu() == this.NumEtu);
	}


}
