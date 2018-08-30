/*
Deleting a Student’s record
When a student leaves the school, the record related to that student needs 
to be deleted from the Student table. The student’s roll no, whose record 
has to be deleted, should be passed as a command line argument.
Upon deletion, the Student details must be stored in another table named 
StudentLog which will maintain the details such as Rollno, StudentName, 
Standard and Leaving_date.

CREATE TABLE stdnt_log (
	Rollno Number (4) Primary Key,
	StudentName Varchar (20)  Not Null,
	Standard Varchar (2) Not Null,
	Date_Of_Birth Date,
	Fees Number (9,2)
);

INSERT INTO stdnt VALUES(1001, 'BOB', 'IV', '15-aUG-1947', 4500.0);
 */

package com.w3epic.wiprotraining.assignment3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Assignment3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "scott", "tiger");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int rollno = Integer.parseInt(args[0]);
		
		try {
			// backup/log student data to stdnt_log table
			sql = "INSERT INTO stdnt_log SELECT * FROM stdnt WHERE rollno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rollno);
			int logged = pstmt.executeUpdate();
			
			// delete student data from stdnt table
			sql = "DELETE FROM stdnt WHERE rollno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rollno);
			
			if (pstmt.executeUpdate() == 1 && logged == 1)
				System.out.println("Student having rollno = " + rollno + " deleted successfully");
			else
				System.out.println("Error");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		sc.close();
	}

}
