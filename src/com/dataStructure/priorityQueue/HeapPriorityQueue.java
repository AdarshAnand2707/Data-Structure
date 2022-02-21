package com.dataStructure.priorityQueue;

import java.util.*;

import com.dataStructure.heap.BinaryHeap;

public class HeapPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T>,Iterable<T> {
	private BinaryHeap<T> heap;
	
	public HeapPriorityQueue() {
		this(1);
	}
	
	public HeapPriorityQueue(int capacity) {
		this.heap=new BinaryHeap<>(capacity);
	}
	
	public HeapPriorityQueue(boolean isMinPriorityQueue) {
		this.heap=new BinaryHeap<>(isMinPriorityQueue);
	}
	
	public HeapPriorityQueue(int capacity,boolean isMinPriorityQueue) {
		this.heap=new BinaryHeap<>(capacity,isMinPriorityQueue);
	}
	
	public HeapPriorityQueue(T[] elements,boolean isMinPriorityQueue) {
		this.heap=new BinaryHeap<>(elements,isMinPriorityQueue);
	}
	
	public HeapPriorityQueue(T[] elements) {
		this(elements,true);
	}
	
	public HeapPriorityQueue(Collection<T> elements,boolean isMinPriorityQueue) {
		this.heap=new BinaryHeap<>(elements,isMinPriorityQueue);
	}
	
	public HeapPriorityQueue(Collection<T> elements) {
		this(elements,true);
	}
	
	
	
	public boolean isEmpty() {
		return heap.isEmpty();
	}
	
	public boolean isFull() {
		return heap.isFull();
	}
	
	public int size() {
		return heap.size();
	}
	
	public void add(T element) {
		heap.add(element);
	}
	
	public void offer(T element) {
		heap.add(element);
	}
	
	public T poll() {
		return heap.removeAt(0);
	}
	
	public T peek() {
		return heap.getRoot();
	}
	
	public List<T> removeAll(){
		return heap.removeAll();
	}
	
	public String toString() {
		return heap.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return heap.iterator();
	}
	
	/*************************************************************
	 * Test
	 *
	public static void main(String[] args) {
		HeapPriorityQueue<Integer> pq=new HeapPriorityQueue<>(true);
		pq.add(5);
		pq.add(1);
		pq.add(4);
		pq.add(3);
		pq.add(2);
		System.out.println(pq);
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq);
		Integer[] elements={6,2,5,4,3,1};
		HeapPriorityQueue<Integer> pq1=new HeapPriorityQueue<>(elements,false);
		System.out.println(pq1);
		System.out.println(pq1.poll());
		System.out.println(pq1.poll());
		System.out.println(pq1.poll());
		System.out.println(pq1);
	}*******************************************************************/
}
