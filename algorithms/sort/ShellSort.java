package de.ads.algorithms.sort;

import de.ads.algorithms.test.SortTest;

public class ShellSort extends Sort {

	@Override
	public <T extends Comparable<T>> void sort(T[] toSort) {
		
		int end = toSort.length;
		int distance = 1;
		
		while (distance < end / 3)
			distance = 3 * distance + 1; // 1, 4, 13, 40, 121, 364 ... 
		
		while (distance >= 1) {
			
			for (int currentEnd = distance; currentEnd < end; currentEnd++) {
				
				// perform insertion sort over distance
				for (int compare = currentEnd; 
					 compare >= distance && less(toSort[compare], toSort[compare-distance]); 
					 compare -= distance)
					
					swap(toSort, compare, compare-distance);
				
			}
			
			distance = distance / 3;
		}
	}
	
	public static void main(String[] args) {
		SortTest.testSort(new ShellSort());
	}

}
