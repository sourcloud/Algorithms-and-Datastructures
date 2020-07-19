package de.ads.datastructures.interfaces;

public interface OrderedSymbolTable<K extends Comparable<K>, V> extends SymbolTable<K,V> {
	
	public K min();
	public K max();
	public K floor(K key);
	public K ceil(K key);
	public int rank(K key);
	public K select(int rank);
	public void deleteMin();
	public void deleteMax();
	public int size(K lowerBound, K upperBound);
	public Iterable<K> keys(K lowerBound, K upperBound);

}
