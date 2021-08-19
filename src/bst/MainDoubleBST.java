package bst;
public class MainDoubleBST {
	public static void main(String[] args) {
		BinarySearchTreeDouble tree = new BinarySearchTreeDouble();
		
		int divisor = 1;
		while(divisor <= 128) {
			System.out.print(divisor + " ");
			divisor *= 2;
			for(int i = 1; i < divisor; i+=2) 
				tree.add(i*300/divisor);
		}
		System.out.println();
		tree.prettyPrint();
		System.out.println("==================");
		System.out.println("==================");
		for(int i = 50; i < 90; ++i) {
			System.out.print(tree.findCount(i) + " ");
			tree.remove(i);
		}
		System.out.println();
		tree.prettyPrint();
	}
}
