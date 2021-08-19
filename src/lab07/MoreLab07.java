package lab07;

import java.util.Arrays;

public class MoreLab07 {
    /**
     * practice on the class GroupPerperties
     * @param array
     * @return
     */
    public static GroupProperties processEvens(int[] array) {
        if (array == null || array.length == 0) {
            return new GroupProperties(0, 0, 0);
        }
        // not empty
        else {
            int sumOfEven = 0;
            double averageOfEven = 0.0;
            int productOfEven = 1;
            int numOfEven = 0;
            boolean allOdd = true;
            for (int num : array) {
                if (num % 2 == 0) {
                    sumOfEven += num;
                    productOfEven *= num;
                    numOfEven++;
                    allOdd = false;
                }
            }
            if (allOdd) {  // all odd numbers
                productOfEven = 0;
                averageOfEven = 0;
                sumOfEven = 0;
            }
            else {  // at least one even numbers
                averageOfEven = sumOfEven * 1.0 / numOfEven;
            }
            return new GroupProperties(sumOfEven, productOfEven, averageOfEven);
        }
    }

    /**
     * return the array of the longest strings in the words array
     * @param words
     * @return
     */
    public static String[] longest(String[] words) {
        if (words == null) {
            return null;
        }
        else if (words.length == 0) {
            return new String[] {};
        }
        else {
            boolean allNull = true;
            for (String word : words) {
                if (word != null) {
                    allNull = false;
                }
            }
            if (allNull) {
                return new String[] {};
            }
            else {
                // find the longest string in the words array
                String longest = "";
                int count = 0;
                for (int i = 0; i < words.length; ++i) {
                    if (words[i] == null) {
                        continue;
                    }
                    else {
                        if (words[i].length() > longest.length()) {
                            longest = words[i];
                            count = 1;
                        }
                        else {
                            // even if the words are not the same but have the same length, count should increase
                            if (words[i].length() == longest.length()) {
                                count++;
                            }
                        }
                    }
                    // System.out.println(longest);
                }
                // find all the longest strings in the array
                String[] longestArray = new String[count];
                int num = 0;
                for (String str : words) {
                    if (str != null && str.length() == longest.length()) {
                        longestArray[num] = str;
                        num++;
                    }
                }
                return longestArray;
            }
        }
    }
    public static void main(String[] args) {
        int[] test1 = null;
        int[] test2 = {};
        int[] test3 = {1, 3, 5, 7};
        int[] test4 = {0, 1, 2, 3, 4, 5, 6, 7};
        int[] test5 = {1, 2, 3, 5, 8, 7, 10};
        System.out.print("Test1. Expecting GroupProperties[0, 0, 0.0] received: ");
        System.out.println(processEvens(test1));
        System.out.print("Test2. Expecting GroupProperties[0, 0, 0.0] received: ");
        System.out.println(processEvens(test2));
        System.out.print("Test3. Expecting GroupProperties[0, 0, 0.0] received: ");
        System.out.println(processEvens(test3));
        System.out.print("Test4. Expecting GroupProperties[12, 0, 3.0] received: ");
        System.out.println(processEvens(test4));
        System.out.print("Test5. Expecting GroupProperties[20, 160, 6.666666666666667] received: ");
        System.out.println(processEvens(test5));
        String[] wtest1 = null;
        String[] wtest2 = {};
        String[] wtest3 = {null, null, null};
        String[] wtest4 = {"one", null, "two", "three", null, "seven"};
        String[] wtest5 = {null, "one", null, "two", "twenty", null, "seven"};
        System.out.print("Test1. Expecting null received: ");
        System.out.println(Arrays.toString(longest(wtest1)));
        System.out.print("Test2. Expecting [] received: ");
        System.out.println(Arrays.toString(longest(wtest2)));
        System.out.print("Test3. Expecting [] received: ");
        System.out.println(Arrays.toString(longest(wtest3)));
        System.out.print("Test4. Expecting [three, seven] received: ");
        System.out.println(Arrays.toString(longest(wtest4)));
        System.out.print("Test5. Expecting [twenty] received: ");
        System.out.println(Arrays.toString(longest(wtest5)));
    }
      
    public static void main2(String[] args) {
        int[] array1 = null;
        int[] array2 = {};
        int[] array3 = {7};
        int[] array4 = {8};
        int[] array5 = {8, 9, 10, 11, 12};
        int[] array6 = {3, 5, 7, 9, 11, 13};

        String[] words1 = null;
        String[] words2 = {};
        String[] words3 = {null, null};
        String[] words4 = {""};
        String[] words5 = {"one"};
        String[] words6 = {"", ""};
        String[] words7 = {"", "four", "one", "ono"};
        String[] words8 = {"", "one", "two", "three", "four", "four", "three", "six", "three", "thrhr", "twole", "threa"};

        GroupProperties gp1 = processEvens(array1);
        GroupProperties gp2 = processEvens(array2);
        GroupProperties gp3 = processEvens(array3);
        GroupProperties gp4 = processEvens(array4);
        GroupProperties gp5 = processEvens(array5);
        GroupProperties gp6 = processEvens(array6);

        String[] la1 = longest(words1);
        String[] la2 = longest(words2);
        String[] la3 = longest(words3);
        String[] la4 = longest(words4);
        String[] la5 = longest(words5);
        String[] la6 = longest(words6);
        String[] la7 = longest(words7);
        String[] la8 = longest(words8);

        // Test
        gp1.printPerperties();
        gp2.printPerperties();
        gp3.printPerperties();
        gp4.printPerperties();
        gp5.printPerperties();
        gp6.printPerperties();

        System.out.println("#######################################");

        System.out.println("Array is: " + Arrays.toString(words1) + "; longest arr is: " + Arrays.toString(la1) + ", length is: " + (la1 == null ? "null" : la1.length));
        System.out.println("Array is: " + Arrays.toString(words2) + "; longest arr is: " + Arrays.toString(la2) + ", length is: " + (la2 == null ? "null" : la2.length));
        System.out.println("Array is: " + Arrays.toString(words3) + "; longest arr is: " + Arrays.toString(la3) + ", length is: " + (la3 == null ? "null" : la3.length));
        System.out.println("Array is: " + Arrays.toString(words4) + "; longest arr is: " + Arrays.toString(la4) + ", length is: " + (la4 == null ? "null" : la4.length));
        System.out.println("Array is: " + Arrays.toString(words5) + "; longest arr is: " + Arrays.toString(la5) + ", length is: " + (la5 == null ? "null" : la5.length));
        System.out.println("Array is: " + Arrays.toString(words6) + "; longest arr is: " + Arrays.toString(la6) + ", length is: " + (la6 == null ? "null" : la6.length));
        System.out.println("Array is: " + Arrays.toString(words7) + "; longest arr is: " + Arrays.toString(la7) + ", length is: " + (la7 == null ? "null" : la7.length));
        System.out.println("Array is: " + Arrays.toString(words8) + "; longest arr is: " + Arrays.toString(la8) + ", length is: " + (la8 == null ? "null" : la8.length));
    }
}
