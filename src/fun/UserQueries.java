package fun;

import Database.DatabaseConection;
import Database.DatabaseInteraction;
import com.zaxxer.hikari.HikariConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserQueries {

	private Connection cn=null;
	Statement st = null;
	ResultSet rs = null;
	//detaille Connection Database sur Gooogle Cloud
	String databaseName = "tutorat";
	String databaseUser = "root";
	String databasePassword = "";
	String localConnection = "jdbc:mysql://localhost/"+databaseName;
	private DatabaseInteraction data;

	public UserQueries() throws  SQLException, ClassNotFoundException {
		cn = DatabaseConection.getInstance(localConnection, databaseUser,databasePassword);
		data = new DatabaseInteraction();
	}
// Requetes communes aux �tudiants et aux tuteurs
public ArrayList<Cours> getListeCours(String userNumEtu) throws SQLException{
	
	ArrayList<Cours> c = new ArrayList<>();
	Cours d = new Cours ();

	String req ="SELECT nom, date, salle FROM cours WHERE idResponsable ="+userNumEtu;
	st = cn.createStatement();
   	rs = st.executeQuery(req);
    while(rs.next()) {
		d.setIdCours(rs.getInt("idCours"));
    	d.setNom(rs.getString("nom"));
    	d.setDate(rs.getDate("date"));
    	d.setSalle(rs.getString("salle"));
    	c.add(d);
    }
    return c;
}

public Cours findID(String id) throws SQLException {
	
	Cours e = new Cours();
	PreparedStatement pstmt4 = cn.prepareStatement("SELECT * FROM cours WHERE idCours = ?");
	pstmt4.setString(1,id);
	
	ResultSet rs2 = pstmt4.executeQuery();
	while(rs2.next()) {
		e.setIdCours(rs2.getInt("idCours"));
		e.setNom(rs2.getString("nom"));
		e.setDate(rs2.getDate("date"));
		e.setSalle(rs2.getString("salle"));
		e.setNbreElevMax(rs2.getInt("nbEleveMax"));
		e.setDescriptif(rs2.getString("descriptif"));
		e.setIdMatiere(rs2.getInt("idMatiere"));
	}
	return e;
}

	public ArrayList<String> affichageMatiere() throws SQLException {
			String req = "SELECT matiere.nom FROM matiere\n" +
					"INNER JOIN user ON user.idFiliere=matiere.idFiliere\n" +
					"WHERE userNumEtu=\""+data.lastUserConnected()+"\" OR userMail=\""+data.lastUserConnected()+"\"\n";
			ArrayList<String> list = new ArrayList<>();
		st = cn.createStatement();
		rs = st.executeQuery(req);
		while(rs.next()) {
			String s = rs.getString("nom");
			list.add(s);
		}
		return list;
	}

	public ArrayList<Cours> affichageInscriptionCours(String s) throws SQLException {
		String req1 = "SELECT cours.idCours,cours.nom,cours.date,cours.heur,cours.salle,cours.descriptif\n" +
				"FROM cours\n" +
				"INNER JOIN matiere ON matiere.idmatiere=cours.idmatiere\n" +
				"WHERE matiere.nom=\""+s+"\" AND matiere.idFiliere =(\n" +
				"    SELECT idFiliere \n" +
				"    FROM user\n" +
				"    WHERE userNumEtu=\""+data.lastUserConnected()+"\" OR userMail=\""+data.lastUserConnected()+"\"\n" +
				"    )";

		ArrayList<Cours> list = new ArrayList<>();
		Cours cours = new Cours();
		st = cn.createStatement();
		rs = st.executeQuery(req1);
		while(rs.next()) {
			cours.setIdCours(rs.getInt("idCours"));
			System.out.println(cours.getIdCours());
			cours.setNom(rs.getString("nom"));
			System.out.println(cours.getNom());
			cours.setDate(rs.getDate("date"));
			System.out.println(cours.getDate());
			cours.setHeur(rs.getString("heur"));
			System.out.println(cours.getHeur());
			cours.setSalle(rs.getString("salle"));
			System.out.println(cours.getSalle());
			cours.setDescriptif(rs.getString("descriptif"));
			System.out.println(cours.getDescriptif());
			list.add(cours);
		}
		return list;
	}

	public ArrayList<Cours> affichageCours() throws SQLException {
		String req1 = "SELECT cours.idCours,cours.nom,cours.date,cours.heur,cours.salle,cours.descriptif\n" +
				"FROM cours\n" +
				"INNER JOIN s_inscrit ON cours.idCours=s_inscrit.idCours\n" +
				"WHERE s_inscrit.userNumEtu =(\n" +
				"    SELECT userNumEtu FROM user\n" +
				"    WHERE userNumEtu=\""+data.lastUserConnected()+"\" OR userMail=\""+data.lastUserConnected()+"\"\n" +
				")";

		ArrayList<Cours> list = new ArrayList<>();
		Cours cours = new Cours();
		st = cn.createStatement();
		rs = st.executeQuery(req1);
		while(rs.next()) {
			cours.setIdCours(rs.getInt("idCours"));
			System.out.println(cours.getIdCours());
			cours.setNom(rs.getString("nom"));
			System.out.println(cours.getNom());
			cours.setDate(rs.getDate("date"));
			System.out.println(cours.getDate());
			cours.setHeur(rs.getString("heur"));
			System.out.println(cours.getHeur());
			cours.setSalle(rs.getString("salle"));
			System.out.println(cours.getSalle());
			cours.setDescriptif(rs.getString("descriptif"));
			System.out.println(cours.getDescriptif());
			list.add(cours);
		}
		return list;
	}

	public ArrayList<Cours> affichageCoursTuteur() throws SQLException {
		String req1 = "SELECT cours.idCours,cours.nom,cours.date,cours.heur,cours.salle,cours.descriptif\n" +
				"FROM cours \n" +
				" WHERE idResponsable=(\n" +
				"     SELECT userNumEtu FROM user\n" +
				"    WHERE userNumEtu=\""+data.lastUserConnected()+"\" OR userMail=\""+data.lastUserConnected()+"\"\n" +
				" )";

		ArrayList<Cours> list = new ArrayList<>();
		Cours cours = new Cours();
		st = cn.createStatement();
		rs = st.executeQuery(req1);
		while(rs.next()) {
			cours.setIdCours(rs.getInt("idCours"));
			System.out.println(cours.getIdCours());
			cours.setNom(rs.getString("nom"));
			System.out.println(cours.getNom());
			cours.setDate(rs.getDate("date"));
			System.out.println(cours.getDate());
			cours.setHeur(rs.getString("heur"));
			System.out.println(cours.getHeur());
			cours.setSalle(rs.getString("salle"));
			System.out.println(cours.getSalle());
			cours.setDescriptif(rs.getString("descriptif"));
			System.out.println(cours.getDescriptif());
			list.add(cours);
		}
		return list;
	}

  public void inscrire(Cours c) throws SQLException{
	  Inscrits s = new Inscrits();
	 int d;
	 int e;
	 int i=0;
	 int nbreMax = c.getNbreElevMax();
	 int placeR= nbreMax - i;
	 Statement stmt = cn.createStatement();
	 String sql = "SELECT COUNT(userNumEtu) FROM S_inscrit WHERE idCours = " + c.getIdCours();
	 i = stmt.executeUpdate(sql); 
	 
	 if(placeR < nbreMax ) {
	
		 Statement stmt1 = cn.createStatement();
		 String sql1 = "INSERT INTO s_inscrit VALUES ( " + c.getIdCours() + s.getNumEtu()+s.isSurAttente()+s.isPresence()+")";
		 d = stmt1.executeUpdate(sql1);
	 }
	 
	 else {
		 s.setSurAttente(true);
		 Statement stmt2 = cn.createStatement();
		 String sql2 = "INSERT INTO s_inscrit VALUES ( " + c.getIdCours() + s.getNumEtu()+s.isSurAttente()+s.isPresence()+")";
		 d = stmt2.executeUpdate(sql2);
	 }
	  
 }


 public void desinscrire(Cours c) throws SQLException{
      User u = new User();
	  ArrayList<Cours> inscrits = new ArrayList<>();
	  inscrits =getListeCours(u.getNumEtu()); 
	 
	  if(inscrits.contains(c)) {
		  PreparedStatement pstmt1 = cn.prepareStatement("DELETE idCours,userNumEtu,surAttente,pr�sence FROM s_inscrit WHERE userNumEtu = ?");
		  pstmt1.setString(1, u.getNumEtu());
	  }
	 
 }
 
 // Requetes pour tuteurs
 public boolean addCours (Cours d) throws SQLException {
	 
	 int c;
	 try {
		 Cours f = new Cours();
		 f = findID("f.getIdCours");
		 if(f.getIdCours()==d.getIdCours()) {
			 System.out.println("Ce cours a d�j� �t� cr�e");
			 return false;
		 }
		 else {
			 Statement stmt4 = cn.createStatement();
			 String sql4 = "INSERT INTO cours VALUES ( " + f.getIdCours()+f.getNom()+f.getDate()+f.getSalle()+f.getNbreElevMax()+f.getDescriptif()+f.getIdMatiere()+")";
		     c= stmt4.executeUpdate(sql4);
		     if(c>0) {
		    	 return true;
		     }
		 }
	 }catch(Exception ex) {
		   ex.printStackTrace();
	   } 
	 return false;
 }
 
 
 public boolean modifyDate (Cours d) throws SQLException {
	 int c;
	 try {
		 Cours f = new Cours();
		 f= findID("f.getIdCours");
		 if(f.getIdCours()!=d.getIdCours()) {
			 System.out.println("Je n'ai pas trouv� ce cours");
			 return false;
		 }
		 else {
			 Statement stmt5 = cn.createStatement();
			 String sql5 = "UPDATE cours SET (date  = " + d.getDate() + ")" ;
			 c=stmt5.executeUpdate(sql5);
			 if(c>0) {
				 return true;
			 }
		 }
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 return false;
 }
 
 public boolean modifySalle(Cours d) throws SQLException{
	 int c;
	 try {
		 Cours f = new Cours();
		 f= findID("f.getIdCours");
		 if(f.getIdCours()!=d.getIdCours()) {
			 System.out.println("Je n'ai pas trouvé ce cours");
			 return false;
		 }
		 else {
			 Statement stmt6 = cn.createStatement();
			 String sql6 = "UPDATE cours SET (salle  = " + d.getSalle() + ")" ;
			 c=stmt6.executeUpdate(sql6);
			 if(c>0) {
				 return true;
			 }
		 }
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 return false;
 }
 
 //Requetes pour l'admin
 public List <User> findbyID(String id) throws SQLException{
	 
	 List<User> r = new ArrayList<User>();
	 
	 PreparedStatement pstmt2 = cn.prepareStatement("SELECT * FROM user WHERE id = ?");
	 pstmt2.setString(1, id);
	 
	 ResultSet rs1 = pstmt2.executeQuery();
		while(rs1.next()){
			User f = new User();
			f.setNumEtu(rs1.getString("userNumEtu"));
		    f.setNom(rs1.getString("userNom"));
			f.setPrenom(rs1.getString("userPrenom"));
		    f.setMail(rs1.getString("userMail"));
		    f.setPasswd(rs1.getString("password"));
		    f.setStatut(rs1.getString("statut"));
		    f.setIdFiliere(rs1.getInt("idFiliere"));
		    r.add(f);	 
			}
	 return r;
 }


public boolean insert (User v) throws SQLException {
	int f;
	try {
		User u = new User();
		List<User> utilisateur = new ArrayList<User>();
		utilisateur = findbyID(u.getNumEtu());
		
		if(u.getNumEtu()==v.getNumEtu()) {
			System.out.println("L'utilisateur existe d�j�");
			return false;
		}
		else {
			Statement stmt3 = cn.createStatement();
			String sql3 = "INSERT INTO user VALUES ( " + v.getNumEtu() + v.getNom()+v.getPrenom()+v.getMail()+v.getPasswd()+v.getStatut()+v.getIdFiliere() + ")";
			f = stmt3.executeUpdate(sql3);
			if(f>0) {
				return true;
			}
		}
		}catch(Exception e) {
		   e.printStackTrace();
	   } 
	return false;
}


public boolean updateStatut(User v) throws SQLException{
	int f;
	try {
		User u = new User();
		List<User> utilisateur = new ArrayList<User>();
		utilisateur = findbyID(u.getNumEtu());
		
		if(u.getNumEtu()!=v.getNumEtu()) {
			System.out.println("L'utilisateur n'existe pas ");
			return false;
		}
		else {
			Statement stmt6 = cn.createStatement();
			String sql6 = "UPDATE user SET (salle =  " + v.getStatut()+ ")";
			f = stmt6.executeUpdate(sql6);
			if(f>0) {
				return true;
			}
		}
		}catch(Exception e) {
		   e.printStackTrace();
	   } 
	return false;
}

}
