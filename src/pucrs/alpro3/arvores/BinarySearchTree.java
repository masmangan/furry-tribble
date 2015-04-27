package pucrs.alpro3.arvores;

/**
 * 
 * @author marco.mangan@pucrs.br
 *
 */
public class BinarySearchTree {

	private class Node {
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
			return node.value + " " + toString(node.left) + " "
					+ toString(node.right);
		return "*";
	}

	public int getLevelForValue(int value) {
		return getLevelForValue(root, value, 0);
	}

	private int getLevelForValue(Node node, int value, int level) {
		if (node == null)
			throw new IllegalArgumentException("Valor não encontrado: " + value);
		
		if (value < node.value)
			return getLevelForValue(node.left, value, level + 1);
		
		if (value > node.value)
			return getLevelForValue(node.right, value, level + 1);
		
		return level;
	}

	public int getHeightForValue(int value) {
		return getHeightForValue(root, value);
	}

	private int getHeightForValue(Node node, int value) {
		if (node == null)
			throw new IllegalArgumentException("Valor não encontrado: " + value);

		if (value < node.value)
			return getHeightForValue(node.left, value);
		
		if (value > node.value)
			return getHeightForValue(node.right, value);

		return h(node);
	}

	private int h(Node node) {
		if (node == null)
			return -1;
		
		return 1 + Math.max(h(node.left), h(node.right));
	}
	
	
}
