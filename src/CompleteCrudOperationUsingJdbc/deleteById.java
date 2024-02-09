package CompleteCrudOperationUsingJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class deleteById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(" Class Loaded..........");
			String url = "jdbc:mysql://localhost:3306/jdbcRevision?createDatabaseIfNotExist=true";
			String user = "root";
			String pass = "admin";
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println(" Connection stablish Successfully............");
			String query = "delete from student where Sid=?";
			PreparedStatement ps = con.prepareStatement(query);
			System.out.println("Enter student id to delete:");
			int id = sc.nextInt();
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("  1 Record Deleted:");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
