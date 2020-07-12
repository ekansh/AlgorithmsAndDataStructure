package algos.matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import algos.matrix.utils.CreateIntMatrix;

public class ReachToACelUsingBFS2 {
	public static void main(String[] args) {
		ReachToACelUsingBFS2 r = new ReachToACelUsingBFS2();
		int[][] grid = CreateIntMatrix.constructMatrixFromArgs(
				new String[] { "3", "4", "1", "0", "0", "0", "1", "1", "1", "1", "0", "1", "1", "1" });
		CreateIntMatrix.printMat(grid);
		int minSteps = r.minSteps(grid, 0, 0,2,3);
		System.out.println(minSteps);
	}
	HashSet<String> seen = new HashSet<>();
	public  int minSteps(int [][]grid, int start_row, int start_col, int end_row, int end_col) {
		
		Queue<ArrayList<Integer>> q = new LinkedList<ArrayList<Integer>>();
		int steps=0;
		int minSteps=-1;
		
		q.add(new ArrayList<Integer>() {{add(start_row); add(start_col); add(steps);}});// pushing first element ( HAS TO BE ACCESIBLE)
		q.add(new ArrayList<Integer>() {{add(-1); add(-1); add(-1);}});
	
		while ( !q.isEmpty()) {
			ArrayList<Integer> poll = q.poll();
			String c = poll.get(0)+":"+poll.get(1);
			if(poll.get(0)==-1) { // next breadth
				if(!q.isEmpty()) {
					q.add(new ArrayList<Integer>() {{add(-1); add(-1); add(-1);}});
					continue;
				}
			} 
			if(poll.get(0)==end_row && poll.get(1)==end_col) { // goal reached : destination cell 
				int numberOfSteps = poll.get(2);
				minSteps= minSteps==-1 ? numberOfSteps:Math.min(numberOfSteps, minSteps);
			}
			
			if(seen.contains(c ) ||isRestricted(grid,poll.get(0), poll.get(1) , 0)) continue; // DONT GO HERE
			
			if( !(poll.get(0)==end_row && poll.get(1)==end_col)) {// this is a special setup if you want to reach same cell multiple times to find the shortest path
				seen.add(c); // saw the cell 
			}
			addNeighboursInQ(grid, poll, q ); // put neighbours in queue 
		}
		return minSteps;
	}
	private void addNeighboursInQ(  int[][] grid, ArrayList<Integer> poll, Queue<ArrayList<Integer>> q) {
		int [][]directions= {{1,0}, {-1,0}, {0,1},{0,-1}};
		int step = poll.get(2);
		for (int[] js : directions) {
			int neighbourRow=  poll.get(0)+js[0];
			int neighbourCol=  poll.get(1)+js[1];
			String c = neighbourRow+":"+neighbourCol;
			ArrayList<Integer> e = new ArrayList<Integer>() {{add(neighbourRow); add(neighbourCol);add(step+1);}};
			if(!seen.contains(c) && !isRestricted(grid, neighbourRow, neighbourCol, 0)) {
				q.add(e);
			}
		}
		
	}
	/**
	 * 
	 * @param grid int[][]
	 * @param r row
	 * @param c column
	 * @param restriction if certain cell is no go 
	 * @return
	 */
	private boolean isRestricted(int[][] grid,int r , int c, int restriction) {
		if( r>=grid.length||r<0 ||c>=grid[0].length || c<0||grid[r][c]==restriction) {
			return true;
		}
		return false;
	}
	private static class Cell {
		int row, col;
		Cell(int x, int y){row=x; col=y;}
		@Override
		public String toString() {return row+":"+col;}
	}
	  
}
