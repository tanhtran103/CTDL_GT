package lab10;

import java.util.Stack;

public class MyLIFO_App {
	public static <E> void reserve(E[] array) {
		Stack<E> stack = new Stack<>();
		for (E value : array) {
            stack.push(value);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
	}

	// This method checks the correctness of the given input
	// i.e. ()(())[]{(())} ==> true, ){[]}() ==>false
	public static boolean isCorrect(String input) {
		Stack<Character> stack = new Stack<>();
		for (char c : input.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
				stack.pop();
			} else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
				stack.pop();
			} else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
				stack.pop();
			} else {
				return false;
			}
		}
		return stack.isEmpty();
	}

	// This method evaluates the value of an expression
	// i.e. 51 + (54 *(3+2)) = 321
	public static int evaluateExpression(String expression) {
		return 0;
	}

	public static void main(String[] args) {
		Integer[] array = { 1, 2, 3 };
		reserve(array);
		System.out.print("Reverse of the array is: ");
 		for (Integer number : array) {
            System.out.print(number + " ");
        }
		System.out.println();
 		String rightInput = "()(())[]{(())}";
 		String wrongInput = " ){[]}()";
		System.out.println(rightInput + " is " + isCorrect(rightInput));
		System.out.println(wrongInput + " is " + isCorrect(wrongInput));
	}
}
