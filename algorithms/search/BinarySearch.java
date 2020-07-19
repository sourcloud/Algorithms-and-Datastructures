package de.ads.algorithms.search;

import de.ads.algorithms.test.SearchTest;

public class BinarySearch {

	public static <T extends Comparable<T>> int indexOf(T[] toSearch, T toFind) {
		
		int lowerBound = 0;
		int upperBound = toSearch.length - 1;
		
		while (lowerBound <= upperBound) {
			
			int middle = lowerBound + (upperBound - lowerBound) / 2;
			
			// check left half if lower than value in middle
			if (toFind.compareTo(toSearch[middle]) < 0)
				upperBound = middle - 1;
			
			// check right half if higher than value in middle
			else if (toFind.compareTo(toSearch[middle]) > 0)
				lowerBound = middle + 1;
			
			// return if matches value in middle
			else
				return middle;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		// must be sorted for binary search to work!
		String[] testArray = {"a", "b", "c", "d", "e", "f", "g"};
		
		String inArray = "e";
		String notInArray = "z";
		
		int inArrayIndex = indexOf(testArray, inArray);
		int notInArrayIndex = indexOf(testArray, notInArray);
		
		SearchTest.testCalculatedIndex(inArray, inArrayIndex, 4);
		SearchTest.testCalculatedIndex(notInArray, notInArrayIndex, -1);
		
	}
	
}
