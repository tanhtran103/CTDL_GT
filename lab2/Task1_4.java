package lab2;

public class Task1_4 {
	public static void towerOfHanoi(int n, char source, char dest, char spare) {
		if (n == 1) {
			System.out.println("Take disk 1 from " + source + " to " + dest);
			return;
		}
		towerOfHanoi(n - 1, source, spare, dest);
		System.out.println("Take disk " + n + " from " + source + " to " + dest);
		towerOfHanoi(n - 1, spare, dest, source);
	}

	public static void main(String args[]) {
		int n = 2;
		towerOfHanoi(n, 'A', 'C', 'B');
	}
}
