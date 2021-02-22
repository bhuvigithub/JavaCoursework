package uk.ac.ncl.csc8404.coursework.student;

import java.util.Date;
import java.util.List;

import uk.ac.ncl.csc8404.coursework.module.ModuleMapping;
import uk.ac.ncl.csc8404.coursework.smartcard.SmartCard;
import uk.ac.ncl.csc8404.coursework.supervisor.Supervisor;
/**
 * 
 * @author Bhubanesh Mishra
 * StudentDetails- Student details Class which implements the Student Interface 
 *
 */
public class StudentDetails implements Student {

	 /* Neither of the following member fields variables is directly accessible to 
     * anyone outside of this class
     */	
	
	private  String firstName;
	private  String lastName;
	private  int age;
	private  int credit;
	private  int passmarks;
	private Supervisor supervisor;
	private StudentId studentId;
	private Date dateOfBirth;
	private SmartCard studentCard;
	private List<ModuleMapping> moduleMapping;
	
	 /**
     * Construct a Student given first name, last name, age, dob, credit and pass and creates StudentId .
     *
     * @param firstName of the Student
     * @param lastName of the Student
     * @param sAge of the Student
     * @param dob (Date of Birth) of a Student 
     * @param cred credit for the Student
     * @param pass marks for the Student
     */
	
	
	public StudentDetails (String firstName, String lastName, int sAge, Date dob,
			int cred, int pass) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age=sAge;
		this.credit = cred;
		this.passmarks = pass;
		this.dateOfBirth = dob;
		
