package com.dataStructure.linkedList;
import java.util.Iterator;

public class SinglyLinkedList<T> implements Iterable<T>,LinkedList<T> {
	private Node<T> head = null;
	private Node<T> tail=null;
	private int size=0;
	
	private static class Node<T> {
		private T data;
		private Node<T> next = null;
		
		public Node(T data,Node<T> next){
			this.data=data;
			this.next=next;
		}
		
		public Node(T data) {
			this(data,null);
		}
		
		public String toString() {
			return data.toString();
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size()==0;
	}

	public void add(T data) {
		addLast(data);
	}
	
	public void addLast(T data) {
		if(isEmpty()) {
			head=tail=new Node<T>(data);
		} else {
			tail.next=new Node<T>(data);
			tail=tail.next;
		}
		size++;
	}
	
	public void addFirst(T data) {
		if(isEmpty()) {
			head=tail=new Node<T>(data);
		} else {
			Node<T> n=new Node<T>(data,head.next);
			head=n;
		}
		size++;
	}
	
	public void add(int index,T data) throws Exception {
		if(index<0 || index>size)
			throw new Exception("Illeagal index");
		if(index==0) {
			addFirst(data);
			return;
		}
		if(index==size) {
			addLast(data);
			return;
		}
		Node<T> trav=head;
		for(int i=0;i<index-1;i++) {
			trav=trav.next;
		}
		Node<T> n=new Node<T>(data);
		n.next=trav.next;
		trav.next=n;
		size++;
	}
	
	public void addAt(int index,T data) throws Exception {
		add(index,data);
	}
	
	
	public int indexOf(T ele) {
		int index=0;
		Node<T> trav=head;
		if(ele==null) {
			for(;trav!=null;trav=trav.next,index++) {
				if(trav.data==null)
					return index;
			}
		} else {
			for(;trav!=null;trav=trav.next,index++) {
				if(ele.equals(trav.data))
					return index;
			}
		}
		return -1;
	}
	
	public boolean contains(T ele) {
		return indexOf(ele)!=-1;
	}
	
	public T removeFirst() {
		T data=head.data;
		head=head.next;
		size--;
		if(isEmpty())
			tail=null;
		return data;
	}
	
	public boolean remove(T ele) {
		if(isEmpty())
			throw new RuntimeException("List is Empty");
		if(!contains(ele))
			return false;
		Node<T> trav=head;
		if(ele==null) {
			if(head.data==null) {
				removeFirst();
				return true;
			} else {
				while(trav.next.data!=null) {
					trav=trav.next;
				}
				Node<T> temp=trav.next.next;
				trav.next=temp;
			}
		} else {
			if(ele.equals(head.data)) {
				removeFirst();
				return true;
			} else {
				while(!ele.equals(trav.next.data)) {
					trav=trav.next;
				}
				Node<T> temp=trav.next.next;
				trav.next=temp;
			}
		}
		size--;
		return true;
	}
	
	
	public T removeAt(int index) throws Exception {
		if(index<0 || index>size)
			throw new Exception("Illeagal index");
		if(index==0) {
			return removeFirst();
		}
		Node<T> trav=head;
		for(int i=0;i<index;i++) {
			trav=trav.next;
		}
		T data=trav.data;
		remove(trav.data);
		return data;
	}
	
	
	public void clear() {
		Node<T> trav=head;
		while(trav!=null) {
			Node<T> nextNode=trav.next;
			trav.next=null;
			trav.data=null;
			trav=nextNode;
		}
		head=tail=trav=null;
		size=0;
	}
	
	@Override
	public String toString() {
		if(isEmpty()) {
			return "[]";
		}
		Node<T> trav=head;
		StringBuilder sb=new StringBuilder("[");
		for(int i=0;i<size()-1;i++) {
			sb.append(trav+", ");
			trav=trav.next;
		}
		return sb.append(trav+"]").toString();
	}
	

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			Node<T> trav=head;
			
			@Override
			public boolean hasNext() {
				return trav!=null;
			}

			@Override
			public T next() {
				T data=trav.data;
				trav=trav.next;
				return data;
			}
			
			@Override
			public void remove() {
				throw new UnsupportedOperationException("remove");
			}
		};
	}
	
	/******************************************************************
	 * test
	 * 
	public static void main(String[] args) throws java.lang.Exception {
		SinglyLinkedList<Integer> list=new SinglyLinkedList<Integer>();
		list.add(1);
		list.add(2);
		for(int i=0;i<5;i++)
			list.add(i);
		list.remove(3);
		list.removeAt(1);
		list.add(1,4);
		//list.print();
		System.out.println("list: "+list);
		System.out.println(list.size);
		for(int data:list)
			System.out.println(data);
	}
	*******************************************************************/
}
