package lab11;

public class Main {

	public static void main(String[] args) {
		/**
		 * Given a tree such as
		 *          A
		 *        /   \
		 *      B       C
		 *     / \     / 
		 *    D   E   F 
		 *    
		 */
		System.out.println("\n======================== Tree #1 ========================");
		BinaryTree<String> empty = new BinaryTree<>();
		BinaryTree<String> treeD = new BinaryTree<>("D");
		BinaryTree<String> treeE = new BinaryTree<>("E");
		BinaryTree<String> treeF = new BinaryTree<>("F");
		BinaryTree<String> treeB = new BinaryTree<>("B", treeD, treeE);
		BinaryTree<String> treeC = new BinaryTree<>("C", treeF, empty);
		BinaryTree<String> tree = new BinaryTree<>("A", treeB, treeC);
		tree.prettyPrint();
		System.out.println("---------------------");
		System.out.println("node count: " + tree.nodeCount());
		System.out.println("---------------------");
		System.out.println("tree height: " + tree.height());
		System.out.println("---------------------");
		System.out.println("tree is full?: " + tree.isAFullTree());
		
		/**
		 * Given s tree such as
		 *             A
		 *           /   \
		 *         B       C
		 *        / \     / \
		 *       D   E   F   G
		 *          / \ 
		 *         H   J
		 */
		System.out.println("\n======================== Tree #2 ========================");
		BinaryTree<String> treeG = new BinaryTree<>("G");
		treeC = new BinaryTree<>("C", treeF, treeG);
		BinaryTree<String> treeH = new BinaryTree<>("H");
		BinaryTree<String> treeJ = new BinaryTree<>("J");
		treeE = new BinaryTree<>("E", treeH, treeJ);
		treeB = new BinaryTree<>("B", treeD, treeE);
		tree = new BinaryTree<>("A", treeB, treeC);
		
		System.out.println("---------------------");
		tree.prettyPrint();
		System.out.println("---------------------");
		System.out.println("node count: " + tree.nodeCount());
		System.out.println("---------------------");
		System.out.println("tree height: " + tree.height());
		System.out.println("---------------------");
		System.out.println("tree is full?: " + tree.isAFullTree());
		
		
		/**
		 * Given s tree such as
		 * 
		 *          W
		 */
		System.out.println("\n======================== Tree #3 ========================");
		BinaryTree<String> treeW = new BinaryTree<>("W");
		System.out.println("---------------------");
		treeW.prettyPrint();
		System.out.println("---------------------");
		System.out.println("node count: " + treeW.nodeCount());
		System.out.println("---------------------");
		System.out.println("tree height: " + treeW.height());
		System.out.println("---------------------");
		System.out.println("tree is full?: " + treeW.isAFullTree());
		
		
		/**
		 * Given s tree such as
		 *          Z
		 *         /
		 *        Y
		 *       /
		 *      X 
		 */
		System.out.println("\n======================== Tree #4 ========================");
		BinaryTree<String> empty2 = new BinaryTree<>();
		BinaryTree<String> empty3 = new BinaryTree<>();
		BinaryTree<String> treeX = new BinaryTree<>("X");
		BinaryTree<String> treeY = new BinaryTree<>("Y", treeX, empty2);
		BinaryTree<String> treeZ = new BinaryTree<>("Z", treeY, empty3);
		System.out.println("---------------------");
		treeZ.prettyPrint();
		System.out.println("---------------------");
		System.out.println("node count: " + treeZ.nodeCount());
		System.out.println("---------------------");
		System.out.println("tree height: " + treeZ.height());
		System.out.println("---------------------");
		System.out.println("tree is full?: " + treeZ.isAFullTree());
		
		
		
		/**
		 * Given s tree such as
		 *          N
		 *           \
		 *        	  K
		 *             \
		 *              L
		 *               \
		 *                M
		 */
		System.out.println("\n======================== Tree #5 ========================");
		BinaryTree<String> empty4 = new BinaryTree<>();
		BinaryTree<String> empty5 = new BinaryTree<>();
		BinaryTree<String> empty6 = new BinaryTree<>();
		BinaryTree<String> empty7 = new BinaryTree<>();
		BinaryTree<String> empty8 = new BinaryTree<>();
		BinaryTree<String> treeM = new BinaryTree<>("M", empty7, empty8);
		BinaryTree<String> treeL = new BinaryTree<>("L", empty6, treeM);
		BinaryTree<String> treeK = new BinaryTree<>("K", empty5, treeL);
		BinaryTree<String> treeN = new BinaryTree<>("N", empty4, treeK);
		System.out.println("---------------------");
		treeN.prettyPrint();
		System.out.println("---------------------");
		System.out.println("node count: " + treeN.nodeCount());
		System.out.println("---------------------");
		System.out.println("tree height: " + treeN.height());
		System.out.println("---------------------");
		System.out.println("tree is full?: " + treeN.isAFullTree());
		
		
		/**
		 * Given s tree such as
		 *          root is null
		 */
		System.out.println("\n======================== Tree #6 ========================");
		BinaryTree<String> treeU = new BinaryTree<>();
		System.out.println("---------------------");
		treeU.prettyPrint();
		System.out.println("---------------------");
		System.out.println(treeU.nodeCount());
		System.out.println("---------------------");
		System.out.println("tree height: " + treeU.height());
		System.out.println("---------------------");
		System.out.println("tree is full?: " + treeU.isAFullTree());
	}
}
