package exam01;

import java.util.Arrays;

public class Exam01Driver {
	public static void main(String[] args) {
		SimpleCar [] cars = { new SimpleCar("blue Honda Civic", 35.0, 12.4),
		new SimpleCar("black Chevy Tahoe", 18.0, 26.0),
		new SimpleCar("white Bentley Continental", 15.0, 20.0),
		new SimpleCar("red Mini Cooper", 30.0, 11.6)};
		for(var c : cars) {
			c.drive(200);
		}
		System.out.println("Expected: black Chevy Tahoe (2)");
		System.out.println("Actual:   " + Exam01.pickCarForRange(cars));
		System.out.println("Expected: [8, 2, 4, 2, 2, 6, 7, 9, 1, 3]");
		System.out.println("Actual:   " + Arrays.toString(Exam01.evenFirst(new int[] {7,8,2,9,1,4,2,2,6,3})));
		System.out.println("Expected: [77, 49, 121]");
		System.out.println("Actual:   " + Arrays.toString(Exam01.coprimes(30, new int[] {77,38,32,49,121,44,63,72,36,33})));
		String test = "In mathematics, the sieve of Eratosthenes is an ancient "
				+"algorithm for finding all prime numbers up to any given "
				+"limit. It does so by iteratively marking as composite "
				+"(that is, not prime) the multiples of each prime, starting "
				+"with the first prime number, 2. The multiples of a given "
				+"prime are generated as a sequence of numbers starting from "
				+"that prime, with constant difference between them that is "
				+"equal to that prime. This is the sieve's key distinction "
				+"from using trial division to sequentially test each "
				+"candidate number for divisibility by each prime.";
		String[] array = test.split("[\\s(),.0-9]+");
		System.out.println("Expected: 7");
		System.out.println("Actual:   " + Exam01.freqFirstLetter('i', array));
		System.out.println("Expected: 0");
		System.out.println("Actual:   " + Exam01.freqFirstLetter('h', array));
		System.out.println("Expected: most frequent: t");
		System.out.println("Actual:   most frequent: " + Exam01.mostFreqFirstLetter(array));
	}

}
