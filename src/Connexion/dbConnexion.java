package Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbConnexion {
	public Connection Connect() {
		try {
			String url = "";
			String user ="root";
			String password ="root";
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			
			return conn ;
		} catch (ClassNotFoundException | SQLException  e) {
			// TODO: handle exception
			Logger.getLogger(dbConnexion.class.getName()).log(Level.SEVERE,null,e);
		}
		return null;
	}
	
}
