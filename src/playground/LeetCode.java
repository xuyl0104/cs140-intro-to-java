package playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LeetCode {

	public static void main(String[] args) {
		// Q1
		int[] releasedTime = {12, 23, 36, 46, 62};
		String keyStrokeString = "spuda";
		System.out.println(slowestReleasedKey(releasedTime, keyStrokeString));
		
		// Q2
		int[] nums = {-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10};
		int[] l = {0, 1, 6, 4, 8, 7};
		int[] r = {4, 4, 9, 7, 9, 10};
		System.out.println(Arrays.toString(arithmeticSubarrays(nums, l, r)));

	}
	
	public static char slowestReleasedKey(int[] releasedTime, String keyStrokes) {
		int maxDuration = releasedTime[0];
		char maxChar = keyStrokes.charAt(0);
		for (int i = 1; i < keyStrokes.length(); ++i) {
			int durationOfCur = releasedTime[i] - releasedTime[i - 1];
			if (durationOfCur > maxDuration) {
				maxDuration = durationOfCur;
				maxChar = keyStrokes.charAt(i);
			}
		}
		return maxChar;
	}
	
	public static boolean[] arithmeticSubarrays(int[] arr, int[] l, int[] r) {
		boolean[] res = new boolean[l.length];
		
		for (int i = 0; i < l.length; ++i) {
			ArrayList<Integer> subArrayList = new ArrayList<>();
			for (int j = l[i]; j <= r[i]; ++j) {
				subArrayList.add(arr[j]);
			}
			Collections.sort(subArrayList);
			res[i] = isArithmeticSubarray(subArrayList);
		}
		
		return res;
	}
	
	public static boolean isArithmeticSubarray(ArrayList<Integer> arr) {
		if (arr.size() <= 2) {
			return true;
		}
		else {
			int diff = arr.get(1) - arr.get(0);
			boolean res = true;
			for (int i = 2; i < arr.size(); ++i) {
				if (arr.get(i) - arr.get(i - 1) == diff) {
					continue;
				}
				else {
					res = false;
				}
			}
			return res;
		}
	}

}
