package lab4;

import java.util.Arrays;
import java.util.Random;

public class Sort {
// sort by descending order
	public static void selectionSort(int[] array) {
// TODO
		for (int i = 0; i < array.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			int temp = array[min];
			array[min] = array[i];
			array[i] = temp;
		}
	}

// sort by descending order
	public static void bubbleSort(int[] array) {
// TODO
		for (int i = 0; i < array.length - 1; i++) {
			boolean stop = true;
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
					stop = false;
				}
			}
			if (stop) {
				break;
			}
		}
	}

// sort by descending order
	public static void insertionSort(int[] array) {
// TODO
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				if (array[j] < array[j - 1]) {
					int temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}

	}

	// sort by descending order
	public static void merge(int[] array, int left, int mid, int right) {
		int leftLength = mid - left + 1;
		int rightLength = right - mid;
		int[] leftArr = new int[leftLength];
		int[] rightArr = new int[rightLength];
		for (int i = 0; i < leftLength; i++) {
			leftArr[i] = array[left + i];
		}
		for (int i = 0; i < rightLength; i++) {
			rightArr[i] = array[mid + i + 1];
		}
		int i = 0, j = 0;
		while (i < leftLength && j < rightLength) {
			if (leftArr[i] < rightArr[j]) {
				array[left++] = leftArr[i++];
			} else {
				array[left++] = rightArr[j++];
			}
		}
		while (i < leftLength) {
			array[left++] = leftArr[i++];
		}
		while (j < rightLength) {
			array[left++] = rightArr[j++];
		}

	}

	public static void mergeSort(int[] array, int left, int right) {
		if (left >= right) {
			return;
		} else {
			int mid = (left + right) / 2;
			mergeSort(array, left, mid);
			mergeSort(array, mid + 1, right);
			merge(array, left, mid, right);
		}

	}

	// select pivot element based on the median of three
	// strategy
	private static int getPivot_MedianOfThree(int[] array, int left, int right) {
		// TODO
		int mid = (left + right)/2;
		if (array[right] < array[left]) {
			int temp = array[left];
			array[left] = array[right];
			array[right] = temp;
		}
		if (array[mid] < array[left]) {
			int temp = array[mid];
			array[mid] = array[left];
			array[left] = temp;
		}
		if (array[right] < array[mid]) {
			int temp = array[right];
			array[right] = array[mid];
			array[mid] = temp;
		}
		return mid;
	}

	// select pivot element based on the first element
	// in the array
	private static int getPivot_First(int[] array) {
		// TODO
		return array[0];
	}

	// select pivot element based on the last element in
	// the array
	private static int getPivot_Last(int[] array) {
		// TODO
		return array[array.length - 1];
	}

	// select pivot element based on choosing a randomly
	// element in the array
	private static int getPivot_Random(int[] array) {
		// TODO
		return array[(int) (Math.random() * array.length)];
	}

	// sort by ascending order
	public static void quickSort(int[] array, int left, int right) {
		// TODO
		if (left < right) {
			int pivotIndex = partition(array, left, right);
			quickSort(array, left, pivotIndex - 1);
			quickSort(array, pivotIndex + 1, right);
		}
	}

	private static int partition(int[] array, int left, int right) {
		// TODO Auto-generated method stub
		int pivot = array[right];
		int i = left - 1;
		for (int j = left; j < right; j++) {
			if (array[j] < pivot) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		int temp = array[i + 1];
		array[i + 1] = array[right] ;
		array[right] = temp;
		return i + 1;
	}

	public static void main(String[] args) {
		// Test selection sort
		int[] array = { 1, 5, 3, 8, 2, 4 };
		selectionSort(array);
		System.out.println(Arrays.toString(array));

		int[] array2 = { 2, 6, 7, 5, 3, 9, 1 };
		int[] array3 = { 1, 2, 3, 4, 5, 6, 8, 7 };
		bubbleSort(array2);
		bubbleSort(array3);

		// Test bubble sort
		System.out.println(Arrays.toString(array2));
		System.out.println(Arrays.toString(array3));

		// Test insertion sort
		insertionSort(array3);
		System.out.println(Arrays.toString(array3));
		
		//Test merge sort
		int[] array4 = { 43, 45, 12, 76, 89, 83, 29 };
		mergeSort(array4, 0, array4.length - 1);
		System.out.println(Arrays.toString(array4));
		
		//Test quick sort
		int[] array5 = {39, 43, 56, 79, 32, 49};
		quickSort(array5, 0, array.length-1);
		System.out.println(Arrays.toString(array5));
	}
}