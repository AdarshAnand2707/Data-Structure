package com.dataStructure.linkedList;
import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T>,LinkedList<T> {
	private Node<T> head=null;
	private Node<T> tail=null;
	private int size=0;
	
	private static class Node<T>{
		private T data;
		private Node<T> next;
		private Node<T> prev;
		
		
		public Node(T data, Node<T> next, Node<T> prev) {
			this.data=data;
			this.next=next;
			this.prev=prev;
		}
		
		public Node(T data){
			this(data,null,null);
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
	
	public void addFirst(T data) {
		if(isEmpty()) {
			head=tail=new Node<T>(data);
		} else {
			head.prev=new Node<T>(data);
			head.prev.next=head;
			head=head.prev;
		}
		size++;
	}
	
	public void addLast(T data) {
		if(isEmpty()) {
			head=tail=new Node<T>(data);
		} else {
			tail.next=new Node<T>(data);
			tail.next.prev=tail;
			tail=tail.next;
		}
		size++;
	}
	
	public void add(T data) {
		addLast(data);
	}
	
	public void add(int index,T data) throws Exception {
		if(index<0 || index>size)
			throw new Exception("Illegal index");
		if(index==0){
			addFirst(data);
			return;
		}
		if(index==size) {
			addLast(data);
			return;
		}
		Node<T> trav=head;
		for(int i=0;i<index-1;i++)
			trav=trav.next;
		Node<T> n=new Node<T>(data,trav.next,trav);
		trav.next.prev=n;
		trav.next=n;
		size++;
	}
	
	
	public int indexOf(T data) {
		Node<T> trav=head;
		int index=0;
		if(data==null) {
			for(;trav!=null;index++,trav=trav.next) {
				if(trav.data==null)
					return index;
			}
		}else {
			for(;trav!=null;index++,trav=trav.next) {
				if(data.equals(trav.data))
					return index;
			}
		}
		return -1;
	}
	
	
	public boolean contains(T data) {
		return indexOf(data)!=-1;
	}
	
	public T removeFirst() {
		if(isEmpty())
			throw new RuntimeException("List is Empty");
		T data=head.data;
		head.data=null;
		head=head.next;
		size--;
		if(isEmpty())
			tail=null;
		head.prev=null;
		return data;
	}
	
	public T removeLast() {
		if(isEmpty())
			throw new RuntimeException("List is Empty");
		T data=tail.data;
		tail=tail.prev;
		size--;
		if(isEmpty())
			head=null;
		tail.next=null;
		return data;
	}
	
	public T remove(Node<T> node) {
		if(node.prev==null)
			return removeFirst();
		if(node.next==null)
			return removeLast();
		T data=node.data;
		node.prev.next=node.next;
		node.next.prev=node.prev;
		node.data=null;
		node=node.next=node.prev=null;
		size--;
		return data;
	}
	
	
	public boolean remove(T ele) {
		if(isEmpty())
			throw new RuntimeException("List is Empty");
		if(ele==null) {
			for(Node<T> trav=head;trav!=null;trav=trav.next) {
				if(trav.data==null) {
					remove(trav);
					return true;
				}
			}
		} else {
			for(Node<T> trav=head;trav!=null;trav=trav.next) {
				if(ele.equals(trav.data)) {
					remove(trav);
					return true;
				}
			}
		}
		return false;
	}
	
	
	public T removeAt(int index) throws Exception {
		if(index<0 || index>size-1)
			throw new Exception("Illegal index");
		int i;
		Node<T> trav;
		if(index<size/2) {
			for(i=0,trav=head;i!=index;i++)
				trav=trav.next;
		} else {
			for(i=size-1,trav=tail;i!=index;i--)
				trav=trav.prev;
		}
		return remove(trav);
	}
	
	
	public void clear() {
		if(isEmpty())
			throw new RuntimeException("List is Empty");
		Node<T> trav=head;
		for(int i=0;i<size();i++) {
			Node<T> temp=trav.next;
			trav.data=null;
			trav.next=trav.prev=null;
			trav=temp;
		}
		head=tail=null;
		size=0;
	}
	

	public String toString() {
		if(isEmpty()) {
			return "[]";
		} else {
			Node<T> trav=head;
			StringBuilder sb=new StringBuilder("[");
			for(int i=0;i<size()-1;trav=trav.next,i++)
				sb.append(trav+", ");
			return sb.append(trav+"]").toString();
		}
	}
	
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){
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
				DoublyLinkedList.this.remove(trav.prev);
			}
			
		};
	}
	
	/******************************************************************
	 * test
	 *
	public static void main(String[] args) throws java.lang.Exception {
		DoublyLinkedList<Integer> list=new DoublyLinkedList<>();
		for(int i=1;i<=10;i++)
			list.add(i*10);
		System.out.println(list);
		list.remove(30);
		list.removeAt(1);
		list.add(1,30);
		System.out.println("list: "+list);
		System.out.println(list.size);
		for(int data:list)
			System.out.println(data);
		Iterator<Integer> iterator=list.iterator();
		while(iterator.hasNext()) {
			int data=iterator.next();
			if(data==70)
				iterator.remove();
		}
		System.out.println(list);
	}
	*******************************************************************/
}
