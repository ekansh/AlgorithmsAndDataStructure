package algos.linkedlist;

import dataStructure.ListNode;

public class TravelLinkedList {
	public static <T> void travelLinkedList(ListNode<T> start){
		if (start == null ){
				System.out.println("");
				return ;
				
		}else{
			System.out.print(" -> "+start.getData());
			 travelLinkedList(start.getNext());
		}
	}
	public static <T> void travelLinkedList(ListNode<T> start, int len){
		if (start == null || len  ==0 ){
				System.out.println("");
				return ;
				
		}else{
			System.out.print(" -> "+start.getData());
			 travelLinkedList(start.getNext(), len-1);
		}
	}
}
