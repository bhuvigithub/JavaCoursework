package uk.ac.ncl.csc8404.coursework.unitest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Test;


import uk.ac.ncl.csc8404.coursework.smartcard.SmartCard;
import uk.ac.ncl.csc8404.coursework.student.StudentDetails;
import uk.ac.ncl.csc8404.coursework.student.StudentType;
import uk.ac.ncl.csc8404.coursework.supervisor.Supervisor;
/**
 * 
 * @author Bhubanesh Mishra
 * StudentManagementUnitTest - Unit test class to test the functionality of the student methods used.
 *
 */
public class StudentManagementUnitTest {
	
	
/**
 * Test method for checking the Supervisor details 	
 */
	@Test
	public final void testSupervisorName() {
		Supervisor sp = new Supervisor("Nero", "Dante");
		assertEquals("Nero Dante", sp.toString());
	}
	/**
	 * Test method for checking the Student Name 	
	 */	
	@Test
	public final void testStudentName() {
		Date dob = new GregorianCalendar(1992, 11, 25).getTime();
		StudentDetails sd = new StudentDetails("Birt", "Hallow", 25, dob, 180 ,50);
		assertEquals("Birt Hallow", sd.toString());	
	}
	/**
	 * Test method to check empty supervisor details	
	 */	
	@Test
	public final void testEmptySupervisor() {
		Date dob = new GregorianCalendar(1992, 11, 25).getTime();
		StudentDetails sd1 = new StudentDetails("Birt", "Hallow", 25, dob, 180 ,50);
		Supervisor sp = new Supervisor("Mark", "Orton");
		sd1.setSupervisor(sp);
		assertEquals(null, sd1.getSupervisorName());
	}
	/**
	 * Test method for checking the student age 
	 */
	@Test
	public final void testStudentAge() {
		Date dob = new GregorianCalendar(1992, 11, 25).getTime();
		StudentDetails sd2 = new StudentDetails("Birt", "Hallow", 25, dob, 180 ,50);
		assertEquals(25, sd2.getAge());
	}
	/**
	 * Test method for checking the student DOB 	
	 */
	@Test
	public final void testStudentDateOfBirth() {
		Date dob = new GregorianCalendar(1992, 11, 25).getTime();
		StudentDetails sd3 = new StudentDetails("Birt", "Hallow", 25, dob, 180 ,50);
		assertEquals(dob, sd3.getDateOfBirth());
	}
	/**
	 * Test method to check PGT student type  	
	 */
	@Test
	public final void testPGTStudentType() {
		Date dob = new GregorianCalendar(1992, 11, 25).getTime();
		StudentDetails sd4 = new StudentDetails("Birt", "Hallow", 25, dob, 180 ,50);
		assertEquals(StudentType.PGT, sd4.getStudentType());
	}
	/**
	 * Test method to check UG student type  	
	 */
	
	@Test
	public final void testUGStudentType() {
		Date dob = new GregorianCalendar(1992, 11, 25).getTime();
		StudentDetails sd5 = new StudentDetails("Birt", "Hallow", 25, dob, 120 ,40);
		assertEquals(StudentType.UG, sd5.getStudentType());
	}
	/**
	 * Test method to check PGR student type  	
	 */
	
	@Test
	public final void testPGRStudentType() {
		Date dob = new GregorianCalendar(1992, 11, 25).getTime();
		StudentDetails sd6 = new StudentDetails("Birt", "Hallow", 25, dob, 0 ,0);
		assertEquals(StudentType.PGR, sd6.getStudentType());
	}
	
	/**
	 * Test method to check the correctness of Student SmartCard Number that is  generated 	
	 */

	@Test
	public final void testSmartCarNumber() {
		Calendar doic = new GregorianCalendar(1992, 11, 25);
		Date doi = doic.getTime();
		StudentDetails sd6 = new StudentDetails("Birt", "Hallow", 25, doi, 0 ,0);
		SmartCard sc = new  SmartCard(sd6, sd6.getStudentType(), doi);
		String sc1 = sc.getSmartCardNumber();
		String alpha = sc1.substring(0, 2);
		String date = sc1.substring(3, 7);
      	String num = sc1.substring(8, 10);
		//check for the matching of the first two letters in student smart card to their first and last name initials
      	assertTrue((alpha.charAt(0)== sd6.getFirstName().charAt(0))
      			&& (alpha.charAt(1)== sd6.getLastName().charAt(0)));
		assertTrue(date.equals(String.valueOf(doic.get(Calendar.YEAR))));
		assertTrue(num.matches("^\\d{2}$"));
	}
	
	/**
	 * Test method to check Student Id generated is as per the requirement 	
	 */
	
	@Test
	public final void testStudentId() {
		Calendar doic = new GregorianCalendar(1992, 11, 25);
		Date doi = doic.getTime();
		StudentDetails sd6 = new StudentDetails("Birt", "Hallow", 25, doi, 0 ,0);
		
		String alpha = sd6.getStudentId().substring(0, 1);
	     
      	String num = sd6.getStudentId().substring(1, 5);
		
		assertTrue(alpha.matches("^[a-z]$"));
		
		assertTrue(num.matches("^\\d{4}$"));
	}
	
	
	
	
}
	
