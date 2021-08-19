package lab07;

import java.util.Arrays;

public class Lab07 {
    /**
     * Question 1
     * @param array
     * @param str
     * @return
     */
    public static boolean contains(String[] array, String str) {
        boolean contains = false;
        for (int i = 0; i < array.length; ++i) {
            if (str.equals(array[i])) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    public static String[] noDuplicateJoin(String[] first, String[] second) {
        int numOfUniqueStringInSecond = 0;
        String[] strOfUniqueStringInSecond = new String[second.length];
        for (int i = 0; i < second.length; ++i) {
            if (!contains(first, second[i])) {
                strOfUniqueStringInSecond[numOfUniqueStringInSecond] = second[i];
                numOfUniqueStringInSecond++;
            }
        }
        String[] combinedStr = new String[first.length + numOfUniqueStringInSecond];
        for (int i = 0; i < first.length; ++i) {
            combinedStr[i] = first[i];
        }
        for (int i = 0; i < numOfUniqueStringInSecond; ++i) {
            combinedStr[first.length + i] = strOfUniqueStringInSecond[i];
        }

        return combinedStr;
    }

    /**
     * Question 2
     * @param array
     * @return
     */
    public static int countMax(int[] array) {
        // First compute the maximum integer inside of `array`.
        // Then, in another loop, calculate the count of how many
        // times that value occurs in the array. Return this count
        // Assume that `array`
        // is not null but return 0 if it is empty.
        int times = 0;
        int max = Integer.MIN_VALUE;
        if (array.length == 0) {
            times = 0;
        }
        else if (array.length == 1) {
            times = 1;
            max = array[0];
        }
        else {
            max = array[0];
            // get the max in this loop
            for (int i = 1; i < array.length; ++i) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
            // count the num of max in the array
            for (int i = 0; i < array.length; ++i) {
                if (array[i] == max) {
                    times++;
                }
            }
        }
        return times;
    }

    /**
     * Question 3
     * @param array
     * @return
     */
    public static int[] reverse(int[] array) {
        // Return a new array with the elements of `array` reversed.
        // Assume `array` is not null although it may be empty.  
        // the reverse of an empty array is an empty array.
        // NOTE we will check that `array` is not changed in any way
        if (array.length == 0) {
            int[] res = new int[array.length];
            return res;
        }
        else {
            int[] res = new int[array.length];
            for (int i = 0; i < array.length; ++i) {
                res[i] = array[array.length - 1 - i];
            }
            return res;
        }
    }

    /**
     * Question 4
     */
    private int n;
    public Lab07(int arg) {
        n = arg;
    }

    public int getN() {
        return n;
    }

    public int[] intersperse(int[] array) {
        // Return a new array which resembles `array`
        // but between each element, insert an `n`.
        // If n is 6 intersperse({1,2,3}) should return {1,6,2,6,3}
        // Assume that `array` is not null.
        // If `array` is empty, return an empty array.
        if (array.length == 0) {
            int[] res = new int[0];
            return res;
        }
        else if (array.length == 1) {
            int[] res = new int[1];
            res[0] = array[0];
            return res;
        }
        else {
            int[] res = new int[array.length * 2 -1];
            // first, add elements in array
            for (int i = 0; i < array.length; ++i) {
                res[i * 2] = array[i];
            }
            // second, add the elements of 'n'
            for (int i = 0; i < array.length - 1; ++i) {
                res[2 * i + 1] = getN();
            }
            return res;
        }
    }

    /**
     * command to compile: 
     * javac -d . Exam01.java && java exam01.Exam01
     * 
     * command to compile and run the JUnit:
     * javac -d . -cp ./junit-platform-console-standalone-1.5.0.jar *.java && java -jar ./junit-platform-console-standalone-1.5.0.jar -cp . --scan-classpath
     * @param args
     */
    public static void main(String[] args) {
        var first = new String[]{"one", "two", "three", "four", "five", "six", "seven"};
        var second = new String[]{"zero", "two", "four", "six", "eight"};
        int[] array = {4, 7, 2, 9, 1, 9, 3, 5, 9};
        var test = new Lab07(10);
        System.out.println(contains(second, "four"));
        System.out.println(contains(second, "five"));
        System.out.println(Arrays.toString(noDuplicateJoin(first, second)));
        System.out.println(countMax(new int[] {4, 7, 2, 9, 1, 9, 3, 5, 9}));
        System.out.println(countMax(new int[] {}));
        System.out.println(Arrays.toString(reverse(array)));
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(test.intersperse(array)));
    }
}
