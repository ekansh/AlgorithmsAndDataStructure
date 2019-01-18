package algos.linkedlist;

import java.util.Comparator;

import dataStructure.ListNode;

public class MergeSortedLinkList {
	
	public static void main(String[] args) {
		
	}
	public <T> ListNode<T> mergeLinkedList(ListNode<T> node1, ListNode<T> node2){
		if (node1== null){
			return node2;
		} else if (node2== null){
			return node1;
		}
		if(node1.getNext().getData()> node2.getData()){
			ListNode<T>	node1new = node1.getNext();
			node1.setNext(node2);
			return mergeLinkedList(node1new, node2);
		}
		if(node2.getNext().getData()> node1.getData()){
			ListNode<T>	node1new = node1.getNext();
			node1.setNext(node2);
			return mergeLinkedList(node1new, node2);
		}
		
		return null;
	}
}
