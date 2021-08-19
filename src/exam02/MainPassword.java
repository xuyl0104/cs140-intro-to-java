package exam02;
import java.util.Scanner;

/**
 * 	Websites commonly require a password that satisfies several requirements. Write a program that checks if an input string satisfies the following 
 * 	(error message is shown for each):
   	At least 8 characters (Too short)
	At least one letter (Missing letter)
	At least one number (Missing number)
	At least one of these special characters: !, #, % (Missing special)
	Output OK, or all related error messages (in above order).
	
	e.g. If the input string is "Hello", the output is:
	Too short
	Missing number
	Missing special
 * @author xuyunlong
 *
 */
public class MainPassword {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		/* Type your code here. */
		String inputString = scnr.next();
		boolean atLeastEightChars = false;
		boolean atLeastOneLetter = false;
		boolean atLeastOneNum = false;
		boolean atLeastOneSpecialChar = false;
		
		if (inputString.length() >= 8) {
			atLeastEightChars = true;
		}
		for (char c : inputString.toCharArray()) {
			if (Character.isDigit(c) && !atLeastOneNum) {
				atLeastOneNum = true;
			}
			if (Character.isLetter(c) && !atLeastOneLetter) {
				atLeastOneLetter = true;
			}
			if (!atLeastOneSpecialChar) {				
				if (c == '!' || c == '#' || c == '%') {
					atLeastOneSpecialChar = true;
				}
			}
		}
		
		System.out.print(getOutputString(atLeastEightChars, atLeastOneNum, atLeastOneLetter, atLeastOneSpecialChar));
		
	}
	
	public static String getOutputString(boolean atLeastEightChars, boolean atLeastOneNum, boolean atLeastOneLetter, boolean atLeastOneSpecialChar) {
		StringBuilder sb = new StringBuilder();
		if (!atLeastEightChars) {
			sb.append("Too short\n");
		}
		if (!atLeastOneLetter) {
			sb.append("Missing letter\n");
		}
		if (!atLeastOneNum) {
			sb.append("Missing number\n");
		}
		if (!atLeastOneSpecialChar) {
			sb.append("Missing special\n");
		}
		if (atLeastEightChars && atLeastOneLetter && atLeastOneNum && atLeastOneSpecialChar) {
			sb.append("OK\n");
		}
		return sb.toString();
	}
}
