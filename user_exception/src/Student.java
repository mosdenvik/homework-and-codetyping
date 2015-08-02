package ua.org.oa.moskalenkod;

public class Student {

	private static final int MAX_AGE = 30;
	private static final int MIN_AGE = 18;
	public static final String WRONG_AGE_MESSAGE = "Wrong student age. Use age from "
			+ MIN_AGE + " to " + MAX_AGE;
	private static final int MIN_NAME_LENGTH = 2;
	private static final String WRONG_NAME_MESSAGE = "Wrong name. Add name more than "
			+ MIN_NAME_LENGTH + " letters";
	private static final int INDEX_ID = 10;
	private static final String WRONG_ID = "Wrong ID. Use 10-characters ID!!!";

	private String name;
	private int age;
	private String ID;

	public String getName() {
		return name;
	}

	public void setName(String name) throws StudentNameException {
		if (name.length() >= MIN_NAME_LENGTH) {
			this.name = name;
		} else {
			throw new StudentNameException(WRONG_NAME_MESSAGE);
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws StudentAgeException {
		if (age >= MIN_AGE && age <= MAX_AGE) {
			this.age = age;
		} else {
			throw new StudentAgeException(WRONG_AGE_MESSAGE);
		}
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) throws StudentIDException {
		if (iD.length() == INDEX_ID) {
			this.ID = iD;
		} else {
			throw new StudentIDException(WRONG_ID);
		}
	}

	public Student(String name, int age, String iD)
			throws StudentNameException, StudentAgeException,
			StudentIDException {
		super();
		setName(name);
		setAge(age);
		setID(iD);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + age;
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
		Student other = (Student) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [name: " + getName() + ", age: " + getAge() + ", ID: "
				+ getID() + "]";
	}

}