package de.ads.datastructures.implementations;

import java.util.Iterator;

import de.ads.datastructures.interfaces.Stack;
import de.ads.datastructures.test.StackTest;

public class ListStack<T> implements Stack<T> {
	
	private Node head;
	private int nodeCount;
	
	private class Node {
		
		Node next;
		T data;
		
		Node(T data) {
			this.data = data;
		}
	}
	
	private class StackIterator implements Iterator<T> {
		
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
	public void push(T item) {
		Node oldHead = head;
		head = new Node(item);
		head.next = oldHead;
		nodeCount++;
	}

	@Override
	public T pop() {
		T toReturn = head.data;
		head = head.next;
		nodeCount--;
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
		return new StackIterator();
	}
	
	
	public static void main(String[] args) {
		
		Stack<String> myStack = new FixedCapacityArrayStack<String>(5);
		
		myStack.push("Hello");
		StackTest.testSize(myStack, 1);
		
		myStack.push("World");
		StackTest.testSize(myStack, 2);
		
		StackTest.testPushAndPop(myStack, "Hallo Welt");
		StackTest.testIterator(myStack);
	}

}
