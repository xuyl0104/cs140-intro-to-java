package bst;

public class BST {
	public class Node {
		public int data;
		public Node left;
		public Node right;
		
		public void insert(int node) {
			if (node == data) {
				System.out.println("Node already exists. No need to insert.");
				return;
			}
			else {
				if (node < data) {
					if (left == null) {
						left = new Node();
						left.data = node;
					}
					else {
						left.insert(node);
					}
				}
				else {
					if (right == null) {
						right = new Node();
						right.data = node;
					}
					else {
						right.insert(node);
					}
				}
			}
		}

		public void preOrderPrint() {	
			System.out.print(data + " ");
			if (left != null) {
				left.preOrderPrint();
			}
			if (right != null) {
				right.preOrderPrint();
			}
		}

		public void prettyPrint(String indent) {
			if (right != null) {
				right.prettyPrint(indent + "  ");
			}
			System.out.println(indent + data);
			if (left != null) {
				left.prettyPrint(indent + "  ");
			}
		}

		public void inOrderPrint() {
			if (left != null) {
				left.inOrderPrint();
			}
			System.out.print(data + " ");
			if (right != null) {
				right.inOrderPrint();
			}
		}

		public void postOrderPrint() {
			if (left != null) {
				left.postOrderPrint();
			}
			if (right != null) {
				right.postOrderPrint();
			}
			System.out.print(data + " ");
			
		}

		public int height() {
			if (left == null && right == null) {
				return 0;
			}
			if (left == null) {
				return 1 + right.height();
			}
			if (right == null) {
				return 1 + left.height();
			}
			return 1 + Math.max(left.height(), right.height());
		}
		
	} // end of class Node
	
	
	// private field: the root of the BST
	private Node root;
	
	// constructor with no arguments
	public BST() {
		root = null;
	}
	
	// constructor with 1 argument
	public BST(int data) {
		root = new Node();
		root.data = data;
		root.left = null;
		root.right = null;
	}
	
	// constructor with 3 arguments
	public BST(int data, Node leftNode, Node rightNode) {
		root = new Node();
		root.data = data;
		root.left = leftNode;
		root.right = rightNode;
	}
	
	// not used
	public int nodeCount() {
		return 0;
	}
	
	/**
	 * return the left subtree of the root
	 * */
	public BST leftTree() {
		if (root == null) return null;
		else {
			BST leftBST = new BST();
			leftBST.root = root.left;
			return leftBST;
		}
	}
	
	/**
	 * return the right subtree of the root
	 * */
	public BST rightTree() {
		if (root == null) return null;
		else {
			BST rightBST = new BST();
			rightBST.root = root.right;
			return rightBST;
		}
	}
	
	/**
	 * insert a node to the current BST
	 * */
	public void insert(int node) {
		if (root == null) {
			root = new Node();
			root.data = node;
//			System.out.println("Tree is empty. Root node is created. Root is " + root.data + ".");
		}
		else {
			root.insert(node);
		}
	}
	
	
	/**
	 * delete a node from the BST
	 * 
	 * (a) delete leaf
	         50                             50
           /     \         delete(20)      /   \
          30      70       --------->    30     70 
         /  \    /  \                     \    /  \ 
       20   40  60   80                   40  60   80
       --
       
       (b) has one child
             50                             50
           /     \         delete(30)      /   \
          30      70       --------->    40     70 
            \    /  \                          /  \ 
            40  60   80                       60   80
            
       
       (c) has two children
             50                              50
           /     \         delete(30)      /    \
          30      70       --------->    39      70 
         /  \    /  \                    / \     /  \ 
        20  40  60   80                 20  40  60   80
            / \                              \
          39   45                            45
            
       
       (d)
             50                             60
           /     \         delete(50)      /   \
          40      70       --------->    40    70 
                 /  \                         /  \ 
                60   80                      65   80
                 \
                  65
	* 
	*/
	public void delete(int node) {
		if (root == null) {
			
		}
		else {
			if (!isInTheTree(node)) {
				System.out.println("Node is not in the tree. Cannot remove from the tree.");
			}
			else {
				// root is the node to be deleted -- see case (d)
				if (root.data == node && height() > 1) {
					if (root.right != null) {
						Node toBeDeletedNode = rightTree().minimumNode();
						Node parentOfToBeDeletedNode = findParent(toBeDeletedNode.data);
						int tobeDeletedData = rightTree().minimumNode().data;
						int parentOfToBeDeletedData = findParent(toBeDeletedNode.data).data;
						root.data = rightTree().minimumNode().data;

						// delete the connection
						if (tobeDeletedData > parentOfToBeDeletedData) {
							parentOfToBeDeletedNode.right = toBeDeletedNode.right;
						}
						else {
							parentOfToBeDeletedNode.left = toBeDeletedNode.right;
						}
					}
					else {
						/**
						       15                        8
						       /       delete(15)       / \ 
  					          8      --------->        6   10
  							 / \
    						6   10
    						
						 **/
						root.data = root.left.data;
						root.left = root.left.left;
						root.right = root.left.right;
					}
				}
				else if (root.data == node && height() == 1) {
					System.out.println("Deleting the last node in the tree...");
					root = null;
				}
				else {
					Node parentOfToBeDeletedNode = findParent(node);
					Node toBeDeletedNode = node < parentOfToBeDeletedNode.data ? parentOfToBeDeletedNode.left : parentOfToBeDeletedNode.right;
					
					// see case (a)
					if (toBeDeletedNode.left == null && toBeDeletedNode.right == null) {
						if (toBeDeletedNode.data > parentOfToBeDeletedNode.data) {
							parentOfToBeDeletedNode.right = null;
						}
						else {
							parentOfToBeDeletedNode.left = null;
						}
					}
					// see case (c) - has two children
					else if (toBeDeletedNode.left != null && toBeDeletedNode.right != null) {
						BST tempBST = new BST();
						tempBST.root = toBeDeletedNode;
						tempBST.delete(node);
						if (toBeDeletedNode.data > parentOfToBeDeletedNode.data) {
							parentOfToBeDeletedNode.right = tempBST.root;
						}
						else {
							parentOfToBeDeletedNode.left = tempBST.root;
						}
						
					}
					// see case (b)
					else if ((toBeDeletedNode.left == null && toBeDeletedNode.right != null) || (toBeDeletedNode.left != null && toBeDeletedNode.right == null)) {
						if (toBeDeletedNode.left == null && toBeDeletedNode.right != null) {
							if (toBeDeletedNode.data > parentOfToBeDeletedNode.data) {
								parentOfToBeDeletedNode.right = toBeDeletedNode.right;
							}
							else {
								parentOfToBeDeletedNode.left = toBeDeletedNode.right;
							}
						}
						else {
							if (toBeDeletedNode.data > parentOfToBeDeletedNode.data) {
								parentOfToBeDeletedNode.right = toBeDeletedNode.left;
							}
							else {
								parentOfToBeDeletedNode.left = toBeDeletedNode.left;
							}
						}
						
					} // end of case (b)
				}
			}
		}
	}
	
