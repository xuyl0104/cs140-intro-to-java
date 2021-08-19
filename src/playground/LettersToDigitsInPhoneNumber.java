package playground;

import java.util.Scanner;

/**
 * this is an exercise from zyBooks 7.10--incremental developing
 * the problem is about transforming phone numbers with english words to numbers with digits only
 * e.g. 1-555-HOLIDAY --> 1-555-4654329
 * @author Yunlong Xu
 * @version 0.0.1
 */
public class LettersToDigitsInPhoneNumber {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String userInput = scnr.nextLine().toUpperCase();
        int length = userInput.length();

        char currChar;

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < length; ++i) {
            currChar = userInput.charAt(i);
            // char is letter
            if ((currChar >= 'a' && currChar <= 'z') || (currChar >= 'A' && currChar <= 'Z')) {
                int digit = (currChar - 'A') / 3 + 2;
                if (digit > 9) {
                    digit = 9;
                }
                // System.out.println(digit);
                str.append(digit);
            }
            // char is digit
            else if (currChar >= '0' && currChar <= '9') {
                // System.out.println(currChar);
                str.append(currChar);
            }
            else {
                // System.out.println(currChar);
                str.append(currChar);
            }
        }

        System.out.println(str.toString());
        scnr.close();
    }
}