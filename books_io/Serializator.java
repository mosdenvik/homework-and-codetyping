package books_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializator {

	public static void serialization(File file, Book book) {
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream(file);
			if (fos != null) {
				oos = new ObjectOutputStream(fos);
				oos.writeObject(book);
			}
		} catch (IOException e) {
			System.err.println();
		}
	}

	
	
	public static void deserialization(File file, Book book) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			Book unknown = (Book) ois.readObject();
			System.out.println(unknown);

		} catch (ClassNotFoundException ce) {
			System.err.println(ce);
			System.err.println("Class does not exist");
		} catch (FileNotFoundException fe) {
			System.err.println(fe);
			System.err.println("File didn't found");
		} catch (IOException ioe) {
			System.err.println(ioe);
			System.err.println("Access error");
		}
	}

}
