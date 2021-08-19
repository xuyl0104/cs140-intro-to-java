package playground;
import java.util.Scanner;
import java.util.ArrayList;

public class PhotoLineups {

	// TODO: Write method to create and output all permutations of the list of names.
	public static void allPermutations(ArrayList<String> permList, ArrayList<String> nameList, String indent) {
		if (nameList.size() == 0) {
			// all the names are in the list and print
			System.out.print(indent + "permList: ");
			printPermList(permList);
			System.out.print(indent + "nameList: ");
			printPermList(nameList);

			System.out.print(indent + "* ");
			printPermList(permList);
			System.out.println(indent + "(back to previous level)");
		}
		else {
			System.out.print(indent + "permList: ");
			printPermList(permList);
			System.out.print(indent + "nameList: ");
			printPermList(nameList);
			System.out.println(indent + "->next level of recursion...");
			for (int i = 0; i < nameList.size(); ++i) {
				System.out.println(indent + i + ")Add nameList[" + i + "] = " + nameList.get(i) + " to permList");
				System.out.println(indent + i + ")Remove nameList[" + i + "] = " + nameList.get(i) + " from nameList");				

				String temp = nameList.get(i);
				permList.add(nameList.get(i));
				nameList.remove(nameList.get(i));
				allPermutations(permList, nameList, indent + "|\t");
				permList.remove(permList.size() - 1);
				nameList.add(i, temp);
			}
			System.out.println(indent + "(back to previous level)");
		}
	}

	public static void printPermList(ArrayList<String> permList) {
		for (String name : permList) {
			System.out.print(name + " ");
		}   
		System.out.println("");
	}

	public static void main(String[] args) {
		Scanner scnr = new Scanner("Julia Lucas Mia -1");
		ArrayList<String> nameList = new ArrayList<String>();
		ArrayList<String> permList = new ArrayList<String>();
		String name;

		// TODO: Read in a list of names; stop when -1 is read. Then call recursive method.
		name = scnr.next();
		while (!name.equals("-1")) {
			nameList.add(name);
			name = scnr.next();
		}
		allPermutations(permList, nameList, "");
	}
}
