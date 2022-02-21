package com.dataStructure.stack;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayStack<T> implements Iterable<T>, Stack<T> {
	private T[] stack_arr;
	private int size;
	private int top=-1;
	private int capacity;
	private boolean isFixedSize;
	
	@SuppressWarnings("unchecked")
	public ArrayStack(){
		this.capacity=16;
		this.isFixedSize=false;
		this.stack_arr=(T[])new Object[capacity];
	}
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		this.capacity=capacity;
		this.isFixedSize=true;
		this.stack_arr=(T[])new Object[capacity];
	}
	
	private void increaseCapacity() {
		capacity=2*capacity;
		stack_arr=Arrays.copyOf(stack_arr, capacity);
	}
	
	public boolean isFixedSize() {
		return isFixedSize;
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
	
	public void push(T ele) {
		if(isFull() && isFixedSize) {
			throw new RuntimeException("Stack is full");
		}
		if(!(isFixedSize) && isFull()) {
			increaseCapacity();
		}
		//top++;
		stack_arr[++top]=ele;
		size++;
	}
	
	public T pop() {
		if(isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		T ele=(T)stack_arr[top];
		stack_arr[top--]=null;
		//top--;
		size--;
		return ele;
	}
	
	public T peek() {
		if(isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		return (T)stack_arr[top];
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int index=top;

			@Override
			public boolean hasNext() {
				return index!=-1;
			}

			@Override
			public T next() {
				T data=stack_arr[index--];
				return data;
			}
			
			@Override
			public void remove() {
				throw new UnsupportedOperationException("Remove");
			}
			
		};
	}
	
	public String toString() {
		StringBuilder str=new StringBuilder();
		str.append("[");
		for(int i=0;i<size-1;i++) {
			str.append(stack_arr[i]+", ");
		}
		str.append(stack_arr[size-1]+"]");
		return str.toString();
	}
	
	/*******************************************************
	 * Test
	 *
	public static void main(String[] args) {
		ArrayStack<Integer> stack1=new ArrayStack<>();
		for(int i=1;i<=16;i++) 
			stack1.push(i);
		System.out.println(stack1);
		System.out.println(stack1.isFull());
		stack1.push(17);
		//System.out.println(stack1.isFull());
		//System.out.println(stack1.capacity);
		System.out.println(stack1.size());
		System.out.println(stack1);
		ArrayStack<Character> stack2=new ArrayStack<>(5);
		stack2.push('a');
		stack2.push('b');
		stack2.push('c');
		stack2.push('d');
		stack2.push('e');
		System.out.println(stack2);
		System.out.println(stack2.isFull());
		stack2.pop();
		stack2.push('f');
		System.out.println(stack2);
		System.out.println(stack2.peek());
		for(int ele:stack1)
			System.out.println(ele);
		Iterator<Integer> iterator=stack1.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
			//if(data==15)
				//iterator.remove();
		}
	}************************************************************/

}
