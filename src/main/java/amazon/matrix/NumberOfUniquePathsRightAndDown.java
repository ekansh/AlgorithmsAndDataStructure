package amazon.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import algos.matrix.utils.CreateIntMatrix;
import algos.matrix.utils.SimpleMatrixUtils;

 
public class NumberOfUniquePathsRightAndDown {
	public static void main(String[] args) {
		NumberOfUniquePathsRightAndDown s = new NumberOfUniquePathsRightAndDown();
		int uniquePaths = s.uniquePaths(3,2);
		System.out.println(uniquePaths);
	}

	public int uniquePaths(int m, int n) {
		return uniquePaths(1, 1, m, n);
	}

	Map<Cell, Integer> map = new HashMap<>();

	public int uniquePaths(int r, int c, int m, int n) {
		if (r > m || c > n)
			return 0;
		if (r == m && n == c)
			return 1;
		Cell cell = new Cell(r, c);
		if (map.containsKey(cell))
			return map.get(cell);

		int v = uniquePaths(r + 1, c,m,n) + uniquePaths(r, c + 1,m,n);
		map.put(cell, v);
		return v;
	}
}
class Cell {
    int r, c;
    Cell(int a, int b){
        r=a;
        c =b;
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + c;
		result = prime * result + r;
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
		if (c != other.c)
			return false;
		if (r != other.r)
			return false;
		return true;
	}
}