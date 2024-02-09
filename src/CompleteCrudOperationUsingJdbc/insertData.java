package CompleteCrudOperationUsingJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insertData {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean b = true;
		while (b) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println(" Class Loaded:");
				String url = "jdbc:mysql://localhost:3306/jdbcRevision?createDatabaseIfNotExist=true";
				String user = "root";
				String pass = "admin";
				Connection con = DriverManager.getConnection(url, user, pass);
				System.out.println(" Connection stablish Successfully............");
				String query = "insert into student(Sname , Scity)value(? , ?)";
				PreparedStatement ps = con.prepareStatement(query);
				System.out.println("Enter Student Name:");
				String Sname = sc.next();
				System.out.println("Enter Student City:");
				String Scity = sc.next();
				ps.setString(1, Sname);
				ps.setString(2, Scity);
				ps.executeUpdate();
				System.out.println(" 1 data Inserted...........");
//				b = false;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
