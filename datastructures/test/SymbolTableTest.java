package de.ads.datastructures.test;

import de.ads.datastructures.interfaces.SymbolTable;

public class SymbolTableTest {
	
	public static <K,V> void testPutAndGet(SymbolTable<K, V> toTest, K key, V toPut) {
		
		toTest.put(key, toPut);
		V foundValue = toTest.get(key);
		boolean isValid = toPut.equals(foundValue);
		
		System.out.println("Put " + toPut + " at " + key);
		System.out.println("Got " + foundValue + " at " + key);
		System.out.println("Valid: " + isValid);
		System.out.println("---------------");
	}
	
	public static <K, V> void testContains(SymbolTable<K,V> toTest, K key, boolean expected) {
		
		boolean foundItem = toTest.contains(key);
		
		System.out.println("Tried to find item at: " + key);
		System.out.println("Successful: " + foundItem);
		System.out.println("Valid: " + (expected == foundItem));
		System.out.println("---------------");
	}
	
	public static <K, V> void testDelete(SymbolTable<K,V> toTest, K key) {
		
		toTest.delete(key);
		boolean isDeleted = !toTest.contains(key);
		
		System.out.println("Tried to delete item at: " + key);
		System.out.println("Valid: " + isDeleted);
		System.out.println("---------------");
	}
	
	public static <K, V> void testSize(SymbolTable<K,V> toTest, int expected) {
		
		int size = toTest.size();
		boolean isValid = (expected == size);
		
		System.out.println("Size: " + size);
		System.out.println("Valid: " + isValid);
		System.out.println("---------------");
	}
	
	public static <K, V> void testKeys(SymbolTable<K,V> toTest) {

		boolean isValid = true;
		
		for (K key : toTest.keys())
			if (!toTest.contains(key))
				isValid = false;
		
		System.out.println("Tested keys");
		System.out.println("Valid: " + isValid);
		System.out.println("---------------");
	}

}
