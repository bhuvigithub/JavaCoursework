package uk.ac.ncl.csc8404.coursework.supervisor;

/**
 * 
 * Supervisor - Class to set and get the name of the Supervisor
 *
 */

public class Supervisor {

	//private member variable
	private String firstName;
	private String lastName;
	

	/**
     * Construct a Supervisor given first name, last name
     *
     * @param firstName First name of the Supervisor
     * @param lastName First Name of the Supervisor
     * 
     **/
	public Supervisor(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
     * Get the <code>fistName</code> field.
     *
     * @return Returns the <code>firstName</code> field
     */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Set the first part of the supervisor name
	 *  
	 * @param firstName First name of supervisor
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
     * Get the <code>lastName</code> field.
     *
     * @return Returns the <code>lastName</code> field
     */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Set the last part of the supervisor name
	 *  
	 * @param lastName Last name of supervisor
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
     * Returns a string representation of a Supervisor name. The string
     * representation is a first name and last name separated
     * by a space character.
     * 
     * @see java.lang.Object#toString()
     */
    @Override	

   public String toString() {
	   return getFirstName() + " " + getLastName();
   }

}

