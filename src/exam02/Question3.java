package exam02;

import java.util.List;

/**
 * You are provided with a class Person, which has a field String ssn, 
 * which is always a String of 9 digits, and a getter method String getSsn().

In class Question3, complete the method leastSSN, which returns the Person in testList with the smallest ssn. 
Any null elements intestList` are skipped.
Because the String ssn looks like a 9 digit number, person1.getSsn().compareTo(person2.getSsn()) < 0 is the test to use to check that person1.ssn 
is less than person2.ssn. See public int compareTo​(String anotherString) for details or see this zyBook Section 5.12., table 5.12.1.
It testList is null or empty or if all the Person objects in testList are null, then return null
Hint the solution shown in 22.2 deals with a mix of null elements in a List.
 * @author xuyunlong
 *
 */
public class Question3 {
	private List<Person> testList;

	public Question3(List<Person> testList) {
		this.testList = testList;
	}

	public Person leastSSN() {
		Person retVal = null;
		// TODO
		// return null if testList is null, empty,
		// or all the elements are null
		// otherwise return the non-null Person in testList
		// with the least ssn -- since the ss is a Sring of 9 digits
		// this can be the least as a number or as a String.
		if (testList == null || testList.size() == 0) {
			return null;
		}

		boolean allNulls = true;
		for (Person person : testList) {
			if (person != null) {
				allNulls = false;
			}
		}

		if (allNulls) {
			return null;
		}

		Person maxSSN = null;
		for (Person person : testList) {
			if (person != null) {
				maxSSN = person;
				break;
			}
		}
		for (Person person : testList) {
			if (person != null && person.getSsn().compareTo(maxSSN.getSsn()) < 0) {
				maxSSN = person;
			}
		}
		return maxSSN;	

	}
}
