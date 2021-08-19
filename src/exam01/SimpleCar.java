package exam01;
public class SimpleCar {
	private static int nextVIN = 1;
	private String carDescription; // description of the car
	private final int VIN; // unique vehicle identification number
	private double gasTank; // number of gallons currently in tank
	private final double FULL_TANK; // full capacity of gas tank
	private final double MPG; // miles-per-gallon (MPG)
	private double totalMiles; // total miles driven
	
	// Constructor assigns initial values to instance variables
	// and a VIN number 
	public SimpleCar(String carType, double fullT, double mpgallon) {
		carDescription = carType;
		FULL_TANK = fullT; // don't worry constants can be set in the constructor
		MPG = mpgallon;
		gasTank = FULL_TANK;
		totalMiles = 0.0;
		VIN = nextVIN++;
	}

	// this is needed for JUnit testing
	public static void resetNextVIN() {
		nextVIN = 1;
	}

	public double drivingRange() {
		return gasTank * MPG;
	}

	// Drive the requested miles with NO error checking
	public void drive(double tripDistance) {
		totalMiles += tripDistance;
		gasTank -= tripDistance/MPG;
	}
	
	// Add gallons of gas with NO error checking
	public void addGas(double gallonsToAdd) {
		gasTank += gallonsToAdd;
	}
	
	// Return amount of gas in tank
	public double checkGasGauge() {
		return gasTank;
	}
	
	// Return total number of miles driven
	public double checkOdometer() {
		return totalMiles;
	}
	
	@Override
	public String toString() {
		return carDescription + " (" + VIN +")";
	}
	
}