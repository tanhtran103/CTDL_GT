package lab1;

import java.util.Arrays;

public class MyArray {
	private int[] arr;

	public MyArray(int[] arr) {
		this.arr = arr;
	}

	// Method mirror that outputs the contents of an array in a
	// reverse order like a mirror
	// Example: input [1, 2, 3] ==> output: [1, 2, 3, 3, 2, 1]
	public int[] mirror() {
		System.out.println("Input: " + Arrays.toString(arr));
		int[] reverseArr = new int[this.arr.length];
		for (int i = 0; i < arr.length; i++) {
			reverseArr[i] = arr[arr.length - i - 1];
		}
		int[] result = new int[arr.length + reverseArr.length];
		System.arraycopy(arr, 0, result, 0, arr.length);
		System.arraycopy(reverseArr, 0, result, arr.length, reverseArr.length);
		return result;
	}

	// removes all duplicate elements from an array and returns a
	// new array
	// Input: 1 3 5 1 3 7 9 8
	// Output: 1 3 5 7 9 8
	public int[] removeDuplicates() {
		int arrLength = arr.length;
		for (int i = 0; i < arrLength; i++) {
			for (int j = i + 1; j < arrLength; j++) {
				if (arr[i] == arr[j]) {
					arr[j] = arr[arrLength - 1];
					arrLength--;
					j--;
				}
			}
		}

		int[] result = new int[arrLength];
		System.arraycopy(arr, 0, result, 0, arrLength);
		return result;
	}

	// Input: 10 11 12 13 14 16 17 19 20
	// Output: 15 18
	public int[] getMissingValues() {
		// TODO
		return null;
	}

	// Input: 10 11 12 -1 14 10 17 19 20
	// Output(k=3): 10 11 12 12 14 16 17 19 20
	public int[] fillMissingValues(int k) {
		// TODO
		return null;
	}

	public static void main(String[] args) {
		// Test method mirror
		int[] arr1 = { 1, 2, 3 };
		MyArray myArr = new MyArray(arr1);
		System.out.println("Output: " + Arrays.toString(myArr.mirror()));

		// Test method remove duplicate
		int[] arr2 = { 1, 3, 5, 1, 3, 7, 9, 8 };
		MyArray myArr2 = new MyArray(arr2);
		System.out.println(Arrays.toString(myArr2.removeDuplicates()));
	}
}
