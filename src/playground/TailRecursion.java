package playground;

public class TailRecursion {

	public static void main(String[] args) {
		long startTime = 0L;
		long endTime = 0L;
		int n = 20;
		
//		startTime = System.nanoTime();
//		System.out.println(commonRecursion(n, "----|"));
//		endTime = System.nanoTime();
//		System.out.println("Running time of the recursion is: " + (endTime - startTime));
//
//		startTime = System.nanoTime();
//		System.out.println(tailRecursion(n, "----|", 1));
//		endTime = System.nanoTime();
//		System.out.println("Running time of the recursion is: " + (endTime - startTime));
		
		startTime = System.nanoTime();
		System.out.println(fibonacci(20));
		endTime = System.nanoTime();
		System.out.println("Running time of the recursion is: " + (endTime - startTime));
		
		startTime = System.nanoTime();
		System.out.println(tailRecurssionFibonacci(20, 0, 0, 1));
		endTime = System.nanoTime();
		System.out.println("Running time of the recursion is: " + (endTime - startTime));
		
		startTime = System.nanoTime();
		System.out.println(arrayFibonacci(20));
		endTime = System.nanoTime();
		System.out.println("Running time of the recursion is: " + (endTime - startTime));
	}

	public static long commonRecursion(int n, String level) {
		if (n <= 1) {
			return 1;
		}
		else {
			return n * commonRecursion(n - 1, level + "----|");
		}
	}

	public static long tailRecursion(int n, String level, long curVal) {
		if (n == 1) {
			return curVal;
		}
		else {
			return tailRecursion(n - 1, level + "----|", n * curVal);
		}
	}

	// recursive-1
	// 0 1 1 2 3 5 8 13 21 34 55
	public static long fibonacci(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	// tail recursion
	public static long tailRecurssionFibonacci(int n, int counter, long a, long b) {
		if (n == counter) {
			return a;
		}
		else {
			return tailRecurssionFibonacci(n, counter + 1, b, a + b);
		}
		
	}
	
	// array
	public static long arrayFibonacci(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		else {
			long[] fib = new long[2];
			fib[0] = 0;
			fib[1] = 1;
			long temp = 0;
			for (int i = 2; i <= n; ++i) {
				temp = fib[0] + fib[1];
				fib[0] = fib[1];
				fib[1] = temp;
			}
			return fib[1];
		}
	}
}
