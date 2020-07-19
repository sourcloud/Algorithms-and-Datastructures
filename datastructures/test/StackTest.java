package de.ads.datastructures.test;

import de.ads.datastructures.interfaces.Stack;

public class StackTest {
	
	public static <T> void testSize(Stack<T> toTest, int expected) {
		System.out.println("Size: " + toTest.size());
		System.out.println("Valid: " + (toTest.size() == expected));
		System.out.println("---------------");
	}
	
	public static <T> void testPushAndPop(Stack<T> toTest, T newElement) {
		toTest.push(newElement);
		System.out.println("Pushed: " + newElement);
		T popped = toTest.pop();
		System.out.println("Popped: " + popped);
		System.out.println("Valid: " + (newElement.equals(popped)));
		System.out.println("---------------");
	}
	
	public static <T> void testIterator(Stack<T> toTest) {
		boolean isValid = true;
		for (T item : toTest)
			if (!item.equals(toTest.pop()))
				isValid = false;
		System.out.println("Iterator valid: " + isValid);
		System.out.println("---------------");
	}

}
