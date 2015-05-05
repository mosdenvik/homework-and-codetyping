package books_io;

import java.io.File;

public class BookApp {

	public static void main(String[] args) {
		File bookFile = new File("src\\books_io\\Books.txt");
		BookOperator operator = new BookOperator();
		operator.readBookFromFile(bookFile);
		operator.saveBooksToList(bookFile);
		operator.writeBookToFile(bookFile, new Book("Blinov", "Java Methods Programming", 2004));
		operator.writeBookToFile(bookFile, new Book("King", "Horror", 1999));
		
	}
}
