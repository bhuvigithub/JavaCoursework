package uk.ac.ncl.csc8404.coursework.smartcard;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import uk.ac.ncl.csc8404.coursework.student.StudentDetails;
import uk.ac.ncl.csc8404.coursework.student.StudentId;
import uk.ac.ncl.csc8404.coursework.student.StudentType;
/**
 * 
 * SmartCard - smart card class for unique smart card number generation
 *
 */
public class SmartCard {
	// private variable declarations 
	private StudentDetails studentDetails;
    private Date dateOfIssue;
    private Date expiryDate;
    private String smartCardNumber;
/**
 * Construct create for getting the student details for SmartCard generation and Generates the Unique SmartCard number
 * @param studentDetails details of the student
 * @throws IllegalArgumentException
 * <code>studentDetails</code> is null
 * @param studentType Type of student
 * @throws IllegalArgumentException 
 * <code>studentType</code>  Age range does not contain the students age.
 * @param dateOfIssue date of issue of SmartCard
 * @throws IllegalArgumentException 
 * <code>dateOfIssue</code> has null issue date
 * 
 */
    public SmartCard(StudentDetails studentDetails, StudentType studentType,  Date dateOfIssue) {
        
    	//null check of student info
    	if (studentDetails == null)
            throw new IllegalArgumentException(
                "null student details not permitted");
        
        //null check of doi
        if (dateOfIssue == null)
            throw new IllegalArgumentException(
                "null issue date not permitted");
       this.studentDetails = studentDetails; 
       
        //smart card issue rule checkpoint
      if (( studentType == StudentType.UG && studentDetails.getAge() < 17)
    		  || ( (studentType == StudentType.PGT || studentType == StudentType.PGR )
    				  && studentDetails.getAge() < 20))
         throw new IllegalArgumentException ("Invalid Student Age Detected");      
        
      if (studentDetails.getStudentCard() != null) {
    	  this.smartCardNumber = studentDetails.getStudentCard().getSmartCardNumber();
    	  this.dateOfIssue = studentDetails.getStudentCard().getDateOfIssue();
    	  this.expiryDate = studentDetails.getStudentCard().getExpiryDate();  
      } else 
      {
    	  
      
    	  
    		  
      this.dateOfIssue = dateOfIssue;
      
        
        //func call of expiry date
        setExpiryDate(studentType);
        // Unique smartCard number generation
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(this.dateOfIssue);
        
        int num = StudentId.getUnique();
        if (num > 99) num = (int)(num/100);
        
        this.smartCardNumber = String.valueOf(studentDetails.getFirstName().charAt(0))+
        		String.valueOf(studentDetails.getLastName().charAt(0))+ "-" + 
        		String.valueOf(calendar.get(Calendar.YEAR)) + "-" + 
        		(num <10 ? "0"+num : num);
    }
  }
    
/**
 * 
 * Get the <code>studentDetails</code> field.
 * 
 * @return the StudentDetails <code>studentDetails</code> field.
 */
  
 public StudentDetails getStudentDetails() {	
	 return  studentDetails;
	}

 /**
  * 
  * Get the <code>dateOfIssue</code> field.
  * 
  * @return the DateOfIssue <code>dateOfIssue</code> field.
  */

	public Date getDateOfIssue() {
		
		return  dateOfIssue;
	}

/**
 * Get the <code>smartCardNumber</code> field.
 * 
 * @return the SmartCard number <code>smartCardNumber</code> field
 */
	public String getSmartCardNumber() {
		return smartCardNumber;
	}
/**
 * Private method to set the ExpiryDate of the SmartCard
 * @param type to know the StudentType which then used to allot the ExpiryDate accordingly
 */


private void setExpiryDate(StudentType type){
	 
	 Calendar calendar = new GregorianCalendar();
     calendar.setTime(this.dateOfIssue);
     
     if (type == StudentType.UG) {
     calendar.add(Calendar.YEAR, 4);
     this.expiryDate = calendar.getTime();
     } else if (type == StudentType.PGT) {
    	 calendar.add(Calendar.YEAR, 2);
         this.expiryDate = calendar.getTime(); 
     } else if (type == StudentType.PGR) {
    	 calendar.add(Calendar.YEAR, 5);
         this.expiryDate = calendar.getTime();
     }
     
        
 }
/**
 * 
 * Get the <code>expiryDate</code> field.
 * 
 * @return the card ExpiryDate <code>expiryDate</code> field.
 */
public Date getExpiryDate() {
	return expiryDate;
}
 
 /**
  * String representation of the SmartCard details
  * It also provides access to student name, dateOfBirth, StudentId and dateOfIssue
  */
public String toString() {
	
	return "Smart Card Number : " + getSmartCardNumber() + "\n" 
	+ "Student Name :" + getStudentDetails().toString() + 
			"\n" + "Student Id : " + getStudentDetails().getStudentId()
			+ "\n" + "Student DOB : " + getStudentDetails().getDateOfBirth()
			+ "\n" + "Smart Card DOI : " + getDateOfIssue()
			+ "\n" + "Smart Card DOE : " + getExpiryDate();
}


}

