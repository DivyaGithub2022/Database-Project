package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertExample {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","root");
		
		Statement stmt = con.createStatement();
		
		stmt.executeUpdate("insert into eproduct (name, price, date_added) values ('Head phone',100.00, now())");
		System.out.println("The row is inserted.");
		
		ResultSet result = stmt.executeQuery("select * from eproduct");
		
		while(result.next()) {
			System.out.println("Product Id " + result.getInt("ID"));
			System.out.println("Product name " + result.getString("name"));
		}
		

		stmt.executeUpdate("update eproduct set name = 'Tablet' where name = 'iPad';");
		System.out.println("The row is updated.");
		
		ResultSet result1 = stmt.executeQuery("select * from eproduct");
		
		while(result1.next()) {
			System.out.println("Product Id " + result1.getInt("ID"));
			System.out.println("Product name " + result1.getString("name"));
			System.out.println("Product price " + result1.getDouble("price"));
		}
			
		con.close();
		
	}

}
