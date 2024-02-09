package CompleteCrudOperationUsingJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class updateData {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(" Class Loaded Successfully:");
			String url = "jdbc:mysql://localhost:3306/jdbcRevision?createDatabaseIfNotExist=true";
			String user = "root";
			String pass = "admin";
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println(" Connection stablish Successfully............");
			String query = " update student set Sname=? , Scity=? where Sid=?";
			PreparedStatement ps = con.prepareStatement(query);
			System.out.println("Enter Student Name:");
			String Sname = sc.next();
			ps.setString(1, Sname);
			System.out.println("Enter Student City:");
			String Scity = sc.next();
			ps.setString(2, Scity);
			System.out.println("Enter Student Id to update");
			int sid = sc.nextInt();
			ps.setInt(3, sid);
			ps.executeUpdate();
			System.out.println(" 1 data Updated...........");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
