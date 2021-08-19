package bst;

public class MainBST {

	public static void main(String[] args) {
		
		/**
		 * 
	       (c) has two children
	             50                              50
	           /     \         delete(30)      /    \
	          30      70       --------->    39      70 
	         /  \    /  \                    / \     /  \ 
	        20  40  60   80                 20  40  60   80
	            / \                              \
	          39   45                            45
		* 
		*/
		BST tree = new BST();
		tree.insert(50);
		tree.insert(30);
		tree.insert(70);
		tree.insert(20);
		tree.insert(40);
		tree.insert(60);
		tree.insert(80);
		tree.insert(39);
		tree.insert(45);
		
		tree.prettyPrint();
				
		System.out.println("\n\n ******** delete 50 ********");
		tree.delete(50);
		tree.prettyPrint();
		
		System.out.println("\n\n ******** delete 30 ********");
		tree.delete(30);
		tree.prettyPrint();
		
		
		System.out.println("\n\n ******** delete 70 ********");
		tree.delete(70);
		tree.prettyPrint();
		
		
		System.out.println("\n\n ******** delete 20 ********");
		tree.delete(20);
		tree.prettyPrint();
		
		
		System.out.println("\n\n ******** delete 40 ********");
		tree.delete(40);
		tree.prettyPrint();
		
		
		System.out.println("\n\n ******** delete 39 ********");
		tree.delete(39);
		tree.prettyPrint();
		
		
		System.out.println("\n\n ******** delete 45 ********");
		tree.delete(45);
		tree.prettyPrint();
		
		
		System.out.println("\n\n ******** delete 60 ********");
		tree.delete(60);
		tree.prettyPrint();
		
		
		System.out.println("\n\n ******** delete 80 ********");
		tree.delete(80);
		tree.prettyPrint();
		

		System.out.println("##########################################");
		System.out.println("##########################################");
		System.out.println("##########################################");
		
		
		System.out.println("============= insert root ===================");
		BST tree1 = new BST();
		System.out.println("height: " + tree1.height());
		tree1.prettyPrint();
		
		System.out.println("\n============= insert 10 ===================");
		tree1.insert(10);
		System.out.println("height: " + tree1.height());
		tree1.prettyPrint();
		
		System.out.println("\n============= insert 13 ===================");
		tree1.insert(13);
		System.out.println("height: " + tree1.height());
		tree1.prettyPrint();
		
		System.out.println("\n============= insert 7 ===================");
		tree1.insert(7);
		System.out.println("height: " + tree1.height());
		tree1.prettyPrint();
		
		System.out.println("\n============= insert6  ===================");
		tree1.insert(6);
		System.out.println("height: " + tree1.height());
		tree1.prettyPrint();
		
		System.out.println("\n============= insert 8 ===================");
		tree1.insert(8);
		System.out.println("height: " + tree1.height());
		tree1.prettyPrint();
		System.out.println("MAX: " + tree1.maximumNode().data);
		System.out.println("MIN: " + tree1.minimumNode().data);
		
		System.out.println("\n============= insert 11 ===================");
		tree1.insert(11);
		System.out.println("height: " + tree1.height());
		tree1.prettyPrint();
		
		System.out.println("\n============= insert 15 ===================");
		tree1.insert(15);
		System.out.println("height: " + tree1.height());
		tree1.prettyPrint();
		
		System.out.println("\n============= insert 9 ===================");
		tree1.insert(9);
		System.out.println("height: " + tree1.height());
		tree1.prettyPrint();
		System.out.println("MAX: " + tree1.maximumNode().data);
		System.out.println("MIN: " + tree1.minimumNode().data);
		
		System.out.println("\n============= insert 12 ===================");
		tree1.insert(12);
		System.out.println("height: " + tree1.height());
		tree1.prettyPrint();
		System.out.println("MAX: " + tree1.maximumNode().data);
		System.out.println("MIN: " + tree1.minimumNode().data);
		
		
		/**
		 * Given s tree such as
		 *            10
		 *           /   \
		 *         7      13
		 *        / \     / \
		 *       6   8   11 15
		 *            \   \
		 *             9   12
		 */
		
		System.out.println("\n=========== delete 7 ==============");
		tree1.delete(7);;
		tree1.prettyPrint();
		
		
		System.out.println("\n=========== delete 10 ==============");
		tree1.delete(10);;
		tree1.prettyPrint();
		
		System.out.println("\n=========== delete 13 ==============");
		tree1.delete(13);;
		tree1.prettyPrint();
		
		System.out.println("\n=========== delete 11 ==============");
		tree1.delete(11);;
		tree1.prettyPrint();
		
		System.out.println("\n=========== delete 9 ==============");
		tree1.delete(9);
		tree1.prettyPrint();
		
		System.out.println("\n=========== delete 12 ==============");
		tree1.delete(12);;
		tree1.prettyPrint();
		
		System.out.println("\n=========== delete 15 ==============");
		tree1.delete(15);;
		tree1.prettyPrint();
		
		System.out.println("\n================END================");
	}

}
