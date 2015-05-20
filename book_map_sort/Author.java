package book_map_sort;

public class Author implements Comparable<Author>{
	private final String name;
	
	public Author(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	
	@Override
	public String toString() {
		return "Author [name: " + name + "]";
	}

	@Override
	public int compareTo(Author obj) {
		return this.name.compareTo(obj.name);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Author other = (Author) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
