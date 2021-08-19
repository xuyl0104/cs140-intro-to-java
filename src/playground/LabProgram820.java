package playground;
import java.util.Scanner;

public class LabProgram820 {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int numNumbers;
        int smallest;
        int smaller;
        int[] numArray;
        numNumbers = scnr.nextInt();
        numArray = new int[numNumbers];

        // input integers into the array
        for (int i = 0; i < numNumbers; ++i) {
            numArray[i] = scnr.nextInt();
        }

        // initialize the smallest and 2nd smallest
        if (numArray[0] <= numArray[1]) {
            smallest = numArray[0];
            smaller = numArray[1];
        }
        else {
            smallest = numArray[1];
            smaller = numArray[0];
        }

        // traverse the array from the second index and update smallest and smaller
        for (int i = 2; i < numNumbers; ++i) {
            if (numArray[i] < smallest) {
                smaller = smallest;
                smallest = numArray[i];
            }
            else {
                if (numArray[i] < smaller) {
                    smaller = numArray[i];
                }
            }
        }

        // output the smallest and smaller in ascending order
        System.out.println(smallest + " " + smaller);

        scnr.close();

    }
}