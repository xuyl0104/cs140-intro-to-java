package avl;

/****
 * https://www.geeksforgeeks.org/avl-tree-set-1-insertion/
 * @author xuyunlong
 */
public class AVL {
	public class Node {
		public int data;
		public Node left;
		public Node right;

		/**
		 * insert node into the tree
		 * @param node
		 */
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

		/**
		 * find the first node that is not balanced
		 * @return
		 */
		public Node firstUnbalancedNode() {
			Node returnNode = null;
			int returnLevel = Integer.MAX_VALUE;
			if (!isBalanced()) {
				returnNode = this;
				returnLevel = depth();
				if (left != null && !left.isBalanced()) {
					Node tempNode = left.firstUnbalancedNode();
					if (tempNode.depth() < returnLevel) {
						returnNode = tempNode;
						returnLevel = tempNode.depth();
					}
				}
				if (right != null && !right.isBalanced()) {
					Node tempNode = right.firstUnbalancedNode();
					if (tempNode.depth() < returnLevel) {
						returnNode = tempNode;
						returnLevel = tempNode.depth();
					}
				}
			}
			return returnNode;
		}

		public void traverseNodeIsBalanced() {
			System.out.println(data + "; balanced: " + isBalanced());
			if (left != null) {
				left.traverseNodeIsBalanced();
			}
			if (right != null) {
				right.traverseNodeIsBalanced();
			}
		}

		/**
		 * get the type of imbalance
		 * @return RR or LL or RL or LR
		 */
		public String getTypeOfRotation() {
			String resString = "";
			Node childNode = null;
			Node grandChildNode = null;
			if (left != null && right != null) {
				if (left.depth() >= right.depth()) {
					resString += "L";
					childNode = left;
				}
				else {
					resString += "R";
					childNode = right;
				}
			}
			if (right == null) {
				resString += "L";
				childNode = left;
			}
			if (left == null) {
				resString += "R";
				childNode = right;
			}

			// grandchild x
			if (childNode.left != null && childNode.right != null) {
				if (childNode.left.depth() >= childNode.right.depth()) {
					resString += "L";
					grandChildNode = childNode.left;
				}
				else {
					resString += "R";
					grandChildNode = childNode.right;
				}
			}
			if (childNode.right == null) {
				resString += "L";
				grandChildNode = childNode.left;
			}
			if (childNode.left == null) {
				resString += "R";
				grandChildNode = childNode.right;
			}

			return resString;
		}

		/**
		 * 
              z                                y
			 /  \                            /   \ 
			T1   y     Left Rotate(z)       z      x
			    /  \   - - - - - - - ->    / \    / \
			   T2   x                     T1  T2 T3  T4
			       / \
			     T3  T4

		 */
		public void L() {
			Node parentNode = findParent(this.data);
			Node childNode = right;
			int flag = 0; // 0-left, 1-right
			if (parentNode.data >= this.data) {
				flag = 0;
			}
			else {
				flag = 1;
			}

			Node tempNode = childNode.left;
			childNode.left = this;
			this.right = tempNode;

			if (this.equals(root)) {
				root = childNode;
			} 
			else {
				if (flag == 0) {
					parentNode.left = childNode;
				}
				if (flag == 1) {
					parentNode.right = childNode;
				}
			}
		}

		/**
		 * 
		 * T1, T2, T3 and T4 are subtrees.
			         z                                      y 
			        / \                                   /   \
			       y   T4      Right Rotate (z)          x      z
			      / \          - - - - - - - - ->      /  \    /  \ 
			     x   T3                               T1  T2  T3  T4
			    / \
			  T1   T2

		 * */
		public void R() {
			Node parentNode = findParent(this.data);
			int flag = 0; // 0-left, 1-right
			if (parentNode.data >= this.data) {
				flag = 0;
			}
			else {
				flag = 1;
			}
			Node childNode = this.left;

			Node tempNode = childNode.right;
			childNode.right = this;
			this.left = tempNode;
			
			if (this.equals(root)) {
				root = childNode;
			} 
			else {
				if (flag == 0) {
					parentNode.left = childNode;
				}
				if (flag == 1) {
					parentNode.right = childNode;
				}
			}
		}

