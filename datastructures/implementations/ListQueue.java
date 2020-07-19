package de.ads.datastructures.implementations;

import java.util.Iterator;

import de.ads.datastructures.interfaces.Queue;
import de.ads.datastructures.test.QueueTest;

public class ListQueue<T> implements Queue<T>{

	private Node head;
	private Node tail;
	private int nodeCount;
	
	private class Node {
		
		Node next;
		T data;
		
		Node(T data) {
			this.data = data;
		}
	}
	
	private class QueueIterator implements Iterator<T> {
		
		private Node currentNode = head;
		
		public boolean hasNext() {
			return currentNode != null;
		}
		
		public T next() {
			T toReturn = currentNode.data;
			currentNode = currentNode.next;
			return toReturn;
		}
	}

	@Override
	public void enqueue(T item) {
		
		Node oldTail = tail;
		
		tail = new Node(item);
		tail.next = null;
		
		if (isEmpty())
			head = tail;
		
		else
			oldTail.next = tail;
		
		nodeCount++;
		
	}

	@Override
	public T dequeue() {
		
		T toReturn = head.data;
		
		head = head.next;
		nodeCount--;
		
		if (isEmpty())
			tail = null;
		
		return toReturn;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public int size() {
		return nodeCount;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new QueueIterator();
	}
	
	
	public static void main(String[] args) {
		
		Queue<String> myQueue = new ListQueue<String>();
		
		myQueue.enqueue("This");
		QueueTest.testSize(myQueue, 1);
		
		myQueue.enqueue("is");
		QueueTest.testSize(myQueue, 2);
		
		myQueue.enqueue("my");
		QueueTest.testSize(myQueue, 3);
		
		myQueue.enqueue("Queue");
		QueueTest.testSize(myQueue, 4);
		
		QueueTest.testEnqueueAndDequeue(myQueue, "Hello World");
		QueueTest.testIterator(myQueue);
	}

}
