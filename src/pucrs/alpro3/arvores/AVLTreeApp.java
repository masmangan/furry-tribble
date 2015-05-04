package pucrs.alpro3.arvores;

/**
 * 
 * @author marco.mangan@pucrs.br
 *
 */
public class AVLTreeApp {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		AVLTree bst = new AVLTree();
		
		System.out.println(bst.size());
		System.out.println(bst);
		bst.add(20);
		System.out.println(bst.size());
		System.out.println(bst);
		bst.add(10);
		System.out.println(bst.size());
		System.out.println(bst);
		bst.add(30);
		System.out.println(bst.size());
		System.out.println(bst);
		bst.add(5);
		System.out.println(bst.size());
		System.out.println(bst);
		bst.add(1);
		System.out.println(bst.size());
		System.out.println(bst);
		System.out.println(bst.contains(10));
		System.out.println(bst.contains(11));
}
}