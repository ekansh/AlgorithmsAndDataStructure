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
}
