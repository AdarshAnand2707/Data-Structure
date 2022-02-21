package com.dataStructure.unionFind;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UnionFind<T> {
	private Map<T,Integer> map=new HashMap<T,Integer>();
	private int size;
	private int[] sz;
	private int[] id;
	private int numComponents;
	
	
	public UnionFind() {
		this(0);
	}
	
	public UnionFind(int size) {
		this.size=size;
		this.numComponents=size;
		this.sz=new int[size];
		this.id=new int[size];
		for(int i=0;i<size;i++) {
			id[i]=i;
			sz[i]=1;
		}
	}
	
	
	public UnionFind(Collection<T> collections) {
		this(collections.size());
		int i=0;
		for(T collection:collections)
			map.put(collection, i++);
	}
	
	public UnionFind(T[] obj) {
		this(obj.length);
		this.size=obj.length;
		for(int i=0;i<size;i++) {
			map.put(obj[i], i);
		}
	}
	
	

	public T getKey(int val) {
		Set<Map.Entry<T, Integer>> mappings=map.entrySet();
		T data=null;
		for(Map.Entry<T, Integer> mapping:mappings) {
			if(mapping.getValue()==val) {
				data=mapping.getKey();
				break;
			}
		}
		/*Set<T> keys=map.keySet();
		int i=0;
		for(T key:keys) {
			if(i==val) {
				data=key;
				break;
			}
			i++;
		}*/
		return data;
	}
	
	public void add(T ele) {
		if(map.containsKey(ele))
			return;
		map.put(ele, size);
		size=map.size();
		numComponents=size;
		sz=new int[size];
		id=new int[size];
		for(int i=0;i<size;i++) {
			id[i]=i;
			sz[i]=1;
		}
	}
	
	
	public T find(T ele) {
		return find(map.get(ele));
	}
	
	public T find(int p) {
		int root=p;
		while(root!=id[root])
			root=id[root];
		while(p!=root) {
			int next=id[p];
			id[p]=root;
			p=next;
		}
		return getKey(root);
	}
	
	
	public boolean connected(T p,T q) {
		return find(p).equals(find(q));
	}
	
	public void union(T p,T q) {
		if(connected(p,q))
			return;
		union(map.get(p),map.get(q));
	}
	
	public void union(int p,int q) {
		int root1=map.get(find(p));
		int root2=map.get(find(q));
		if(sz[root1]<sz[root2]) {
			sz[root2]+=sz[root1];
			id[root1]=root2;
			sz[root1]=0;
		} else {
			sz[root1]+=sz[root2];
			id[root2]=root1;
			sz[root2]=0;
		}
		numComponents--;
	}
	
	public int componentSize(T p) {
		return sz[map.get(find(p))];
	}
	
	public int numberOfComponent() {
		return numComponents;
	}

	public String toString() {
		StringBuilder str=new StringBuilder("{");
		Set<Map.Entry<T, Integer>> mappings=map.entrySet();
		for(Map.Entry<T, Integer> mapping:mappings) {
			str.append(mapping.getKey()+"=");
			str.append(id[mapping.getValue()]+", ");
		}
		String s=str.toString();
		s=s.substring(0,s.length()-2);
		return s+"}";
	}
	
	/***********************************************************
	 * Test
	 */
	public static void main(String[] args) {
		UnionFind<String> uf=new UnionFind<String>();
		uf.add("E");
		uf.add("F");
		uf.add("I");
		uf.add("D");
		uf.add("C");
		uf.add("A");
		uf.add("J");
		uf.add("L");
		uf.add("G");
		uf.add("K");
		uf.add("B");
		uf.add("H");
		uf.add("A");
		uf.union("C","K");
		uf.union("F","E");
		uf.union("A","J");
		uf.union("A","B");
		uf.union("C","D");
		uf.union("D","I");
		uf.union("L","F");
		uf.union("C","A");
		uf.union("A","B");
		uf.union("H","G");
		uf.union("H","F");
		uf.union("H","B");
		System.out.println(uf);
		System.out.println(uf.find("A"));
		System.out.println(uf.connected("H", "G"));
		ArrayList<Integer> arr=new ArrayList<Integer>();
		for(int i=0;i<11;i++)
			arr.add(i);
		UnionFind<Integer> uf1=new UnionFind<Integer>(arr);
		System.out.println(uf1);
	}//***********************************************************/
	
}
