package avl;

import java.util.Random;

public class MainAVL {

	public static void main(String[] args) {

		AVL tree = new AVL();
		tree.insert(14);
		tree.insert(12);
		tree.insert(15);
		tree.insert(9);
		tree.insert(13);
		tree.insert(16);
		tree.insert(4);
		tree.insert(10);
		tree.insert(8);
		tree.insert(17);
		tree.insert(3);
		tree.insert(2);
		/**
		 * 
		             14              
		           /     \         
		          12      15   
		         /  \      \
		        9   13      16
		       /  \			 \	
		      4    10   	  17
		     / \			
			3   8
		   /						
	      2

		 */

		tree.prettyPrint();

		// transform the BST to AVL
		while (tree.findFirstUnbalancedNode() != null) {
			System.out.println("First unbalanced: " + (tree.findFirstUnbalancedNode() == null ? "no" : tree.findFirstUnbalancedNode().data));
			tree.toAVL();
			tree.prettyPrint();
		}

		System.out.println("\n================END================");

		AVL tree1 = new AVL();
		tree1.insert(12);
		tree1.insert(4);
		tree1.insert(14);
		tree1.insert(3);
		tree1.insert(9);
		tree1.insert(13);
		tree1.insert(18);
		tree1.insert(2);
		tree1.insert(8);
		tree1.insert(10);
		tree1.insert(15);
		tree1.insert(19);
		tree1.insert(16);

		/**
		 * 
		             12              
		           /     \         
		          4       14 <----unbalanced
		         /  \     /  \
		        3    9   13  18
		       / 	/ \		 / \	
		      2    8  10 	15  19
							 \
							  16
		 */

		tree1.prettyPrint();
		// transform the BST to AVL
		while (tree1.findFirstUnbalancedNode() != null) {
			System.out.println("First unbalanced: " + (tree1.findFirstUnbalancedNode() == null ? "no" : tree1.findFirstUnbalancedNode().data));
			tree1.toAVL();
			tree1.prettyPrint();
		}

		System.out.println("\n================END================");
		
//		AVL tree2 = new AVL();
//		Random random = new Random();
//		for (int i = 0; i < 20; ++i) {
//			int rand = random.nextInt(50);
//			if (!tree2.isInTheTree(rand)) {
//				tree2.insert(rand);
//			}
//		}
//		
//		tree2.prettyPrint();
//		
//		System.out.println("TO AVL...");
//		
//		while (tree2.findFirstUnbalancedNode() != null) {
//			System.out.println("First unbalanced: " + (tree2.findFirstUnbalancedNode() == null ? "no" : tree2.findFirstUnbalancedNode().data));
//			tree2.toAVL();
//			tree2.prettyPrint();
//		}
//		System.out.println("END");
	}

}
