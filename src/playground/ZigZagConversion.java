package playground;

/**
 * convert a string into zigzag format
 * input: "ABCDEFGHIJK"
 * output: 
 * 		if numOfRows = 3
 * 		   A   E   I
 * 		   B D F H J
 * 		   C   G   K
 * 
 * input: "ABCDEFGHIJKLMNOPQRST"
 * output:  
 * 		if numOfRows = 4
 * 		   A     G     M     S
 * 		   B   F H   L N   R T
 *         C E   I K   O Q
 *         D     J     P
 * 
 * NOTE: spaces do not matter, for now...
 * 	
 * @author xuyunlong
 *
 */
public class ZigZagConversion {
	
	
	public static void zigZagConverter(String inputString, int numOfRows) {
		StringBuilder[] sbs = new StringBuilder[numOfRows];
		for (int i = 0; i < numOfRows; ++i) {
			sbs[i] = new StringBuilder();
		}
		
		int[] pos = new int[numOfRows];
		for (int i = 0; i < numOfRows; ++i) {
			pos[i] = 0;
		}
		
		int i = 0;
		int len = inputString.length();
		while (i < len) {
			for (int idx = 0; idx < numOfRows && i < len; ++idx) {
				for (int j = 0; j < (i - pos[idx] - 1) && i >= numOfRows; ++j) {
					sbs[idx].append(' ');
				}
				
				sbs[idx].append(inputString.charAt(i));
				
				pos[idx] = i;
				i++;
			}
			for (int idx = (numOfRows - 2); idx >= 1 && i < len; --idx) {
				for (int j = 0; j < (i - pos[idx] - 1) && i >= numOfRows; ++j) {
					sbs[idx].append(' ');
				}
				
				sbs[idx].append(inputString.charAt(i));
				
				pos[idx] = i;
				i++;
			}
		}
		
		for (StringBuilder sb : sbs) {
			System.out.println(sb.toString());
		}
	}

	public static void main(String[] args) {
		String inputString = "ABCDEFGHIJKLMNOPQRST";
		int numOfRows = 3;
		zigZagConverter(inputString, numOfRows);

	}

}
