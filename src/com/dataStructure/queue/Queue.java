package com.dataStructure.queue;

public interface Queue<T> {
	
	public int size();
	
	public boolean isEmpty();
	
	public boolean isFull();
	
	public void clear();
	
	public void enqueue(T ele);
	
	public void offer(T ele);
	
	public T dequeue();
	
	public T poll();
	
	public T peek();
	
}
