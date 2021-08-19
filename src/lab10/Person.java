package lab10;
import java.time.LocalDate;

public class Person {
   private String firstName;
   private String lastName;
   private String ssn;
   private LocalDate dateOfBirth;
   
   public Person(String fName, String lName, String id, LocalDate dob) {
      firstName = fName;
      lastName = lName;
      ssn = id;
      dateOfBirth = dob;
   }
   
   public String name() { return lastName + ", " + firstName; }
   
   public String getFirstName() { return firstName; }
   public String getLastName() { return lastName; }
   public String getSsn() { return ssn; }
   public LocalDate getDateOfBirth() {return dateOfBirth;}
   public String toString() {
	   return name() + ", id: " + ssn; 
   }
}
