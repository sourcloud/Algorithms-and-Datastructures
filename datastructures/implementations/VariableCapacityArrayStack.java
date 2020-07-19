package de.ads.datastructures.implementations;

import java.util.Iterator;

import de.ads.datastructures.interfaces.Stack;
import de.ads.datastructures.test.StackTest;

public class VariableCapacityArrayStack<T> implements Stack<T> {

	private T[] entries;
	private int numberOfEntries;
	
	private class StackIterator implements Iterator<T> {
		
		private int index = numberOfEntries - 1;
		
		public boolean hasNext() { 
			return index >= 0; 
		}
		
		public T next() {
			return entries[index--];
		}
	}
	
	@SuppressWarnings("unchecked")
	public VariableCapacityArrayStack(int capacity) {
		entries = (T[]) new Object[capacity];
		numberOfEntries = 0;
	}

	@Override
	public void push(T item) {
		
		// double capacity if reached maximum fill
		if (entries.length == numberOfEntries)
			resize(2 * entries.length);
		
		entries[numberOfEntries++] = item;
	}

	@Override
	public T pop() {
		
		T toReturn = entries[--numberOfEntries];
		entries[numberOfEntries] = null;
		
		// halve capacity if reached quarter fill
		if ((numberOfEntries > 0) && (numberOfEntries == entries.length / 4))
			resize(entries.length / 2);
		
		return toReturn;
	}

	@Override
	public boolean isEmpty() {
		return (numberOfEntries == 0);
	}

	@Override
	public int size() {
		return numberOfEntries;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new StackIterator();
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int max) {
		
		T[] temp = (T[]) new Object[max];
		
		for (int i = 0; i < numberOfEntries; i++)
			temp[i] = entries[i];
		
		entries = temp;
	}
	
	
	public static void main(String[] args) {
		
		Stack<String> myStack = new VariableCapacityArrayStack<String>(1);
		
		myStack.push("Hello");
		StackTest.testSize(myStack, 1);
		
		// Push possible due to resize
		myStack.push("World");
		StackTest.testSize(myStack, 2);
		
		StackTest.testPushAndPop(myStack, "Hallo Welt");
		StackTest.testIterator(myStack);
	}
	
}