	/**
	 * find the parent node of a node
	 * */
	public Node findParent(int node) {
		Node parentNode = root;
		Node resNode = root;
		while (node != parentNode.data) {
			resNode = parentNode;
			if (node > parentNode.data) {				
				parentNode = parentNode.right;
			}
			else {
				parentNode = parentNode.left;
			}
		}
		return resNode;
	}
	
	
	/**
	 * get the node with maximum value 
	 * */
	public Node maximumNode() {
		if (root == null) {
			System.out.println("Tree is empty. No maximum data.");
			return null;
		}
		else {
			if (root.right == null) {
				return root;
			}
			else {
				return rightTree().maximumNode();
			}
		}
	}
	
	/**
	 * get the node with minimum value
	 * */
	public Node minimumNode() {
		if (root == null) {
			System.out.println("Tree is empty. No minimum data.");
			return null;
		}
		else {
			if (root.left == null) {
				return root;
			}
			else {
				return leftTree().minimumNode();
			}
		}
	}
	
	/**
	 * print the tree in preOrder
	 * root first, left subtree second, right subtree last
	 * */
	public void preOrderPrint() {
		if (root == null) {
			System.out.println("Tree is empty. Nothing to print.");
		}
		else {
			root.preOrderPrint();
			System.out.println("");
		}
	}
	
	/**
	 * print the tree in inOrder
	 * left subtree first, root second, right subtree last
	 * */
	public void inOrderPrint() {
		if (root == null) {
			System.out.println("Tree is empty. Nothing to print.");
		}
		else {
			root.inOrderPrint();
			System.out.println("");
		}
	}
	
	/**
	 * print the tree in postOrder
	 * left subtree first, right subtree second, root last
	 * */
	public void postOrderPrint() {
		if (root == null) {
			System.out.println("Tree is empty. Nothing to print.");
		}
		else {
			root.postOrderPrint();
			System.out.println("");
		}
	}
	
	/**
	 * print the tree 
	 * */
	public void prettyPrint() {
		if (root == null) {
			System.out.println("Tree is empty. Nothing to print.");
		}
		else {
			root.prettyPrint("");
		}
	}
	
	/**
	 * height of the BST
	 * */
	public int height() {
		if (root == null) {
			return 0;
		}
		else {
			return 1 + root.height();
		}
	}
	
	/**
	 * check if a node is in the BST
	 * */
	public boolean isInTheTree(int node) {
		if (root == null) {
			return false;
		}
		else {
			if (root.data == node) {
				return true;
			}
			if (node < root.data) {
				return leftTree().isInTheTree(node);
			}
			if (node > root.data) {
				return rightTree().isInTheTree(node);
			}
			return false;
		}
	}
}
