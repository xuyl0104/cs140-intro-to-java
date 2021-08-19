package lab03;

import java.util.Scanner;

public class Lab523 {
    String inputName;
    public Lab523(String name) {
        inputName = name;
    }
    
    public String lastnameFirst1() {
        String returnName = "";
        // define int i and int j as inputName.indexOf(' ') and inputName.indexOf(' ', i + 1);
        // that find the locations of the spaces in inputName. 
        // If there is only 1 space, which means no middleName, j will be -1
        // If j > 0, lastName is inputName.substring(j + 1), firstName is
        // inputName.substring(0, i) amd middleName is inputName.substring(i + 1, j)
        // Making the first letter of firstName uses firstName.toUpperCase().charAt(0)
        // Similarly for the first letter of middleName
        // Assign returnName as the concateenation all the parts and "."

        // else
        // lastName is inputName.substring(i + 1), firstName is
        // inputName.substring(0, i)
        // Similarly assign returnName
        int i = 0;
        int j = 0;
        i = inputName.indexOf(' ');
        j = inputName.indexOf(' ', i + 1);

        String firstName = "";
        String lastName = "";
        String middleName = "";

        if (j < 0) {
            // System.out.println("No middle name");
            firstName = inputName.substring(0, i);
            lastName = inputName.substring(i + 1);
            returnName = lastName + ", " + firstName.toUpperCase().charAt(0) + ".";
        }
        else {
            // System.out.println("Has middle name");
            firstName = inputName.substring(0, i);
            middleName = inputName.substring(i + 1, j);
            lastName = inputName.substring(j + 1);
            returnName = lastName + ", " + firstName.toUpperCase().charAt(0) + "." + middleName.toUpperCase().charAt(0) + ".";
        }
        
        return returnName;
    }

    public String lastnameFirst2() {
        String returnName = "";
        Scanner parser = new Scanner(inputName);
        // firstName will be parser.next() and the nextName is parser.next()
        // if(parser.hasNext()) then middleName = nextName and lastName is parser.next()
        // else lastName is nextName
        // int each branch of the if-else build the returnName as
        // in lastnameFirst1
        String firstName = parser.next();
        String nextName = parser.next();
        String middleName = "";
        String lastName = "";

        if (parser.hasNext()) {
            middleName = nextName;
            lastName = parser.next();
            returnName = lastName + ", " + firstName.toUpperCase().charAt(0) + "." + middleName.toUpperCase().charAt(0) + ".";
        }
        else {
            lastName = nextName;
            returnName = lastName + ", " + firstName.toUpperCase().charAt(0) + ".";
        }

        parser.close();
        return returnName;
    }

    public static void main(String[] args) {
        String test1 = "Pat Silly Doe";
        String test2 = "Julia Clark";
        System.out.println("Using lastnameFirst1:");
        System.out.println("Input: " + test1);
        System.out.println("Output: " + new Lab523(test1).lastnameFirst1());
        System.out.println("Input: " + test2);
        System.out.println("Output: " + new Lab523(test2).lastnameFirst1());
        System.out.println("\nUsing lastnameFirst2:");
        System.out.println("Input: " + test1);
        System.out.println("Output: " + new Lab523(test1).lastnameFirst2());
        System.out.println("Input: " + test2);
        System.out.println("Output: " + new Lab523(test2).lastnameFirst2());
    }

}