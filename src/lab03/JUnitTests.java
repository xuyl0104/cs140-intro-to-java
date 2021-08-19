package lab03;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class JUnitTests {

	@Test
	void testDescribeChange1() {
		assertEquals("2 Dollars\n3 Quarters\n1 Dime\n1 Nickel\n2 Pennies", Lab522.describeChange(292).trim());
	}

	@Test
	void testDescribeChange2() {
		assertEquals("1 Dollar\n2 Quarters\n1 Penny", Lab522.describeChange(151).trim());
	}

	@Test
	void testDescribeChange3() {
		assertEquals("1 Quarter\n2 Dimes\n1 Penny", Lab522.describeChange(46).trim());
	}

	@Test
	void testDescribeChange4() {
		assertEquals("1 Dime\n1 Nickel\n4 Pennies", Lab522.describeChange(19).trim());
	}

	@Test
	void testlastnameFirstA() {
		var test = new Lab523("Mary Wollstonecraft Shelley");
		assertEquals("Shelley, M.W.", test.lastnameFirst1());
	}

	@Test
	void testlastnameFirstB() {
		var test = new Lab523("Mary Wollstonecraft Shelley");
		assertEquals("Shelley, M.W.", test.lastnameFirst2());
	}

	@Test
	void testlastnameFirstC() {
		var test = new Lab523("Walter Scott");
		assertEquals("Scott, W.", test.lastnameFirst1());
	}

	@Test
	void testlastnameFirstD() {
		var test = new Lab523("Walter Scott");
		assertEquals("Scott, W.", test.lastnameFirst2());
	}
}
