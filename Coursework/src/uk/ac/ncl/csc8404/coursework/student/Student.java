/**
 * 
 */
package uk.ac.ncl.csc8404.coursework.student;

import java.util.Date;
import java.util.List;

import uk.ac.ncl.csc8404.coursework.module.ModuleMapping;
import uk.ac.ncl.csc8404.coursework.smartcard.SmartCard;

/**
 * @author Bhubanesh Mishra
 * Student - Interface to Student Information
 */
public interface Student {
/**
 * Get the first name 
 * 	
 * @return the first name of the Student
 */
 String getFirstName();
 
 /**
  * Get the last name
  *  	
  * @return the last name of the student
  */
 
 String getLastName();
 
 /**
  * Get Date of Birth
  * 	
  * @return the Date of Birth of the student
  */
	
 Date getDateOfBirth();
 
 /**
  * Get the Student ID	
  * 
  * @return the Student-Id created for the student
  */
 
 String	 getStudentId();
 
 /**
  * Get the Student Type
  * 	
  * @return the type of Student
  */
 
 StudentType getStudentType();
 
 /**
  * Get the Supervisor name	
  * 
  * @return the supervisor name for the student
  */
	
 String getSupervisorName();
 
 /**
  * Get the student card details
  * 	
  * @return the smart card  for the student
  */
 
 SmartCard getStudentCard();
 
 /**
  * Get the student registration confirmation
  * 	
  * @return the confirmation of student registration
  */
 
 boolean getstudentregis();
 
 /**
  * Get the module mapping
  * 	
  * @return the module mapping for the student
  */
 
 List<ModuleMapping> getModuleMapping();
	

}