		//initialize the studentId variable to enum StudentID.
		this.studentId = new StudentId();
	}
	
	public StudentDetails (String firstName, String lastName) {
		
		//call the setFirstname function to initialize the first name. 
		setFirstName(firstName);
		
		//call the setLastName function to initialize the last name.
		setLastName(lastName);
	}

	 /**
     * Get the <code>fistName</code> field.
     *
     * @return Returns the <code>firstName</code> field
     */
	
	public String getFirstName() { return firstName; }
	
	 /**
     * Get the <code>lastName</code> field.
     *
     * @return Returns the <code>lastName</code> field
     */
	
	public String getLastName() { return lastName; }
	
	 /**
     * Get the <code>age</code> field.
     *
     * @return Returns the <code>age</code> field
     */
	
	public int getAge() { return age; }
	 /**
     * Set the first part of the student name.
     *
     * @param firstName the first part of the student name
     * @throws NullPointerException 
     * <code>firstName</code> is null 
     * @throws IllegalArgumentException 
     * <code>firstName</code> is empty
     */
	
	public void setFirstName(String firstName) {
	
		if ((firstName == null || firstName.isEmpty()))
		      throw new IllegalArgumentException ("Blank first name");
		
		this.firstName = firstName;
		
	}
	 /**
     * Set the last part of the student name.
     *
     * @param lastName the first part of the student name
     * @throws NullPointerException 
     * <code>lastName</code> is null 
     * @throws IllegalArgumentException 
     * <code>lastName</code> is empty
     */
	public void setLastName(String lastName) {
	
		if ((lastName == null || lastName.isEmpty()))
		      throw new IllegalArgumentException ("Blank last name");
		
		this.lastName = lastName;
		
	}
	 /**
     * Get the <code>dateOfBirth</code> field.
     *
     * @return Returns the <code>dateOfBirth</code> field
     */
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	/**
     * Set the Date of Birth of the student .
     *
     * @param dateOfBirth of the student
     * @throws IllegalArgumentException
     * <code>dateOfBirth</code> is null 
     */
	
	public void setDateOfBirth(Date dateOfBirth) {
		if (dateOfBirth == null)
            throw new IllegalArgumentException(
                "null date of birth not permitted");
		
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * Set the age for the student
	 * 
	 * @param age age of the student 
	 */
	public void setAge(int age) {
		this.age = age;
	}

	 /**
	 *studentId String representation
     * Get the <code>studentId</code> field.
     *
     * @return Returns the <code>studentId</code> field
     */
	
	public String getStudentId() {
		return studentId.toString();
	}

	/**
     * Get the <code>StudentType</code> field.
     *
     * @return Returns the <code>StudentType</code> field
     * @throws IllegalArgumentException 
     * <code>StudentType</code> is of wrong type
     */
	public StudentType getStudentType() {
        if (this.credit == 120 && this.passmarks == 40 ) {
       	 
	         return StudentType.UG;	 
        }
        else if (this.credit == 180 && this.passmarks== 50 ) {
	       
	        return StudentType.PGT;
 }
        else if (this.credit == 0 && this.passmarks == 0) {
       	
       	return StudentType.PGR;
        }
        throw new IllegalArgumentException ("Wrong Student Type");
}
	/**
	 * Method to get the Supervisor name <code>supervisor</code> for Post Graduate research students
	 * 
	 * @return the String representation of the Supervisor name if type matches with
	 *  <code>supervisor</code> PGR 
	 */

	public String getSupervisorName() { 
		if (getStudentType()== StudentType.PGR)
		return this.supervisor.toString(); 
		else return null;
		}	
	/**
	 * Set the Supervisor for the student using the Supervisor class
	 *  
	 * @param supervisor supervisor name
	 */
	
	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}
    /**
    * Boolean method to confirm the current student registration
    * Checks the validity of studentType and its respective credits.
    * @return true if the student is currently registered for enough credits as per the student type  
    */
	public boolean getstudentregis() {
		return ((getStudentType() == StudentType.UG && credit == 120)|| (getStudentType()== StudentType.PGT && credit == 180)
			|| (getStudentType() == StudentType.PGR && credit == 0));
			
	}
	
	/**
     * Get the <code>moduleMapping</code> field.
     *
     * @return Returns the module mapped to a student<code>moduleMapping</code> field
     */

	public List<ModuleMapping> getModuleMapping() {
		return moduleMapping;
	}
	/**
	 * Set the module mapping by invoking the ModuleMapping class for the student
	 * This class will invoke the method that list the modules
	 * for which the student is registered for
	 * @param moduleMapping List of moduleMapping
	 */
	
	public void setModuleMapping(List<ModuleMapping> moduleMapping) {
		this.moduleMapping = moduleMapping;
	}
	/**
     * Get the <code>studentCard</code> field.
     *
     * @return Returns the Smart card for the student<code>studentCard</code> field
     */
	
	public SmartCard getStudentCard() {
		return studentCard;
	}

	/**
	 * Set the studentCard by invoking the Smartcard class for the student
	 * 
	 * @param studentCard Smart Card for the student
	 */
	
	public void setStudentCard(SmartCard studentCard) {
		this.studentCard = studentCard;
	}
	
	/**
     * Get the <code>credit</code> field.
     *
     * @return Returns the <code>credit</code> field
     */

	public int getCredit() {
		return credit;
	}
	
	/**
	 * Set the credit for the student
	 *  
	 * @param credit credit for the student
	 */

	public void setCredit(int credit) {
		this.credit = credit;
	}

	/**
     * Get the <code>passmarks</code> field.
     *
     * @return Returns the <code>passmarks</code> field
     */
	
	public int getPassmarks() {
		return passmarks;
	}

	/**
	 * Set the passmarks for the student
	 *  
	 * @param passmarks Passmark for the student
	 */
	
	public void setPassmarks(int passmarks) {
		this.passmarks = passmarks;
	}
	/**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (!(obj instanceof StudentDetails))
		          return false;
	final StudentDetails sd = (StudentDetails) obj;
	
	return firstName.equals(sd.firstName)&& lastName.equals(lastName); 	
		
	}
	
    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
	public int hashCode() {
		
		int hc = 17;
		
		hc = 37 * hc + firstName.hashCode();
		
		return 37 * hc + lastName.hashCode();	
		
	}
	
    /**
     * Returns a string representation of a Student name. The string
     * representation is a first name and last name separated
     * by a space character.
     * 
     * @see java.lang.Object#toString()
     * @see #valueOf for the string representation of 
     * a name
     */
    @Override
	public String toString() {
		return firstName + " " + lastName;
	}

    
    /**
    * Constructs an instance of Student name from its
    * string representation. The string representation
    * of a Student name is a first name and last name separated
    * by a one or more more whitespace character. It is assumed that first and last 
    * names do not contain spaces.
    * 
    * @param name a student name in the specified string representation
    * @return an instance of a StudentDetail corresponding to the given
    * string
    * @throws NullPointerException if <code>name</code> is null
    * @throws ArrayIndexOutOfBoundsException if there are no
    * two component parts to <code>name</code> (first and last
    * names)
    */
    
    
public static StudentDetails valueOf(String name) {
	    final String[] sn = name.split("\\s+");
		
	    return new StudentDetails(sn[0], sn[1]);
  }

	
}
