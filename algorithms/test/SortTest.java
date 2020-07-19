package de.ads.algorithms.test;

import de.ads.algorithms.sort.Sort;

public class SortTest {

	public static void testSort(Sort toTest) {
		
		String[] stringsToSort = {"S", "O", "R", "T", "I", "N", "G", "T", "E", "S", "T"};
		Integer[] numbersToSort = {3, 5, 1, 2, 13, 21, 1, 1, 2, 11, 9};
		
		System.out.print("Unsorted: ");
		Sort.print(stringsToSort);
		
		toTest.sort(stringsToSort);
		
		System.out.print("Sorted:   ");
		Sort.print(stringsToSort);	
		System.out.println("---------------");

		System.out.print("Unsorted: ");
		Sort.print(numbersToSort);
		
		toTest.sort(numbersToSort);
		
		System.out.print("Sorted:   ");
		Sort.print(numbersToSort);
		System.out.println("---------------");
		
		boolean isValid = Sort.isSorted(stringsToSort) && Sort.isSorted(numbersToSort);
		
		System.out.println("Valid: " + isValid);
		System.out.println("---------------");
	}
}
