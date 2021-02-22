package uk.ac.ncl.csc8404.coursework.management;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.ac.ncl.csc8404.coursework.module.ModuleMapping;
import uk.ac.ncl.csc8404.coursework.module.ModuleRegister;
import uk.ac.ncl.csc8404.coursework.smartcard.SmartCard;
import uk.ac.ncl.csc8404.coursework.student.StudentDetails;
import uk.ac.ncl.csc8404.coursework.student.StudentType;
/**
 * 
 * StudentManagement - Class which acts as an utility class and manages the University Actions taken on the  Student.
 *  
 * 
 * Uses the singleton design pattern to ensure only one instance of the 
 * class is present. 
 * 
 */

public class StudentManagement {
	
	private static final StudentManagement INSTANCE = new StudentManagement(); 
	
private StudentManagement () {
	
}

public static StudentManagement getInstance() { return INSTANCE; }

public Map<String, StudentDetails> studentMap = new HashMap<>();	

/**
 * Method to Registers a new student and allocate a student id.
 * Adds a student to student map Repository.
 * @param s for using the StudentDetails class
 * Prints the student map size before and after the registration to confirm the addition of record.
 */

public void registerStudent(StudentDetails s) {
	    System.out.println("Before registering student repo size : " + studentMap.size());
	    studentMap.put(s.getStudentId(), s );
		System.out.println("After registering student repo size : " + studentMap.size());
	}
/**
 * Method to get the no of students for a particular type who are registered.
 * @param type to get the student type
 * @return the count of student for the particular student type
 */
 
public int noOfStudents(StudentType type) {
    int count =0;     
	for (StudentDetails sd : studentMap.values()) {
        	 if (sd.getStudentType() == type) count++;
         }
    return count;
}
/**
 * Method to remove the student record after the student leaves the university
 * @param id the student id number used for termination
 * Prints the student map size before and after the termination to confirm the removal of student record.
 */
	
public void terminateStudent(String id) {
	System.out.println("Before removing student repo size : " + studentMap.size());       
	studentMap.remove(id);
	System.out.println("After removing student repo size : " + studentMap.size());
}
/**
 * Boolean method to check if the student is registered in the repository
 * @param id student id
 * @return the student id from the student map
 */
public boolean hasRegistered(String id) {
	return studentMap.containsKey(id);
}
/**
 * Method to replace the old student details with new details, except the student id
 * @param studentid id of the student
 * @param s1 student details
 */


public void ammendStudentData(String studentid, StudentDetails s1) {
    StudentDetails sd = studentMap.get(studentid);
    sd.setFirstName(s1.getFirstName());
    sd.setLastName(s1.getLastName());
    sd.setAge(s1.getAge());
    sd.setModuleMapping(s1.getModuleMapping());
    studentMap.put(sd.getStudentId(), sd );
}

/**
 * Method to fetch the details of a student student registered in the Repo.
 * @param id student id
 * @return if student is present in the repo returns the student id else returns null.
 */
public StudentDetails getStudent(String id) {

	return (studentMap.containsKey(id) ? studentMap.get(id) : 
		null );
}
 
/**
 * Method to create Smart Card and issue to the student with the provided ID
 * @param id student id
 * returns the existing SmartCard if student with the provided id already has a smart card issued
 */ 


  public void issueStudentSmartCard(String id) {
      try {
    	  StudentDetails sd = studentMap.get(id);
    	  SmartCard sc = new SmartCard (sd, sd.getStudentType(), new Date());  
    	  sd.setStudentCard(sc);
    	  System.out.println("Card No " + sd.getStudentCard().getSmartCardNumber() +
    			  " Issued to Student Id " + sd.getStudentId() );
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
      
}
 
  /**
   * Populate and return  the Student data from the Student data csv file.	
   * @return List of Student details
   */
  
  public List<StudentDetails> studentDataquery() {
	  List<StudentDetails> data = new ArrayList<StudentDetails>();
	  String file = "src/uk/ac/ncl/csc8404/coursework/files/StudentData.csv";
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(file));	
			String record = br.readLine();
			while (record != null) {
				if (record != null) {
					String[] fields = record.split(",");
					String[] datefields = fields[3].split("/");
					Calendar dob1 = new GregorianCalendar(Integer.parseInt(datefields[2]), Integer.parseInt(datefields[1])-1, Integer.parseInt(datefields[0]));
					data.add(new StudentDetails(fields[0], fields[1], Integer.parseInt(fields[2]), dob1.getTime(), Integer.parseInt(fields[4]), Integer.parseInt(fields[5]) ));
					record = br.readLine();
				}
			}
			br.close();
			
			for (StudentDetails sd : data) {
				if (sd.getStudentType() == StudentType.UG)
					sd.setModuleMapping(new ArrayList<ModuleMapping>(ModuleRegister.populateUGModule().values()));
				else if (sd.getStudentType() == StudentType.PGT)
					sd.setModuleMapping(new ArrayList<ModuleMapping>(ModuleRegister.populatePGTModule().values()));

			}
			
			
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		
				
		return data; 
		}
 
  
  }



