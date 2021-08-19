package exam02;

import java.util.List;

/**
 * In class Question2, complete the method longestString, which finds the longest non-null String in the List of Strings testList.

If the testList is null, empty, or completely full of null Strings, return the empty String "".
Note that if all the Strings in testList are empty Strings, then the return value is also "".
If there is more than one longest String in the List return the first one.
 * @author xuyunlong
 *
 */
public class Question2 {
	private List<String> testList;

	public Question2(List<String> testList) {
		this.testList = testList;
	}

	public String longestString() {
		// TODO 
		// return the longest String in testList
		// if there is more than one longest return the first
		// if testList is null, or empty, or all the elements are null or 
		// empty Strings, return ""

		String res = "";
		boolean allNulls = true;
		boolean allEmpty = true;
		if (testList == null || testList.size() == 0) {
			return res;
		}
		for (String string : testList) {
			if (string != null) {
				allNulls = false;
				break;
			}
		}
		if (allNulls) {
			return res;
		}

		for (String string : testList) {
			if (string != null && string.length() != 0) {
				allEmpty = false;
				break;
			}
		}

		if (allEmpty) {
			return res;
		}

		int maxLength = -1;
		for (String strObject : testList) {
			if (strObject != null) {
				if (strObject.length() > maxLength) {
					res = strObject;
					maxLength = strObject.length();  
				}
			}
		}
		return res;
	}
}
