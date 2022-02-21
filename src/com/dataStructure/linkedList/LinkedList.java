package com.dataStructure.linkedList;

public interface LinkedList<T> {
	
	/*
	 * size of the linked list
	 */
	public int size();
	
	
	/*
	 * checks if the list is empty
	 */
	public boolean isEmpty();

	
	/*
	 * add an element to the end of the list
	 */
	public void add(T data);
	
	
	/*
	 * add an element at a given index in the list
	 */
	public void add(int index,T data) throws Exception;
	
	
	/*
	 * returns the index of an element in the list
	 */
	public int indexOf(T ele) ;
	
	
	/*
	 * checks if an element is present in element
	 */
	public boolean contains(T ele) ;
	
	
	/*
	 * removes an element from the list
	 */
	public boolean remove(T ele) ;
	
	
	/*
	 * removes an element at a given index
	 */
	public T removeAt(int index) throws Exception ;
	
	
	
	/*
	 * clears all the element in the list
	 */
	public void clear() ;

}
