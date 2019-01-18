package algos.linkedlist;

import java.util.Comparator;

import dataStructure.ListNode;

public class MergeSortedLinkListRecursive {

	public static void main(String[] args) {
		ListNode<Integer> start1 = CreateLinkedList.createLinkedList(1,3,7,15);
		TravelLinkedList.travelLinkedList(start1);
		System.out.println("");
		ListNode<Integer> start2 = CreateLinkedList.createLinkedList(4,5,6,10);
		TravelLinkedList.travelLinkedList(start2);
		System.out.println("");
		ListNode<Integer> mergeLinkedList = mergeLinkedList(start1,start2);
		TravelLinkedList.travelLinkedList(mergeLinkedList);
		System.out.println("");
	}

	public static ListNode<Integer> mergeLinkedList(ListNode<Integer> node1, ListNode<Integer> node2) {
		if (node1 == null) {
			return node2;
		} else if (node2 == null) {
			return node1;
		}else if (node1.getNext() != null && node1.getData() < node2.getData()
				&& node1.getNext().getData() > node2.getData()) {// if node2 should lie between node1 and node1.next
			ListNode<Integer> list1NodeFromNextNode = node1.getNext();
			node1.setNext(node2);
			System.out.println("node2 should lie between node1 and node1.next");
			System.out.println("List 1");
			TravelLinkedList.travelLinkedList(node1.getNext());
			System.out.println("List 2");
			TravelLinkedList.travelLinkedList(list1NodeFromNextNode);
			mergeLinkedList(node1.getNext(), list1NodeFromNextNode);
		} else if (node1.getNext() != null && node1.getData() < node2.getData()
				&& node1.getNext().getData() < node2.getData()) { // both node1 and node1.next is less than node 2, hence just move forward on node1
			System.out.println("both node1 and node1.next is less than node 2, hence just move forward on node1");
			System.out.println("List 1");
			TravelLinkedList.travelLinkedList(node1.getNext());
			System.out.println("List 2");
			TravelLinkedList.travelLinkedList(node2);
			mergeLinkedList(node1.getNext(), node2);
		}else if (node2.getNext() != null && node2.getData() < node1.getData()
				&& node2.getNext().getData() > node1.getData()) {
			ListNode<Integer> list1NodeFromNextNode = node2.getNext();
			node2.setNext(node1);
			
			System.out.println("node1 should lie between node2 and node2.next");
			System.out.println("List 1");
			TravelLinkedList.travelLinkedList(node2.getNext());
			System.out.println("List 2");
			TravelLinkedList.travelLinkedList(list1NodeFromNextNode);
			
			mergeLinkedList(node2.getNext(), list1NodeFromNextNode);
		} else if (node2.getNext() != null && node2.getData() < node1.getData()
				&& node2.getNext().getData() < node1.getData()) { // both node2 and node2.next is less than node 1, hence just move forward on node2
			System.out.println("both node2 and node2.next is less than node 1, hence just move forward on node2");
			System.out.println("List 1");
			TravelLinkedList.travelLinkedList(node2.getNext());
			System.out.println("List 2");
			TravelLinkedList.travelLinkedList(node1);
			mergeLinkedList(node2.getNext(), node1);
		}

		return node1;
	}
}
