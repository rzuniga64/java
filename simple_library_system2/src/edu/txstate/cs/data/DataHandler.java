package edu.txstate.cs.data;

import java.lang.String;

/**
 * Is Implementor for the Bridge pattern
 *
 * @return .....
 */

public interface DataHandler {

	public LibData loadDataFromFile(String fileName);
	
	public void saveDataToFile(String fileName, LibData directory);
}
