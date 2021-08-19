package lab10;
import java.util.Objects;

public class Student {
	private Person asPerson;
	private String major;
	private String bNumber;
	private static int nextBNum = 111111;

	public Student(Person person, String maj) {
		asPerson = person;
		major = maj;
		bNumber = "B00" + nextBNum++;
	}

	public String getBnumber() {
		return bNumber;
	}

	public Person getAsPerson() {
		return asPerson;
	}

	public String getMajor() {
		return major;
	}
	
	public String toString() {
		return asPerson + ", Bnum: " + bNumber + ", Major: " + major;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bNumber);
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
		return Objects.equals(bNumber, other.bNumber);
	} 
}
