package com.example.ds;

public class LinkLOp {
	Node head;
	public class Node{
		Node next;
		int data;
	}
	public Node getNode(int val){
		Node node = new Node();
		node.data = val;
		node.next = null;
		return node;
	}
	public Node insertBegin(int val)
	{
		Node newNode = getNode(val);
		if(head!=null){
			newNode.next = head;
			head = newNode;
			
		}
		else{
			head = newNode;
		}
		return head;
	}
	public Node insertEnd(int val)
	{
		Node newNode = getNode(val);
		Node iter = head;
		while(iter.next!=null)
		{
			iter = iter.next; 
		}
		iter.next = newNode;
		return head;
	}
	
	public void displayList()
	{
		Node iter = head;
		while(iter!=null)
		{
			System.out.print("-->");
			System.out.print(iter.data);
			iter = iter.next; 
		}
	}
	public Node reverse()
	{
		Node parent = head;
		Node curr = head;
		Node rev=null;
		while(curr!=null){
			parent = curr;
			curr = curr.next;
			parent.next=rev;
			rev = parent;
			
		}
		head = rev;
		return head;
	}
	public static void main(String[] args){
		LinkLOp list = new LinkLOp();
		list.insertBegin(10);
		list.insertBegin(20);
		list.insertBegin(1);
		list.insertEnd(6);
		list.displayList();
		list.reverse();
		list.displayList();
	}
}