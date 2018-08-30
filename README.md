Wipro TalentNext PBL

Topics Covered:  Meta Data & PreparedStatement


No. 	Hands-on Assignment 	Topics Covered 	Status

1 	

 Develop a jdbc program containing main method, which should instantiate a class called DAOClass, which should contain methods called insert, delete, modify and display. Description of what each of these methods are expected to do is given below. Necessary details required for executing these methods, are passed from command line argument. For e.g. If the name of the class containing the main method is JDBCCalls, then if you want to insert a record, you will execute this class as java JDBCCalls 1 101 “Ajit” “IV” “20-Nov-2001” 4000
Where 1 is the option for inserting the record and all other details are the values for the columns in each row of the student table. The structure of student table is given below. Similarly, for deleting a record, you have to execute the code as 
java JDBCCalls 2 101
where 2 is the option for deleting a record and 101 is the rollno of the student, whose record has to be deleted.
For modifying a record, you will use
java JDBCCalls 3 101 4500, where 3 is the option for modifying a record and the 4500 is the new fee which needs to replace the old fee value.
For Displaying records, if the main class is executed as follows 
java JDBCCalls 4 101
it should display only one record, that of the student with roll no. 101. 4 option is for displaying the record. 
If the main class is executed as
java JDBCCalls 4 (without specifying the rollno.), it means that details of all the students should be displayed.

	PreparedStatement 	

2 	

 Inserting a record
ABC International School wants to computerize students details. The school maintains a database of students in Oracle. The student table contains information related to students and is shown in the following student table structure. 
Column Name Type  Constraint
Rollno Number (4) Primary Key
StudentName Varchar (20)  Not Null
Standard Varchar (2) Not Null
Date_Of_Birth Date 
Fees Number (9,2) 
           
 When a new student joins the school, the student record is inserted in the student table.  The valid student details are as follows:
• Rollno: Valid value is a 4-digit number 
• StudentName: Valid value can contain maximum 20 letters in uppercase
• Standard : Valid values are Roman Letters representing I to X(I, II, III, IV….IX, X)
Write a Java program to insert some records to the table

	PreparedStatement 	

3 	

 Deleting a Student’s record
When a student leaves the school, the record related to that student needs to be deleted from the Student table. The student’s roll no, whose record has to be deleted, should be passed as a command line argument.
Upon deletion, the Student details must be stored in another table named StudentLog which will maintain the details such as Rollno, StudentName, Standard and Leaving_date.

	PreparedStatement 	

4 	

 Modification of Student record 
When there is a change in the fee to be paid by a student, the respective row should be appropriately updated. Pass the rollno from the command prompt along with the new fee amount and this amount should be reflected in the table for that particular student.

	PreparedStatement 	

5 	

 Display Student details
Write the code to display details of all the students, if no roll no. is passed, while executing the main program.
If while executing the main program, the roll no. is passed, then it should display the record of that particular student.

	PreparedStatement 	