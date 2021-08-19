package finalexam;

import java.util.Arrays;

public class Question1Tester {
	public static void main(String[] args) {
		System.out.println(BinarySearchTree.valid(new int[] {1,-1,2}) + " should be false");
		System.out.println(BinarySearchTree.valid(new int[] {0, 1, 2}) + " should be false");
		System.out.println(BinarySearchTree.valid(new int[] {0, 0, 1, 2}) + " should be false");
		System.out.println(BinarySearchTree.valid(new int[] {11,2}) + " should be false");
		System.out.println(BinarySearchTree.valid(new int[] {}) + " should be false");
		System.out.println(BinarySearchTree.valid(null) + " should be false");
		System.out.println(BinarySearchTree.valid(new int[] {0}) + " should be true");
		System.out.println(BinarySearchTree.valid(new int[] {1, 2, 3, 4}) + " should be true");
		System.out.println(BinarySearchTree.makeInt(new int[] {0}) + " should be 0");
		System.out.println(BinarySearchTree.makeInt(new int[] {1, 2, 3, 4}) + " should be 1234");
		System.out.println(BinarySearchTree.makeInt(new int[] {9, 8, 7, 6, 5, 4}) + " should be 987654");
		/**
		 * 
		 * 
		 * 					6234
		 * 				 /        \
		 * 			 3999	      7934
		 *          /    \             \
		 *      2239     5234	    	12346
		 * 				/				/	\
		 * 			4234			8868	72346
		 * 								\
		 * 								9234
		 * 
		 * 
		 * 
		 * 
		 */	
		
		
		
		
		BinarySearchTree tree = new BinarySearchTree(new int[] {6, 2, 3, 4});
		tree.insert(new int[] {3, 9, 9, 9});
		tree.insert(new int[] {7, 9, 3, 4});
		tree.insert(new int[] {2, 2, 3, 9});
		tree.insert(new int[] {1, 2, 3, 4, 6});
		tree.insert(new int[] {7, 2, 3, 4, 6});
		tree.insert(new int[] {5, 2, 3, 4});
		tree.insert(new int[] {8, 8, 6, 8});
		tree.insert(new int[] {9, 2, 3, 4});
		tree.insert(new int[] {4, 2, 3, 4});
		System.out.println("TREE:");
		tree.prettyPrint();
		System.out.println("CHECKING largestSum:");
		System.out.println(Arrays.toString(tree.largestSum()) + " should be [3, 9, 9, 9] or [8, 8, 6, 8]");
	}
}
