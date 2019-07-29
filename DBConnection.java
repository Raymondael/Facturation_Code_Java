package donnees;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DBConnection {
	
	static Connection conn;
	static Statement st;
	ResultSet rs;
	PreparedStatement pst;
	
	public static Connection SeConnecter() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("Jdbc:mysql://localhost/facturation","root", "");
			st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			System.out.println("connexion établit");
			return conn;
			
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "connexion echouee");
			return null;
		}
	}

}
