package pucrs.alpro3.arvores;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class BinarySearchTree {

	class Node {
		int value;
		Node left, right;

		public Node(int value) {
			this.value = value;
			left = right = null;
			count++;
		}

	}

	private int count;

	private Node root;

	public BinarySearchTree() {
		root = null;
		count = 0;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public int size() {
		return count;
	}

	public void add(int v) {
		root = add(root, v);
	}

	private Node add(Node node, int v) {

		if (node == null)
			return new Node(v);

		if (v < node.value)
			node.left = add(node.left, v);
		else if (v > node.value)
			node.right = add(node.right, v);
		else
			throw new IllegalArgumentException("A chave está cadastrada:" + v);

		return node;
	}

	public boolean contains(int v) {
		throw new NotImplementedException();
	}

	@Override
	public String toString() {
		return toString(root);
	}

	private String toString(Node node) {
		if (node != null)
			return node.value + " " + toString(node.left) + " "
					+ toString(node.right);
		return "*";
	}

}
