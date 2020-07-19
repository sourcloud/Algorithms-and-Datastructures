package de.ads.algorithms.sort;

import de.ads.algorithms.test.SortTest;

public class SelectionSort extends Sort {

	@Override
	public <T extends Comparable<T>> void sort(T[] toSort) {
		
		int end = toSort.length;
		
		for (int currentStart = 0; currentStart < end; currentStart++) {
			
			int currentMinimum = currentStart;
			
			for (int comparePosition = currentStart+1; comparePosition < end; comparePosition++)
				
				if (less(toSort[comparePosition], toSort[currentMinimum]))
					currentMinimum = comparePosition;
			
			swap(toSort, currentStart, currentMinimum);
		}
	}
	
	public static void main(String[] args) {
		SortTest.testSort(new SelectionSort());
	}

}
