package lab08;

public class EmployeeData implements Comparable<EmployeeData> {
   private String firstName; // First Name
   private String lastName;  // Last Name
   private Integer emplID;   // Employee ID
   private Integer deptNum;  // Department Number
   
   EmployeeData(String firstName, String lastName, Integer emplID, Integer deptNum) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.emplID = emplID;
      this.deptNum = deptNum;
   }

   @Override
   public int compareTo(EmployeeData otherEmpl) {
      int comparisonVal;         // Outcome of comparison
      
      // Compare based on department number first
      comparisonVal = deptNum.compareTo(otherEmpl.deptNum);
      
      // If in same organization, use name
      if (comparisonVal == 0) {
         comparisonVal = emplID.compareTo(otherEmpl.emplID);
      }
      
      return comparisonVal;
   }
   
   @Override
   public String toString() {
      return lastName + " " + firstName + 
             "       \tID: " + emplID + 
             "\t\tDept. #: " + deptNum;
   }
}
