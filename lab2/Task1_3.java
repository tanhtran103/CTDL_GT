package lab2;

import java.util.Arrays;

public class Task1_3 {
	public static int[] getPascalTriangle(int n) {
		if (n == 1) {
			return new int[1];
		} else {
			int[] prevRow = getPascalTriangle(n - 1);
			return generateNextRow(prevRow);
		}
	}

	public static int[] generateNextRow(int[] prevRow) {
		int[] pre = new int[prevRow.length + 1];
		pre[0] = 1;
		pre[pre.length - 1] = 1;
		for (int i = 1; i < pre.length - 1; i++) {
			pre[i] = prevRow[i] + prevRow[i - 1];
		}
		return pre;
	}

	public static void printSupport(int row, int currentIndex) {
		if (row < currentIndex) {
			return;
		}
		System.out.println(Arrays.toString(getPascalTriangle(currentIndex)));
		printSupport(row, currentIndex + 1);
	}

	public static void printPascalTriangle(int row) {
		printSupport(row, 1);
	}

	public static void main(String[] args) {
		printPascalTriangle(5);
	}
}
