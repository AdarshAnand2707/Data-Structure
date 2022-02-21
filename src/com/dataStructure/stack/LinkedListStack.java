package com.dataStructure.stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListStack<T> implements Iterable<T>,Stack<T> {
	private LinkedList<T> list;
	private boolean isFixedSize;
	
	public LinkedListStack(){
		this.list=new LinkedList<T>();
		this.isFixedSize=false;
	}
	
	
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isFixedSize() {
		return isFixedSize;
	}

	@Override
	public boolean isEmpty() {
		return size()==0;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public void push(T ele) {
		list.addLast(ele);
	}

	@Override
	public T pop() {
		if(isEmpty())
			throw new EmptyStackException();
		return list.removeLast();
	}

	@Override
	public T peek() {
		if(isEmpty())
			throw new EmptyStackException();
		return list.peekLast();
	}

	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}
	
	public String toString() {
		return list.toString();
	}
}
