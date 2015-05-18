package book_set_comparator;

import java.io.File;

public class BookSorterApp {

	public static void main(String[] args) {
		File bookFile = new File("src\\book_set_comparator\\Books.txt");
		BookSorter sorter = new BookSorter();
		sorter.readBooksToSet(bookFile);
		sorter.showAllBooks();
		sorter.sortBookByParameter("author");
		sorter.sortBookByParameter("title");
		sorter.sortBookByParameter("year");
	}

}