		/**
		 * 
		 * 
		 *       z                               z                           x
			    / \                            /   \                        /  \ 
			   y   T4  Left Rotate (y)        x    T4  Right Rotate(z)    y      z
			  / \      - - - - - - - - ->    /  \      - - - - - - - ->  / \    / \
			T1   x                          y    T3                    T1  T2 T3  T4
			    / \                        / \
			  T2   T3                    T1   T2
		 * 
		 * 
		 * */
		public void LR() {
			Node parentNode = findParent(this.data);
			Node childNode = left;
			Node grandChildNode = childNode.right;
			
			int flag = 0; // 0-left, 1-right
			if (parentNode.data >= this.data) {
				flag = 0;
			}
			else {
				flag = 1;
			}

			// L()
			Node tempNode1 = grandChildNode.left;
			childNode.right = tempNode1;
			grandChildNode.left = childNode;
			this.left = grandChildNode;
			
			// R()
			Node tempNode = grandChildNode.right;
			grandChildNode.right = this;
			this.left = tempNode;
			if (this.equals(root)) {
				root = grandChildNode;
			} 
			else {				
				if (flag == 0) {
					parentNode.left = grandChildNode;
				}
				if (flag == 1) {
					parentNode.right = grandChildNode;
				}
			}
		}

		/**
		 *     z                            z                            x
			  / \                          / \                          /  \ 
			T1   y   Right Rotate (y)    T1   x      Left Rotate(z)   z      y
			    / \  - - - - - - - - ->     /  \   - - - - - - - ->  / \    / \
			   x   T4                      T2   y                  T1  T2  T3  T4
			  / \                              /  \
			T2   T3                           T3   T4

		 * */
		public void RL() {
			Node parentNode = findParent(this.data);
			Node childNode = right;
			Node grandChildNode = childNode.left;
			
			int flag = 0; // 0-left, 1-right
			if (parentNode.data >= this.data) {
				flag = 0;
			}
			else {
				flag = 1;
			}

			// R()
			Node tempNode1 = grandChildNode.right;
			childNode.left = tempNode1;
			grandChildNode.right = childNode;
			this.right = grandChildNode;
			
			// L()
			Node tempNode = grandChildNode.left;
			grandChildNode.left = this;
			this.right = tempNode;
			
			if (this.equals(root)) {
				root = grandChildNode;
			}
			else {				
				if (flag == 0) {
					parentNode.left = grandChildNode;
				}
				if (flag == 1) {
					parentNode.right = grandChildNode;
				}
			}
		}

		/**
		 * check if the subtree with node as root is balanced
		 * @return
		 */
		public boolean isBalanced() {
			if (right == null && left == null) {
				return true;
			}
			if (right == null) {
				return left.depth() <= 1;
			}
			if (left == null) {
				return right.depth() <= 1;
			}
			else if (Math.abs(left.depth() - right.depth()) <= 1) {
				return left.isBalanced() && right.isBalanced();
			}
			else {
				return false;
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

		/**
		 * pretty print the tree
		 * @param indent
		 */
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

		public int depth() {
			if (left == null && right == null) {
				return 1;
			}
			if (left == null) {
				return 1 + right.depth();
			}
			if (right == null) {
				return 1 + left.depth();
			}
			return 1 + Math.max(left.depth(), right.depth());
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
	public AVL() {
		root = null;
	}

	// constructor with 1 argument
	public AVL(int data) {
		root = new Node();
		root.data = data;
		root.left = null;
		root.right = null;
	}

	// constructor with 3 arguments
	public AVL(int data, Node leftNode, Node rightNode) {
		root = new Node();
		root.data = data;
		root.left = leftNode;
		root.right = rightNode;
	}

	// not used
	public int nodeCount() {
		return 0;
	}

	public void toAVL() {
		if (root != null) {
			Node node = findFirstUnbalancedNode();
			System.out.println(node.getTypeOfRotation());
			switch (node.getTypeOfRotation()) {
			case "RR":
				node.L();
				break;

			case "LL":
				node.R();
				break;

			case "LR":
				node.LR();
				break;

			case "RL":
				node.RL();
				break;

			default:
				break;
			}
		}
	}

	/**
	 * return the left subtree of the root
	 * */
	public AVL leftTree() {
		if (root == null) return null;
		else {
			AVL leftBST = new AVL();
			leftBST.root = root.left;
			return leftBST;
		}
	}

	/**
	 * return the right subtree of the root
	 * */
	public AVL rightTree() {
		if (root == null) return null;
		else {
			AVL rightBST = new AVL();
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

	public void traverseNodeIsBalanced() {
		if (root != null) {
			root.traverseNodeIsBalanced();
		}
	}

	public Node findFirstUnbalancedNode() {
		if (root == null) {
			return null;
		}
		return root.firstUnbalancedNode();
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
						AVL tempBST = new AVL();
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
