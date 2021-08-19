package cbt;
/**
 * A binary tree in which each node has two children.
 * The code for height is a minor modification of the textbook
 */
public class MyCompleteBinaryTree<T> {
	/*******************************************************************************/
	class Node {
		private T data;
		private Node left;
		private Node right;
		private Node parent;

		/**
		 * Constructor that sets the data value
		 * @param element the value of data for the new Node
		 */
		public Node(T element) { 
			data = element;
		}

		public T getData() {
			return data;
		}

		/**
		 * Returns the height of the subtree whose root is this node.
		 * @return the height of this subtree
		 */
		private int height() {
			if (left == null && right == null) return 0;
			if (left == null) return 1 + right.height();
			if (right == null) return 1 + left.height();
			return 1 + Math.max(left.height(), right.height());
		}

		/**
		 * Given a tree such as
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
			// TODO
			if(right != null) right.prettyPrint("  " + indent);
			System.out.println(indent + data);
			if(left != null) left.prettyPrint("  " + indent);
		}

		/**
		 * Counts the number of Nodes in the tree 
		 * @return the number of Nodes in the tree
		 */
		public int nodeCount() {
			// TODO 
			if (left == null && right == null) return 1;
			if (left == null) return 1 + right.nodeCount();
			if (right == null) return 1 + left.nodeCount();
			return 1 + left.nodeCount() + right.nodeCount();
		}

		/**
		 * Test if this is the root of a full tree. That every Node has either 0
		 * children or 2 children (i.e. no Node has only one child)
		 * @return true if this tree is a full tree, otherwise 
		 * return false
		 */
		public boolean isAFullTree () {
			if ((right != null && left != null)) {
//				System.out.println(data + " is full");
				return left.isAFullTree() && right.isAFullTree();
			}
			if (right == null && left == null) {
//				System.out.println(data + " is full");
				return true;
			}
			else {
//				System.out.println(data + " is not full");
				return false;
			}
		}

		/**
		 * Reports the Node that contains the search element as its data
		 * or null of the element is not present 
		 * @param element item to search for
		 * @return the Node containing element as its data or null if not
		 * found.
		 * 
		 * 
		 * Given a tree such as
		 *          A
		 *        /   \
		 *      B       C
		 *     / \     / 
		 *    D   E   F 
		 *    
		 * 
		 */
		public Node find(T element) {
			Node returnVal = null;
			// check if the root.data matches element
			if((element == null && data == null) || 
					(element != null && element.equals(data))) {
				returnVal = this;
			}
			// TODO
			// if returnVal is null and left is not null apply find on left
			// if returnVal is null and right is not null apply find on right
			if (returnVal == null && left != null) {
				returnVal = left.find(element);
			}
			if (returnVal == null && right != null) {
				returnVal = right.find(element);
			}
			return returnVal;
		}

		/**
		 * Checks if the tree has every level filled.
		 * In a binary tree the number of nodes at each level is 
		 * 1 (height 0), 2 (height 1), 4 (height 2), 8 (height 3), 16 (height 4), 
		 * .... twoPower(h) (height h) -- see the twoPower method below that
		 * computers 2-to-the-nth-power or 2^n. The sum of 1+2+4+8+16+...+2^h is
		 * 2^(h+1) - 1. So a perfect tree just needs to have node count equal to 
		 * that number
		 * @return true if every level in the tree is filled.
		 */
		public boolean isPerfect() {
			return nodeCount() == twoPower(height()+1) - 1;
		}

