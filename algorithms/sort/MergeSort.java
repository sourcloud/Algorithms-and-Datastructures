package de.ads.algorithms.sort;

import de.ads.algorithms.test.SortTest;

public class MergeSort extends Sort {

	private static Object[] temp;
	
	@Override
	public <T extends Comparable<T>> void sort(T[] toSort) {
		temp = new Object[toSort.length];
		sort(toSort, 0, toSort.length-1);
	}
	
	private static <T extends Comparable<T>> void sort(T[] toSort, int lowerBound, int upperBound) {
		
		if (upperBound <= lowerBound)
			return;
		
		int middle = lowerBound + (upperBound - lowerBound) / 2;
		
		// Sort left half
		sort(toSort, lowerBound, middle);
		
		// Sort right half
		sort(toSort, middle + 1, upperBound);
		
		// Merge both sides
		merge(toSort, lowerBound, middle, upperBound);
	}
	
	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>> void merge(T[] toSort, int lowerBound, int middle, int upperBound) {
		
		int i = lowerBound;
		int j = middle + 1;
		
		// 
		for (int k = lowerBound; k <= upperBound; k++)
			temp[k] = toSort[k];
		
		for (int k = lowerBound; k <= upperBound; k++)
			
			if (i > middle)
				toSort[k] = (T) temp[j++];
		
			else if (j > upperBound)
				toSort[k] = (T) temp[i++];
		
			else if (less((T) temp[j], (T) temp[i]))
				toSort[k] = (T) temp[j++];
		
			else
				toSort[k] = (T) temp[i++];
	
	}
	
	public static void main(String[] args) {
		SortTest.testSort(new MergeSort());
	}

}
