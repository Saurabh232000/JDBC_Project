package CompleteCrudOperationUsingJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class findAllData {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(" Class Loaded..........");
			String url = "jdbc:mysql://localhost:3306/jdbcRevision?createDatabaseIfNotExist=true";
			String user = "root";
			String pass = "admin";
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println(" Connection stablish Successfully............");
			String query = "select * from student ";
			Statement cs = con.createStatement();
			ResultSet rs = cs.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String city = rs.getString(3);
				System.out.println(id);
				System.out.println(name);
				System.out.println(city);
				System.out.println("_________");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
