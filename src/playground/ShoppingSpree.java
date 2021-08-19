package playground;

import java.util.ArrayList;

/***
 * select randomly 3 items from the shopping cart which has 4 items inside;
 * print all the possible costs
 * @author YunlongXu
 */
public class ShoppingSpree {
	public static void main(String[] args) {
		ArrayList<GroceryItem> possibleItems = new ArrayList<GroceryItem>(); // Possible shopping items
		ArrayList<GroceryItem> shoppingBag = new ArrayList<GroceryItem>();   // Current shopping bag
		GroceryItem tmpGroceryItem;                                          // item
		final int MAX_CAPACITY_OF_BAG = 3; 

		// Populate grocery with different items
		tmpGroceryItem = new GroceryItem();
		tmpGroceryItem.itemName = "Milk";
		tmpGroceryItem.priceDollars = 2;
		possibleItems.add(tmpGroceryItem);

		tmpGroceryItem = new GroceryItem();
		tmpGroceryItem.itemName = "Belt";
		tmpGroceryItem.priceDollars = 24;
		possibleItems.add(tmpGroceryItem);

		tmpGroceryItem = new GroceryItem();
		tmpGroceryItem.itemName = "Toys";
		tmpGroceryItem.priceDollars = 19;
		possibleItems.add(tmpGroceryItem);

		tmpGroceryItem = new GroceryItem();
		tmpGroceryItem.itemName = "Cups";
		tmpGroceryItem.priceDollars = 12;
		possibleItems.add(tmpGroceryItem);
		
		System.out.println("zyBooks 18.9.2: Shopping spree in which a user can fit 3 items in a shopping bag.\n");

		// Try different combinations of three items
		// if the number of possible items is less than or equal to the max capacity of the bag, do nothing
		if (possibleItems.size() > MAX_CAPACITY_OF_BAG) {			
			shoppingBagCombinations(shoppingBag, possibleItems, "");
		}
		else {
			System.out.println("Not enough items to choose from. Please add more items to the possible items list");
		}
	}

	// recursive function
	private static void shoppingBagCombinations(ArrayList<GroceryItem> shoppingBag,
			ArrayList<GroceryItem> possibleItems, String indent) {
		// base case
		if (possibleItems.size() == 1) {
			// shopping is over; print the total cost of the three selected items
			System.out.print(indent + "shoppingbag: ");
			printShoppingBagInfo(shoppingBag);
			System.out.println("");
			System.out.print(indent + "possibleItems: ");
			printShoppingBagInfo(possibleItems);
			System.out.println("");
			System.out.print(indent + "* ");
			printShoppingBagInfo(shoppingBag);
			System.out.println("= $" + totalCost(shoppingBag));
			System.out.println(indent + "(back to previous level)");
		}
		// recursive function call
		else {
			System.out.print(indent + "shoppingbag: ");
			printShoppingBagInfo(shoppingBag);
			System.out.println("");
			System.out.print(indent + "possibleItems: ");
			printShoppingBagInfo(possibleItems);
			System.out.println("");
			System.out.println(indent + "->next level of recursion...");
			for (int i = 0; i < possibleItems.size(); ++i) {
				System.out.println(indent + i + ")Add possibleItem[" + i + "] = " + possibleItems.get(i).itemName + " to bag");
				System.out.println(indent + i + ")Remove possibleItem[" + i + "] = " + possibleItems.get(i).itemName + " from possible");				
				shoppingBagCombinations(
						expandedShoppingBag(shoppingBag, possibleItems.get(i)), 
						reducPossibleItems(possibleItems, possibleItems.get(i)),
						indent + "|       "
						);
			}
			System.out.println(indent + "(back to previous level)");
		}
	}

	// add an item to the current shoppingBad and return the updated one
	public static ArrayList<GroceryItem> expandedShoppingBag(ArrayList<GroceryItem> before, GroceryItem toBeAdded) {
		@SuppressWarnings("unchecked")
		ArrayList<GroceryItem> resArrayList = (ArrayList<GroceryItem>)before.clone();
		resArrayList.add(toBeAdded);
		return resArrayList;
	}

	// reduce the item from the current possible items and return the update possibleItems ArrayList
	public static ArrayList<GroceryItem> reducPossibleItems(ArrayList<GroceryItem> before, GroceryItem toBeDeleted) {
		ArrayList<GroceryItem> resArrayList = new ArrayList<>();
		for (GroceryItem groceryItem : before) {
			if (!groceryItem.equals(toBeDeleted)) {
				resArrayList.add(groceryItem);
			}
		}
		return resArrayList;
	}


	// print the info of the shoppingBag
	public static void printShoppingBagInfo(ArrayList<GroceryItem> shoppingBag) {
		for (GroceryItem groceryItem : shoppingBag) {
			System.out.print(groceryItem.itemName + " ");
		}
	}

	// get the total cost of the items in the shoppingBag
	public static int totalCost(ArrayList<GroceryItem> shoppingBag) {
		int totalCost = 0;
		for (GroceryItem groceryItem : shoppingBag) {
			totalCost += groceryItem.priceDollars;
		}
		return totalCost;
	}
}

