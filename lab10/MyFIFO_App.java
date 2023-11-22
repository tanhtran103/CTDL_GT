package lab10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyFIFO_App {
	// method stutter that accepts a queue of integers as
	// a parameter and replaces
	// every element of the queue with two copies of that element
	// front [1, 2, 3] back
	// becomes
	// front [1, 1, 2, 2, 3, 3] back
	public static <E> void stutter(Queue<E> input) {
		int size = input.size();
		for (int i = 0; i < size; i++) {
			E current = input.poll();
			input.offer(current);
			input.offer(current);
		}
	}

	// Method mirror that accepts a queue of strings
	// as aparameter and appends the
	// queue's contents to itself in reverse order
	// front [a, b, c] back
	// becomes
	// front [a, b, c, c, b, a] back
	public static <E> void mirror(Queue<E> input) {
		Queue<E> tempQueue = new LinkedList<>();
		Stack<E> temp = new Stack<>();
		tempQueue.addAll(input);
		while (!input.isEmpty()) {
			temp.push(input.poll());
		}
		while (!temp.isEmpty()) {
			tempQueue.offer(temp.pop());
		}
		input.addAll(tempQueue);
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		System.out.println("Before stutter " + queue);
		stutter(queue);
		System.out.println("After stutter " + queue);
		System.out.println("-----------------------");
		Queue<String> queue2 = new LinkedList<>();
		queue2.add("a");
		queue2.add("b");
		queue2.add("c"); 
		System.out.println("Before mirror " + queue2);
		mirror(queue2);
		System.out.println("After mirror " + queue2);
	}
}