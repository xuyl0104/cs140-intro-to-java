package finalexam;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BinarySearchTree {
	private int[] data;
	private BinarySearchTree left;
	private BinarySearchTree right;

	public BinarySearchTree(int[] arr) {
		if(valid(arr))
			this.data = arr;
		else throw new IllegalArgumentException("Invalid input");
	}

	/**
	 * The method valid returns true if arr is not null, not empty
	 * and every element is an int between 0 and 9 inclusive with one
	 * extra condition:
	 * The array of length 1 containing 0: [0] is valid but if the 
	 * array is length > 1, then it is only valid if the first element if not 0.
	 * Hence [7, 3, 1] is valid but [0, 7, 3, 1] is not valid since the first
	 * element is 0.
	 * @param arr the array to validate
	 * @return true if the array elements are all between 0 and 9 and there
	 * is at least one element in the array also if arr.length > 1 then arr[0] != 0.
	 * Returns false in all other cases.
	 */
	public static boolean valid(int[] arr) {
		//TODO
		if (arr == null || arr.length == 0) {
			return false;
		}
		if (arr.length == 1) {
			if (arr[0] >= 0 && arr[0] <= 9) {				
				return true;
			}
			else {
				return false;
			}
		}
		
		if (arr.length > 1) {
			if (arr[0] == 0) {
				return false;
			}
			else {
				for (int i = 0; i < arr.length; ++i) {
					if (arr[i] > 9 || arr[i] < 0) {
						return false;
					}
				}
				return true;
			}
		}
		return true;
	}
	
	/**
	 * Converts an array that is valid using the test above into
	 * a int formed by the sequence of digits in the array, e.g.
	 * [3, 5, 8, 2, 0, 3] becomes 358203. We do accept that [0] 
	 * returns 0. Note that and array [0, 3, 4, 6] is NOT valid.
	 * This is to avoid the confusion of 0346 and 346, which 
	 * are the same numerically.
	 *
	 * You start with 0 as the return value and loop through the array
	 * multiplying the return value by 10 and adding the next element 
	 * in the array.
	 *
	 * Return 0 if the array is not valid. 
	 * @param arr the array of digits to convert
	 * @return the sequence of digits in the array as an int and 0 if the array
	 * is not valid 
	 */
	public static int makeInt(int[] arr) {
		//TODO
		if (!valid(arr)) {
			return 0;
		}
		if (arr.length == 1) {
			return arr[0];
		} 
		String resString = "";
		for (int i = 0; i < arr.length; ++i) {
			resString += arr[i];
		}
		return Integer.valueOf(resString);
	}

	/**
	 * This mehtod is provided to you. It uses an IntStream
	 * to make the code shorter.
	 * Returns the sum of the elements in the array and
	 * 0 if the array is null. 
	 * @param arr the input array
	 * @return the sum of the elements in the array and
	 * 0 if arr is null
	 */
	public static int sum(int[] arr) {
		if(arr == null) return 0;
		return IntStream.of(arr).sum();
	}

	/**
	 * The insert is provided. The element arr must be
	 * a valid array using the test above and it is stored
	 * according to its numerical value when converted to a 
	 * long.
	 * @param arr array to be inserted in the tree
	 */
	public void insert(int[] arr){
		if (valid(arr)) {
			if(makeInt(data) == makeInt(arr)) return;
			else if(makeInt(data) > makeInt(arr)) {
				if(left == null) left = new BinarySearchTree(arr);
				else left.insert(arr);
			}
			else{
				if(right == null) right = new BinarySearchTree(arr);
				else right.insert(arr);
			}
		}
	}

	/**
	 * Return the array with the largest sum of its elements in the tree.
	 * If two or more arrays have the same largest sum, return one
	 * of them (which one is not specified by the question)
	 * @return one of the arrays in the tree of largest sum of its 
	 * elements
		 * 
		 * 
		 * 					6234
		 * 				 /        \
		 * 			 3999	      7934
		 *          /    \             \
		 *      2239     5234	    	12346
		 * 				/				/	\
		 * 			4234			8868	72346
		 * 								\
		 * 								9234
		 * 	
	 */
	
	public int[] largestSum() {
		//TODO -- use the sum method above
		int[] res = null;
		if (data == null) {
			return res;
		}
		if (left == null && right == null) {
			return data;
		}
		res = data;
		if (left != null) {
			int sumOfLeftlargest = sum(left.largestSum());
			if (sum(res) < sumOfLeftlargest) {
				res = left.largestSum();
			}
		}
		if (right != null) {
			int sumOfRightLargest = sum(right.largestSum());
			if (sum(res) < sumOfRightLargest) {
				res = right.largestSum();
			}
		}
		return res;
	}
	
	public void prettyPrint() {
		prettyPrint(0);
	}

	private void prettyPrint(int indentLevel) {
		if(left != null) left.prettyPrint(indentLevel + 1);
		for(int i = 0; i < indentLevel; i++) System.out.print("  ");
		System.out.println(Arrays.toString(data));
		if(right != null) right.prettyPrint(indentLevel + 1);
	}
}
