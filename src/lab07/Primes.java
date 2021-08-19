package lab07;

import java.util.Arrays;

public class Primes {
    public static boolean isPrime(int n) {
        boolean isPrime = true;
        if (n == 0 || n == 1) {
            isPrime = false;
        }
        else if (n == 2) {
            isPrime = true;
        }
        else {
            for (int i = 2; i < n / 2 + 1; ++i) {
                if (n % i == 0) {
                    isPrime = false;
                }
            }
        }
        return isPrime;
    }

    public static void printPrimeArray(String[] isPrime, int cur) {
        System.out.print("[");
        for (int i = 0; i < isPrime.length; ++i) {
            if (i == cur) {
                System.out.printf("(%s),", isPrime[i]);
            }
            else {
                System.out.printf("%s,", isPrime[i]);
            }
        }
        System.out.println("]");
    }

    public static int[] primesLessThan(int n) {
        String[] isPrime = new String[n];
        isPrime[0] = "F";
        isPrime[1] = "F";
        for (int i = 2; i < n; ++i) {
            isPrime[i] = "T";
        }

        int count = 0;
        for (int i = 2; i < n; ++i) {
            // i is prime
            // we should update the indicators at position 2*i, 3*i ...
            // print the isPrime array
            if (isPrime[i] == "T") {
                if (isPrime(i)) {
                    count++;
                    for (int j = 2 * i; j < n; j = j + i) {
                        isPrime[j] = "F";
                    }
                    // printPrimeArray(isPrime, i);
                    System.out.println(Arrays.toString(isPrime));
                }
            }
        }
        int[] primes = new int[count];
        int pos = 0;
        for (int i = 0; i < isPrime.length; ++i) {
            if (isPrime[i].equals("T")) {
                primes[pos] = i;
                pos++;
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(primesLessThan(40)));
    }
}
