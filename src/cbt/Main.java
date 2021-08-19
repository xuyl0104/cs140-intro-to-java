package cbt;
public class Main {
	public static void main(String[] args) {
		CompleteBinaryTree<Integer> tree = new CompleteBinaryTree<>();
		
		int i = 1;
		System.out.println("add 1 to tree");
		System.out.println("---------------");
		tree.addBalanced(1);
		tree.prettyPrint();
		System.out.println("--------------- size() = " + tree.size());
		System.out.println("last Node's getData() " + tree.findLastEntered().getData());
		System.out.println("---------------");
		System.out.println("remove 2 (not present)"); // checking removing null at root
		System.out.println(tree.remove(2));  // checking adding null at lower in tree
		System.out.println("---------------");
		tree.prettyPrint();
		System.out.println("--------------- size() = " + tree.size());
		System.out.println("remove 1 (is present)"); // checking removing null at root
		System.out.println("---------------");
		System.out.println(tree.remove(1));  // checking adding null at lower in tree
		tree.prettyPrint();
		System.out.println("--------------- size() = " + tree.size());
		System.out.println("add null to tree");
		System.out.println("---------------");
		tree.addBalanced(null); // checking inserting null at root
		tree.prettyPrint();
		System.out.println("--------------- size() = " + tree.size());
		System.out.println("last Node's getData() " + tree.findLastEntered().getData());
		System.out.println("---------------");
		for(i = 1; i < 15; ++i) {
			System.out.println("add " + i + " to tree");
			System.out.println("---------------");
			tree.addBalanced(i);
			tree.prettyPrint();
			System.out.println("--------------- size() = " + tree.size());
			System.out.println("last Node's getData() " + tree.findLastEntered().getData());
			System.out.println("---------------");
		}
		System.out.println("remove null"); // checking removing null at root
		System.out.println(tree.remove(null));  // checking adding null at lower in tree
		tree.prettyPrint();
		System.out.println("--------------- size() = " + tree.size());
		System.out.println("add null to tree");
		System.out.println("---------------");
		tree.addBalanced(null);
		tree.prettyPrint();
		System.out.println("--------------- size() = " + tree.size());
		System.out.println(tree.findLastEntered().getData());
		System.out.println("---------------");
		for(i = 15; i < 31; ++i) { 
			System.out.println("add " + i + " to tree");
			System.out.println("---------------");
			tree.addBalanced(i);
			tree.prettyPrint();
			System.out.println("--------------- size() = " + tree.size());
			System.out.println(tree.findLastEntered().getData());
			System.out.println("---------------");
		}
		for(i = 20; i < 40; ++i) { 
			if(tree.find(i) != null) System.out.println(i + " is found");
			else System.out.println(i + " is not found");
		}
		System.out.println("---------------");
		for(i = 0; i < 10; ++i) {
			System.out.println("remove " + i);
			System.out.println(tree.remove(i));
			tree.prettyPrint();
			System.out.println("--------------- size() = " + tree.size());
		}
		System.out.println("remove null");
		System.out.println(tree.remove(null));
		tree.prettyPrint();
		System.out.println("--------------- size() = " + tree.size());
		for(i = 31; i < 35; ++i) {
			System.out.println("remove " + i);
			System.out.println(tree.remove(i));
			tree.prettyPrint();
			System.out.println("--------------- size() = " + tree.size());
		}
	}
}
