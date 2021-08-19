package assignment03;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Tester {
	static Book[] bkArray = new Book[10];
	
	public static void main(String[] args) {
		bkArray[0] = new Book("Title3","Author3","Publisher3","Date3");
		bkArray[1] = new Book("Title9","Author9","Publisher9","Date9");
		bkArray[2] = new Book("Title0","Author0","Publisher0","Date0");
		bkArray[3] = new Book("Title2","Author2","Publisher2","Date2");
		bkArray[4] = new Book("Title5","Author5","Publisher5","Date5");
		bkArray[5] = new Book("Title8","Author8","Publisher8","Date8");
		bkArray[6] = new Book("Title1","Author1","Publisher1","Date1");
		bkArray[7] = new Book("Title4","Author4","Publisher4","Date4");
		bkArray[8] = new Book("Title6","Author6","Publisher6","Date6");
		bkArray[9] = new Book("Title7","Author7","Publisher7","Date7");
		
		for(Book b : bkArray) {
			System.out.println(b);
		}
		System.out.println("---------------");
		Arrays.sort(bkArray, new BookComparator());
		for(Book b : bkArray) {
			System.out.println(b);
		}
		System.out.println("---------------");
		bkArray[0] = new Book("Title3","Author3","Publisher3","Date3");
		bkArray[1] = new Book("Title9","Author9","Publisher9","Date9");
		bkArray[2] = new Book("Title0","Author0","Publisher0","Date0");
		bkArray[3] = new Book("Title2","Author2","Publisher2","Date2");
		bkArray[4] = new Book("Title5","Author5","Publisher5","Date5");
		bkArray[5] = new Book("Title8","Author8","Publisher8","Date8");
		bkArray[6] = new Book("Title1","Author1","Publisher1","Date1");
		bkArray[7] = new Book("Title4","Author4","Publisher4","Date4");
		bkArray[8] = new Book("Title6","Author6","Publisher6","Date6");
		bkArray[9] = new Book("Title7","Author7","Publisher7","Date7");
		for(Book b : bkArray) {
			System.out.println(b);
		}
		System.out.println("---------------");
		Arrays.sort(bkArray, new Comparator<Book>() {
			@Override
			public int compare(Book b1, Book b2) {
				return b1.getAuthor().compareTo(b2.getAuthor());
			}
		});
		for(Book b : bkArray) {
			System.out.println(b);
		}
		System.out.println("---------------");
		bkArray[0] = new Book("Title3","Author3","Publisher3","Date3");
		bkArray[1] = new Book("Title9","Author9","Publisher9","Date9");
		bkArray[2] = new Book("Title0","Author0","Publisher0","Date0");
		bkArray[3] = new Book("Title2","Author2","Publisher2","Date2");
		bkArray[4] = new Book("Title5","Author5","Publisher5","Date5");
		bkArray[5] = new Book("Title8","Author8","Publisher8","Date8");
		bkArray[6] = new Book("Title1","Author1","Publisher1","Date1");
		bkArray[7] = new Book("Title4","Author4","Publisher4","Date4");
		bkArray[8] = new Book("Title6","Author6","Publisher6","Date6");
		bkArray[9] = new Book("Title7","Author7","Publisher7","Date7");
		for(Book b : bkArray) {
			System.out.println(b);
		}
		System.out.println("---------------");		
		Arrays.sort(bkArray, Comparator.comparing(Book::getAuthor));
		for(Book b : bkArray) {
			System.out.println(b);
		}
		System.out.println("---------------");		
		
		
		ArrayList<Car> list = new ArrayList<>();
		list.add(new Car("Honda", "CR-V", Color.WHITE, 180.0));
		list.add(new Car("Honda", "Civic", Color.YELLOW, 210.0));
		list.add(new Car("Toyota", "RAV4", Color.GRAY, 190.0));
		list.add(new Car("Toyota", "Supra", Color.WHITE, 250.0));
		list.add(new Car("Ford", "Mustang", Color.YELLOW, 290.0));
		list.add(new Car("Subaru3", "STI", Color.BLUE, 280.0));
		list.add(new Car("Subaru2", "STI", Color.BLUE, 280.0));
		list.add(new Car("Subaru1", "STI", Color.BLUE, 280.0));
		list.add(new Car("Subaru4", "STI", Color.BLUE, 280.0));
		list.add(new Car("Subaru5", "STI", Color.BLUE, 280.0));
		
		System.out.println("-------------- TEST 1 (order on maker name first) ---------------");
		System.out.println("---- before ----");
		for (Car car : list) {
			System.out.println(car);
		}
		Collections.sort(list);  // sorted on maker name, then model name, then VIN
		System.out.println("---- after ----");
		for (Car car : list) {
			System.out.println(car);
		}
		
		System.out.println("-------------- TEST 2 (order on top speed) ---------------");
		list.clear();
		list.add(new Car("Honda", "CR-V", Color.WHITE, 180.0));
		list.add(new Car("Honda", "Civic", Color.YELLOW, 210.0));
		list.add(new Car("Toyota", "RAV4", Color.GRAY, 190.0));
		list.add(new Car("Toyota", "Supra", Color.WHITE, 250.0));
		list.add(new Car("Ford", "Mustang", Color.YELLOW, 290.0));
		list.add(new Car("Subaru3", "STI", Color.BLUE, 280.0));
		list.add(new Car("Subaru2", "STI", Color.BLUE, 280.0));
		list.add(new Car("Subaru1", "STI", Color.BLUE, 280.0));
		list.add(new Car("Subaru4", "STI", Color.BLUE, 280.0));
		list.add(new Car("Subaru5", "STI", Color.BLUE, 280.0));
		System.out.println("---- before ----");
		for (Car car : list) {
			System.out.println(car);
		}
		Collections.sort(list, new CarSpeedComparator());  // 
		System.out.println("---- after ----");
		for (Car car : list) {
			System.out.println(car);
		}
		
		System.out.println("-------------- TEST 3 (order on top speed) ---------------");
		list.clear();
		list.add(new Car("Honda", "CR-V", Color.WHITE, 180.0));
		list.add(new Car("Honda", "Civic", Color.YELLOW, 210.0));
		list.add(new Car("Toyota", "RAV4", Color.GRAY, 190.0));
		list.add(new Car("Toyota", "Supra", Color.WHITE, 250.0));
		list.add(new Car("Ford", "Mustang", Color.YELLOW, 290.0));
		list.add(new Car("Subaru3", "STI", Color.BLUE, 280.0));
		list.add(new Car("Subaru2", "STI", Color.BLUE, 280.0));
		list.add(new Car("Subaru1", "STI", Color.BLUE, 280.0));
		list.add(new Car("Subaru4", "STI", Color.BLUE, 280.0));
		list.add(new Car("Subaru5", "STI", Color.BLUE, 280.0));
		System.out.println("---- before ----");
		for (Car car : list) {
			System.out.println(car);
		}
		Collections.sort(list, Comparator.comparingDouble(Car::getTopSpeed));  // 
		System.out.println("---- after ----");
		for (Car car : list) {
			System.out.println(car);
		}
		
		System.out.println("-------------- TEST 4 (naturalOrder) ---------------");
		list.clear();
		list.add(new Car("Honda", "CR-V", Color.WHITE, 180.0));
		list.add(new Car("Honda", "Civic", Color.YELLOW, 210.0));
		list.add(new Car("Toyota", "RAV4", Color.GRAY, 190.0));
		list.add(new Car("Toyota", "Supra", Color.WHITE, 250.0));
		list.add(new Car("Ford", "Mustang", Color.YELLOW, 290.0));
		list.add(new Car("Subaru3", "STI", Color.BLUE, 280.0));
		list.add(new Car("Subaru2", "STI", Color.BLUE, 280.0));
		list.add(new Car("Subaru1", "STI", Color.BLUE, 280.0));
		list.add(new Car("Subaru4", "STI", Color.BLUE, 280.0));
		list.add(new Car("Subaru5", "STI", Color.BLUE, 280.0));
		System.out.println("---- before ----");
		for (Car car : list) {
			System.out.println(car);
		}
		Collections.sort(list, Comparator.naturalOrder());  // 
		System.out.println("---- after ----");
		for (Car car : list) {
			System.out.println(car);
		}
	
		System.out.println("-------------- TEST 5 (thenComparing) ---------------");
		list.clear();
		list.add(new Car("Honda", "CR-V", Color.WHITE, 180.0));
		list.add(new Car("Honda", "Civic", Color.YELLOW, 210.0));
		list.add(new Car("Toyota", "RAV4", Color.GRAY, 190.0));
		list.add(new Car("Toyota", "Supra", Color.WHITE, 250.0));
		list.add(new Car("Ford", "Mustang", Color.YELLOW, 290.0));
		list.add(new Car("Subaru3", "STI", Color.BLUE, 280.0));
		list.add(new Car("Subaru2", "STI", Color.BLUE, 280.0));
		list.add(new Car("Subaru1", "STI", Color.BLUE, 280.0));
		list.add(new Car("Subaru4", "STI", Color.BLUE, 280.0));
		list.add(new Car("Subaru5", "STI", Color.BLUE, 280.0));
		System.out.println("---- before ----");
		for (Car car : list) {
			System.out.println(car);
		}
		Collections.sort(list, Comparator.comparingDouble(Car::getTopSpeed).thenComparing(Comparator.naturalOrder()));  // 
		System.out.println("---- after ----");
		for (Car car : list) {
			System.out.println(car);
		}
		
		System.out.println("-------------- TEST STUDENT ---------------");
		List<Student> sList = new ArrayList<>();
		sList.add(new Student(new Person("A1", "A1"), "CS", "SUNY"));
		sList.add(new Student(new Person("B1", "B1"), "CS", "SUNY"));
		sList.add(new Student(new Person("C1", "C1"), "MATH", "SUNY"));
		sList.add(new Student(new Person("D1", "D1"), "CS", "SUNY"));
		sList.add(new Student(new Person("E1", "E1"), "MATH", "SUNY"));
		
		sList.add(new Student(new Person("A2", "A2"), "CS", "MIT"));
		sList.add(new Student(new Person("B2", "B2"), "CS", "MIT"));
		sList.add(new Student(new Person("C2", "C2"), "MATH", "MIT"));
		sList.add(new Student(new Person("D2", "D2"), "CS", "MIT"));
		sList.add(new Student(new Person("E2", "E2"), "MATH", "MIT"));
		
		Comparator<Student> c1 = Comparator.comparing(Student::getUniversityName);
		Comparator<Student> c2 = Comparator.comparing(Student::getMajor);
		Comparator<Student> c3 = Comparator.naturalOrder();
		Comparator<Student> c4 = c1.thenComparing(c2).thenComparing(c3);
		
		Collections.shuffle(sList);
		System.out.println("---- before ----");
		for (Student student : sList) {
			System.out.println(student);
		}
		
		Collections.sort(sList, c4);
		
		System.out.println("---- after ----");
		for (Student student : sList) {
			System.out.println(student);
		}
	}

}
