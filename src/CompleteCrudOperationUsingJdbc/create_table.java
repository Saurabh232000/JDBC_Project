package CompleteCrudOperationUsingJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class create_table {
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded");
			String url = "jdbc:mysql://localhost:3306/jdbcRevision?createDatabaseIfNotExist=true";
			String user = "root";
			String pass = "admin";
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println("connection established successfully!!!!!!!!!!");
			String q = "create table Student (Sid int(20) primary key auto_increment,Sname varchar(20),Scity varchar(20))";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(q);
			System.out.println(" Student table created successfully!!!!!!!!!!");
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
