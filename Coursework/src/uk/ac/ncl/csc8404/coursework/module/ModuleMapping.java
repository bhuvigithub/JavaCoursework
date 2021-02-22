package uk.ac.ncl.csc8404.coursework.module;
/**
 * 
 * ModuleMapping - Class to map the modules to Student
 *
 */
public class ModuleMapping {
	
	private String name;
	private String code;
	private int credit;
	
	
	public ModuleMapping(String name, String code, int credit) {
		super();
		this.name = name;
		this.code = code;
		this.credit = credit;
	}
	/**
     * Get the module name <code>name</code> field.
     *
     * @return Returns the module name <code>name</code> field
     */
	public String getName() {
		return name;
	}
	/**
	 * Set the name of the module
	 *  
	 * @param name of the module
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
     * Get the module code <code>code</code> field.
     *
     * @return Returns the module code <code>code</code> field
     */
	public String getCode() {
		return code;
	}
	/**
	 * Set the code for the module
	 *  
	 * @param code for the modules 
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
     * Get the module credit <code>credit</code> field.
     *
     * @return Returns the module credit <code>credit</code> field
     */
	public int getCredit() {
		return credit;
	}
	/**
	 * Set the credit for the module
	 *  
	 * @param credit of the module
	 */
	public void setCredit(int credit) {
		this.credit = credit;
	}
	/**
     * Returns a string representation of a Module. The string
     * representation is a module code,  module name and module credit separated by a comma character.
     * */
	public String toString() {
		return code + "," + name + "," + credit;
	}

}
