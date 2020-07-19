package de.ads.algorithms.sort;

public abstract class Sort {

	public abstract <T extends Comparable<T>> void sort(T[] toSort);
	
	public static <T extends Comparable<T>> void print(T[] toSort) {
		for (int i = 0; i < toSort.length; i++)
			System.out.print(toSort[i] + " ");
		System.out.println();
	}
	
	public static <T extends Comparable<T>> boolean isSorted(T[] toCheck) {
		for (int i = 1; i < toCheck.length; i++)
			if (less(toCheck[i], toCheck[i-1]))
				return false;
		return true;
	}
	
	protected static <T extends Comparable<T>> void swap(T[] elements, int firstIndex, int secondIndex) {
		T temp = elements[firstIndex];
		elements[firstIndex] = elements[secondIndex];
		elements[secondIndex] = temp;
	}
	
	protected static <T extends Comparable<T>> boolean less(T firstElement, T secondElement) {
		return firstElement.compareTo(secondElement) < 0;
	}
	
	
}
