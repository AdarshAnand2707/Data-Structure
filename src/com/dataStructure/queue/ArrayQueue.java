package com.dataStructure.queue;

import java.util.Iterator;

public class ArrayQueue<T> implements Queue<T>,Iterable<T> {
	private T[] arr;
	private int front;
	private int back;
	private int size;
	private int capacity;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(){
		this.capacity=16;
		this.arr=(T[])new Object[capacity];
		this.front=0;
		this.back=-1;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity) {
		this.capacity=capacity;
		this.arr=(T[])new Object[capacity];
		this.front=0;
		this.back=-1;
	}
	
	
	public int size() {
		return size;
	}
	
	
	public boolean isEmpty() {
		return size==0;
	}
	
	
	public boolean isFull() {
		return size==capacity;
	}
	
	public void clear() {
		if(isEmpty())
			throw new RuntimeException("Queue is Empty");
		for(int i=0;i<size;i++)
			dequeue();
		size=0;
		front=0;
		back=-1;
	}
	
	
	public void enqueue(T ele) {
		if(isFull())
			throw new RuntimeException("Queue is full");
		back++;
		back=back%capacity;
		arr[back]=ele;
		size++;
	}
	
	
	public void offer(T ele) {
		enqueue(ele);
	}
	
	
	public T dequeue() {
		if(isEmpty())
			throw new RuntimeException("Queue is Empty");
		T ele=(T)(arr[front]);
		arr[front]=null;
		front++;
		front=front%capacity;
		size--;
		return ele;
	}
	
	
	public T poll() {
		return dequeue();
	}
	
	
	public T peek() {
		if(isEmpty()) {
			throw new RuntimeException("Queue is Empty");
		}
		return (T)arr[front];
	}
	
	
	public String toString() {
		if(isEmpty())
			return "[]";
		StringBuilder str=new StringBuilder();
		str.append("[");
		int index=front;
		while(index!=back) {
			str.append(arr[index]);
			str.append(", ");
			index++;
			index=index%capacity;
		}
		str.append(arr[back]);
		str.append("]");
		return str.toString();
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int index=front;
			int count=1;
			
			@Override
			public boolean hasNext() {
				return count<=size;
			}

			@Override
			public T next() {
				T data=arr[index];
				index++;
				count++;
				index=index%capacity;
				return data;
			}
			
			@Override
			public void remove() {
				throw new UnsupportedOperationException("Remove");
			}
			
		};
	}
	
	/***************************************************
	 * TEST
	 *
	public static void main(String[] args) {
		ArrayQueue<Integer> queue=new ArrayQueue<>();
		for(int i=1;i<=5;i++)
			queue.enqueue(i);
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue);
		queue.enqueue(17);
		queue.enqueue(18);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue);
		System.out.println(queue.isFull());
		ArrayQueue<Character> queue2=new ArrayQueue<>(5);
		queue2.enqueue('a');
		queue2.enqueue('b');
		queue2.enqueue('c');
		queue2.enqueue('d');
		queue2.enqueue('e');
		System.out.println(queue2);
		System.out.println(queue2.dequeue());
		queue2.enqueue('f');
		queue2.dequeue();
		queue2.enqueue('h');
		System.out.println(queue2);
		System.out.println(queue2.isFull());
		for(int i:queue)
			System.out.println(i);
		Iterator<Integer> iterator=queue.iterator();
		while(iterator.hasNext())
			System.out.println(iterator.next());
	}******************************************************/

	
}
