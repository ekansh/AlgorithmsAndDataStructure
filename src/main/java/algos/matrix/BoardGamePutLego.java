package algos.matrix;

import java.util.*;

public class BoardGamePutLego {
	public static void main(String[] args) {
		BoardGamePutLego b = new BoardGamePutLego(6, 6, 2, 2);
		b.printMat();
		System.out.println("won? "+b.makeMove(0, 0));
		b.printMat();
		System.out.println("won? "+b.makeMove(2,3));
		b.printMat();
		System.out.println("won? "+b.makeMove(0,3));
		b.printMat();
		
		System.out.println("won? "+b.makeMove(3,1));
		b.printMat();
		System.out.println("won? "+b.makeMove(3,3));
		b.printMat();
		
		System.out.println("won? "+b.makeMove(4,4));
		b.printMat();
	}
	int mat[][];
	int lego[][];
	Set<Cell> available = new HashSet<>();

	public BoardGamePutLego(int r, int c, int legoL, int legoH) {
		lego = new int[legoL][legoH];
		mat = new int[r][c];
		for (int i = 0; i < mat.length-lego.length+1; i++) {
			for (int j = 0; j < mat[0].length-lego[0].length+1; j++) {
				available.add(new Cell(i,j));
			}
		}
	}
	
	public int makeMove(int row,int col) {
		if (!available.contains(new Cell(row,col))) {
			return -1;
		}
		for ( int i =Math.max(0,  row-lego.length+1);i<row+lego.length;i++) {
			for (int j = Math.max(0,  col-lego[0].length+1); j <col+ lego[0].length; j++) {
				available.remove(new Cell(i,j));
			}
		}
		return available.isEmpty() ? 1:0;
	}
	public void printMat() {
		System.out.println("current state");
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (available.contains(new Cell(i, j))) {
					System.out.print("|O|");
				} else {
					System.out.print("|X|");
				}
			}
			System.out.println();
		}

	}

	private static class Cell {
		int r, c;

		Cell(int y, int x) {
			r = y;
			c = x;
		}

		@Override
		public String toString() {
			return r + ":" + c;
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
}
