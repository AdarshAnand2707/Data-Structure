package com.dataStructure.priorityQueue;

import java.util.List;

public interface PriorityQueue<T extends Comparable<T>> {
	
	public boolean isEmpty();
	
	public boolean isFull();
	
	public int size();
	
	public void add(T element);
	
	public void offer(T element);
	
	public T poll();
	
	public T peek();
	
	public List<T> removeAll();
	
	public String toString();
}
