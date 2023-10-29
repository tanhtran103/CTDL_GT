package lab6;

import java.awt.geom.CubicCurve2D;

public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	public SinglyLinkedList() {
		super();
	}

	// Returns the number of elements in the list.
	public int size() {
		return this.size;
	}

	// Returns true if the list is empty, and false
	// otherwise.
	public boolean isEmpty() {
		return this.size == 0;
	}

	// Returns (but does not remove) the first element in
	// the list.
	public E first() {
		return this.head.getData();
	}

	// Returns (but does not remove) the last element in
	// the list.
	public E last() {
		return this.tail.getData();
	}

	// Adds a new element to the front of the list.
	public void addFirst(E e) {
		Node<E> newNode = new Node<>(e);
		newNode.setNext(head);
		head = newNode;
	}

	// Adds a new element to the end of the list.

	public void addLast(E e) {
		Node<E> newNode = new Node<>(e);
		if (head == null) {
			head = newNode;
			tail = newNode;
		}
		tail.setNext(newNode);
		tail = newNode;
	}

	// Removes and returns the first element of the list.
	public E removeFirst() {
		if (head == null) {
			return null;
		}
		E removeHead = head.getData();
		head = head.getNext();
		return removeHead;
	}

	// Removes and returns the last element of the list.
	public E removeLast() {
		if (head == null) {
			return null;
		}
		if (size == 1) {
			head = tail = null;
		}
		E temp = head.getData();
		Node<E> current = head;
		while (current.getNext() != null) {
			current = current.getNext();
			tail = current;
			tail.setNext(null);
		}
		return temp;
	}

	public void printList() {
		Node<E> node = head;
		if (head == null) {
			System.out.println("List is empty");
		}
		while (node != null) {
			System.out.print(node.getData() + " ");
			node = node.getNext();
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
		// linkedList.addFirst(3);
		// linkedList.addFirst(2);
		// linkedList.addFirst(1);
		linkedList.addLast(4);
		linkedList.addLast(5);
		linkedList.addLast(6);
		linkedList.addLast(3);
		linkedList.removeFirst();
		linkedList.removeLast();
		linkedList.printList();
	}
}
