package Serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjFIO {

	public static void main(String[] args) {

		ZStudent[] zstudents = {
				new ZStudent(50, "Ngu", "M", "Monday", 50.0F),
				new ZStudent(100, "Gray", "G", "Tuesday", 60.0F),
				new ZStudent(150, "Green", "G", "Wednesday", 70.0F),
				new ZStudent(200, "Purple", "P", "Thursday", 80.0F),
				new ZStudent(300, "Red", "R", "Friday", 90.0F)
		};

		try {
			FileOutputStream fos = new FileOutputStream("zStudentFile.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			// to write out student records to a file
			//for (int i = 0; i < 5; i++) {

			//oos.writeObject(zstudents[i]);// to write 1 obj at a time
			oos.writeObject(zstudents);
			//}

			oos.close();
		} catch (IOException e) {
			System.out.println("Error:" + e);
		}
	}
}


