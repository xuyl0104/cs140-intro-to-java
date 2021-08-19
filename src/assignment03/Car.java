package assignment03;

import java.awt.Color;

public class Car implements Comparable<Car> {
	private static int vinCount = 1;
	private String maker;
	private String model;
	private int VIN;
	private Color color;
	private double topSpeed;
	
	public Car(String maker, String model, Color color, double topSpeed) {
		super();
		this.maker = maker;
		this.model = model;
		this.VIN = vinCount++;
		this.color = color;
		this.topSpeed = topSpeed;
	}
	public String getMaker() {
		return maker;
	}
	public String getModel() {
		return model;
	}
	public int getVIN() {
		return VIN;
	}
	public Color getColor() {
		return color;
	}
	public double getTopSpeed() {
		return topSpeed;
	}
	@Override
	public int compareTo(Car other) {
		int comparisonValue;
		comparisonValue = (maker+model).compareTo(other.maker+other.model);
		if (comparisonValue == 0) {
			comparisonValue = VIN - other.VIN;
		}
		return comparisonValue;
	}
	
	@Override
	public String toString() {
		return maker + "\t" + model + "\t" + topSpeed + "\t" + VIN;
	}
	
}
