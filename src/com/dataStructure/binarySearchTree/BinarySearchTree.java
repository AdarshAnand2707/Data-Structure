package com.dataStructure.binarySearchTree;

import java.util.ArrayDeque;
import java.util.Collection;

public class BinarySearchTree<T extends Comparable<T>> {
	
	private int nodeCount=0;
	private Node root=null;
	
	private class Node{
		T data;
		Node left,right;
		
		public Node(Node left,Node right,T data) {
			this.data=data;
			this.left=left;
			this.right=right;
		}
		
		public Node(T data) {
			this(null,null,data);
		}
		
		public String toString() {
			return data.toString();
		}
	}
	
	public int size() {
		return nodeCount;
	}
	
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	
	public boolean contains(T ele) {
		return contains(root,ele);
	}
	
	
	private boolean contains(Node node,T ele) {
		if(node==null)
			return false;
		int cmp=ele.compareTo(node.data);
		if(cmp<0)
			return contains(node.left,ele);
		if(cmp>0)
			return contains(node.right,ele);
		else
			return true;
	}
	
	
	public boolean add(T ele) {
		if(contains(ele))
			return false;
		else {
			root=add(root,ele);
			nodeCount++;
			return true;
		}
	}
	
	public boolean add(T[] ele) {
		for(T data:ele)
			add(data);
		return true;
	}
	
	public boolean  add(Collection<T> ele) {
		for(T data:ele)
			add(data);
		return true;
	}
	
	private Node add(Node node,T ele) {
		if(node==null)
			node=new Node(ele);
		else {
			if(ele.compareTo(node.data)<0)
				node.left=add(node.left,ele);
			else
				node.right=add(node.right,ele);
		}
		return node;
	}
	
	
	public boolean remove(T ele) {
		if(contains(ele)) {
			root=remove(root,ele);
			nodeCount--;
			return true;
		}
		return false;
	}
	
	private Node remove(Node node,T ele) {
		if(node==null)
			return null;
		int cmp=ele.compareTo(node.data);
		if(cmp<0)
			node.left=remove(node.left,ele);
		else if(cmp>0)
			node.right=remove(node.right,ele);
		else {
			if(node.left==null)
				return node.right;
			if(node.right==null)
				return node.left;
			else {
				Node temp=findMin(node.right);
				node.data=temp.data;
				node.right=remove(node.right,temp.data);
			}
		}
		return node;
	}
	
	private Node findMin(Node node) {
		while(node.left!=null)
			node=node.left;
		return node;
	}
	
	
	public int height() {
		return height(root);
	}
	
	private int height(Node node) {
		if(node==null)
			return 0;
		return Math.max(height(node.left),height(node.right))+1;
	}
	
	public void preOrderTransversal() {
		preOrderTransversal(root);
		System.out.println();
	}
	
	
	private void preOrderTransversal(Node node) {
		if(node==null)
			return;
		System.out.print(node+" ");
		preOrderTransversal(node.left);
		preOrderTransversal(node.right);
	}
	
	public void inOrderTransversal() {
		inOrderTransversal(root);
		System.out.println();
	}
	
	private void inOrderTransversal(Node node) {
		if(node==null)
			return;
		inOrderTransversal(node.left);
		System.out.print(node+" ");
		inOrderTransversal(node.right);
	}
	
	public void postOrderTransversal() {
		postOrderTransversal(root);
		System.out.println();
	}
	
	private void postOrderTransversal(Node node) {
		if(node==null)
			return;
		postOrderTransversal(node.left);
		postOrderTransversal(node.right);
		System.out.print(node+" ");
	}
	
	public void levelOrderTransversal() {
		levelOrderTransversal(root);
		System.out.println();
	}
	
	private void levelOrderTransversal(Node node) {
		if(node==null)
			return;
		ArrayDeque<Node> queue=new ArrayDeque<>();
		queue.offer(node);
		while(!queue.isEmpty()) {
			Node next=queue.poll();
			System.out.print(next.data+" ");
			if(next.left!=null)
				queue.offer(next.left);
			if(next.right!=null)
				queue.offer(next.right);
		}
	}
	
	
	public String toString() {
		StringBuilder sb=new StringBuilder("["); 
		ArrayDeque<Node> queue=new ArrayDeque<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			Node next=queue.poll();
			sb.append(next.data+", ");
			if(next.left!=null)
				queue.offer(next.left);
			if(next.right!=null)
				queue.offer(next.right);
		}
		String s=sb.toString();
		s=s.substring(0,s.length()-2);
		return s+"]";
	}
	
	
	
	
	/**
	 *Test 
	 *
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst=new BinarySearchTree<>();
		//Integer[] ele= {11,6,13,15,8,3,1,5,17,12,14,19};
		//bst.add(ele);
		bst.add(11);
		bst.add(6);
		bst.add(15);
		bst.add(3);
		bst.add(8);
		bst.add(13);
		bst.add(17);
		bst.add(1);
		bst.add(5);
		bst.add(12);
		bst.add(14);
		bst.add(19);
		System.out.println(bst.size());
		bst.inOrderTransversal();
		bst.postOrderTransversal();
		bst.preOrderTransversal();
		bst.levelOrderTransversal();
		System.out.println(bst.height());
		System.out.println(bst);
	}******************************************************************/
	
	
}
