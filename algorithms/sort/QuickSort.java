package de.ads.algorithms.sort;

import de.ads.algorithms.test.SortTest;

public class QuickSort extends Sort {

	@Override
	public <T extends Comparable<T>> void sort(T[] toSort) {
		sort(toSort, 0, toSort.length - 1);
	}
	
	private static <T extends Comparable<T>> void sort(T[] toSort, int lowerBound, int upperBound) {
		
		if (upperBound <= lowerBound)
			return;
		
		int partitionIndex = partition(toSort, lowerBound, upperBound);
				
		sort(toSort, lowerBound, partitionIndex-1);
		sort(toSort, partitionIndex+1, upperBound);
	}
	
	private static <T extends Comparable<T>> int partition(T[] toSort, int lowerBound, int upperBound) {
		
		T pivot = toSort[upperBound];
		
		int i = (lowerBound - 1);		
		
		for (int j = lowerBound; j < upperBound; j++) {
			
			if (less(toSort[j], pivot)) {
				
				i++;
				swap(toSort, i, j);

			}
		}	
		
		swap(toSort, i+1, upperBound);
		
		return i+1;
		
		
	}
	
	public static void main(String[] args) {
		SortTest.testSort(new QuickSort());
	}

}
