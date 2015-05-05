package books_io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookOperator {

		
	
	public void readBookFromFile(File bookFile) {
		String currentLine = "";
		if (bookFile.exists()) {
			try (BufferedReader br = new BufferedReader(
					new FileReader(bookFile))) {
				while ((currentLine = br.readLine()) != null) {
					String[] splitArray = currentLine.split(";");
					for (int i = 0; i < splitArray.length; i++) {
						System.out.println(splitArray[i]);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("File does not exist!");
		}
	}

	
	public void writeBookToFile(File bookFile, Book book) {
		BufferedWriter bw = null;
		book = new Book(book.getAuthor(), book.getTitle(), book.getYear());
		try {
			bw = new BufferedWriter(new FileWriter(bookFile, true));
			bw.write("\r\n" + book.getAuthor() + ";" + book.getTitle() + ";" + book.getYear());
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
	public void saveBooksToList(File bookFile) {
		List<Book> books = new ArrayList<Book>();
		BufferedReader br = null;
		if (bookFile.exists()) {
			try {
				br = new BufferedReader(new FileReader(bookFile));
				String currentLine = "";
				while ((currentLine = br.readLine()) != null) {
					String[] splitArray = currentLine.split(";");
					Book book = new Book(splitArray[0], splitArray[1], Integer.parseInt(splitArray[2]));
					books.add(book);
				}
				for (Book b : books) {
					System.out.println(b);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			System.out.println("File does not exist!");
		}
	}

}
