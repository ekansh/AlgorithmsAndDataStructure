package amazon.matrix;

import java.util.ArrayList;
import java.util.List;


import static java.util.Arrays.*;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class MinimumDaysToUpgradeGrid {
	
	public static void main(String[] args) {
		MinimumDaysToUpgradeGrid minimumDaysToUpgradeGrid = new MinimumDaysToUpgradeGrid();
		List<List<Integer>> list = asList(asList(0, 1,1,0, 1), asList(0,1,0,1,0), asList(0,0,0,0,1),asList(0,1,0,0,0));
		int minimumDays = minimumDaysToUpgradeGrid.minimumDays(4,5,list);
		System.out.println(minimumDays);
	}

	int minimumDays(int rows, int columns, List<List<Integer>> grid) {
		
		int [][] newg = getDuplicateOfGrid(grid);
		int[][] old = getDuplicateOfGrid(grid);
		int days = 0;
		while (!allUpdated(newg,rows,columns)) {
			days++;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					if(old[i][j]==0 && newg [i][j]!=1) {
						newg[i][j]=0;
					}else if(old[i][j]==1){
						checkAndAdd(i,j,rows,columns,newg);
					}
				}
			}
			old=newg;
		}
		return days;
	}
	private void checkAndAdd(int y,int x,int row, int col, int[][] mat) {
		if (y+1<row && isInLimit(y,x,row,col)  ) {
			mat[y+1][x]=1;
		}
		if (y-1>=0 && isInLimit(y,x,row,col)   ) {
			mat[y-1][x]=1;
		}
		if (x+1<col && isInLimit(y,x,row,col)   ) {
			mat[y][x+1]=1;
		}
		if (x-1>=0 && isInLimit(y,x,row,col)   ) {
			mat[y][x-1]=1; 
		}
	}
	private boolean isInLimit(int y,int x,int row,int col) {
		return x < col && y < row && x>=0 && y >=0;
	}
	private int[][] getDuplicateOfGrid(List<List<Integer>> grid) {
//		List<List<Integer>> mat = new ArrayList<List<Integer>>(grid);
		int r =grid.size();
		List<Integer> l1 = grid.get(0);
		int c = l1.size();
		int mat[][] = new int[r][c];
		int i =0; 
		int j=0;
		for (List<Integer> list : grid) {
			for (Integer integer : list) {
				mat[i][j]=integer;
				j++;
			}
			j=0;
			i++;
		}
		printMat(mat);
		return mat;
	}
	public  void printMat(int[][] matEager) {
		int r = matEager.length;
		int c = matEager[0].length;
		System.out.println("{");
		for (int i = 0; i < r; i++) {
			System.out.print("\t[");
			for (int j = 0; j < c; j++) {
				System.out.print(matEager[i][j] + ":");
			}
			System.out.println("]");
		}
		System.out.println("}");
	}

	private boolean allUpdated(int[][] mat,int rows,int columns) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (mat[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
}