package de.ads.datastructures.implementations;

import de.ads.datastructures.interfaces.Queue;
import de.ads.datastructures.interfaces.SymbolTable;
import de.ads.datastructures.test.SymbolTableTest;

public class SequentialSearchST<K,V> implements SymbolTable<K,V> {
	
	private Node head;
	
	private class Node {
		K key;
		V value;
		Node next;
		
		public Node(K key, V value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	public SequentialSearchST() {
		head = null;
	}

	@Override
	public void put(K key, V value) {
		
		for (Node current = head; current != null; current = current.next)
			
			if (key.equals(current.key)) {
				current.value = value;
				return;
			}
		
		head = new Node(key, value, head);
			
	}

	@Override
	public V get(K key) {
		
		for (Node current = head; current != null; current = current.next)
			
			if (key.equals(current.key))
				return current.value;
		
		return null;
	}

	@Override
	public void delete(K key) {
		put(key, null);
	}

	@Override
	public boolean contains(K key) {
		return (get(key) != null);
	}

	@Override
	public boolean isEmpty() {
		return (size() == 0);
	}

	@Override
	public int size() {
		
		int count = 0;
		
		for (Node current = head; current != null; current = current.next)
			if (current.value != null)
				count++;
		
		return count;
	}

	@Override
	public Iterable<K> keys() {
		
		Queue<K> keyQueue = new ListQueue<K>();
		
		for (Node current = head; current != null; current = current.next)
			if (current.value != null)
				keyQueue.enqueue(current.key);
			
		return keyQueue;
	}
	
	
	public static void main(String[] args) {
		
		SymbolTable<Integer, String> table = new SequentialSearchST<>();
		
		table.put(0, "Hello");
		SymbolTableTest.testSize(table, 1);
		
		table.put(10, "World");
		SymbolTableTest.testSize(table, 2);
		
		SymbolTableTest.testDelete(table, 0);
		SymbolTableTest.testSize(table, 1);
		
		SymbolTableTest.testContains(table, 0, false);
		SymbolTableTest.testContains(table, 10, true);
		
		SymbolTableTest.testPutAndGet(table, 5, "Hello World");
		
		table.put(1, "test");
		table.put(2, "test");
		table.put(111, "test test test");
		
		SymbolTableTest.testKeys(table);
	}

}
