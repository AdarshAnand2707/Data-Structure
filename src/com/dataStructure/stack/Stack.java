package com.dataStructure.stack;


public interface Stack<T> {
	
	public int size();
	
	public boolean isFixedSize();
	
	public boolean isEmpty();
	
	public boolean isFull();
	
	public void push(T ele);
	
	public T pop();
	
	public T peek();

}
