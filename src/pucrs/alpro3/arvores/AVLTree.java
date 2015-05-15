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

		if (v < node.value) {
			node.left = add(node.left, v);
			int delta = h(node.left) - h(node.right);
			if (delta == 2) {
				//rotacao
				System.out.println("RotaÃ§Ã£o com filho da esquerda!");
				System.out.printf("Node: %d, node left: %d, value: %d\n",
						node.value, node.left.value, v);
				// copia
				Node a = node.left; 
				// o nodo esquerdo de dez aponta para o direito de cinco
				node.left = a.right; 
				// o nodo direito de cinco passa a apontar para dez
				a.right = node;
				// retorna cinco como nodo raiz
				node = a;
			}
			
			// TODO: completar rotação dupla
			
			
		} else if (v > node.value) {
			node.right = add(node.right, v);
			// TODO: completar rotação simples
			// TODO: completar rotação dupla
			
		}
		else
			throw new IllegalArgumentException("A chave estÃ¡ cadastrada:" + v);

		///
				
		node.height = 1 + Math.max(h(node.left), h(node.right));
		
		///
		
		return node;
	}

	private int h(Node node) {
		return node == null? - 1 : node.height;
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
			return node.value + " (" + node.height + ")[ " + (h(node.left) - h(node.right)) + "] "+ toString(node.left) + " "
					+ toString(node.right);
		return "*";
	}

		
}
