package lab09;

import java.util.Set;
import java.util.Map;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.TreeMap;

import assignment03.Person;
import assignment03.Student;

public class StudentPerformance {
	private static Set<Student> roster = new TreeSet<>();
	private static Map<String, Course> courseList = new TreeMap<>();
	private static Map<Student, List<Course>> studentRecord = new HashMap<>();
	private static Map<Student, Double> studentGPAs = new HashMap<>();

	public static void setupRosterAndRecords() {
		// add some students to roster
		// make Person p1, p2, p3, p4, p5
		// make Students s1, s2, s3, s4, s5 using the Persons
		// roster.add(s1); etc.
		Person p1 = new Person("Leo", "Messi");
		Person p2 = new Person("Luis", "Suarez");
		Person p3 = new Person("Gerard", "Pique");
		Person p4 = new Person("Sergio", "Busquets");
		Person p5 = new Person("Sergio", "Roberto");

		Student s1 = new Student(p1, "CS", "SUNY");
		Student s2 = new Student(p2, "MATH", "SUNY");
		Student s3 = new Student(p3, "Statistics", "SUNY");
		Student s4 = new Student(p4, "History", "SUNY");
		Student s5 = new Student(p5, "Chemistry", "SUNY");

		roster.add(s1);
		roster.add(s2);
		roster.add(s3);
		roster.add(s4);
		roster.add(s5);

		for(Student st : roster) {			
			studentRecord.put(st, new ArrayList<>());
		}
	}

	public static void setupCourseList() {
		// create some mappings
		courseList.put("CS140", new Course(4, "Data Struct"));
		courseList.put("CS550", new Course(3, "Operating System"));
		courseList.put("CS120", new Course(4, "C++ Programming"));
		courseList.put("CS250", new Course(3, "Data analysis"));
		courseList.put("MATH440", new Course(5, "Multivariate Function"));
		courseList.put("MATH550", new Course(3, "Linear Algebra"));
		courseList.put("CHEM520", new Course(3, "Basic Chemistry"));
		courseList.put("CHEM230", new Course(3, "Chemistry-I"));
		courseList.put("HIST170", new Course(3, "Civil War"));
	}

	public static void addCourse(Student st, String crs, double grade) {
		// crs is a course abbreviation such as "CS140"
		// we will first clone the Course we get using 
		// courseList.get(crs.toUpperCase()) 
		// Define Course temp = courseList.get(crs.toUpperCase()).clone();
		// set the grade using temp.setGrade, and then add temp to the ArrayList
		// studentRecord.get(st).
		Course temp = courseList.get(crs.toUpperCase()).clone();
		try {			
			temp.setGrade(grade);
			studentRecord.get(st).add(temp);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Cannot add course to the arraylist.");
		}
	}

	public static void populateStudentRecords() {
		// use addCourse many times so all the students get several courses
		Set<String> courseKeySet = courseList.keySet();
		List<String> courseKeyList = new ArrayList<>(courseKeySet);
		Random random = new Random();
		int rand;
		Set<Integer> courseRandomIntegers = new HashSet<>();
		// add five unique courses to each student
		for (Student student : roster) {			
			while (courseRandomIntegers.size() < 5) {
				rand = random.nextInt(courseKeyList.size());
				if (courseRandomIntegers.add(rand)) {				
					addCourse(student, courseKeyList.get(rand), 2.0 + 2*Math.random());
				}
			}
			courseRandomIntegers.clear();
		}
	}

	public static void computeGPAs() {
		// provided a student has not repeated a course,
		// the GPA of that student is 
		// (sum of all course.getGrade()*course.getCredits()) divided by 
		// (sum of all course.getCredits()) for the courses in the ArrayList
		// of the student.
		// Go through for(Student st : roster) and for st compute the 
		// the GPA form the ArrayList studentRecord.get(st), then put
		// that GPA in studentGPAs.
		for (Student student : roster) {
			double sumOfCreditsWeighted = 0;
			double sumOfCredits = 0.0;
			double gpa = 0.0;
			List<Course> courses = studentRecord.get(student);
			for (Course course : courses) {
				sumOfCreditsWeighted += course.getCredits() * course.getGrade();
				sumOfCredits += course.getCredits();
			}
			gpa = sumOfCreditsWeighted / sumOfCredits;
			studentGPAs.put(student, gpa);
		}
	}

	public static List<Student> studentsByGPA() {
		// define List<Student> list as a new ArrayList
		// use list.addAll(roster) to fill the list
		// call Collections.sort to sort list with the Comparator
		// Comparator.comparingDouble(st -> studentGPAs.get(st)).reversed());
		// return list
		List<Student> list = new ArrayList<>();
		list.addAll(roster);
		Collections.sort(list, Comparator.comparingDouble(st -> studentGPAs.get(st)).reversed());
		return list;
	}

	public static void printStudentRecord() {
		for (Student student : roster) {
			System.out.println("-------------------------------------------------");
			System.out.println(student);
			System.out.println("-------------------------------------------------");
			for (Course course : studentRecord.get(student)) {				
				System.out.println(course);
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		setupRosterAndRecords();
		setupCourseList();
		populateStudentRecords();
		computeGPAs();
		printStudentRecord();
		System.out.println("\n\n-----------------STUDENT RECORD------------------");
		for(Student st : studentsByGPA()) {
			System.out.printf("%.3f--%s\n", studentGPAs.get(st), st);
		}
	}
}
