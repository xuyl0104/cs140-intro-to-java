package exam01;

public class Exam01 {
    // Q1
    public static SimpleCar pickCarForRange(SimpleCar[] cars) {
        if (cars == null || cars.length == 0) {
            return null;
        }
        else if (cars.length == 1) {
            return cars[0];
        }
        else {
            SimpleCar theCar = cars[0];
            for (int i = 1; i < cars.length; ++i) {
                if (cars[i].drivingRange() > theCar.drivingRange()) {
                    theCar = cars[i];
                }
            }
            return theCar;
        }
    }

    // Q2
    public static int[] evenFirst(int[] array) {
        if (array == null) return null;
        if (array.length == 0) return new int[] {};
        else {
            int[] res = new int[array.length];
            int countOfEven = 0;
            int countOfOdd = 0;
            for (int i = 0; i < array.length; ++i) {
                if (array[i] % 2 == 0) {
                    res[countOfEven] = array[i];
                    countOfEven++;
                }
            }
            for (int i = 0; i < array.length; ++i) {
                if (array[i] % 2 != 0) {
                    res[countOfEven + countOfOdd] = array[i];
                    countOfOdd++;
                }
            }
            return res;
        }
    }

    // Q3
    public static int gcf(int m, int n) {
        if(m < 0) m = -m;
        if(n < 0) n = -n;
        if (m == 0 && n > 0) return n;
        if (m > 0 && n == 0) return m;
        if (m == 0 && n == 0) return 0;
        while(m != n) {
            while(m > n) m = m - n;
            while(n > m) n = n - m;
        }
        return m;
    }

    public static int[] coprimes(int x, int[] numbers) {
        int count = 0;
        for (int i = 0; i < numbers.length; ++i) {
            if (gcf(x, numbers[i]) == 1) {
                count++;
            }
        }
        int[] res = new int[count];
        count = 0;
        for (int i = 0; i < numbers.length; ++i) {
            if (gcf(x, numbers[i]) == 1) {
                res[count] = numbers[i];
                count++;
            }
        }
        return res;
    }

    // Q4
    public static boolean equalIgnoreCase(char c1, char c2) {
        return Character.toLowerCase(c1) == Character.toLowerCase(c2);
    }

    public static int freqFirstLetter(char ch, String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        else {
            int count = 0;
            for (int i = 0; i < words.length; ++i) {
                if (equalIgnoreCase(ch, words[i].charAt(0))) {
                    count++;
                }
            }
            return count;
        }
    }

    // Q5
    public static char mostFreqFirstLetter(String[] words) {
        if (words == null || words.length == 0) {
            return (char)0;
        }
        else {
            int mostFrequency = freqFirstLetter('a', words);
            char mostFreqLetter = 'a';
            for (int i = 'b'; i <= 'z'; ++i) {
                if (freqFirstLetter((char)i, words) > mostFrequency) {
                    mostFrequency = freqFirstLetter((char)i, words);
                    mostFreqLetter = (char)i;
                }
            }
            return mostFreqLetter;
        }
    }
}
