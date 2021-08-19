package lab07;

import java.util.Scanner;

public class Lab930 {
    public static int getFrequencyOfWords(String[] wordsList, String currWord) {
        int count = 0;
        for (String word : wordsList) {
            if (word.equals(currWord)) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String[] wordsList = scnr.nextLine().split("\\s+");
        ArraySet set = new ArraySet();
        set.addAll(wordsList);
        for (String currWord: set.getStore()) {
            System.out.println(currWord + " " + getFrequencyOfWords(wordsList, currWord));
        }
        scnr.close();
    }
}
