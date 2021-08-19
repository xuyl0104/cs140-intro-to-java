package playground;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamExamples1 {
	public static void main(String[] args) throws IOException {
		Stream<String> stream1 = Stream.of("January", "February", "March", "April", "May",
				"June", "July", "August", "September", "October", "November", "December");
		
		String[] array = {"January", "February", "March", "April", "May", "June", 
				"July", "August", "September", "October", "November", "December"};
		Stream<String> stream2 = Stream.of(array);
		
		List<String> list = new ArrayList<>(Arrays.asList("January", "February", "March", "April", "May",
				"June", "July", "August", "September", "October", "November", "December"));
		Stream<String> stream3 = list.stream();
		
		Stream<String> lines = Files.lines(Paths.get("textfile.txt")); // note throws IOException above

		List<String> list1 = List.of("January", "February", "March", "April", "May",
				"June", "July", "August", "September", "October", "November", "December");
		// List.of will not allow nulls
		Stream<String> stream4 = list1.stream();
		
		IntStream istream1 = IntStream.of(5, 2, 6, 8, 2, 7, 0, 10);
		
		LongStream lstream1 = LongStream.of(5, 2, System.currentTimeMillis(), 8, 2, 7, 0, 100000000000L);
		
		DoubleStream dstream1 = DoubleStream.of(5, 2, 6, 8, 2, 7, 0, 10);
		
		IntStream istream2 = IntStream.generate( () -> 7 ); // is an infinite stream of 7s
		Stream<Integer> stream5 = Stream.generate( () -> 7 );
		
		IntStream istream3 = IntStream.iterate(0, n -> n + 2); // is the infinite stream 0, 2, 4, 6, ...
		Stream<Integer> stream6 = Stream.iterate(0, n -> n + 2);
	}
}