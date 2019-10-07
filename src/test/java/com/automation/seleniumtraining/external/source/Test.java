package com.automation.seleniumtraining.external.source;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {
	List<User> users=new ArrayList<User>();
	
	public static void main(String[] args) {
		Test t= new Test();
		t.doTest();		

	}
	private void doTest(){
		//get the data from database
		getDataFromDB();
		printUsers();
		//iterate each data and supply the values to the website
		Signon s= new Signon();
		s.openBrowser();
		// access the home page
		s.accessHomePage();
		// verify the title
		if(s.verifyTitle()){
			for(User u:users){
				String actualTitle=s.signOn(u.getUser(), u.getPassword(), u.getExpectedTitle());
				u.setActualTitle(actualTitle);
				s.gotoHomePage();
			}
		}
		s.closeBrowser();
		printUsers();
		// capture the results and write them to excel sheet
		writeResultsToExcel();
	}
	
	private void printUsers(){
		for (User u:users){
			System.out.println(u);
		}
	}
	
	private void getDataFromDB(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testing","root","admin");
			PreparedStatement st= con.prepareStatement("Select login,password,expectedTitle from users");
			ResultSet rs= st.executeQuery();
			while(rs.next()){
				String name=rs.getString("login");
				String pass=rs.getString("password");
				String expTitle=rs.getString("expectedTitle");
				User u= new User(name,pass,expTitle);
				users.add(u);
			}
		}
		catch(ClassNotFoundException cnfe){
			cnfe.printStackTrace();
		}
		catch(SQLException se){
			se.printStackTrace();
		}
	}
	
	public void writeResultsToExcel() {
		try {

			Workbook wb = new XSSFWorkbook();// new HSSFWorkbook();
			FileOutputStream fileOut = new FileOutputStream("sample.xlsx");
			Sheet sheet1 = wb.createSheet("Details");
			
			Row row = sheet1.createRow((short) 0);
			row.createCell(0).setCellValue("Login");
			row.createCell(1).setCellValue("Password");
			row.createCell(2).setCellValue("Expected Title");
			row.createCell(3).setCellValue("Actual Title");
			row.createCell(4).setCellValue("Status");
			// Iterate the collection
			short r = 1;
			for (User u : users) {
				row = sheet1.createRow(r);
				row.createCell(0).setCellValue(u.getUser());
				row.createCell(1).setCellValue(u.getPassword());
				row.createCell(2).setCellValue(u.getExpectedTitle());
				row.createCell(3).setCellValue(u.getActualTitle());
				String result="Fail";
				if(u.getActualTitle().contains(u.getExpectedTitle())){
					result="Pass";
				}
				row.createCell(4).setCellValue(result);
				r=(short)(r+1);
			}
			wb.write(fileOut);
			wb.close();
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
