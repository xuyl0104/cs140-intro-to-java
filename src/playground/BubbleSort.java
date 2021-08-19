package playground;

import java.util.Arrays;

public class BubbleSort {
    
    public static void bubbleSort(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len - 1; ++i) {
            for (int j = 0; j < len - 1 - i; ++j) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static boolean twoArraysAreEqual(int[] arr1, int [] arrr2) {
        for (int i = 0; i < arr1.length; ++i) {
            if (arr1[i] != arrr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        int[] arr2 = new int[10];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = (int)(Math.random() * 100);
            arr2[i] = arr[i];
        }

        bubbleSort(arr);
        Arrays.sort(arr2);

        printArray(arr);

        System.out.println("Compare bubblesort and Array.Sort():");
        System.out.println(twoArraysAreEqual(arr, arr2));
    }
}