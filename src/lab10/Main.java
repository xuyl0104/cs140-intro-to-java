package lab10;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
	public static ArrayList<Student> [] makeMyHashSet(int n) {
		@SuppressWarnings("unchecked") // leave this here, it is need to prevent Warnings
		ArrayList<Student>[] array = new ArrayList[n]; 
		// note "new ArrayList<Student>[n]" will not compile because of need for run-time "type erasure"

		// TODO 
		// Loop through the array and assign each element
		// as an empty ArrayList
		// return array
		// remove line 17
		for (int i = 0; i < array.length; ++i) {
			array[i] = new ArrayList<Student>();
		}
		return array;
	}

	public static boolean put(Student st, ArrayList<Student>[] array) {
		boolean retVal = false;
		// TODO let h be Math.abs(st.hashCode()) and change
		// h to h modulo the array length 
		// assign List<Student> temp as array[h]
		// If !temp.contains(st):
		// add st to temp and change retVal to true

		int h = Math.abs(st.hashCode());
		h = h % array.length;
		List<Student> temp = array[h];
		if (!temp.contains(st)) {
			temp.add(st);
			retVal = true;
		}
		return retVal;
	}

	public static Iterator<Student> getIterator(ArrayList<Student>[] array) {
		// TODO
		// Assign List<Student> list as a new empty ArrayList
		// loop through the List<Student> in array 
		// for each List<Student> lst do list.addAll(lst);
		// return list.iterator();
		List<Student> list = new ArrayList<>();
		for (ArrayList<Student> sList : array) {
			list.addAll(sList);
		}
		return list.iterator();
	}


	public static void main(String[] args) {
		int numStudents = 50;
		ArrayList<Student>[] hashSetArray = makeMyHashSet(16);

		for(int i = 0; i < numStudents; ++i) {
			String lName = NamesResource.getRandomLastName();
			String fName = NamesResource.getRandomFirstName();
			String ssn = NamesResource.getRandomID();
			LocalDate d = NamesResource.getRandomBirthDate(1998, 2004);
			Person p = new Person(lName, fName, ssn, d);
			String major = NamesResource.getRandomMajor();
			Student st = new Student(p, major);
			put(st, hashSetArray);
		}
		// view the table:
		for(var list: hashSetArray) {
			System.out.println(list.size() + ": " + list); 
		}	

		System.out.println("-----------------");

		Iterator<Student> iter = getIterator(hashSetArray);

		hashSetArray = makeMyHashSet(64);

		while (iter.hasNext()) {			
			put(iter.next(), hashSetArray);
		}

		for(var list: hashSetArray) {
			System.out.println(list.size() + ": " + list); 
		}	
	}
}
