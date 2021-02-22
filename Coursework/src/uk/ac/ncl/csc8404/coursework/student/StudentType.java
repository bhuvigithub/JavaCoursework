package uk.ac.ncl.csc8404.coursework.student;

/**
* StudentType Enum which sets the type of Student variables to a predefine constant which is later used by StudentDetails class
* Undergraduate denoted by UG
* Postgraduate Taught denoted by PGT
* Postgraduate Research denoted by PGR
*/

public enum StudentType {
	
	UG("UG"), 
	PGT("PGT"),
	PGR("PGR");
	
	//private member variable of type String
	private String studentType;
	
	//Private constructor with a string param to initialize the studentType
	private StudentType (String studentType) {
		this.studentType = studentType;
	}

	/**
	 *studentType String  get method
     * 
     *
     * @return Returns the <code>studentType</code> field
     */
	public String getStudentType() {
		return studentType;
	}
	
	

}
