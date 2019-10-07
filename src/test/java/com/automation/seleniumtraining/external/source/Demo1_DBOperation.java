package com.automation.seleniumtraining.external.source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo1_DBOperation {

	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testing","root","admin");
			
			Scanner sc= new Scanner(System.in);
			System.out.print("Enter the name : ");
			String name=sc.next();
			
			PreparedStatement st= con.prepareStatement("Select empid,ename from emp where ename=?");
			
			st.setString(1, name);
			ResultSet rs= st.executeQuery();
			while(rs.next()){
				System.out.print(rs.getString("empid")+" - ");
				System.out.println(rs.getString("ename"));
			}
		}
		catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
		}
		catch(SQLException se){
			se.printStackTrace();
		}
		
	}

}