		/**
		 * Add the element to the complete tree. If the element is already
		 * in the tree, nothing is done to the tree and the return value
		 * is false. If this is a new element and the bottom level is not filled, 
		 * then element is added as the next element from the left. If the bottom 
		 * level is filled, then element is put at the start of a new level.  
		 * @param element object to add to the tree
		 * @return true if a new element is added, fall if the element was already
		 * in the tree
		 * 
		 * * Given a tree such as
		 *          A
		 *        /   \
		 *      B       C
		 *     / \     / 
		 *    D   E   F 
		 */      
		public boolean addBalanced(T element) {
			// we should come in knowing element is not found
			// but the method is public so someone else may call it
			if(find(element) != null) return false;
			if(left == null) { //MUST give preference to left side
				left = new Node(element);
				left.parent = this;
				return true;
			}
			if(right == null) {
				right = new Node(element);
				right.parent = this;
				return true;
			}
			// TODO
			// note you DO NOT need "else" after "return"
			// if the whole tree is perfect (use this.isPerfect()) then return
			// the recursive call on left -- this option start a new bottom level

			// if only left is perfect, then return the recursive call on right -- this
			// option occurs when the bottom level of the tree is at least half filled

			// finally the remaining case is to return the recursive call on left -- this
			// option occurs when the bottom level is less than half filled
			if (this.isPerfect()) {
				return left.addBalanced(element);
			}
			
			// NOTE: add this case besides the cases mentioned on zyBooks
//			if (left.isPerfect() && !right.isPerfect()) {
//				return right.addBalanced(element);
//			}
//			if (left.isPerfect() && right.isPerfect() && (left.height() != right.height())) {
//				return right.addBalanced(element);
//			}
			if(left.isPerfect()) {				
				return right.addBalanced(element);
			}
			
			return left.addBalanced(element);
		}

		/**
		 * Removes element from the tree. To maintain the complete structure, the
		 * only Node that can be removed is the last one added, so element must
		 * be swapped from its current position to the data at the last Node.
		 * If the element is not in the tree, returns false.
		 * @param element object to be removed from the tree
		 * @return true is the element is removed, false if the element is not present
		 * @throws IllegalStateException if an attempt to remove the last Node remaining 
		 * in the tree. 
		 * 
		 * Given a tree such as
		 *          A
		 *        /   \
		 *      B       C
		 *     / \     / 
		 *    D   E   F 
		 */
		public boolean remove(T element) {
			// locate the Node containing element
			Node found = find(element);
			// check if it was found
			if(found == null) return false;
			// throw an exception if the method was called in error--it cannot remove
			// the last Node in the tree (see the remove method below)
			if(nodeCount() == 1) throw new IllegalStateException("Cannot remove the root");
			// TODO
			// Let temp be the last-entered Node by calling the method below.
			// Assign found.data as temp.data and assign temp.data as element
			// Create a variable set equal to the parent of temp (note that Node has a 
			// parent field that you have to use)
			// if temp equals that parent's left field, change the parent's left to null
			// else change the parent's right to null. 
			Node temp = findLastEntered();
			found.data = temp.data;
			
			Node parentOfTemp = temp.parent;
			if (temp.equals(parentOfTemp.left)) {
				parentOfTemp.left = null;
			}
			else {
				parentOfTemp.right = null;
			}
			
			return true;
		}

		/**
		 * Finds the reference to the Node that was last entered into the tree. Because 
		 * a complete tree is a perfect tree with one extra partly-filled level at the bottom,
		 * whether the position of the last element is in the left subtree or right subtree 
		 * depends on the number of Nodes in the tree. 
		 * @return a reference to the last Node that was entered into the tree
		 */
		public Node findLastEntered() {
			int num = nodeCount(); // you cannot use size because that is the numCount of the
			// whole tree and this method is recursing down into smaller and smaller subtrees of
			// the whole tree
			int h = height();
			// TODO
			// if num is 1 return this (meaning the root of the tree was the last and
			// only Node created.
			// if the number of Nodes in the bottom row (that value is num - twoPower(h) + 1)
			// is less than or equal to half the maximum number of Nodes in the bottom row
			// (twoPower(h) is the maximum number of Nodes, so twoPower(h - 1) is one half)
			// then return the recursive call on left
			// Finally return the recursive call on right (no need to use else after return)
			if (num == 1) {
				return this;
			}
			/**
			 * 
			 * * Given a tree such as
			 *          A
			 *        /   \
			 *      B       C
			 *     / \     / 
			 *    D   E   F 
			 *    
			 *    h = 3
			 *    total num of nodes: nodeCount() or num
			 *    numb of nodes in the last level: nodeCount - (2^(h-1) - 1) 
			 *    num of nodes in the last level if complete: 2^(h-1)
			 * */
			
			if ((num - twoPower(h) + 1) <= twoPower(h - 1)) {
				return left.findLastEntered();
			}
			return right.findLastEntered();
			
		}
	} // end of class Node
	
