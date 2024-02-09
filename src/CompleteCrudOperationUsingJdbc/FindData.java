package CompleteCrudOperationUsingJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class FindData {
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
			String query = "select * from student where Sid=?";
			PreparedStatement ps = con.prepareStatement(query);
			System.out.println("Enter student id to fetch:");
			int id = sc.nextInt();
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String name = rs.getString(2);
				String city = rs.getString(3);
				System.out.println(name);
				System.out.println(city);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
