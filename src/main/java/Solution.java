import java.util.*;
import java.util.stream.Stream;

 

public class Solution {

	private static class Node {
		public int val;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _next) {
			val = _val;
			next = _next;
		}

		@Override
		public String toString() {

			return "val";
		}
	}

	public static void main(String[] args) {
		Node a = new Node(3), b = new Node(4), c = new Node(1);
		a.next = b;
		b.next = c;
		c.next = a;
		Solution s = new Solution();
		print(a);
		Node node = s.insert(a, 2);
		print(node);

	}

	private static void print(Node a) {
		Node cur = a;
		do {
			System.out.print(cur + "->");
			cur = cur.next;
		} while (cur != a);
		System.out.println(cur + "->");
	}

	public Node insert(Node head, int insertVal) {
		if (head == null) {
			return new Node(insertVal);
		}
		Node cur = head.next, prev = head, newNode = new Node(insertVal);
		if (cur == null) {
			prev.next = newNode;
			newNode.next = prev;
			return head;
		}
		Node start = prev, end = cur;
		do {
			if (prev.val > cur.val) {
				start = cur;
				end = prev;
			}
			if (prev.val <= insertVal && cur.val >= insertVal) { // when cur == head and prev == null ??
				prev.next = newNode;
				newNode.next = cur;
				break;
			}
			prev = cur;
			cur = cur.next;
		} while (cur != cur);

		if (newNode.next == null) {
			end.next = newNode;
			newNode.next = start;
		}
		return head;

	}

}
