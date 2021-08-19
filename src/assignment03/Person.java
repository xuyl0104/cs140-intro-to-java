package assignment03;

public class Person {
	private String firstName;
	private String lastName;

	public Person(String fName, String lName) {
		firstName = fName;
		lastName = lName;
	}
	
	public String name() { 
		return lastName + ", " + firstName; 
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String toString() {
		return firstName + " " + lastName;
	}
}
