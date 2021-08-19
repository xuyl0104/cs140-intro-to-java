package exam02;

/**
 * A binary tree in which each node has two children.
 * The code for height is a minor modification of the textbook
 */
public class BinaryTree {
	class Node {
		public Integer data; // initially null by default
		public Node left; // initially null by default
		public Node right; // initially null by default

		/**
		 * Constructor that sets the data value
		 * @param element the value of data for the new Node
		 */
		public Node(Integer element) { 
			data = element;
		}

		public Integer getData() {
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
			// not needed but provided for debugging if needed
			if(right != null) right.prettyPrint(indent + "  ");
			System.out.println(indent + data);
			if(left != null) left.prettyPrint(indent + "  ");
		}

		public int sumData() {
			// TODO compute the sum of all the data at each Node in the tree 
			// that DO NOT CONTAIN data == null (there could be at most one)
			// Remember data can be assigned and added like an int even though
			// is an Integer because Java provided automatic conversion -- called "unboxing"
			int sum = 0;
			if (data != null) sum += data;
			// code needed here
			if (left == null && right == null) return sum;
			if (left == null) {
				return sum + right.sumData();
			}
			if (right == null) {
				return sum + left.sumData();
			}
			sum += left.sumData() + right.sumData();
			return sum;
		}

		public double averageData() {
			// TODO
			// if nodeCountForAverage() is 0 then return 0
			// Calculate the average sumData()/nodeCountForAverage() BUT
			// you MUST calculate the average using doubles
			if (nodeCountForAverage() == 0) {
				return 0.0;
			}
			else {
				return 1.0 * sumData() / nodeCountForAverage();
			}			
		}

		public int nodeCountForAverage() {
			// TODO count all the Nodes in the tree that
			// DO NOT CONTAIN data == null (there could be at most one)
			int count = 0;
			// code needed here
			if (data != null) {
				count++;
			}
			if (left == null && right == null) return count;
			if (left == null) {
				return count + right.nodeCountForAverage();
			}
			if (right == null) {
				return count + left.nodeCountForAverage();
			}
			count += left.nodeCountForAverage() + right.nodeCountForAverage();
			return count;
		}

		public void addNode(Integer element) {
			if(left == null) left = new Node(element);
			else if(right == null) right = new Node(element);
			else if(left.height() > right.height()) right.addNode(element);
			else left.addNode(element);
		}
	}

	private Node root; // root is null by default

	/**
	 * Constructs an empty tree.
	 */
	public BinaryTree() {
	} 

	public void prettyPrint() {
		if(root != null) root.prettyPrint("");
	}

	/**
	 * Constructs a tree with one node and no children.
	 * @param rootData the data for the root
	 * @param comp the Comparator for this search tree
	 */
	public BinaryTree(Integer rootData) {
		root = new Node(rootData);
	}

	/**
	 * Checks whether this tree is empty.
	 * @return true if this tree is empty
	 */
	public boolean isEmpty() { return root == null; }

	/**
	 * Gets the sum of all the values of all the Integers stored in the
	 * tree. If any data is null, it is ignored.  
	 * @return the sum of all the data in the tree or 0 if the tree is empty
	 */
	public int sumData() {
		if(root == null) return 0;
		return root.sumData(); 
	}

	/**
	 * Gets the average of all the values of all the Integers stored in the
	 * tree
	 * @return the average of all the data in the tree or 0 if the tree is empty
	 * and 0 if the only data value in the whole tree is null
	 */
	public double averageData() {
		if(root == null) return 0.0;
		return root.averageData(); 
	}

	boolean found(Integer element) {
		// We skip this method for the exam
		// In the test cases we only add distinct values
		return false;
	}

	public void add(Integer element) { // insertion
		if (root == null) root = new Node(element);
		else if(!found(element)) root.addNode(element);
	}
}