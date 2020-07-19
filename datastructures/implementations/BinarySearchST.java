package de.ads.datastructures.implementations;

import de.ads.datastructures.interfaces.OrderedSymbolTable;
import de.ads.datastructures.interfaces.Queue;
import de.ads.datastructures.test.SymbolTableTest;

public class BinarySearchST<K extends Comparable<K>,V> implements OrderedSymbolTable<K, V> {
	
	private K[] keys;
	private V[] values;
	private int filledEntries;
	
	@SuppressWarnings("unchecked")
	public BinarySearchST(int capacity) {
		keys = (K[]) new Comparable[capacity];
		values = (V[]) new Object[capacity];
		filledEntries = 0;
	}

	@Override
	public void put(K key, V value) {
		
		int i = rank(key);
		
		if (i < filledEntries && keys[i].compareTo(key) == 0) {
			values[i] = value;
			return;
		}
		
		for (int j = filledEntries; j > i; j--) {
			keys[j] = keys[j-1];
			values[j] = values[j-1];
		}
		
		keys[i] = key;
		values[i] = value;
		
		filledEntries++;
		
	}

	@Override
	public V get(K key) {
		
		if (isEmpty())
			return null;
		
		int i = rank(key);
		
		if (i < filledEntries && keys[i].compareTo(key) == 0)
			return values[i];
		
		else
			return null;
		
	}

	@Override
	public void delete(K key) {
		
		if (isEmpty())
			return;
		
		if (!contains(key))
			return;
		
		int i = rank(key);
		
		for (int j = i; j < filledEntries - 1; j++) {
			keys[j] = keys[j+1];
			values[j] = values[j+1];
		}
		
		keys[filledEntries-1] = null;
		values[filledEntries-1] = null;
		
		filledEntries--;
	}

	@Override
	public boolean contains(K key) {
		return (get(key) != null);
	}

	@Override
	public boolean isEmpty() {
		return filledEntries == 0;
	}

	@Override
	public int size() {
		return filledEntries;
	}

	@Override
	public Iterable<K> keys() {
		return keys(min(), max());
	}

	@Override
	public K min() {
		return keys[0];
	}

	@Override
	public K max() {
		return keys[filledEntries-1];
	}

	@Override
	public K floor(K key) {
		
		if (contains(key))
			return key;
		
		int i = rank(key);
		
		if (i == 0)
			return null;
		
		return keys[i-1];
	}

	@Override
	public K ceil(K key) {
		int i = rank(key);
		return keys[i];
	}

	@Override
	public int rank(K key) {
		
		int lowerBound = 0;
		int upperBound = filledEntries - 1;
		
		while (lowerBound <= upperBound) {
			
			int middle = lowerBound + (upperBound - lowerBound) / 2;
			int compare = key.compareTo(keys[middle]);
			
			if (compare < 0)
				upperBound = middle - 1;
			
			else if (compare > 0)
				lowerBound = middle + 1;
			
			else 
				return middle;
		}
		
		return lowerBound;
	}

	@Override
	public K select(int rank) {
		return keys[rank];
	}

	@Override
	public void deleteMin() {
		delete(min());
	}

	@Override
	public void deleteMax() {
		delete(max());
	}

	@Override
	public int size(K lowerBound, K upperBound) {
		
		if (upperBound.compareTo(lowerBound) < 0)
			return 0;
		
		else if (contains(upperBound))
			return rank(upperBound) - rank(lowerBound) + 1;
		
		else
			return rank(upperBound) - rank(lowerBound);
	}

	@Override
	public Iterable<K> keys(K lowerBound, K upperBound) {
		
		Queue<K> queue = new ListQueue<K>();
		
		for (int i = rank(lowerBound); i < rank(upperBound); i++)
			queue.enqueue(keys[i]);
		
		if (contains(upperBound))
			queue.enqueue(keys[rank(upperBound)]);
		
		return queue;
	}
	
	
	public static void main(String[] args) {
		
		OrderedSymbolTable<String, String> table = new BinarySearchST<>(10);
		
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
