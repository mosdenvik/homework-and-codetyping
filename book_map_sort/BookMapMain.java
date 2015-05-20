package book_map_sort;

import java.io.File;


public class BookMapMain {

	public static void main(String[] args) {
		File bookFile = new File("src\\book_map_sort\\Books.txt");
		
		BookMapSorter sorter = new BookMapSorter();
		sorter.createKeyMap(bookFile, "author");
		sorter.printAllBooks();
		sorter.sortMapByKey("author");
		sorter.sortMapByKey("title");
		sorter.sortMapByKey("year");
	}
}
