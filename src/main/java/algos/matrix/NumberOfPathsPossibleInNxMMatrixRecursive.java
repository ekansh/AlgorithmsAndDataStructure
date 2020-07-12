package algos.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * possible paths: right and down
 **/
public class NumberOfPathsPossibleInNxMMatrixRecursive {
	public static void main(String[] args) {
		// M x N matrix
		NumberOfPathsPossibleInNxMMatrixRecursive p = new NumberOfPathsPossibleInNxMMatrixRecursive();
		int row = 4;
		int col = 3;
		int computePath = p.uniquePathsInit(1, 1, row, col);
		System.out.println(computePath);

//		List<List<Integer>> grid = new ArrayList<>();
//		grid.add(Arrays.asList(1, 1,1,1));
//		 grid.add(Arrays.asList(1, 0, 1, 1));
//		grid.add(Arrays.asList(1, 1,1,1));
//		int num = p.uniquePathsFromSourceToDestination1(grid, 0, 0, 0, 2);
//		System.out.println(num);

	}

	Set<Cell> seen = new HashSet<>();
	List<List<Cell>> paths = new ArrayList<>();
	List<Cell> tl = new ArrayList<>();
	Map<Cell, Integer> map = new HashMap<>();

	private int uniquePathsInit(int i, int j, int row, int col) {
		paths.clear(); 		tl.clear();		seen.clear();
		int computePath = uniquePaths(1, 1, row, col);
		for( List<Cell> l : paths) {
			l.stream().forEach(e ->System.out.print(e+","));
			System.out.println();
		}
		return computePath;
	}

	private int uniquePathsFromSourceToDestination1(List<List<Integer>> grid, int i, int j, int k, int l) {
		paths.clear();
		tl.clear();
		seen.clear();

		int num = uniquePathsFromSourceToDestination(grid, 0, 0, 0, 2);
		return num;
	}

	private int uniquePathsFromSourceToDestination(List<List<Integer>> grid, int sr, int sc, int tr, int tc) {
		System.out.println(sr + ":" + sc);
		if (sr == tr && sc == tc) {
			Cell x = new Cell(tr, tc);
			tl.add(x);
			paths.add(new ArrayList<>(tl));
			tl.remove(x);
			return 1;
		}
		Cell cell = new Cell(sr, sc);
		if (sr < 0 || sc < 0 || sr >= grid.size() || sc >= grid.get(0).size() || grid.get(sr).get(sc) == 0
				|| seen.contains(cell)) {
			return 0;
		}
		
		seen.add(cell);
		tl.add(cell);
		if (map.containsKey(cell))
			return map.get(cell);
		
		int v1 = uniquePathsFromSourceToDestination(grid, sr + 1, sc, tr, tc);
		int v2 = uniquePathsFromSourceToDestination(grid, sr - 1, sc, tr, tc);
		int v3 = uniquePathsFromSourceToDestination(grid, sr, sc + 1, tr, tc);
		int v4 = uniquePathsFromSourceToDestination(grid, sr, sc - 1, tr, tc);
		map.put(cell,v1+v2+v3+v4);
		tl.remove(cell);
		return v1 + v2 + v3 + v4;
	}

// number of unique paths from top to bottom ( right and down paths allowed
	public int uniquePaths(int r, int c, int m, int n) {
		if (r > m || c > n)
			return 0;
		if (r == m && n == c) {
			Cell x = new Cell(m, n);
			tl.add(x);
			paths.add(new ArrayList<>(tl));
			tl.remove(x);
			return 1;
		}
		Cell cell = new Cell(r, c);
		tl.add(cell);
		//in order to display all paths commented maps, 
		// remove this comment and map.put below  if you just want count
//		if (map.containsKey(cell))
//			return map.get(cell);
		int v1 = uniquePaths(r + 1, c, m, n);
		int v2 = uniquePaths(r, c + 1, m, n);
//		map.put(cell, v1+v2);
		tl.remove(cell);
		return v1+v2;
	}

//CELL Class
	private static class Cell {
		Integer r, c;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((c == null) ? 0 : c.hashCode());
			result = prime * result + ((r == null) ? 0 : r.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cell other = (Cell) obj;
			if (c == null) {
				if (other.c != null)
					return false;
			} else if (!c.equals(other.c))
				return false;
			if (r == null) {
				if (other.r != null)
					return false;
			} else if (!r.equals(other.r))
				return false;
			return true;
		}

		@Override
		public String toString() {

			return r + ":" + c;
		}

		Cell(Integer a, Integer b) {
			r = a;
			c = b;
		}

	}

}
