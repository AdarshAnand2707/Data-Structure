package com.dataStructure.dynamicArray;
import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T> {
	private T[] arr;
	private int capacity;
	private int length=0;
	
	public DynamicArray() {
		this(16);
	}
	
	
	@SuppressWarnings("unchecked")
	public DynamicArray(int capacity) {
		this.capacity=capacity;
		this.arr= (T[])new Object[capacity];
	}
	
	
	public int size() {
		return length;
	}
	
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	
	public T get(int index) {
		if(index>=length || index<0)
			throw new IndexOutOfBoundsException();
		return arr[index];
	}
	
	
	public void set(int index, T element) {
		if(index>=length || index<0)
			throw new IndexOutOfBoundsException();
		arr[index]=element;
	}
	
	public void add(T element) {
		if(length+1>=capacity) {
			if(capacity==0)
				capacity=2;
			else
				capacity*=2;
			@SuppressWarnings("unchecked")
			T[] temp_arr=(T[])new Object[capacity];
			for(int i=0;i<length;i++)
				temp_arr[i]=arr[i];
			arr=temp_arr;
		}
		arr[length++]=element;
	}
	
	public void addAll(T[] arr_add) {
		for(T element: arr_add)
				add(element);
	}
	
	public void addAll(DynamicArray<T> new_darr) {
		T[] temp_arr=(T[]) new_darr.arr;
		for(int i=0;i<new_darr.length;i++) {
			add(temp_arr[i]);
		}
	}
	
	public T removeAt(int index) {
		if(index>=length || index<0)
			throw new IndexOutOfBoundsException();
		if((length-1)<(capacity/2))
			capacity=capacity/2;
		@SuppressWarnings("unchecked")
		T[] temp_arr=(T[])new Object[capacity];
		T data=arr[index];
		for(int i=0,j=0;i<length;i++,j++) {
			if(i==index) {
				j--;
			}
			else
				temp_arr[j]=arr[i];
		}
		this.arr=temp_arr;
		length--;
		return data;
	}
	
	public boolean remove(T element) {
		int index=indexOf(element);
		if(index==-1)
			return false;
		removeAt(index);
		return true;
	}
	
	public void clear() {
		for(int i=0;i<length;i++)
			arr[i]=null;
		length=0;
	}
	
	public int indexOf(T element) {
		for(int i=0;i<length;i++) {
			if(element == null && arr[i]==null) {
				return i;
			} else {
				if(element.equals(arr[i]))
						return i;
			}
		}
		return -1;
	}
	
	public boolean contains(T element) {
		return indexOf(element)!=-1;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int index=0;
			
			@Override
			public boolean hasNext() {
				return index<length;
			}

			@Override
			public T next() {
				return arr[index++];
			}
			
			@Override
			public void remove() {
				throw new UnsupportedOperationException("remove");
			}
			
		};
	}
	
	@Override
	public String toString() {
		if(length==0)
			return "[]";
		else {
			StringBuilder sb= new StringBuilder("[");
			for(int i=0;i<length-1;i++)
				sb.append(arr[i]+", ");
			return sb.append(arr[length-1]+"]").toString();
		}
	}
	
	/***************************************************************
	 * Test
	 * 
	public static void main(String[] args) {
		DynamicArray<Integer> darr=new DynamicArray<>();
		DynamicArray<Integer> darr1=new DynamicArray<>();
		for(int i=1;i<=5;i++)
			darr.add(i);
		for(int i=6;i<=9;i++)
			darr1.add(i);
		darr.addAll(darr1);
		System.out.println("darr.length= "+darr.length);
		System.out.println("darr.capacity= "+darr.capacity);
		System.out.println("darr1.length= "+darr1.length);
		darr.clear();
		System.out.println(darr.capacity);
	}****************************************************/

}
