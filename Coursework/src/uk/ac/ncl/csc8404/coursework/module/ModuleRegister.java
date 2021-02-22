package uk.ac.ncl.csc8404.coursework.module;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Module Register - Class to read the modules from the data files and use it to register a module to a student name.  
 *
 */
 

public class ModuleRegister {

	
static	Map<String, ModuleMapping> data = new HashMap<>();

/**
 * Populate and return  the PGT Modules data from the PGT Module csv file.	
 * @return Map of Module Details mapped against module code.
 */
	
	public static Map<String, ModuleMapping> populatePGTModule() {
	
    //PGT modules data file location
	
	String file = "src/uk/ac/ncl/csc8404/coursework/files/PGTModule.csv";
	try
	{
		BufferedReader br = new BufferedReader(new FileReader(file));	
		String record = br.readLine();
		while (record != null) {
			if (record != null) {
				String[] fields = record.split(",");
				data.put(fields[1], new ModuleMapping(fields[0], fields[1], Integer.parseInt(fields[2])));
				record = br.readLine();
			}
		}
		br.close();
	} catch (Exception e){
		System.out.println(e.getMessage());
	}
	
			
	return data; 
	}
	
	/**
	 * Populate and return  the UG Modules data from the UG Module csv file.	
	 * @return Map of Module Details mapped against module code.
	 */	
	public static Map<String, ModuleMapping> populateUGModule() {
		//UG Modules data file location
		
		String file = "src/uk/ac/ncl/csc8404/coursework/files/UGModule.csv";
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(file));	
			String record = br.readLine();
			while (record != null) {
				if (record != null) {
					String[] fields = record.split(",");
					data.put(fields[1], new ModuleMapping(fields[0], fields[1], Integer.parseInt(fields[2])));
					record = br.readLine();
				}
			}
			br.close();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}	
	return data;
	
	
	}

}
