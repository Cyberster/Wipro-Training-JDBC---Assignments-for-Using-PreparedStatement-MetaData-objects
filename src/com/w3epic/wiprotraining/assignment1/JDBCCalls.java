/*
Develop a jdbc program containing main method, which should instantiate a class 
called DAOClass, which should contain methods called insert, delete, modify and 
display. Description of what each of these methods are expected to do is given 
below. Necessary details required for executing these methods, are passed from 
command line argument. For e.g. If the name of the class containing the main 
method is JDBCCalls, then if you want to insert a record, you will execute this 
class as 

	java JDBCCalls 1 101 Ajit IV 20-Nov-2001 4000

Where 1 is the option for inserting the record and all other details are the 
values for the columns in each row of the student table. The structure of 
student table is given below. Similarly, for deleting a record, you have to 
execute the code as 

	java JDBCCalls 2 101 

where 2 is the option for deleting a record and 101 is the rollno of the 
student, whose record has to be deleted.
For modifying a record, you will use 

	java JDBCCalls 3 101 4500

where 3 is the option for modifying a record and the 4500 is the new fee 
which needs to replace the old fee value.
For Displaying records, if the main class is executed as follows 

	java JDBCCalls 4 101

it should display only one record, that of the student with roll no. 101. 
4 option is for displaying the record. 
If the main class is executed as

	java JDBCCalls 4 

(without specifying the rollno.), it means that details of all the students 
should be displayed.
 * */

package com.w3epic.wiprotraining.assignment1;

public class JDBCCalls {

	public static void main(String[] args) {
		int option = Integer.parseInt(args[0]);
		DAOClass dao = new DAOClass();
		
		switch (option) {
		case 1: // insert: java JDBCCalls 1 101 Ajit IV 20-Nov-2001 4000
			int rollno = Integer.parseInt(args[1]);
			String name = args[2];
			String grade = args[3];
			String dob = args[4];
			int fee = Integer.parseInt(args[5]);
			
			if (dao.insert(rollno, name, grade, dob, fee))
				System.out.println("Inserted successfully");
			else 
				System.out.println("Insertion error");
			break;
			
		case 2: // delete: java JDBCCalls 2 101 
			rollno = Integer.parseInt(args[1]);
			
			if (dao.delete(rollno))
				System.out.println("Deleted successfully");
			else 
				System.out.println("Deletion error");
			
			break;
			
		case 3: // update: java JDBCCalls 3 101 4500
			rollno = Integer.parseInt(args[1]);
			fee = Integer.parseInt(args[2]);
			
			if (dao.modify(rollno, fee))
				System.out.println("Modified successfully");
			else 
				System.out.println("Modification error");
			break;
			
		case 4: // select: java JDBCCalls 4 101
			try {
				rollno = Integer.parseInt(args[1]);
				dao.display(rollno);
				break;
			} catch (Exception e) {
				dao.display();
				break;
			}
			
			
		}

	}

}
