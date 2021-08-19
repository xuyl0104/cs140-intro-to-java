package exam02;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import java.util.Scanner;

public class Question4 {
	// Do not remove the underline in state names such as New_York. The code will break if you do. 
	// This questions was supposed to read from a file but I could not get the file to save in this 
	// zyBook page. In that version, the underline is not needed. 

	public static String data2019 =  
			"California 39512223 Texas 28995881 Florida 21477737 New_York 19453561 Pennsylvania 12801989 " +
					"Illinois 12671821 Ohio 11689100 Georgia 10617423 North_Carolina 10488084 Michigan 9986857 " +
					"New_Jersey 8882190 Virginia 8535519 Washington 7614893 Arizona 7278717 Massachusetts 6949503 " +
					"Tennessee 6833174 Indiana 6732219 Missouri 6137428 Maryland 6045680 Wisconsin 5822434 " +
					"Colorado 5758736 Minnesota 5639632 South_Carolina 5148714 Alabama 4903185 Louisiana 4648794 " +
					"Kentucky 4467673 Oregon 4217737 Oklahoma 3956971 Connecticut 3565287 Utah 3205958 Iowa 3155070 " +
					"Nevada 3080156 Arkansas 3017825 Mississippi 2976149 Kansas 2913314 New_Mexico 2096829 " +
					"Nebraska 1934408 Idaho 1787065 West_Virginia 1792147 Hawaii 1415872 New_Hampshire 1359711 " +
					"Maine 1344212 Montana 1068778 Rhode_Island 1059361 Delaware 973764 South_Dakota 884659 " +
					"North_Dakota 762062 Alaska 731545 Vermont 623,989 Wyoming 578759";

	private Map<String, Integer> populations = new TreeMap<>();

	public Map<String, Integer> getPopulations() { return populations; }

	public Question4 () {
		try (Scanner input = new Scanner(data2019)) {
			while(input.hasNext()) {
				String key = input.next();
				int value = input.nextInt();
				// TODO
				// put this key/value entry into popluations
				populations.put(key, value);
			}
		}
	}
	public List<String> largeAndOddPopulation() {
		// TODO
		// create an ArrayList and add all the state or territory names
		// in populations.keySet() such that the population is at least 10 million
		// and also an odd number (%2 == 1)
		// remove the next line after you complete your code
		List<String> res = new ArrayList<>();
		for (String stateString : populations.keySet()) {
			if (populations.get(stateString) >= 10000000 && populations.get(stateString) % 2 == 1) {
				res.add(stateString);
			}
		}
		return res; 
	}
}
