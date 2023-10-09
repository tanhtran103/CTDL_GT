package lab3;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

// To find the index of the target in the array. If the target
// is not found in the array, then the method returns -1.
// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 45
// Output: 3
	public int iterativeLinearSearch(int target) {
		for (int i = 0; i < this.array.length; i++) {
			if (array[i] == target) {
				return i;
			}
		}
		return -1;
	}

// To find the index of the target in the array. If the target
// is not found in the array, then the method returns -1.
// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 15
// Output: -1
	public int recursiveLinearSearch(int[] arr, int size, int target) {
		if (size == 0) {
			return -1;
		} else if (arr[size - 1] == target) {

			// Return the index of found key.
			return size - 1;
		}
		return recursiveLinearSearch(arr, size - 1, target);
	}

// To find the index of the target in the sorted array. If the
// target is not found in the array, then the method returns -1.
	public int iterativeBinarySearch(int target) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (array[mid] == target)
				return mid;
			if (array[mid] < target)
				low = mid + 1;
			else
				high = mid - 1;

		}
		return -1;
	}

// To find the index of the target in the sorted array. If the
// target is not
// found in the array, then the method returns -1.

	public int recursiveBinarySearch(int low, int high, int target) {
		if (low <= high) {
			int mid = (low + high) / 2;
			if (array[mid] == target)
				return mid;
			if (array[mid] > target)
				return recursiveBinarySearch(low, mid - 1, target);
			else 
				return recursiveBinarySearch(mid + 1, high, target);
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] array = { 12, 10, 9, 45, 2, 10, 10, 45 };
		MyArray myArr = new MyArray(array);
		System.out.println(myArr.iterativeLinearSearch(45));
		System.out.println(myArr.recursiveLinearSearch(array, array.length - 1, 9));
		System.out.println(myArr.iterativeBinarySearch(10));
		System.out.println(myArr.recursiveBinarySearch(0, array.length-1, 15));
	}

}
