package book_set_comparator;

public class Book implements Comparable {

	private String author;
	private String title;
	private int year;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Book(String author, String title, int year) {
		this.author = author;
		this.title = title;
		this.year = year;
	}

	@Override
	public String toString() {
		return "Book [author: " + author + ", title: " + title + ", year: "
				+ year + "]";
	}

	@Override
	public int compareTo(Object obj) {
		Book tmp = (Book) obj;
		if (!(this.author).equals(tmp.author)) {
			return 1;
		} else if (this.author.equals(tmp.author)) {
			return -1;
		}
		return 0;
	}

}
