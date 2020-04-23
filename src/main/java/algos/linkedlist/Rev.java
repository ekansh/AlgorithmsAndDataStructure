package algos.linkedlist;

import java.util.Arrays;

public class Rev {
	public static void main_(String[] p) {
	 
		int n = 12;
		if (n == 0)
			return;
		if (n == 1)
			return;
		int dp[] = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= (int) Math.sqrt(i); j++) {
				dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
			}
		System.out.println(dp[n]);

	}

	public static void main(String[] args) {
		N a = new N(1);
		N b = new N(2);
		N c = new N(3);
		N d = new N(4);
		N e = new N(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		System.out.println("Inital list");
		print(a);
//		doRecursvieReverse(a);
//		doItterativeReverse(a);
		N copy=copyLinkedList(a);
		System.out.println("copied linked list");
		print(copy);
	}

	private static N copyLinkedList(N a) {
		if(a== null) return null;
		N x= new N(a.v);
		x.next =copyLinkedList(a.next);
		return x;
	}

	private static void doItterativeReverse(N cur) {
		N prev = null;// 1 2 3 4 5
		while (cur != null) {
			N next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		System.out.println("after itterative reverse list");
		print(prev);

	}

	private static void doRecursvieReverse(N a) {
		N h = reverse(a);
		System.out.println("after recursive reverse list");
		print(h);
	}

	public static void print(N cur) {
		System.out.println("---------------");
		int i = 0;
		while (i++ < 10 && cur != null) {
			System.out.print("|" + cur.v + "|->");
			cur = cur.next;
		}
		System.out.println();
	}

	private static N reverse(N a) {
		if (a == null || a.next == null)
			return a;
		N reverse = reverse(a.next);
		a.next.next = a;
		a.next = null;
		return reverse;
	}
}

class N {
	int v;
	N next;

	N(int k) {
		v = k;
	}
}