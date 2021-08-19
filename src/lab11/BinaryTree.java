package lab11;

/**
 * A binary tree in which each node has two children.
 * The code for height is a minor modification of the textbook
 */
public class BinaryTree<T> {
	/*******************************************************************************/
	class Node {
		public T data;
		public Node left;
		public Node right;
		/**
		 * Returns the height of the subtree whose root is this node.
		 * @return the height of this subtree
		 */
		private int height() {
			if (left == null && right == null) return 1;
			if (left == null) return 1 + right.height();
			if (right == null) return 1 + left.height();
			return 1 + Math.max(left.height(), right.height());
		}

		/**
		 * Counts the number of Nodes in the tree 
		 * @return the number of Nodes in the tree
		 */
		public int nodeCount() {
			if (left == null && right == null) return 1;
			if (left == null) return 1 + right.nodeCount();
			if (right == null) return 1 + left.nodeCount();
			return 1 + left.nodeCount() + right.nodeCount();
		}

		/**
		 * Given s tree such as
		 *          A
		 *        /   \
		 *      B       C
		 *     / \     / 
		 *    D   E   F 
		 *    
		 * use the indent parameter so the print out has the form
		 * 
		 *   C
		 *     F
		 * A
		 *     E
		 *   B 
		 *     D
		 * 
		 */
		public void prettyPrint(String indent) {
			// modify the indent in the recursive calls
			// and use the indent to print root.data in the correct position
			// SEE the indent in the zyBook Section
			// "18.4 Adding output statements for debugging"

			if(right != null) right.prettyPrint("  " + indent);
			System.out.println(indent + root.data);
			if(left != null) left.prettyPrint("  " + indent);
		}

		/**
		 * Test if this is the root of a full tree. That every Node has either 0
		 * children or 2 children (i.e. no Node has only one child)
		 * @return true if this tree is a full tree, otherwise 
		 * return false
		 */
		public boolean isAFullTree () {
			if ((right != null && left != null)) {
				System.out.println(data + " is full");
				return left.isAFullTree() && right.isAFullTree();
			}
			if (right == null && left == null) {
				System.out.println(data + " is full");
				return true;
			}
			else {
				System.out.println(data + " is not full");
				return false;
			}
		}	
	} // end of class Node
	/*******************************************************************************/
	

	private Node root;

	/**
	 * Constructs an empty tree.
	 */
	public BinaryTree() { root = null; } 

	/**
	 * Constructs a tree with one node and no children.
	 * @param rootData the data for the root
	 */
	public BinaryTree(T rootData) {
		root = new Node();
		root.data = rootData;
		root.left = null;
		root.right = null;
	}

	/**
	 * Constructs a binary tree.
	 * @param rootData the data for the root
	 * @param left the left subtree
	 * @param right the right subtree
	 */
	public BinaryTree(T rootData, BinaryTree<T> left, BinaryTree<T> right) {
		root = new Node();
		root.data = rootData;
		root.left = left.root;
		root.right = right.root;
	}

	/**
	 * Returns the height of this tree.
	 * @return the height
	 */
	public int height() {
		if(root == null) return 0;
		return root.height(); 
	}

	/**
	 * Checks whether this tree is empty.
	 * @return true if this tree is empty
	 */
	public boolean isEmpty() { return root == null; }

	/**
	 * Gets the data at the root of this tree.
	 * @return the root data
	 */
	public T data() { return root.data; }

	/**
	 * Gets the left subtree of this tree.
	 * @return the left child of the root
	 */
	public BinaryTree<T> left() { 
		BinaryTree<T> result = new BinaryTree<>();
		result.root = root.left; 
		return result;
	}

	/**
	 * Gets the right subtree of this tree.
	 * @return the right child of the root
	 */
	public BinaryTree<T> right() { 
		BinaryTree<T> result = new BinaryTree<>();
		result.root = root.right; 
		return result;
	}

	/**
	 * Count the Nodes in the tree
	 * @return the number of Nodes in the tree
	 */
	public int nodeCount() {
		if (root == null) {
			return 0;
		}
		else {
			return root.nodeCount();
		}
	}
	
	/**
	 * Pretty prints the contents of this tree in a horizontal tree-like fashion
	 * Think of tree rotated 90 degrees counterclockwise
	 *          A
	 *        /   \
	 *      B       C
	 *     / \     / 
	 *    D   E   F 
	 * prints as
	 *   C
	 *     F
	 * A
	 *     E
	 *   B 
	 *     D
	 * 
	 */
	public void prettyPrint() {
		if (root == null) {
			System.out.println("Tree is null, nothing to print.");
		}
		else {			
			root.prettyPrint("");
		}
	}

	/**
	 * Test if this tree is a full tree.
	 * @return true if this tree is a full tree, otherwise 
	 * return false
	 */
	public boolean isAFullTree () {
		if (root == null) {
			System.out.println("Tree is null, not full.");
			return false;
		}
		else {			
			return root.isAFullTree();
		} 
	}
}
