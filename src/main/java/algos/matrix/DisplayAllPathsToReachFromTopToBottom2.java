package algos.matrix;

import java.util.ArrayList;
/**
 * possible paths: right and down
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import algos.utils.SimpleMatrixUtilsInt;

public class DisplayAllPathsToReachFromTopToBottom2 {
	
	private final int STOP = 0;
	String ar[];
	List<Cell> path = new ArrayList<Cell>();
	Queue<Cell> q = new LinkedList<>();
	Set<Cell> visited = new HashSet<>();
	int row = 4;
	int col = 3;
	int startY = 1;// row
	int startX = 1;// col
	int endY = 2;// row
	int endX = 2;// col
	int mat[][];

	public static void main(String[] args) {
		// M x N matrix
		DisplayAllPathsToReachFromTopToBottom2 pr = new DisplayAllPathsToReachFromTopToBottom2();
		pr.init();

	}

	public void init() {
		mat = SimpleMatrixUtilsInt.initalizeMatrix(row, col);
		SimpleMatrixUtilsInt.printMat(mat);
		System.out.println("******************************");
		ar = new String[row + col - 1];
		computePath();
		path.stream().forEach(System.out::println);
	}

	private void computePath() {
		Cell c = new Cell(startY, startX, false);
		q.add(c);
		visited.add(c);
		while (!q.isEmpty()) {
			Cell ct = q.poll();
			checkAndAddInQ(ct);
			ct.v = true;
			visited.add(ct);
			path.add(ct);
			if (ct.x == endX && ct.y == endY) {
				break;
			}
		}

	}

	private void checkAndAddInQ(Cell ct) {
		if (ct.y+1<row && isInLimit(ct) && mat[ct.y + 1][ct.x] != STOP) {
			Cell cell = new Cell(ct.y + 1, ct.x, false);
			if( !visited.contains(cell)) {
				q.add(cell);
			}
		}
		if (ct.y-1>=0 && isInLimit(ct) && mat[ct.y - 1][ct.x] != STOP ) {
			Cell cell =new Cell(ct.y - 1, ct.x, false);
			if( !visited.contains(cell)) {
				q.add(cell);
			}
		}
		if (ct.x+1<col && isInLimit(ct)  && mat[ct.y][ct.x + 1] != STOP ) {
			Cell cell =new Cell(ct.y, ct.x + 1, false);
			if( !visited.contains(cell)) {
				q.add(cell);
			}
		}
		if (ct.x-1>=0 && isInLimit(ct) && mat[ct.y][ct.x - 1] != STOP ) {
			Cell cell =new Cell(ct.y, ct.x - 1, false);
			if( !visited.contains(cell)) {
				q.add(cell);
			}
			
		}
	}

	private boolean isInLimit(Cell ct) {
		return ct.x < col && ct.y < row && ct.x>=0 && ct.y >=0;
	}

	private void print() {
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + ":: ");
		}
		System.out.println();
	}
	/**
	 * This needs hash code, the code just happens to be working
	 */
	private static class Cell {

		public Integer x ;
		public Integer y;
		public Boolean v;
		public Cell(Integer y, Integer x,	Boolean v) {
			this.x=x;
			this.y=y;
			this.v=v;
		}
		@Override
		public String toString() {
			
			return y+", "+x +":";
		}
	}

}
