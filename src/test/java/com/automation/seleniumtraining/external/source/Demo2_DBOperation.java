package com.automation.seleniumtraining.external.source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo2_DBOperation {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter the name to be inserted: ");
		String name=sc.next();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testing","root","admin");
			PreparedStatement st= con.prepareStatement("insert into emp(ename) values (?)");
			st.setString(1, name);
			int rows=st.executeUpdate();
			System.out.println("No of rows inserted: "+rows);
		}
		catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		sc.close();
	}

}
