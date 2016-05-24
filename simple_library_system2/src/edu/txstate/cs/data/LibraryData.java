package edu.txstate.cs.data;

/**
 * Is a Abstraction for the Bridge pattern
 *
 * @return .....
 */

public interface LibraryData {

	public LibData getLibData(String FileName);
	public void saveLibData(String fileName, LibData data);
}
