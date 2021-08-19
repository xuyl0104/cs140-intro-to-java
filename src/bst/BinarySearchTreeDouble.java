package bst;
/**
 * A binary tree in which each node has two children.
 * The code for height is a minor modification of the textbook
 */
public class BinarySearchTreeDouble {
	class Node {
		public double data; // initially 0.0 by default
		public Node left; // initially null by default
		public Node right; // initially null by default

		/**
		 * Constructor that sets the data value
		 * @param element the value of data for the new Node
		 */
		public Node(double element) { 
			data = element;
		}

		public double getData() {
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

		public void prettyPrint(String indent) {
			// TODO modify the indent in the recursive calls
			// and use the indent to print root.data in the correct position
			// SEE the indent in the zyBook Section
			// "18.4 Adding output statements for debugging"

			// Copy from Lab 11
			if(right != null) right.prettyPrint("  " + indent);
			System.out.println(indent + data);
			if(left != null) left.prettyPrint("  " + indent);
		}

		/**
		 * Reports the Node that contains the search element as its data
		 * or null of the element is not present 
		 * @param element item to search for
		 * @return the Node containing element as its data or null if not
		 * found.
		 */
		public Node find(double element) {
			Node returnVal = null;
			if (element == data) {
				returnVal = this;
			}
			// if element < data check under left if it is not null
			// if element > data check under right if it is not null
			if (returnVal == null && left != null) {
				returnVal = left.find(element);
			}
			if (returnVal == null && right != null) {
				returnVal = right.find(element);
			}
			return returnVal;
		}

		/**
		 * Reports the count of search steps to locate element
		 * or -1 of the element is not present 
		 * @param element item to search for
		 * @return the count of search steps to locate element
		 * or -1 of the element is not present 
		 */
		public int findCount(double element) {
			if (element == data) {
				return 1;
			}
			// TODO
			// if element < data then if left is not null return 1 + the left findCount
			// else return -1
			// if element > data then if right is not null return 1 + the right findCount
			// else return -1
			if (element < data) {
				if (left != null) {
					return 1 + left.findCount(element);
				}
				else {
					return -1;
				}
			}
			if (element > data) {
				if (right != null) {
					return 1 + right.findCount(element);
				}
				else {
					return -1;
				}
			}
			else {
				return -1;
			}
		}

		/**
		 * Insertion of a new Node in the tree but it will not
		 * insert a the new Node if its data compares to 0
		 * with existing data in the tree. 
		 * We could consider putting an ArrayList at each node.
		 * @param newNode
		 */
		public void addNode(Node newNode) { // insertion  
			if (newNode.data < data) {  
				if (left == null) { left = newNode; }
				else { left.addNode(newNode); }
			} else if (newNode.data > data) {  
				if (right == null) { right = newNode; }
				else { right.addNode(newNode); }
			}
		}		
	}

	private Node root; // root is null by default

	/**
	 * Constructs an empty tree.
	 * @param cmp the Comparator for this search tree
	 */
	public BinarySearchTreeDouble() {
	} 

	public void prettyPrint() {
		if(root != null) root.prettyPrint("");
	}

	/**
	 * Constructs a tree with one node and no children.
	 * @param rootData the data for the root
	 * @param comp the Comparator for this search tree
	 */
	public BinarySearchTreeDouble(double rootData) {
		root = new Node(rootData);
	}

	/**
	 * Returns the height of this tree.
	 * @return the height
	 */
	public int height() {
		if(isEmpty()) return 0;
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
	 * @throw IllegalStateException if the tree is empty
	 */
	public double data() {
		if(root == null) throw new IllegalStateException("Tree is empty");
		return root.data; 
	}

	/**
	 * Finds the Node in the tree with data equal to element. Returns null
	 * if it is not found 
	 * @param element object to find in the tree
	 * @return the Node reference that contains element and null if element
	 * is not found
	 */
	public Node find(double element) {
		if(root == null) return null;
		return root.find(element);
	}

	/**
	 * Gets the left subtree of this tree.
	 * @return the left child of the root
	 */
	public BinarySearchTreeDouble left() { 
		BinarySearchTreeDouble result = new BinarySearchTreeDouble();
		result.root = root.left; 
		return result;
	}

	/**
	 * Gets the right subtree of this tree.
	 * @return the right child of the root
	 * @throw IllegalStateException if the tree is empty
	 */
	public BinarySearchTreeDouble right() { 
		BinarySearchTreeDouble result = new BinarySearchTreeDouble();
		result.root = root.right; 
		return result;
	}

	/**
	 * Get the maximum element in this binary search tree
	 * @return the largest element in the tree
	 * @throw IllegalStateException if the tree is empty
	 */
	public double maximum() {
		if(isEmpty()) throw new IllegalStateException("Tree is empty");
		if(right().isEmpty()) return data();
		return right().maximum();
	}

	/**
	 * Get the maximum element in this binary search tree
	 * @return the largest element in the tree
	 * @throw IllegalStateException if the tree is empty
	 */
	public double minimum() {
		if(isEmpty()) throw new IllegalStateException("Tree is empty");
		if(left().isEmpty()) return data();
		return left().maximum();
	}

	public boolean isSearchTree() {
		if(isEmpty()) return true;
		if(!left().isSearchTree()) return false;
		if(!right().isSearchTree()) return false;
		double lMax = left().maximum();
		if(lMax >= data()) return false;
		double rMin = right().minimum();
		if(data() >= rMin) return false;
		return true;
	}

	public void add(double element) { // insertion
		Node newNode = new Node(element);
		if (root == null) root = newNode;
		else root.addNode(newNode);
	}

	/**
	 * Finds the Node in the tree with data equal to element. Returns null
	 * if it is not found 
	 * @param element object to find in the tree
	 * @return the Node reference that contains element and null if element
	 * is not found
	 */
	public int findCount(double element) {
		if(root == null) return -1;
		return root.findCount(element);
	}

	public boolean remove(double element) {
		// Find node to be removed
		// Note this is a version of find using a loop because
		// it needs to track "parent". It is more complex than the recursion above.
		Node toBeRemoved = root;
		Node parent = null;
		boolean found = false;
		while (!found && toBeRemoved != null) {
			if(toBeRemoved.data == element) found = true;
			else {
				parent = toBeRemoved;
				if (toBeRemoved.data > element) { toBeRemoved = parent.left; }
				else { toBeRemoved = parent.right; }
			}
		}

		if (!found) return false; // element was not present in the tree so give up

		// from now on toBeRemoved is the Node that contains element
		// If one of the children is empty, use the other
		if (toBeRemoved.left == null || toBeRemoved.right == null) {
			Node newChild;
			if (toBeRemoved.left == null) {
				newChild = toBeRemoved.right;
			} else {
				newChild = toBeRemoved.left;
			}

			if (parent == null) { // Found in root
				root = newChild;
			} else if (parent.left == toBeRemoved) {
				parent.left = newChild;
			} else {
				parent.right = newChild;
			}
			return true;
		}

		// Neither subtree is empty
		// Find smallest element of the right subtree
		Node smallestParent = toBeRemoved;
		Node smallest = toBeRemoved.right;
		while (smallest.left != null) {
			smallestParent = smallest;
			smallest = smallest.left;
		}

		// smallest contains smallest child in right subtree
		// Move contents, unlink child
		toBeRemoved.data = smallest.data;
		if (smallestParent == toBeRemoved) {
			smallestParent.right = smallest.right; 
		} else {
			smallestParent.left = smallest.right; 
		}
		return true;
	}
}