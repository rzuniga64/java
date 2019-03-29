package Serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadZStudent {

	public static void main(String[] args) throws IOException  {

		// TODO Auto-generated method stub
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {

			fis = new FileInputStream("zStudentFile.ser");
		    ois = new ObjectInputStream(fis);
			ZStudent[] sbuf;

			 // to read out student records from a file

			//for (int i = 0; i < 5; i++) {
				//sbuf = (ZStudent)ois.readObject(); // explicit cast reqd
			    sbuf = (ZStudent[]) ois.readObject();
			    for (ZStudent o: sbuf)
				  System.out.println(o.toString());

			//}
			//fis.close();
			} catch (IOException ioe) {
				System.out.println("Error: " + ioe);
			} catch (ClassNotFoundException cnfe) {
				System.out.println("Error: " + cnfe);
			}
            finally {
            	fis.close();
            
            }
	}

}
