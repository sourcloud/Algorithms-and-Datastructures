package de.ads.algorithms.sort;

import de.ads.algorithms.test.SortTest;

public class BubbleSort extends Sort {

	@Override
	public <T extends Comparable<T>> void sort(T[] toSort) {
		boolean swapped;
		do {
			swapped = false;
			for (int i = 0; i < toSort.length - 1; i++) {
				if (toSort[i].compareTo(toSort[i+1]) > 0) {
					swap(toSort, i, i+1);
					swapped = true;
				}
			}
		} while (swapped);
	}

	public static void main(String[] args) {
		SortTest.testSort(new BubbleSort());
	}
}
