package book_map_sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BookMapSorter<T> {

	
	Map<T, Book> books;
	File bookFile = new File("src\\book_map_sort\\Books.txt");
	Map<Author, Book> booksAuthorMap =  (Map<Author, Book>) createKeyMap(bookFile, "author");
	Map<Title, Book> booksTitleMap = (Map<Title, Book>) createKeyMap(bookFile, "title");
	Map<Year, Book> booksYearMap = (Map<Year, Book>) createKeyMap(bookFile, "year");

	public Map<T, Book> createKeyMap(File bookFile, String key) {
		BufferedReader br = null;
		if (bookFile.exists()) {
			try {
				br = new BufferedReader(new FileReader(bookFile));
				String currentLine = "";
				if (key.equals("author") && key != null) {
					books = (Map<T, Book>) new HashMap<Author, Book>();
					while ((currentLine = br.readLine()) != null) {
						String[] splitArray = currentLine.split(";");
						Book book = new Book(splitArray[0], splitArray[1], Integer.parseInt(splitArray[2]));
						Author author = new Author(splitArray[0]);
						books.put( (T) author, book);
					}
				}
				if (key.equals("title") && key != null) {
					books = (Map<T, Book>) new HashMap<Title, Book>();
					while ((currentLine = br.readLine()) != null) {
						String[] splitArray = currentLine.split(";");
						Book book = new Book(splitArray[0], splitArray[1], Integer.parseInt(splitArray[2]));
						Title title = new Title(splitArray[1]);
						books.put((T) title, book);
					}
				}
				if (key.equals("year") && key != null) {
					books = (Map<T, Book>) new HashMap<Year, Book>();
					while ((currentLine = br.readLine()) != null) {
						String[] splitArray = currentLine.split(";");
						Book book = new Book(splitArray[0], splitArray[1], Integer.parseInt(splitArray[2]));
						Year year = new Year(Integer.parseInt(splitArray[2]));
						books.put((T) year, book);
					}
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
		return books;
	}

	public void printAllBooks() {
		System.out.println("Print all books from file: ");
		List list = new ArrayList(booksAuthorMap.values());
		Book[] bookArray = (Book[]) list.toArray(new Book[booksAuthorMap.size()]);
		for (int i = 0; i < bookArray.length; i++) {
			System.out.println(bookArray[i]);
		}
	}

	public void sortMapByKey(String param) {
		if (param.equals("author") && param != null) {
			Map<Author, Book> sortedMap = new TreeMap<Author, Book>(booksAuthorMap);
			System.out.println("Sort map by key-author....");
			Iterator<Map.Entry<Author, Book>> iterator = sortedMap.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Author, Book> pair = iterator.next();
				Author key = pair.getKey();
				Book value = pair.getValue();
				System.out.println(key + " --- " + value);
			}
		}
		if (param.equals("title") && param != null) {
			Map<Title, Book> sortedMap = new TreeMap<Title, Book>(booksTitleMap);
			System.out.println("Sort map by key-title....");
			Iterator<Map.Entry<Title, Book>> iterator = sortedMap.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Title, Book> pair = iterator.next();
				Title key = pair.getKey();
				Book value = pair.getValue();
				System.out.println(key + " --- " + value);
			}
		}
		
		if (param.equals("year") && param != null) {
			Map<Year, Book> sortedMap = new TreeMap<Year, Book>(booksYearMap);
			System.out.println("Sort map by key-year....");
			Iterator<Map.Entry<Year, Book>> iterator = sortedMap.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Year, Book> pair = iterator.next();
				Year key = pair.getKey();
				Book value = pair.getValue();
				System.out.println(key + " --- " + value);
			}
		}
	}
}
