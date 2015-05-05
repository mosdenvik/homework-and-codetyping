package books_io;

import java.io.File;

public class SerializationApp {

	public static void main(String[] args) {

		File serializedBook = new File("Serializedbook.txt");
		Book adventure = new Book("Mark Tven", "Arount the world", 1970);

		Serializator srlz = new Serializator();
		srlz.serialization(serializedBook, adventure);
		srlz.deserialization(serializedBook, adventure);

	}

}
