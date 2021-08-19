package assignment03;

public class Student implements Named {
	private Person asPerson;
	private String major;
	private String universityName;
	// private a constructor with 3 parameters to give
	// values to the fields   
	public Student(Person asPerson, String major, String universityName) {
		super();
		this.asPerson = asPerson;
		this.major = major;
		this.universityName = universityName;
	}

	// this is called a delegate method
	@Override
	public String name() {
		return asPerson.name();
	}
	
    // provide getter methods for the 3 fields.
	public Person getAsPerson() {
		return asPerson;
	}

	public void setAsPerson(Person asPerson) {
		this.asPerson = asPerson;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	
	@Override
	public String toString() {
		return asPerson.toString() + "\t" + major + "\t" + universityName;
	}
	
}