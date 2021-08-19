package assignment03;

import java.util.Comparator;

public class CarSpeedComparator implements Comparator<Car>{

	@Override
	public int compare(Car o1, Car o2) {
		return Double.compare(o1.getTopSpeed(), o2.getTopSpeed());
	}
}
