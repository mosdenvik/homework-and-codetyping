package book_map_sort;


public class Book implements Comparable {

	private final String author;
	private final String title;
	private final int year;

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year != other.year)
			return false;
		return true;
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
