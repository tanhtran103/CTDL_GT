package lab11;

import java.util.Collection;
import java.util.List;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	// Add element e into BST
	public void add(E e) {
		if (root == null) {
			root = new BNode<E>(e);
		} else {

			BNode<E> currentNode = root;

			while (true) {
				int compareResult = e.compareTo(currentNode.getData());

				if (compareResult < 0) {
					if (currentNode.getLeft() == null) {
						currentNode.setLeft(new BNode<E>(e));
						return;
					} else {
						currentNode = currentNode.getLeft();
					}
				} else if (compareResult > 0) {
					if (currentNode.getRight() == null) {
						currentNode.setRight(new BNode<E>(e));
						return;
					} else {
						currentNode = currentNode.getRight();
					}
				} else {
					currentNode.setData(e);
					return;
				}
			}
		}
	}

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		for (E e : col) {
			add(e);
		}
	}

	// compute the depth of a node in BST
	public int depth(E node) {
		if (root == null) {
			return -1;
		}
		BNode<E> currentNode = root;
		int depth = 0;
		while (true) {
			int compareResult = node.compareTo(currentNode.getData());

			if (compareResult < 0) {
				if (currentNode.getLeft() == null) {
					return -1;
				} else {
					currentNode = currentNode.getLeft();
					depth++;
				}
			} else if (compareResult > 0) {
				if (currentNode.getRight() == null) {
					return -1;
				} else {
					currentNode = currentNode.getRight();
					depth++;
				}
			} else {
				return depth;
			}
		}
	}

	// compute the height of BST
	public int height() {
		return computeHeightHelper(root);
	}

	private int computeHeightHelper(BNode<E> node) {
		if (node == null) {
			return -1; // Cây rỗng có chiều cao là -1
		} else {
			int leftHeight = computeHeightHelper(node.getLeft());
			int rightHeight = computeHeightHelper(node.getRight());
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}

	// Compute total nodes in BST
	public int size() {
		return countNodes(root);
	}

	private int countNodes(BNode<E> node) {
		if (node == null) {
			return 0;
		} else {
			return countNodes(node.getLeft()) + countNodes(node.getRight()) + 1;
		}
	}

	// Check whether element e is in BST
	public boolean contains(E e) {
		if (root == null) {
			return false;
		}
		return depth(e) != -1;
	}

	// Find the minimum element in BST
	public E findMin() {
		if (root == null) {
			return null;
		}

		Stack<BNode> stack = new Stack<>();
		BNode<E> current = root;

		while (current != null) {
			stack.push(current);
			current = current.getLeft();
		}

		BNode<E> minNode = stack.pop();
		return minNode.getData();
	}

	// Find the maximum element in BST
	public E findMax() {
		if (root == null) {
			return null;
		}

		Stack<BNode> stack = new Stack<>();
		BNode<E> currentNode = root;

		while (currentNode != null) {
			stack.push(currentNode);
			currentNode = currentNode.getRight();
		}

		BNode<E> maxNode = stack.pop();
		return maxNode.getData();
	}

	// Remove element e from BST
	public boolean remove(E e) {
		if (root == null) {
			return false;
		}
		return false;
	}

	// get the descendants of a node
	public List<E> descendants(E data) {
		return null;
	}

	// get the ancestors of a node
	public List<E> ancestors(E data) {
		return null;
	}

	// display BST using inorder approach
	public void inorder() {
		inorderHelper(root);
	}

	private void inorderHelper(BNode<E> root) {
		if (root != null) {
			inorderHelper(root.getLeft());
			System.out.print(root.getData() + " ");
			inorderHelper(root.getRight());
		}
	}

	// display BST using preorder approach
	public void preorder() {
		preorderHelper(root);
	}

	private void preorderHelper(BNode<E> root) {
		if (root != null) {
			System.out.print(root.getData() + " ");
			preorderHelper(root.getLeft());
			preorderHelper(root.getRight());
		}
	}

	// display BST using postorder approach
	public void postorder() {
		postorderHelper(root);
	}

	private void postorderHelper(BNode<E> root) {
		if (root != null) {
			postorderHelper(root.getLeft());
			postorderHelper(root.getRight());
			System.out.print(root.getData() + " ");
		}
	}
	public static void main(String[] args) {
		BST bstTree = new BST();
		bstTree.add(5);
		bstTree.add(3);
		bstTree.add(7);
		bstTree.add(2);
		bstTree.add(4);
		bstTree.add(6);
		bstTree.add(8);
		
		//Test inorder
		bstTree.inorder();
		System.out.println();
		//Test preorder
		bstTree.preorder();
		System.out.println();
		//Test postorder
		bstTree.postorder();
	}
}
