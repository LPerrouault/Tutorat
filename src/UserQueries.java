
import Database.DatabaseConection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserQueries {
	
	private Connection cn;
	
	
	

	public UserQueries(String u,String l,String p) throws  SQLException, ClassNotFoundException {
		this.cn = DatabaseConection.getInstance(u, l, p);
	}
// Requetes communes aux �tudiants et aux tuteurs
public List<Cours> getListeCours(String userNumEtu) throws SQLException{
	
	List<Cours> c = new ArrayList <Cours> ();
	
	PreparedStatement pstmt = cn.prepareStatement("SELECT C.idMatiere,C.date,C.salle,C.descriptif FROM Cours C INNER JOIN S_inscrit S WHERE C.userNumEtu = ?");
    pstmt.setString(1, userNumEtu);
    
    ResultSet rs = pstmt.executeQuery();
    while(rs.next()) {
    	Cours d = new Cours ();
    	d.setIdMatiere(rs.getInt("C.idMatiere"));
    	d.setDate(rs.getDate("C.date"));
    	d.setSalle(rs.getString("C.salle"));
    	d.setDescriptif(rs.getString("C.decriptif"));
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
	  List<Cours> inscrits = new ArrayList<Cours> ();
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
			 System.out.println("Je n'ai pas trouv� ce cours");
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