package playground;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamPractice {

	public static void main(String[] args) {
		Stream<String> st1 = Stream.of("A", "B", "C", "D");
		int res = (int) st1.filter(x -> x.equals("B")).count();
		System.out.println(res);
		
		String[] monthArray = {
				"January", "February", "March", "April", "May", "June", 
				"July", "August", "September", "October", "November", "December"
				};
		List<String> monthList = List.of(monthArray);
		Stream<String> st2 = monthList.stream();
		String[] res2 = st2.filter(x -> x.compareTo("April") > 0).toArray(String[]::new);
		System.out.println(Arrays.toString(res2));
	}

}
