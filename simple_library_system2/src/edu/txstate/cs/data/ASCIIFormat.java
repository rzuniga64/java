package edu.txstate.cs.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Is Concrete Implementor for the Bridge pattern
 *
 * @return .....
 */

public class ASCIIFormat implements DataHandler {

	@Override
	public LibData loadDataFromFile(String fileName) {
		 LibData libData = new LibData();
		 
		 try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br  = new BufferedReader(fr);
            String currentLine = br.readLine();
            while (currentLine != null) {
	            //parse the data
	            String[] content = currentLine.split("$");
	            libData.setId(Integer.parseInt(content[0]));
	            libData.setName(content[1]);
	            libData.setTitle(content[2]);
	            libData.setDate(content[3]);
	            libData.getBorrowedList().add(libData);
	            currentLine = br.readLine();
            }
            br.close();
		 } catch (FileNotFoundException ex) {
			 ex.printStackTrace();
		 } catch (IOException ex) {
			 ex.printStackTrace();
		 }
		 return libData;
	}
	
	@Override
	public void saveDataToFile(String fileName, LibData libData) {
		try {
			FileWriter fos = new FileWriter(fileName, true);
			BufferedWriter bw = new BufferedWriter(fos);
			bw.write(Integer.toString(libData.getId()) + "$" + libData.getName() + "$" + libData.getTitle() + "$" + libData.getDate());
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