	/*******************************************************************************/

	private Node root; // default value is null
	private int size;  // default value is 0

	/**
	 * Constructs an empty tree.
	 */
	public MyCompleteBinaryTree() { root = null; } 

	/**
	 * Constructs a tree with one node and no children.
	 * @param rootData the data for the root
	 */
	public MyCompleteBinaryTree(T rootData) {
		root = new Node(rootData);
		size = 1;
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
	public T data() {
		if(root == null) return null;
		return root.data; 
	}

	/**
	 * Gets the left subtree of this tree.
	 * @return the left child of the root
	 */
	public MyCompleteBinaryTree<T> left() { 
		MyCompleteBinaryTree<T> result = new MyCompleteBinaryTree<>();
		result.root = root.left; 
		return result;
	}

	/**
	 * Gets the right subtree of this tree.
	 * @return the right child of the root
	 */
	public MyCompleteBinaryTree<T> right() { 
		MyCompleteBinaryTree<T> result = new MyCompleteBinaryTree<>();
		result.root = root.right; 
		return result;
	}

	/**
	 * Returns size, which is the number of Nodes in the tree.
	 * @return size
	 */
	public int size() {
		return size;
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
		if(root != null) root.prettyPrint("");
	}

	/**
	 * Test if this tree is a full tree.
	 * @return true if this tree is a full tree, otherwise 
	 * return false
	 */
	public boolean isAFullTree () {
		if(root == null) return true;
		return root.isAFullTree();
	}

	/**
	 * Finds the Node in the tree with data equal to element. Returns null
	 * if it is not found 
	 * @param element object to find in the tree
	 * @return the Node reference that contains element and null if element
	 * is not found
	 */
	public Node find(T element) {
		if(root == null) return null;
		return root.find(element);
	}

	/**
	 * Adds a new element to the tree. Nothing is added if the element is in 
	 * the tree already
	 * @param element the object to add to the tree
	 * @return true if the element is added and false if the element is
	 * already in the tree
	 */
	public boolean addBalanced(T element) {
		// element already in the tree so not added again
		if(find(element) != null) return false;
		size++;
		if(root == null) {
			root = new Node(element);
			return true;
		}
		return root.addBalanced(element);
	}

	/**
	 * Remove the element from tree if it is present
	 * @param element the object to be removed
	 * @return true if the element is removed and false if the
	 * element was not in the tree
	 */
	public boolean remove(T element) {
		if(size == 0) return false; // there are no Nodes in the tree
		if(find(element) == null) return false;
		// If the element is root.data and there is only a single Node, then this 
		// tree must do the remove because root cannot remove itself. 
		// Note element may be null, i.e., we may have stored null in the tree.
		if((element == null && root.data == null) || 
				(element != null && element.equals(root.data))) {
			if(size == 1) {
				root = null;
				size = 0;
				return true;
			}
		}
		size--; // we will certainly remove an element.
		return root.remove(element);
	}

	/**
	 * Tests whether a tree is perfect. A null tree is perfect 
	 * @return true if the tree is perfect, otherwise false
	 */
	public boolean isPerfect() {
		if(root == null) return true;
		return root.isPerfect();
	}

	/**
	 * Finds the reference to the Node that was last entered into the tree. Because 
	 * a complete tree is a perfect tree with one extra partly-filled level at the bottom,
	 * whether the position of the last element is in the left subtree or right subtree 
	 * depends on the number of Nodes in the tree. 
	 * @return a reference to the last Node that was entered into the tree
	 */
	public Node findLastEntered() {
		if(root == null) return null;
		return root.findLastEntered();
	}

	/**
	 * Return 0 if n < 0 otherwise 2^n (2 to the power n)
	 * @param n power of 2 desired
	 * @return 2^n, which is 0 if n < 0 because of integer division
	 */
	public static int twoPower(int n) {
		//if(n < 0) return 0;
		//if(n == 0) return 1;
		//return 2*twoPower(n-1);
		int power = 0;
		if(n >= 0) power = 1;
		while(n > 0) {
			power *= 2;
			n--;
		}
		return power;
	}
}
