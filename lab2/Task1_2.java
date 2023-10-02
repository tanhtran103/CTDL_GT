package lab2;

public class Task1_2 {
	// get the nth value of the Fibonacci series
	public static int getFibonacci(int n) {
		if (n == 0 ) {
			return 0;
		}
		if ( n== 1) { 
			return 1;
		}
		return getFibonacci(n - 1) + getFibonacci(n - 2);
	}

	/*
	 * This method is used to display a Fibonacci series based on the parameter n.
	 * Ex. n=10 ==> 0 1 1 2 3 5 8 13 21 34
	 */
	public static void printFibonacci(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(getFibonacci(i) + " ");
		}
	}
	public static void main(String[] args) {
		int n = 10;
		System.out.println("Print fibonacci base on n: ");
		printFibonacci(n);
	}
}
