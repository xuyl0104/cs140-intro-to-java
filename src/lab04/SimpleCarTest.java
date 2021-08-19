package lab04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JUnitTests {
	SimpleCar hondaCivic;

	@BeforeEach
	void setUp() throws Exception {
		// reset to initial values of the cars
		hondaCivic = new SimpleCar("blue Honda Civic");
	}

	@Test
	@DisplayName("Constrctor makes non null object")
	void testSimpleCar() {
		assertNotNull(hondaCivic);
	}

	@Test
	@DisplayName("A1: Error when argument is 0")
	void testDriveA1() {
		assertEquals("Error: Miles must be greater than zero.", hondaCivic.drive(0.0));
	}

	@Test
	@DisplayName("A2: Error when argument < 0")
	void testDriveA2() {
		assertEquals("Error: Miles must be greater than zero.", hondaCivic.drive(-3.0));
	}

	@Test
	@DisplayName("A3: Warning if tank empty")
	void testDriveA3() {
		hondaCivic.drive(350.0);
		assertEquals("Warning: The blue Honda Civic has no gas!", hondaCivic.drive(3.0));
	}

	@Test
	@DisplayName("A4: Correct message from 280 miles")
	void testDrive4() {
		assertEquals("The blue Honda Civic drove 280.0 miles.", hondaCivic.drive(280.0));
	}

	@Test
	@DisplayName("A5: Running out of gas message")
	void testDrive5() {
		hondaCivic.drive(280.0);
		assertEquals("The blue Honda Civic drove 70.0 miles before running out of gas.", 
				hondaCivic.drive(280.0));
	}

	@Test
	@DisplayName("B1: Error when argument is 0")
	void testAddGasB1() {
		// assert equal Strings
		assertEquals("Error: Gallons must be greater than zero.", 
				hondaCivic.addGas(0.0));
	}

	@Test
	@DisplayName("B2: Error when argument < 0")
	void testAddGasB2() {
		// assert equal Strings
		assertEquals("Error: Gallons must be greater than zero.", 
				hondaCivic.addGas(-1));
	}

	@Test
	@DisplayName("B3: Error gas overflow message")
	void testAddGasB3() {
		// assert equal Strings
		assertEquals("Warning: Gas overflowed from the tank.", 
				hondaCivic.addGas(30));
	}

	@Test
	@DisplayName("B4: Test tank is full after an overflow")
	void testAddGasB4() {
		// uses checkGasGauge()
		// "Warning: Gas overflowed from the tank."
		hondaCivic.drive(35);
		hondaCivic.addGas(2);
		assertEquals( 10.0, 
				hondaCivic.checkGasGauge(), 1e-5);
	}

	@Test
	@DisplayName("B5: correct gas added message")
	void testAddGasB5() {
		// assert equal Strings
		hondaCivic.drive(70.0);
		assertEquals( 2.0 + " gallons added to the gas tank of the blue Honda Civic.", 
				hondaCivic.addGas(2.0));
	}

	@Test
	@DisplayName("B6: correct amount in tank for B5")
	void testAddGasB6() {
		// uses checkGasGauge()
		assertEquals(10, hondaCivic.checkGasGauge(), 1e-5);
	}

	@Test
	@DisplayName("C: Two gallons left after 380 miles")
	void testCheckGasGaugeC() {
		hondaCivic.drive(280.0);
		assertEquals(2, hondaCivic.checkGasGauge(), 1e-5); 
		// JUnit tests for double must specify a tolerated error
	}

	@Test
	@DisplayName("D: 480 on odometer after two 280 mile drives")
	void testCheckOdometerD() {
		hondaCivic.drive(280.0);
		hondaCivic.addGas(4.0);
		hondaCivic.drive(200.0);
		assertEquals(480.0, hondaCivic.checkOdometer(), 1e-5);
		// JUnit tests for double must specify a tolerated error
	}

	@Test
	@DisplayName("E: test honk")
	void testHonkHornE() {
		assertEquals("The blue Honda Civic says beep beep!", 
				hondaCivic.honkHorn());
	}

}
