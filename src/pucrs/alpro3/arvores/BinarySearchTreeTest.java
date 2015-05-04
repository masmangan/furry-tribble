package pucrs.alpro3.arvores;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTreeTest {

	@Test
	public void testNoChildren() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(10);
		int[] actual = bst .getChildren(10);
		assertEquals(0, actual.length);
	}

	@Test
	public void testOneChild() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(20);
		bst.add(10);
		int[] actual = bst .getChildren(20);
		assertEquals(1, actual.length);
		assertEquals(10, actual[0]);
	}	
	
	@Test
	public void testTwoChildren() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(20);
		bst.add(10);
		bst.add(30);
		int[] actual = bst .getChildren(20);
		assertEquals(2, actual.length);
		assertEquals(10, actual[0]);
		assertEquals(30, actual[1]);
	}		
	
	@Test(expected=IllegalArgumentException.class)
	public void testNodeNotFound() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(10);
		bst .getChildren(20);
	}	
	
	@Test(expected=IllegalArgumentException.class)
	public void testNoParent() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(10);
		int actual = bst .getParent(10);
		//assertEquals(0, actual.length);
	}

	@Test
	public void testOneParent() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(20);
		bst.add(10);
		int actual = bst .getParent(10);
		//assertEquals(1, actual.length);
		assertEquals(20, actual);
	}	
	
	@Test
	public void testTwoParent() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(20);
		bst.add(10);
		bst.add(30);
		int actual = bst .getParent(30);
		//assertEquals(2, actual.length);
		assertEquals(20, actual);
		//assertEquals(30, actual);
	}		
	
	@Test(expected=IllegalArgumentException.class)
	public void testNodeNotFoundParent() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(10);
		bst .getParent(20);
	}	
}
