package de.ads.datastructures.test;

import de.ads.datastructures.interfaces.Queue;

public class QueueTest {
	
	public static <T> void testEnqueueAndDequeue(Queue<T> toTest, T newElement) {
		
		toTest.enqueue(newElement);
		
		System.out.println("Enqueued: " + newElement);
		
		T dequeued = null;
		int count = 0;
		while(!toTest.isEmpty()) {
			dequeued = toTest.dequeue();
			count++;
		}
		
		System.out.println("Dequeued: " + count);	
		System.out.println("Valid: " + newElement.equals(dequeued));
		System.out.println("---------------");
	}
	
	public static <T> void testIterator(Queue<T> toTest) {
		boolean isValid = true;
		for (T item : toTest)
			if (!item.equals(toTest.dequeue()))
				isValid = false;
		System.out.println("Iterator valid: " + isValid);
		System.out.println("---------------");
	}
	
	public static <T> void testSize(Queue<T> toTest, int expected) {
		System.out.println("Size: " + toTest.size());
		System.out.println("Valid: " + (toTest.size() == expected));
		System.out.println("---------------");
	}

}
