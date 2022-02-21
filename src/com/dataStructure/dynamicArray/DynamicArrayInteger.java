package com.dataStructure.dynamicArray;


public class DynamicArrayInteger {
	int capacity=2;
	int[] arr=new int[capacity];
	int numbElements=0;
	
	void add(int data) {
		if(numbElements<capacity) {
			numbElements++;
			arr[numbElements-1]=data;
		} else {
			int newCapacity=(int)(1.5*capacity);
			int[] newArr=new int[newCapacity];
			for(int i=0;i<capacity;i++) {
				newArr[i]=arr[i];
			}
			this.arr=newArr;
			this.capacity=newCapacity;
			numbElements++;
			arr[numbElements-1]=data;
		}
	}
	
	
	int get(int i) {
		if(i>=numbElements) {
			System.out.println("Index out of bound for the array of size "+numbElements);
			return Integer.MIN_VALUE;
		} else {
			return arr[i];
		}
	}
	
	
	void print() {
		for(int i=0;i<numbElements;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
		
	boolean isEmpty() {
		if(numbElements==0)
			return true;
		else
			return false;
	}
	
	int size() {
		return numbElements;
	}
	
	void set(int index,int element) {
		if(index<numbElements) {
			arr[index]=element;
		} else {
			System.out.println("Index out of bound for the array of size "+numbElements);
		}
	}
	
	void removeAt(int index) {
		for(int i=0;i<numbElements-1;i++) {
			if(i>=index)
				arr[i]=arr[i+1];
		}
		numbElements--;
	}
	
	void clear() {
		for(int i=0;i<numbElements;i++)
			arr[i]=0;
		numbElements=0;
	}
	
	boolean contains(int data) {
		if(search(data)==-1) {
			return false;
		} else {
			return true;
		}
	}
	
	int search(int data) {
		for(int i=0;i<numbElements;i++) {
			if(arr[i]==data) {
				return i;
			}
		}
		//System.out.println("Not found");
		return -1;
	}
	
	/***********************************************************
	 * Test
	 * 
	 *
	public static void main(String[] args) {
		DynamicArrayInteger arr=new DynamicArrayInteger();
		for(int i=0;i<=8;i++) {
			arr.add(i);
		}
		arr.print();
		System.out.println(arr.size());
		arr.set(3, 10);
		arr.print();
		arr.removeAt(5);
		arr.print();
		System.out.println(arr.contains(7));
		arr.clear();
		System.out.println(arr.size());
	}****************************************************************/

}
