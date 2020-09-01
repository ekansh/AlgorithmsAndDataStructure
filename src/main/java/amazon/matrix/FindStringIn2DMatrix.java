package amazon.matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * https://stackoverflow.com/questions/38450480/find-a-string-in-a-2-dimensional-array
 * @author Ekansh
 *
 */
public class FindStringIn2DMatrix {
	public static void main(String[] args) {
		FindStringIn2DMatrix m = new FindStringIn2DMatrix();
		char[][] a = { 	{ 'B', 'B', 'A', 'B', 'B', 'N' },
						{ 'B', 'B', 'M', 'B', 'B', 'O' },
						{ 'B', 'B', 'A', 'B', 'B', 'Z' },
						{ 'N', 'O', 'Z', 'B', 'B', 'A' },
						{ 'B', 'B', 'B', 'B', 'B', 'M' },
						{ 'B', 'B', 'B', 'B', 'B', 'A' } };
		int count = m.findStringIn2DMatrix(a, "AMAZON");
		System.out.println(count);
	}

	private int findStringIn2DMatrix(char[][] grid, String string) {
		int group = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == string.charAt(0)) { // you can also do this by using seen set and checking seen here, as we are
											// counting in this block
					int findString = findString(grid, i, j,string);
					group+=findString;
				}
			}
		}
		return group;
	}
	public int findString(char[][] grid, int start_row, int start_col, String string) {
		HashSet<Cell> seen = new HashSet<>();
		Queue<Cell> q = new LinkedList<>();
		q.offer(new Cell(start_row, start_col));
		int j = 0, count =0;

		while (!q.isEmpty()) {
			int breadth = q.size();
			for (int i = 0; i < breadth && j<string.length(); i++) {
				Cell e = q.poll();
				if (seen.contains(e)) {
					continue;
				}
				seen.add(e);
				if (j==string.length()-1) {
					count++;
				}else {
					pushAdjacentInQ(grid, q, e, seen, string.charAt(j+1));
				}
			}
			j++;
		}
		return count;
	}
	private void pushAdjacentInQ(char[][] grid, Queue<Cell> q, Cell e, Set<Cell> seen, char nextChar) {
		int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		for (int i = 0; i < dir.length; i++) {
			int Y = dir[i][0] + e.row;
			int X = dir[i][1] + e.col;
			Cell n = new Cell(Y,X);
			if (X >= 0 && X < grid[0].length && Y >= 0 && Y < grid.length && grid[Y][X] == nextChar && !seen.contains(n)) {
				q.offer(n);
			}
		}
	}
	private static class Cell {
		int row, col;
		StringBuilder sb;
		Cell(int x, int y) {
			row = x;
			col = y;
			sb= new StringBuilder();
		}

		@Override
		public String toString() {
			return row + ":" + col;
		}
		// based on row and column only 
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + col;
			result = prime * result + row;
			return result;
		}
		// based on row and column only 
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cell other = (Cell) obj;
			if (col != other.col)
				return false;
			if (row != other.row)
				return false;
			return true;
		}
		
	}
}
