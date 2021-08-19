package playground;
import java.util.Scanner;

public class FactorialPrint {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		int factInput = scnr.nextInt();
		int factVal = 1;
		
		System.out.print("" + factInput + "! = ");
		printFactorial(factInput, factVal);
		System.out.println("");

		scnr.close();
	}
	
	public static void printFactorial(int factCount, int factVal) {
		if (factCount == 0) {
			System.out.print("" + factVal);
		}
		else if (factCount == 1) {
			System.out.println(factCount + " = " + factVal);
		}
		else {
			System.out.print(factCount + " * ");
			printFactorial(factCount - 1, factCount * factVal);
		}
	}

}
