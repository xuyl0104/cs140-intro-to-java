package playground;

import java.util.Random;

/**
 * this class test the Random.nextInt() function
 */
public class RandomGenerator {
    public static void main(String[] args) {
        Random rand = new Random(); 
        // here set seed = 2, this will make the 10 generated random integers the same each time we run the code
        printArray(randomGenerator(rand, 2, 10, 100));
    }

    /**
     * this function print out an int array
     * the format is x x x x x x x (ended with a new line)
     * @param arr the arr to be printed out
     */
    public static void printArray(int[] arr) {

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * this method generates random numbers from rangeLow to rangeHigh (both inclusive)
     * @param rand the Random instance
     * @param rangeLow lower bound (inclusive)
     * @param rangeHigh higher bound (inclusive)
     * @param numRandoms number of random integers generated
     * @return the array containing all the generated integers
     */
    public static int[] randomGenerator(Random rand, int rangeLow, int rangeHigh, int numRandoms) {
        int[] res = new int[numRandoms];

        for (int i = 0; i < numRandoms; i++) {
            res[i] = rangeLow + rand.nextInt(rangeHigh + 1 - rangeLow);
        }
        return res;
    }
}