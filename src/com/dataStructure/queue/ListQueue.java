package com.dataStructure.queue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListQueue<T> implements Iterable<T>,Queue<T> {
	private List<T> list;
	private int capacity;
	
	public ListQueue() {
		this.capacity=16;
		this.list=new ArrayList<>(16);
	}
	
	public ListQueue(int capacity) {
		this.capacity=capacity;
		this.list=new ArrayList<>(capacity);
	}
	
	
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return size()==0;
	}

	@Override
	public boolean isFull() {
		return size()==capacity;
	}

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public void enqueue(T ele) {
		list.add(ele);
	}

	@Override
	public void offer(T ele) {
		list.add(ele);		
	}

	@Override
	public T dequeue() {
		return list.remove(0);
	}

	@Override
	public T poll() {
		return dequeue();
	}

	@Override
	public T peek() {
		return list.get(0);
	}
	
	public String toString() {
		return list.toString();
	}
	
	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}
	
	/*******************************************************
	 * TEST
	 *
	public static void main(String[] args) {
		ListQueue<Integer> queue=new ListQueue<>();
		for(int i=1;i<=10;i++)
			queue.enqueue(i);
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue);
		queue.clear();
		System.out.println(queue);
		ListQueue<Integer> queue2=new ListQueue<>(5);
		for(int i=1;i<=5;i++)
			queue2.enqueue(i);
		System.out.println(queue2);
		Iterator<Integer> iterator=queue2.iterator();
		while(iterator.hasNext()) {
			if(iterator.next()==3)
				iterator.remove();
		}
		System.out.println(queue2);
	}**************************************************************/

	
}