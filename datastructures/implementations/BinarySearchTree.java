package de.ads.datastructures.implementations;

import de.ads.datastructures.interfaces.Queue;
import de.ads.datastructures.interfaces.SymbolTable;
import de.ads.datastructures.test.SymbolTableTest;

public class BinarySearchTree<K extends Comparable<K>, V> implements SymbolTable<K,V> {
	
	private Node root;
	
	private class Node {
		private K key;
		private V value;
		private Node left, right;
		private int subtreeSize;
		
		public Node(K key, V value, int subtreeSize) {
			this.key = key;
			this.value = value;
			this.subtreeSize = subtreeSize;
		}
	}

	@Override
	public void put(K key, V value) {
		root = put(root, key, value);
	}

	@Override
	public V get(K key) {
		return get(root, key);
	}

	@Override
	public void delete(K key) {
		root = delete(root, key);
	}

	@Override
	public boolean contains(K key) {
		return get(key) != null;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return size(root);
	}

	@Override
	public Iterable<K> keys() {
		Queue<K> queue = new ListQueue<>();
		keys(root, queue, min(root).key, max(root).key);
		return queue;
	}
	
	private Node put(Node node, K key, V value) {
		
		if (node == null)
			return new Node(key, value, 1);
		
		int compare = key.compareTo(node.key);
		
		if (compare < 0)
			node.left = put(node.left, key, value);
		
		else if (compare > 0)
			node.right = put(node.right, key, value);
		
		else
			node.value = value;
		
		node.subtreeSize = size(node.left) + size(node.right) + 1;
		return node;
	}
	
	private V get(Node node, K key) {
		
		if (node == null)
			return null;
		
		int compare = key.compareTo(node.key);
		
		if (compare < 0)
			return get(node.left, key);
		
		else if (compare > 0)
			return get(node.right, key);
		
		else
			return node.value;
	}
	
	private Node delete(Node node, K key) {
		
		if (node == null)
			return null;
		
		int compare = key.compareTo(node.key);
		
		if (compare < 0)
			node.left = delete(node.left, key);
		
		else if (compare > 0)
			node.right = delete(node.right, key);
		
		else {
			
			if (node.right == null)
				return node.left;
			
			if (node.left == null)
				return node.right;
			
			Node temp = node;
			
			node = min(temp.right);
			node.right = deleteMin(temp.right);
			node.left = temp.left;
			
		}
		
		node.subtreeSize = size(node.left) + size(node.right) + 1;
		return node;
	}
	
	private int size(Node node) {
		return (node != null) ? node.subtreeSize : 0; 
	}
	
	private Node min(Node node) {	
		if (node.left == null)
			return node;
		return min(node.left);
	}

	private Node max(Node node) {
		if (node.right == null)
			return node;	
		return max(node.right);
	}
	
	private Node deleteMin(Node node) {
		
		if (node.left == null)
			return node.right;
		
		node.left = deleteMin(node.left);
		node.subtreeSize = size(node.left) + size(node.right) + 1;
		return node;	
	}
	
	private void keys(Node node, Queue<K> queue, K lowerBound, K upperBound) {
		
		if (node == null)
			return;
		
		int compareLower = lowerBound.compareTo(node.key);
		int compareUpper = upperBound.compareTo(node.key);
		
		if (compareLower < 0)
			keys(node.left, queue, lowerBound, upperBound);
		
		if (compareLower <= 0 && compareUpper >= 0)
			queue.enqueue(node.key);
		
		if (compareUpper > 0)
			keys(node.right, queue, lowerBound, upperBound);
	}
	
	
	public static void main(String[] args) {
		
		SymbolTable<String, String> table = new BinarySearchTree<>();
		
		SymbolTableTest.testSize(table, 0);
		
		table.put("A", "Hello");
		SymbolTableTest.testSize(table, 1);
		
		table.put("G", "World");
		SymbolTableTest.testSize(table, 2);
		
		SymbolTableTest.testDelete(table, "A");
		SymbolTableTest.testSize(table, 1);
		
		SymbolTableTest.testContains(table, "A", false);
		SymbolTableTest.testContains(table, "G", true);
		
		SymbolTableTest.testPutAndGet(table, "World", "Hello");
		
		table.put("AA", "test");
		table.put("BB", "test");
		table.put("ZZ", "test test test");
		
		SymbolTableTest.testKeys(table);
	}

}
