package algos.linkedlist;

import java.util.List;

import dataStructure.ListNode;
/**
 * reorder linked list 
 * 1 >2>3>4>5
 * 1>5>2>4>3
 * @author Ekansh
 *
 */
public class LinkedListReorder {
	public static void main(String[] args) {
		LinkedListReorder sol = new LinkedListReorder();
		ListNode l = CreateLinkedList.createLinkedList(1, 2, 3, 4);
		sol.reorderList(l);
	}
	ListNode h= null;
	public void reorderList(ListNode head) {
		
		if (head == null || head.next == null)
			return;
		h = head;
		ListNode endOfFirstHalf = getEndOfFirstHalf(head); // 1 2 3 4 (2)
		ListNode reversed = reverse(endOfFirstHalf.next); // 1 2 4 3
		endOfFirstHalf.next = reversed;// 1>2>4>3 | 1>2>3
		reorderList(head, reversed);
		TravelLinkedList.travelLinkedList(head,6);

	}

	private void reorderList(ListNode f, ListNode l) {
		while (l != null) {
			
			ListNode nextF = f.next;
			ListNode nextL = l.next;
			f.next = l;
			TravelLinkedList.travelLinkedList(h,6);
			l.next = nextF;
			TravelLinkedList.travelLinkedList(h,6);
			f = nextF;
			l = nextL;
		}
//		f.next = l;
		TravelLinkedList.travelLinkedList(h,6);
		TravelLinkedList.travelLinkedList(f,6);
		TravelLinkedList.travelLinkedList(l,6);
		
	}

	private ListNode reverse(ListNode c) {
		if (c == null || c.next == null)
			return c;
		ListNode h = reverse(c.next);
		c.next.next = c;
		c.next = null;
		return h;
	}

	private ListNode getEndOfFirstHalf(ListNode l) {
		ListNode p = l, s = l, f = l;
		while (f != null && f.next != null) {
			p = s;
			s = s.next;
			f = f.next.next;
		}
		return f == null ? p : p.next;
		// 1 >2 >3 :s =2 , p=1,f=3, return 2
		// 1 >2 >3>4 :s =3 , p=2,f=-,return 2
	}
}
