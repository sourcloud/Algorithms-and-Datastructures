package de.ads.algorithms.test;

public class SearchTest {
	
	public static <T> void testCalculatedIndex(T toFind, int calculated, int expected) {
		
		System.out.println("To find: " + toFind);
		
		if (calculated != -1)
			System.out.println("Found at index: " + calculated);
		
		else
			System.out.println("Not found!");
		
		System.out.println("Valid: " + (calculated == expected));
		System.out.println("---------------");
	}

}
