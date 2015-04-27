package pucrs.alpro3.arvores;

/**
 * 
 * @author marco.mangan@pucrs.br
 * @author augusto.faria@acad.pucrs.br
 * @author filipe.kalicki@acad.pucrs.br
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

	/**
	 * 
	 */
	public BinarySearchTree() {
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
			return node.value + " " + toString(node.left) + " "
					+ toString(node.right);
		return "*";
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
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

	/**
	 * 
	 * @param value
	 * @return
	 */
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

	public int[] getChildren(int value) {
		return getChildren(root, value);
	}

	private int[] getChildren(Node node, int value) {
		if (node == null)
			throw new IllegalArgumentException("Valor não encontrado: " + value);

		if (value < node.value)
			return getChildren(node.left, value);

		if (value > node.value)
			return getChildren(node.right, value);
		int i = 0;
		if (node.left != null)
			i++;
		if (node.right != null)
			i++;
		int[] retorno = new int[i];
		i = 0;
		if (node.left != null) 
			retorno[i++] = node.left.value;
		if (node.right != null)
			retorno[i] = node.right.value;
		return retorno;
	}

	public int getParent(int i) {
		if (!this.contains(i))
			throw new IllegalArgumentException("Valor não encontrado: " + i);
		
		if (root.value == i)
			throw new IllegalArgumentException("Não tem pai: " + i);
		
		return getParentValue(root, i);
	}
	
	private int getParentValue(Node node, int value) {
		if (node == null)
			throw new IllegalArgumentException("Valor não encontrado: " + value);

		if (value < node.value && node.left.value != value)
			return getParentValue(node.left, value);

		if (value > node.value && node.right.value != value)
			return getParentValue(node.right, value);

		return node.value;
	}
}
