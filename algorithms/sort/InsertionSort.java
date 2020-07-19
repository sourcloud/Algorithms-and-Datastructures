package de.ads.algorithms.sort;

import de.ads.algorithms.test.SortTest;

public class InsertionSort extends Sort {

	@Override
	public <T extends Comparable<T>> void sort(T[] toSort) {
		
		int end = toSort.length;
		
		for (int currentEnd = 1; currentEnd < end; currentEnd++) {
			
			// start at current max and sort as far to the start as possible
			for (int compare = currentEnd; compare > 0 && less(toSort[compare], toSort[compare-1]); compare--)
				swap(toSort, compare, compare-1);
		}
	}

	public static void main(String[] args) {
		SortTest.testSort(new InsertionSort());
	}
	
}
