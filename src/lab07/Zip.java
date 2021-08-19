package lab07;
import java.util.Arrays;

public class Zip {
    public static int[] zip(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];

        int shorter = arr1.length <= arr2.length ? arr1.length : arr2.length;

        for (int i = 0; i < shorter; ++i) {
            res[2 * i] = arr1[i];
            res[2 * i + 1] = arr2[i];
        }

        if (arr1.length >= arr2.length) {
            for (int i = 0; i < (arr1.length - shorter); ++i) {
                res[2 * shorter + i] = arr1[shorter + i];
            }
        }
        else {
            for (int i = 0; i < (arr2.length - shorter); ++i) {
                res[2 * shorter + i] = arr2[shorter + i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 3, 5, 7, 9};
        int[] b1 = {2, 4, 6, 8, 10};
        
        int[] a2 = {1, 3, 5, 7, 9};
        int[] b2 = {2, 4, 6, 8, 10, 12, 14, 16};
        
        int[] a3 = {1, 3, 5, 7, 9, 11, 13};
        int[] b3 = {2, 4, 6, 8, 10};

        int[] a4 = {};
        int[] b4 = {2, 4, 6, 8};
        
        int[] a5 = {1, 3, 5, 7};
        int[] b5 = {};

        System.out.println(Arrays.toString(zip(a1, b1)));
        System.out.println(Arrays.toString(zip(a2, b2)));
        System.out.println(Arrays.toString(zip(a3, b3)));
        System.out.println(Arrays.toString(zip(a4, b4)));
        System.out.println(Arrays.toString(zip(a5, b5)));
    }
}
