package book_set_comparator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class BookSorter {

	Book book;
	File bookFile = new File("src\\book_set_comparator\\Books.txt");
	Set<Book> books = readBooksToSet(bookFile);

	public Set<Book> readBooksToSet(File bookFile) {
		Set<Book> books = new TreeSet<Book>();
		BufferedReader br = null;
		if (bookFile.exists()) {
			try {
				br = new BufferedReader(new FileReader(bookFile));
				String currentLine = "";
				while ((currentLine = br.readLine()) != null) {
					String[] splitArray = currentLine.split(";");
					Book book = new Book(splitArray[0], splitArray[1],
							Integer.parseInt(splitArray[2]));
					books.add(book);
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

	public void showAllBooks() {
		System.out.println("All books from file: ");
		for (Book b : books) {
			System.out.println(b);
		}
	}

	public void sortBookByParameter(String param) {
		
		if (param.equals("author")) {
			System.out.println("Sorted by " + param + ":");
			Set<Book> sortedByAuthorSet = new TreeSet<Book>(
					new Comparator<Book>() {
						@Override
						public int compare(Book o1, Book o2) {
							return (o1.getAuthor().toString()).compareTo(o2
									.getAuthor().toString());
						}
					});
			sortedByAuthorSet.addAll(books);
			for (Book book : sortedByAuthorSet) {
				System.out.println(book);
			}
		}
		if (param.equals("title")) {
			System.out.println("Sorted by " + param + ":");
			Set<Book> sortedByTitleSet = new TreeSet<Book>(
					new Comparator<Book>() {
						@Override
						public int compare(Book o1, Book o2) {
							return (o1.getTitle().toString()).compareTo(o2
									.getTitle().toString());
						}
					});
			sortedByTitleSet.addAll(books);
			for (Book book : sortedByTitleSet) {
				System.out.println(book);
			}
		}
		if (param.equals("year")) {
			System.out.println("Sorted by " + param + ":");
			Set<Book> sortedByYearSet = new TreeSet<Book>(
					new Comparator<Book>() {
						@Override
						public int compare(Book o1, Book o2) {
							if (o1.getYear() - o2.getYear() == 0) {
								return (o1.getAuthor().toString()).compareTo(o2
										.getAuthor().toString());
							}
							return o1.getYear() - o2.getYear();
						}
					});
			sortedByYearSet.addAll(books);
			for (Book book : sortedByYearSet) {
				System.out.println(book);
			}

		}
	}
}
