package algos.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

import dataStructure.ListNode;

public class CreateLinkedList {
	public static ListNode<Integer> createLinkedList(Integer ...integers ){
		ListNode<Integer> start= null ;
		ListNode<Integer> previous = start;
		for (Integer integer : integers) {
			ListNode<Integer> temp =new ListNode<Integer>(integer);
			if (previous != null){
				previous.setNext(temp);
			}
			if( start== null){
				start=temp;
			}
			previous= temp;
		}
		return start;
		
	}
	public static <T> ListNode<T> createLinkedList(T ...ts){
		ListNode<T> start= null ;
		ListNode<T> previous = start;
		for (T t : ts) {
			ListNode<T> temp =new ListNode<T>(t);
			if (previous != null){
				previous.setNext(temp);
			}
			if( start== null){
				start=temp;
			}
			previous= temp;
		}
		return start;
		
	}
	public static void main(String[] args) {
		createLinkedList(null);
	}
}
