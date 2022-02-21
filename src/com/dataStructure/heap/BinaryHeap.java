package com.dataStructure.heap;
import java.util.*;

public class BinaryHeap<T extends Comparable<T>> implements Heap<T>,Iterable<T> {
	private List<T> heap;
	private int capacity;
	private boolean isminHeap;
	
	public BinaryHeap(){
		this(1);
	}
	
	public BinaryHeap(int capacity) {
		this.capacity=capacity;
		this.heap=new ArrayList<T>(capacity);
		this.isminHeap=true;
	}
	
	public BinaryHeap(boolean isminHeap) {
		this();
		this.isminHeap=isminHeap;
	}
	
	public BinaryHeap(int capacity,boolean isminHeap) {
		this(capacity);
		this.isminHeap=isminHeap;
	}
	
	public BinaryHeap(T[] elements,boolean isminHeap) {
		int heapsize=elements.length;
		List<T> heap=new ArrayList<>(heapsize);
		for(int i=0;i<heapsize;i++)
			heap.add(elements[i]);
		this.isminHeap=isminHeap;
		this.heap=heap;
		for(int i=Math.max(0, (heapsize/2)-1);i>=0;i--) {
			sink(i);
		}
	}
	
	public BinaryHeap(T[] elements) {
		this(elements,true);
	}
	
	public BinaryHeap(Collection<T> elements,boolean isminHeap) {
		int heapsize=elements.size();
		List<T> heap=new ArrayList<>(heapsize);
		heap.addAll(elements);
		this.isminHeap=isminHeap;
		this.heap=heap;
		for(int i=Math.max(0, (heapsize/2)-1);i>=0;i--) {
			sink(i);
		}
	}
	
	public BinaryHeap(Collection<T> elements) {
		this(elements,true);
	}
	
	
	
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public boolean isFull() {
		return heap.size()==capacity;
	}
	
	public int size() {
		return heap.size();
	}
	
	public void add(T ele) {
		if(ele==null) {
			throw new IllegalArgumentException();
		}
		heap.add(ele);
		int indexOfLastEle=size()-1;
		swim(indexOfLastEle);
	}
	
	public int indexOf(T ele) {
		return heap.indexOf(ele);
	}
	
	public T getRoot() {
		return heap.get(0);
	}
	
	public T removeAt(int i) {
		if(isEmpty())
			throw new RuntimeException("Heap is empty");
		T ele=heap.get(i);
		int lastIndex=size()-1;
		swap(i,lastIndex);
		heap.remove(lastIndex);
		if(i==lastIndex)
			return ele;
		sink(i);
		if(heap.get(i).equals(ele))
			swim(i);
		return ele;
	}
	
	public void remove(T ele) {
		if(ele==null)
			throw new IllegalArgumentException();
		for(int i=0;i<size();i++) {
			if(ele.equals(heap.get(i))) {
				removeAt(i);
			}
		}
	}
	
	public List<T> removeAll() {
		List<T> temp=new ArrayList<T>();
		for(int i=0;i<size();i++) {
			temp.add(removeAt(0));
		}
		return temp;
	}
	
	private boolean less(int i,int j) {
		T node1=heap.get(i);
		T node2=heap.get(j);
		return node1.compareTo(node2)<=0;
	}
	
	private boolean more(int i,int j) {
		T node1=heap.get(i);
		T node2=heap.get(j);
		return node1.compareTo(node2)>=0;
	}
	
	private void swap(int i,int j) {
		if(i==j)
			return;
		T temp_i=heap.get(i);
		T temp_j=heap.get(j);
		heap.set(i, temp_j);
		heap.set(j, temp_i);
	}
	
	private void swim(int k) {
		if(k==0) {
			return;
		}
		int parent=(k-1)/2;
		while(k>0 && ((isminHeap && less(k,parent)) || (!isminHeap && more(k,parent)))) {
			swap(parent,k);
			k=parent;
			parent=(k-1)/2;
		}
	}
	
	private void sink(int k) {
		int heapsize=size();
		while(true) {
			int left=2*k+1;
			int right=2*k+2;
			int toSwap=left;
			if(right<heapsize && ((isminHeap && less(right,left)) || (!isminHeap && more(right,left)))) {
				toSwap=right;
			}
			if(left>=heapsize || ((isminHeap && less(k,toSwap)) || (!isminHeap && more(k,toSwap))))
				break;
			swap(toSwap,k);
			k=toSwap;
		}
	}
	
	public String toString() {
		return heap.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return heap.iterator();
	}

	
	/**************************************************************
	 * Test
	 *
	public static void main(String[] args) {
		BinaryHeap<Integer> heap=new BinaryHeap<>(true);
		heap.add(5);
		heap.add(2);
		heap.add(3);
		heap.add(4);
		heap.add(1);
		heap.add(6);
		System.out.println(heap);
		System.out.println(heap.removeAt(2));
		System.out.println(heap);
		Integer[] elements= {1,2,4,6,7,5,8,9,0};
		BinaryHeap<Integer> heap2=new BinaryHeap<>(elements,false);
		//heap2.addAll(elements);
		System.out.println(heap2);
		System.out.println(heap2.indexOf(1));
	}****************************************************************/
	
}
