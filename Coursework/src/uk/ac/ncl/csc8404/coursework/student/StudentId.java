package uk.ac.ncl.csc8404.coursework.student;

import java.util.concurrent.atomic.AtomicInteger;
/**
 * 
 * StudentId- Class for an unique Student-Id generation
 *
 */
public class StudentId {

	//using Atomic Integer to perform atomic operation on the int value used in the id generation 
	private  String alph;
	private static AtomicInteger unique = new AtomicInteger(0);
	private int num;
	
	/**
	 * Construct StudentId to generate the unique id of the student
	 * 
	 * */
	
	public StudentId ()
	{
        
       int alphnum = (int)((Math.random() * (122-97))+97);
       alph = String.valueOf((char)alphnum);
       num = getUnique();
		if (num > 9999) num = (int)(num/10000);
	}
	
	/**
	 * Returns String representation of the StudentId generated
	 *   
	 */
	
	public String toString() {
		String Id = alph;
		
		if (num < 10) Id+= "000"+num;
		else if (num <100) Id+= "00"+num;
		else if (num <1000) Id+= "0"+num;
		else Id+=num;
		return Id;
	}
	
	/**
	 * Unique method which makes use of the incrementAndGet API method to generate a unique number and increment the value
	 * @return a unique AtomicInteger
	 */
	public static int getUnique() {
		return unique.incrementAndGet();
		
	}
	
}
