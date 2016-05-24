package edu.txstate.cs.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Is Concrete Implementor for the Bridge pattern
 *
 * @return .....
 */

public class SerializedFormat implements DataHandler, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public LibData loadDataFromFile(String fileName) {
		LibData lb = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            lb = (LibData) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            System.err.println("input file not found.");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("Can't access file");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		return lb;
	}

	@Override
	public void saveDataToFile(String fileName, LibData directory) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(directory);
            oos.close();
        } catch (FileNotFoundException e) {
            System.err.println("input file not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Can't access file");
            e.printStackTrace();
        }
	}
}
