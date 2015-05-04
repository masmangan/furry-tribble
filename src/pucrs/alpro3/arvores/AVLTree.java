package pucrs.alpro3.arvores;


/**
 * 
 * @author marco.mangan@pucrs.br
 *
 */
public class AVLTree {

	private class Node {
		int value;
		int height;
		Node left, right;

		public Node(int value) {
			this.value = value;
			left = right = null;
			height = 0;
			count++;
		}

	}

	private int count;

	private Node root;

	/**
	 * 
	 */
	public AVLTree() {
		root = null;
		count = 0;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * 
	 * @return
	 */
	public int size() {
		return count;
	}

	/**
	 * 
	 * @param v
	 */
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

		///
		
		int hl, hr;
		hl = hr = -1;
		
		if (node.left != null)
			hl = node.left.height;
		if (node.right != null)
			hr = node.right.height;
		
		node.height = 1 + Math.max(hl, hr);
		
		///
		
		return node;
	}

	/**
	 * 
	 * @param v
	 * @return
	 */
	public boolean contains(int v) {
		return contains(root, v);
	}

	private boolean contains(Node node, int v) {
		if (node == null)
			return false;

		if (v < node.value)
			return contains(node.left, v);

		if (v > node.value)
			return contains(node.right, v);

		return true;
	}

	@Override
	public String toString() {
		return toString(root);
	}

	private String toString(Node node) {
		if (node != null)
			return node.value + " (" + node.height + ") "+ toString(node.left) + " "
					+ toString(node.right);
		return "*";
	}

		
}
