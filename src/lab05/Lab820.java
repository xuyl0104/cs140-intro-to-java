package lab05;
import java.util.Arrays;
import java.util.Random;

/**
 * Lab820 in zyBooks 8.20
 * @author Yunlong Xu
 * @version 0.0.1
 */
public class Lab820 {
    public static String least2(int[] arr) {
        // if arr == null return "no elements"
        // if arr.length is 0 return "no elements"	
        // if arr.length is 1 return "only " + arr[0]   
        // return the String created by you code for 8.20
        if (arr == null) {
            return "no elements";
        }
        if (arr.length == 0) {
            return "no elements";
        }
        if (arr.length == 1) {
            return "only " + arr[0];
        }

        else {
            int numNumbers = arr.length;
            int smallest = Integer.MAX_VALUE;
            int smallest2nd = Integer.MAX_VALUE;
            
            for (int i = 0; i < numNumbers; ++i) {
                if (arr[i] < smallest) {
                    smallest2nd = smallest;
                    smallest = arr[i];
                }
                else if (arr[i] < smallest2nd) {
                    smallest2nd = arr[i];
                }
            }
            return "" + smallest + " " + smallest2nd;
        }
    }

    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // the test code
    public static void main(String[] args) {
        System.out.println(least2(null));
        System.out.println(least2(new int[] {}));
        System.out.println(least2(new int[] {7}));
        System.out.println(least2(new int[] {5, 10, 5, 3, 21, 2}));
        System.out.println(least2(new int[] {5, 10, 5, 3, 21, 3}));
        int[] test = new int[100];
        Random rand = new Random();
        System.out.println("Note these tests use reandom arrays so will change each time you run them:");
        for(int i = 0; i < 5; ++i) {
            for(int j = 0; j < test.length; ++j) {
                test[j] = 10*(1 + i) + rand.nextInt(200);
            }
            System.out.print(least2(test) + " is expected to be ");
            // You cannot use the following to write your code
            Arrays.sort(test);
            System.out.println(test[0] + " " + test[1]);
        }

        System.out.println("Compare the time complexity of our method and bubble sort:");
        int[] bigtest = new int[50000];
        int[] bigtestcopy = new int[50000];
        for(int j = 0; j < bigtest.length; ++j) {
            bigtest[j] = 10 + rand.nextInt(100000);
            bigtestcopy[j] = bigtest[j];
        }
        // now we have 2 identical test arrays
        long start = System.currentTimeMillis();
        // solve using bubble sort
        bubbleSort(bigtest);
        System.out.println(bigtest[0] + " " + bigtest[1]);
        long end = System.currentTimeMillis();
        System.out.printf("Time taken = %.3f seconds\n", (end-start)/1000.0);
        start = System.currentTimeMillis();
        // solve using hand crafted least2 sort
        System.out.println(least2(bigtestcopy));
        end = System.currentTimeMillis();
        System.out.printf("Time taken = %.3f seconds\n", (end-start)/1000.0);		
    }
}