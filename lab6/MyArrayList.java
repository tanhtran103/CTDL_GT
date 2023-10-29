package lab6;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;
	
	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	// creates an array of double-size if the array of
	// elements is full
	public void growSize() {
		this.elements = Arrays.copyOf(this.elements, this.elements.length * 2);
	}

	// Returns the number of elements in this list.
	public int size() {
		return this.size;
	}

	// Returns whether the list is empty.
	public boolean isEmpty() {
		return this.size == 0;
	}

	// Returns (but does not remove) the element at index i.
	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= this.size) {
			throw new ArrayIndexOutOfBoundsException();
		} else
			return elements[i];
	}

	// Replaces the element at index i with e, and
	// returns the replaced element.
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= this.size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		elements[i] = e;
		return elements[i];
	}

	// It is used to append the specified element at the
	// end of a list.
	public boolean add(E e) {
		if (this.size == this.elements.length) {
			this.growSize();
		}
		this.elements[this.size] = e;
		size++;
		return true;
	}

	// Inserts element e to be at index i, shifting all
	// subsequent elements later.
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > this.size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		if (this.size == this.elements.length) {
			this.growSize();
		}
		for (int j = size; j > i; j--) {
			elements[j] = elements[j - 1];
		}
		elements[i] = e;
		size++;
	}

	// Removes and returns the element at index i,
	// shifting subsequent elements earlier.
	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= this.size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		for (int j = i; j < this.size; j++) {
			elements[j] = elements[j + 1];
		}
		size--;
		return elements[i];
	}

	// It is used to clear all elements in the list.
	public void clear() {
		for (int i = 0; i < this.size; i++) {
			elements[i] = null;
		}
	}

	/*
	 * It is used to return the index in this list of the last occurrence of the
	 * specified element, or -1 if the list does not contain this element.
	 */
	public int lastIndexOf(Object o) {
		return (int) elements[size - 1];
	}

	public E[] toArray() {
		E[] arr = (E[]) new Object[size];
		for (int i = 0; i < size; i++) {
			arr[i] = elements[i];
		}
		return arr;
	}

	// It is used to return a shallow copy of an ArrayList.
	public MyArrayList<E> clone() {
		MyArrayList<E> cloning = new MyArrayList<>();
		for (int i = 0; i < size; i++) {
			cloning.add(elements[i]);
		}
		return cloning;
	}

	// It returns true if the list contains the specified
	// element
	public boolean contains(E o) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(o)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * It is used to return the index in this list of the first occurrence of the
	 * specified element, or -1 if the List does not contain this element.
	 */
	public int indexOf(E o) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}

	// It is used to remove the first occurrence of the
	// specified element.
	public boolean removeSpecElement(E e) {
		if (indexOf(e) != -1) {
			remove(indexOf(e));
			return true;
		}
		return false;
	}
	
	// It is used to sort the elements of the list on the
	// basis of specified comparator.
	public void sort(Comparator<E> c) {
	}

	public static void main(String[] args) {
		MyArrayList<Integer> arrList = new MyArrayList<>();
		arrList.add(1);
		arrList.add(3);
		arrList.add(2);
		arrList.add(9);
		arrList.add(7);
		arrList.set(2, 3);
		arrList.add(1, 5);
		arrList.remove(2);
		// arrList.clear();
		for (int i = 0; i < arrList.size; i++) {
			System.out.print(arrList.get(i));
		}
		System.out.println();
		System.out.println("Last index of array: " + arrList.lastIndexOf(arrList));
		System.out.println("The list contain 6: " + arrList.contains(6));
		System.out.println("Check if specified element appear in list: " + arrList.removeSpecElement(1));
		System.out.println ("After remove, the list become: ");
		for (int i = 0; i < arrList.size(); i++) {
			System.out.print(arrList.get(i));
		}
	}
}
