package de.ads.algorithms.search;

import de.ads.algorithms.test.SearchTest;

public class SequentialSearch {
	
	public static <T> int indexOf(T[] toSearch, T toFind) {
		
		// check one element after another
		for (int i = 0; i < toSearch.length; i++)
			if (toSearch[i] == toFind)
				return i;
		
		return -1;
	}
	
	public static void main(String[] args) {
		
		// does not need to be sorted
		Integer[] testArray = {5, 12, 2, 45, 21, 4, 22, 33, 99};
		
		int inArray = 33;	
		int notInArray = 15;
		
		int inArrayIndex = indexOf(testArray, inArray);
		int notInArrayIndex = indexOf(testArray, notInArray);
		
		SearchTest.testCalculatedIndex(inArray, inArrayIndex, 7);
		SearchTest.testCalculatedIndex(notInArray, notInArrayIndex, -1);
		
	}

}
