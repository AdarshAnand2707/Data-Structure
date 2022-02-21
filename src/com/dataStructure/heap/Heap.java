package com.dataStructure.heap;

import java.util.List;

public interface Heap<T extends Comparable<T>> {
	
	public int size();
	
	public boolean isEmpty();
	
	public boolean isFull();
	
	public void add(T ele);
	
	public int indexOf(T ele);
	
	public T getRoot();
	
	public T removeAt(int i);
	
	public void remove(T ele);
	
	public List<T> removeAll();
	
	public String toString();
}
