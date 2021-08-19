package exam01;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JUnitTests {
	SimpleCar [] cars;
	static String[] array;
	
	static {
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
		array = test.split("[\\s(),.0-9]+");
	}
	
	@BeforeEach
	void setUp() throws Exception {
		SimpleCar.resetNextVIN();
		cars = new SimpleCar [] { 
				new SimpleCar("blue Honda Civic", 35.0, 12.4),
				new SimpleCar("black Chevy Tahoe", 18.0, 26.0),
				new SimpleCar("white Bentley Continental", 15.0, 20.0),
				new SimpleCar("red Mini Cooper", 30.0, 11.6)};
		for(var c : cars) {
			c.drive(200);
		}
	}

	@Test
	void testPickCarForRange1() {
		assertEquals(cars[1], Exam01.pickCarForRange(cars));
	}

	@Test
	void testPickCarForRange2() {
		cars[1].drive(100);
		assertEquals(cars[0], Exam01.pickCarForRange(cars));
	}

	@Test
	void testPickCarForRange3() {
		assertAll (
				() -> assertNull(Exam01.pickCarForRange(null)),
				() -> assertNull(Exam01.pickCarForRange(new SimpleCar[] {}))
		);
	}

	@Test
	void testEvenFirst1() {
		assertArrayEquals(new int[]{8,2,4,2,2,6,7,9,1,3},
				Exam01.evenFirst(new int[] {7,8,2,9,1,4,2,2,6,3}));
	}

	@Test
	void testEvenFirst2() {
		assertArrayEquals(new int[]{8,2,4,2,2,6},
				Exam01.evenFirst(new int[] {8,2,4,2,2,6}));
	}

	@Test
	void testEvenFirst3() {
		assertArrayEquals(new int[]{7,9,1,3},
				Exam01.evenFirst(new int[] {7,9,1,3}));
	}

	@Test
	void testEvenFirst4() {
		assertAll (
				() -> assertNull(Exam01.evenFirst(null)),
				() -> assertArrayEquals(new int[] {}, Exam01.evenFirst(new int[] {}))
		);		
	}
	
	@Test
	void testCoprimes1() {
		assertArrayEquals(new int[]{77,49,121},
				Exam01.coprimes(30, new int[] {77,38,32,49,121,44,63,72,36,33}));
	}

	@Test
	void testCoprimes2() {
		assertArrayEquals(new int[]{},
				Exam01.coprimes(30, new int[] {76,38,32,48,120,44,63,72,36,33}));
	}

	@Test
	void testCoprimes3() {
		assertArrayEquals(new int[]{77,49,121,31},
				Exam01.coprimes(30, new int[] {77,49,121,31}));
	}
	
	@Test
	void testFreqFirstLetter1() {
		System.out.println(Arrays.toString(array));
		assertEquals(7, Exam01.freqFirstLetter('i', array));
	}

	@Test
	void testFreqFirstLetter2() {
		assertEquals(0, Exam01.freqFirstLetter('h', array));
	}

	@Test
	void testFreqFirstLetter3() {
		assertAll (
				() -> assertEquals(0, Exam01.freqFirstLetter('a', null)),
				() -> assertEquals(0, Exam01.freqFirstLetter('b', new String[] {}))
		);			
	}

	@Test
	void testMostfrequentFirstLetter1() {
		assertEquals('t', Exam01.mostFreqFirstLetter(array));
	}

	@Test
	void testMostfrequentFirstLetter2() {
		assertAll (
				() -> assertEquals((char)0, Exam01.mostFreqFirstLetter(null)),
				() -> assertEquals((char)0, Exam01.mostFreqFirstLetter(new String[] {}))
		);			
	}
}
