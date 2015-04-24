package pucrs.alpro3.arvores;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class BinarySearchTree {

	class Node {
		int value;
		Node left, right;
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
		//
		count++;
		throw new NotImplementedException();
	}
	
	private Node add(Node node, int v) {
		// TODO Se a árvore está vazia
		// cria um novo nodo
		// e guarda o valor v
		if (node == null) {
			Node newNode = new Node();
			newNode.value = v;
			newNode.left = null;
			newNode.right = null;
			return newNode;
		} else {
			if (v < node.value) {
				node.left = add(node.left, v);
			} else if (v > node.value) {
				node.right = add(node.right, v);
			}
		}
		// TODO Se a árvore NÃO está vazia
		// escolher o lado direito ou o lado esquerdo
		// para continuar a inserção
		return null;
	}

	public boolean contains(int v) {
		throw new NotImplementedException();
	}
	
}
