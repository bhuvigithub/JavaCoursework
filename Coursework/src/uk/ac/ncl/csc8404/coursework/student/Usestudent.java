package uk.ac.ncl.csc8404.coursework.student;

import java.util.List;


import uk.ac.ncl.csc8404.coursework.management.StudentManagement;
import uk.ac.ncl.csc8404.coursework.supervisor.Supervisor;
/**
 * 
 * @author Bhubanesh Mishra
 * Usestudent - Class that is an main critical path class to check the functionality of the student management functions.
 *
 */
public class Usestudent {

	public static void main(String[] args) {
		StudentManagement mgmt = StudentManagement.getInstance();
		// tests the student management class Data read function to get the data from a data csv file.
		List<StudentDetails> data = mgmt.studentDataquery();
		Supervisor sp = new Supervisor("John", "Walker");
		
	    System.out.println("Details of the first Student from the data file : ");
	    System.out.println("Student Name is : " + data.get(0).getFirstName() + " " + data.get(0).getLastName() );
	    System.out.println("Student's DOB is : " + data.get(0).getDateOfBirth());
	    System.out.println("Student's Age is : " + data.get(0).getAge());
	    System.out.println("Register this Student" ); 
	    mgmt.registerStudent(data.get(0));
	    System.out.println("Get the list of Modules for which this student is eligible for registration : ");
		System.out.println(data.get(0).getModuleMapping());
		//tests the student management class Registration of a new student function.
		System.out.println("Registration Successfull : " + data.get(0).getstudentregis());
		System.out.println("Get a Student Id for this student is : " + data.get(0).getStudentId());
		//tests the student management class issue smart card function.
		System.out.println("Issue a SmartCard to the student");
		mgmt.issueStudentSmartCard(data.get(0).getStudentId());
		System.out.println("Issued Smart card details are as follow : ");
		System.out.println(data.get(0).getStudentCard());
		
		//test for adding multiple student of different types from the student data csv file and using the registration function on them.
		
		System.out.println("Details of the second Student from the data file : ");
	    System.out.println("Student Name is : " + data.get(1).getFirstName() + " " + data.get(1).getLastName() );
	    System.out.println("Student's DOB is : " + data.get(1).getDateOfBirth());
	    System.out.println("Student's Age is : " + data.get(1).getAge());
	    System.out.println("Register this Student" ); 
	    mgmt.registerStudent(data.get(1));
		System.out.println("Registration Successfull : " + data.get(1).getstudentregis());
		System.out.println("Generate a Student Id for this student is : " + data.get(1).getStudentId());
		System.out.println("Issue a SmartCard to the student");
		mgmt.issueStudentSmartCard(data.get(1).getStudentId());
		System.out.println("Issued Smart card details are as follow : ");
		System.out.println(data.get(1).getStudentCard());
		
		System.out.println("Details of the third Student from the data file : ");
	    System.out.println("Student Name is : " + data.get(2).getFirstName() + " " + data.get(2).getLastName() );
	    System.out.println("Student's DOB is : " + data.get(2).getDateOfBirth());
	    System.out.println("Student's Age is : " + data.get(2).getAge());
	    System.out.println("Register this Student" ); 
	    mgmt.registerStudent(data.get(2));
	    System.out.println("Name of the supervisor : ");
		data.get(2).setSupervisor(sp);
		System.out.println(data.get(2).getSupervisorName());
		System.out.println("Registration Successfull : " + data.get(2).getstudentregis());
		System.out.println("Generate a Student Id for this student is : " + data.get(2).getStudentId());
		System.out.println("Issue a SmartCard to the student");
		mgmt.issueStudentSmartCard(data.get(2).getStudentId());
		System.out.println("Issued Smart card details are as follow : ");
		System.out.println(data.get(2).getStudentCard());
		
		System.out.println("Details of the fourth Student from the data file : ");
	    System.out.println("Student Name is : " + data.get(3).getFirstName() + " " + data.get(2).getLastName() );
	    System.out.println("Student's DOB is : " + data.get(3).getDateOfBirth());
	    System.out.println("Student's Age is : " + data.get(3).getAge());
	    System.out.println("Register this Student" ); 
	    mgmt.registerStudent(data.get(3));
		
		System.out.println("Details of the fifth Student from the data file : ");
	    System.out.println("Student Name is : " + data.get(4).getFirstName() + " " + data.get(2).getLastName() );
	    System.out.println("Student's DOB is : " + data.get(4).getDateOfBirth());
	    System.out.println("Student's Age is : " + data.get(4).getAge());
	    System.out.println("Register this Student" ); 
	    mgmt.registerStudent(data.get(4));
		
	    //tests the student management class no of student type function.
		System.out.println("Total no of students registered in UG : " + mgmt.noOfStudents(StudentType.UG));
		System.out.println("Total no of students registered in PGT : " + mgmt.noOfStudents(StudentType.PGT));
		System.out.println("Total no of students registered in PGR : " + mgmt.noOfStudents(StudentType.PGR));
		
		//tests the student management class registration boolean method 
		System.out.println("Studuent #" + data.get(4).getStudentId() + " Registered into student repo: " 
				+ mgmt.hasRegistered(data.get(4).getStudentId()));
		
		//tests the student management class terminate function
		System.out.println("Terminating 5th student");
        mgmt.terminateStudent(data.get(4).getStudentId());
        
        System.out.println("Studuent #" + data.get(4).getStudentId() + " Registered into student repo: " 
				+ mgmt.hasRegistered(data.get(4).getStudentId()));
		
	    // tests the student management class student update function by fetching the details and updating the record accordingly.
        System.out.println("Ammending 3rd student" );
        StudentDetails nsd = new StudentDetails(data.get(2).getFirstName(), 
                data.get(2).getLastName(), 32, data.get(2).getDateOfBirth(),
                data.get(2).getCredit(), data.get(2).getPassmarks());
        nsd.setModuleMapping(data.get(2).getModuleMapping());
                mgmt.ammendStudentData(data.get(2).getStudentId(), nsd);
	    StudentDetails asd = mgmt.getStudent(data.get(2).getStudentId());
        System.out.println("New Details of the third Student from the data file : ");
	    System.out.println("Student Name is : " + asd.getFirstName() + " " + asd.getLastName() );
	    System.out.println("Student's New Age is : " + asd.getAge());
	     
	    
	}
	
	
	
	
	

}
