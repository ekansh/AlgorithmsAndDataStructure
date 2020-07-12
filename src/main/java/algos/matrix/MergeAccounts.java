package algos.matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import algos.linkedlist.CreateLinkedList;
import dataStructure.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class MergeAccounts {

	public static void main(String[] args) {
//		boolean s = new  Solution().canFinish(4, new int[][] {{1,0},{1,2},{2,3},
//			{3,5},{3,4},{4,5},{5,1}});
//		int s = new Solution().shortestPathBinaryMatrix(new int[][] { { 0, 0, 0 }, { 1, 0, 0 }, { 1, 1, 0 } });
		int s = new Solution().shortestPathBinaryMatrix(new int[][] { { 1, 2,7 }, { 3,4,8 },{5,6,9}});
		System.out.println(s);
	}
}

class Solution {
	int dir[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };

	public int shortestPathBinaryMatrix(int[][] grid) {
//		if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1)
//			return -1;

		boolean seen[][] = new boolean[grid.length][grid[0].length];
		Queue<int[]> q = new LinkedList<>();
		int len = 0;
		q.offer(new int[] { 0, 0 });
		while (!q.isEmpty()) {
			int breadth = q.size();
			System.out.println("breadth ="+len );
			for (int i = 0; i <breadth ; i++) {
				int[] e = q.poll();
				if (seen[e[0]][e[1]])
					continue;
				System.out.println("Path : " + e[0] + "," + e[1]);
//				if (e[0] == grid.length - 1 && e[1] == grid[0].length - 1) {
//					return len + 1;
//				}

				seen[e[0]][e[1]] = true;
				pushAdjacentInQ(grid, q, e, seen);
			}
			len++;
		}
		return -1;
	}

	private void pushAdjacentInQ(int[][] grid, Queue<int[]> q, int[] e, boolean[][] seen) {
		for (int i = 0; i < dir.length; i++) {
			int Y = dir[i][0] + e[0];
			int X = dir[i][1] + e[1];
			if (X >= 0 && X < grid[0].length && Y >= 0 && Y < grid.length && grid[Y][X] != 0 && seen[Y][X] == false) {
				q.offer(new int[] { Y, X });
			}
		}
	}

	public int shortestPathBinaryMatrix1(int[][] grid) {

		int m = grid.length;
		int n = grid[0].length;

		if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
			return -1;
		}

		boolean[][] visited = new boolean[m][n];
		visited[0][0] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0 });

		int ans = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] pop = queue.remove();
				System.out.println("Path : " + pop[0] + "," + pop[1]);
				if (pop[0] == m - 1 && pop[1] == n - 1) {
					return ans + 1;
				}
				for (int k = 0; k < 8; k++) {
					int nextX = dir[k][0] + pop[0];
					int nextY = dir[k][1] + pop[1];

					if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY]
							&& grid[nextX][nextY] == 0) {
						queue.add(new int[] { nextX, nextY });
						visited[nextX][nextY] = true;
					}

				}
			}
			ans++;
//			System.out.println("length " + ans);
		}

		return -1;
	}
}