package book_map_sort;

public class Year implements Comparable<Year>{

	private final int yearOfProduction;

	public Year(int yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}

	public int getYearOfProduction() {
		return yearOfProduction;
	}

	@Override
	public String toString() {
		return "Year [yearOfProduction: " + yearOfProduction + "]";
	}

	@Override
	public int compareTo(Year obj) {
		return (this.yearOfProduction - (obj.yearOfProduction)) ;
	} 

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + yearOfProduction;
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
		Year other = (Year) obj;
		if (yearOfProduction != other.yearOfProduction)
			return false;
		return true;
	}

}
