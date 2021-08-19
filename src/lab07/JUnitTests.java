package lab07;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JUnitTests {
	String[] first;
	String[] second;
	String[] third;
	int[] array;
	Lab07 test;

	@BeforeEach
	void setUp() throws Exception {
		first = new String[]{"one", "two", "three", "four", "five", "six", "seven"};
		second = new String[]{"zero", "two", "four", "six", "eight"};
		third =  new String[]{"two", "four", "six"};
		array = new int[]{4, 7, 2, 9, 1, 9, 3, 5, 9};
		test = new Lab07(10);
	}

	@Test
	void testLab07() {
		assertEquals(10, test.getN());
	}

	@Test
	void testContains1() {
		assertTrue(Lab07.contains(second, "four"));
	}

	@Test
	void testContains2() {
		assertFalse(Lab07.contains(second, "five"));
	}

	@Test
	void testNoDuplicateJoin1() {
		String[] expected = {"eight", "five", "four", "one", "seven", "six", "three", "two", "zero"};
		String[] result = Lab07.noDuplicateJoin(first, second);
		Arrays.sort(result);
		assertArrayEquals(expected, result);
	}

	@Test
	void testNoDuplicateJoin2() {
		String[] expected = {"five", "four", "one", "seven", "six", "three", "two"};
		String[] result = Lab07.noDuplicateJoin(first, third);
		Arrays.sort(result);
		assertArrayEquals(expected, result);
	}
	@Test
	void testNoDuplicateJoin3() {
		String[] fourth = new String[]{"one", "two", "three", "four", "five", "six", "seven"};
		String[] expected = {"one", "two", "three", "four", "five", "six", "seven"};
		String[] result = Lab07.noDuplicateJoin(first, fourth);
		Arrays.sort(result);
		Arrays.sort(expected);
		assertArrayEquals(expected, result);
	}

	@Test
	void testCountMax1() {
		assertEquals(3, Lab07.countMax(array));
	}

	@Test
	void testCountMax2() {
		assertEquals(0, Lab07.countMax(new int[] {}));
	}

	@Test
	void testReverse1() {
		int[] expected = {9, 5, 3, 9, 1, 9, 2, 7, 4};
		assertArrayEquals(expected, Lab07.reverse(array));
	}

	@Test
	void testReverse2() {
		int[] expected = {};
		assertArrayEquals(expected, Lab07.reverse(new int[] {}));
	}

	@Test
	void testReverse3() {
		Lab07.reverse(array);
		assertArrayEquals(new int[]{4, 7, 2, 9, 1, 9, 3, 5, 9}, array);
	}
	
	@Test
	void testReverse4() {
		int[] array = new int[] {1};
		assertArrayEquals(new int[]{1}, Lab07.reverse(array));
	}

	@Test
	void testIntersperse1() {
		int[] expected = {};
		assertArrayEquals(expected, test.intersperse(new int[] {}));
	}

	@Test
	void testIntersperse2() {
		int[] expected = {4, 10, 7, 10, 2, 10, 9, 10, 1, 10, 9, 10, 3, 10, 5, 10, 9};
		assertArrayEquals(expected, test.intersperse(array));
	}
	
	@Test
	void testIntersperse3() {
		int[] array = new int[] {1, 3};
		int[] expected = {1, 10, 3};
		assertArrayEquals(expected, test.intersperse(array));
	}
	
	@Test
	void testIntersperse4() {
		int[] array = new int[] {1, 3, 5, 7};
		int[] expected = {1, 10, 3, 10, 5, 10, 7};
		assertArrayEquals(expected, test.intersperse(array));
	}
}
