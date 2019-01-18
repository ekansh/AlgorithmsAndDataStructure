package algos.linkedlist;

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
}
