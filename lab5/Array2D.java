package lab5;

public class Array2D {
	// add 2 matrices
	public static int[][] add(int[][] a, int[][] b) {
		int[][] result = new int[a.length][b[0].length];
		if (a.length == b.length && a[0].length == b[0].length) {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					result[i][j] = a[i][j] + b[i][j];
				}
			}
		}
		return result;
	}

	// subtract 2 matrices
	public static int[][] subtract(int[][] a, int[][] b) {
		int[][] result = new int[a.length][b[0].length];
		if (a.length == b.length && a[0].length == b[0].length) {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					result[i][j] = a[i][j] - b[i][j];
				}
			}
		}
		return result;
	}

	// multiply 2 matrices
	public static int[][] multiply(int[][] a, int[][] b) {
		int[][] result = new int[a.length][b[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				for (int k = 0; k < b.length; k++) {
					result[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return result;
	}

	// tranpose a matrix
	public static int[][] transpose(int[][] a) {
		int[][] result = new int[a[0].length][a.length];
		for (int i = 0; i < a[0].length; i++) {
			for (int j = 0; j < a.length; j++) {
				result[i][j] = a[j][i];
			}
		}
		return result;
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print("[" + matrix[i][j] + "" + "] ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] a = { { 7, 5, 8 }, { 6, 9, 3 } };
		int[][] b = { { 2, 3, 4 }, { 5, 6, 7 } };
		printMatrix(add(a, b));
		printMatrix(subtract(a, b));
		printMatrix(multiply(a, b));
		printMatrix(transpose(a));
	}
}
