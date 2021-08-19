package playground;
import java.util.Scanner;

public class TestCreatingArrayWithUserInputLength {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int length = scnr.nextInt();
        int[] arr = new int[length];

        for (int i = 0; i < length; ++i) {
            arr[i] = scnr.nextInt();
        }

        for (int i: arr) {
            System.out.println(i);
        }

        scnr.close();
    }
}
