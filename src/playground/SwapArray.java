package playground;

/**
 * swap elements in an array to output the array in reverse order
 */
public class SwapArray {
    
    public static void swapArray(int[] arr) {
        int len = arr.length;
        // e.g. 0 1 2 3 4 5 | 6 7 8 9 10 11
        // e.g. 0 1 2 3 4 (5) 6 7 8 9 10
        int times = len /2;
        int temp = 0;
        for (int i = 0; i < times; ++i) {
            temp = arr[i];
            arr[i] = arr[len - 1 - i];
            arr[len - 1 - i] = temp;
        }
    }

    public static void printArray(int[] arr) {
        // for (int i = 0; i < arr.length; ++i) {
        //     System.out.print(arr[i] + " ");
        // }
        for (int i: arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] arr1 = new int[11];
        int[] arr2 = new int[12];

        for (int i = 0; i < arr1.length; ++i) {
            arr1[i] = (int)(Math.random() * 100);
        }

        for (int i = 0; i < arr2.length; ++i) {
            arr2[i] = (int)(Math.random() * 100);
        }

        System.out.println("Before: ");
        printArray(arr1);
        printArray(arr2);
        
        swapArray(arr1);
        swapArray(arr2);
        System.out.println("After: ");

        printArray(arr1);
        printArray(arr2);
    }
}
