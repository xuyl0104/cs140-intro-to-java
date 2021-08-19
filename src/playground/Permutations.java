package playground;
import java.util.Scanner;

public class Permutations {
	// FIXME: Use a static variable to count permutations. Why must it be static?
	
	public static void printLevelOfRecursion(int levelOfRecursion) {
		for (int i = 1; i < levelOfRecursion; ++i) {
			System.out.print("\t");
		}
	}

	public static void permuteString(String head, String tail, int levelOfRecursion) {
		char current;
		String newPermute;
		int len;
		int i;

		current = '?';
		len = tail.length();

		if (len == 0) {
			// FIXME: Output the permutation count on each line too
			printLevelOfRecursion(++levelOfRecursion);
			System.out.println("head: [" + head + "]  tail: " + (tail.length() == 0 ? "empty" : tail) + "  --> back to prev level" + "\u2191");
		}
		else {
			// FIXME: Change the loop to output permutations in reverse order
			levelOfRecursion++;
			for (i = 0; i < len; ++i) {
				current = tail.charAt(i);           // Get next leading character
				newPermute = tail.substring(0, i) + tail.substring(i + 1);
				// Get the rest of the tail
				printLevelOfRecursion(levelOfRecursion);
				System.out.println("head: " + (head.length() == 0 ? "empty" : head) + "  tail: " + tail + "  --> go to next level");
				permuteString(head + current, newPermute, levelOfRecursion);
			} 
		} 
	} 

	public static void main(String [] args) {
		final String PROMPT_STRING = "Enter a string to permute (<Enter> to exit): ";
		Scanner scnr = new Scanner(System.in);
		String input;

		// Get input and permute the string
		System.out.println(PROMPT_STRING);
		input = scnr.nextLine();

//		while (input.length() > 0) {
			permuteString("", input, 0);
//			System.out.println(PROMPT_STRING);
//			input = scnr.nextLine();
//		} 
		System.out.println("Done.");
	} 
}
