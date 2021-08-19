package playground;

import java.util.ArrayList;

public class TravellingSalemanPaths {
	static final int NUM_CITIES = 3;                                // Number of cities	
	static String[] cityNames = new String[NUM_CITIES];             // City names
	static int[][] cityDistances = new int[NUM_CITIES][NUM_CITIES]; // Distance between cities
	public static void main (String[] args) {
		
		ArrayList<Integer> needToVisit = new ArrayList<Integer>(); // Cities left to visit
		ArrayList<Integer> currPath = new ArrayList<Integer>();    // Current path traveled

		// Initialize distances array
		// 0-Boston; 1-Chicago; 2-Los Angeles 
		cityDistances[0][0] = 0;
		cityDistances[1][1] = 0;
		cityDistances[2][2] = 0;
		cityDistances[0][1] = 960;  // Boston-Chicago
		cityDistances[0][2] = 2960; // Boston-Los Angeles
		cityDistances[1][0] = 960;  // Chicago-Boston
		cityDistances[1][2] = 2011; // Chicago-Los Angeles
		cityDistances[2][0] = 2960; // Los Angeles-Boston
		cityDistances[2][1] = 2011; // Los Angeles-Chicago

		cityNames[0] = "Boston";
		cityNames[1] = "Chicago";
		cityNames[2] = "LosAngeles";

		needToVisit.add(Integer.valueOf(0)); // Boston
		needToVisit.add(Integer.valueOf(1)); // Chicago
		needToVisit.add(Integer.valueOf(2)); // Los Angeles

		// Explore different paths
		if (needToVisit.size() == NUM_CITIES) {			
			travelPaths(currPath, needToVisit);
		}
		else {
			System.out.println("Not enough cities to visit. Please more cities to the list.");
		}
	}
	
	public static void travelPaths(ArrayList<Integer> currPath, ArrayList<Integer> needToVisit) {
		// all the places have been visited
		// base case
		if (currPath.size() == NUM_CITIES) {
			System.out.print(pathInfo(currPath) + " = ");
			System.out.println(calculateTotalDistance(currPath));
		}
		else {
			for (int i = 0; i < needToVisit.size(); ++i) {
				Integer tempInteger = needToVisit.get(i);
				currPath.add(needToVisit.get(i));
				needToVisit.remove(needToVisit.get(i));
				travelPaths(currPath, needToVisit);
				currPath.remove(currPath.size() - 1);
				needToVisit.add(i, tempInteger);
			}
		}
	}
	
	public static String pathInfo(ArrayList<Integer> path) {
		String reString = "";
		for (int i = 0; i < path.size(); ++i) {
			reString += cityNames[path.get(i)] + " ";
		}
		return reString;
	}
	
	public static int calculateTotalDistance(ArrayList<Integer> path) {
		int res = 0;
		for (int i = 0; i < path.size() - 1; ++i) {
			res += cityDistances[path.get(i)][path.get(i + 1)];
		}
		return res;
	}
}

