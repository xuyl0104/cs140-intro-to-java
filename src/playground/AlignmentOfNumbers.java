package playground;

/**
 * this is a program to test the alignment of numbers
 * e.g. %6.2f will align the numbers to the right, with 6 space wide and 2 digits after the decimal point
 * e.g. %-.2f will align the numbers to the left and with 2 digits after the decimal point
 * @author Yunlong Xu
 * @version 0.0.1
 */
public class AlignmentOfNumbers {
    public static void main(String[] args) {
        int tempInCel;
        double tempInF = 0.0;
        for (tempInCel = -10; tempInCel < 400; tempInCel = tempInCel + 25) {
            tempInF = tempInCel * 1.8 + 32.0;
            System.out.printf("%3d in celcius is %6.2f in fahrenheit.\n", tempInCel, tempInF);
        }
    }

}