package algos.matrix;

import java.util.*;
/**
 * https://leetcode.com/discuss/interview-question/799477/Google-or-Phone-Screen-or-Reject
 * You are implementing a board game where you are given a size N x M for the board, where N is the number of rows and M is the number of columns.
In this board game you are playing with some fixed size lego pieces, where each player places 1 piece on the board every turn until no more piece can fit onto the board, and the last player to move wins.

The problem is to implement a method for making a move on this board, placing a piece wherever there is space available, and returns a boolean indicating whether or not the player that has just made the move has won.

Follow up question: The method should also find if there is any move that can be made that will make it so that the next player is unable to place a piece anywhere on the board in their next turn, and make that move.

You choose how to represent the board and lego pieces in the problem, during my interview I chose to use a 2D array of characters for the board, where each X indicates occupied and O indicates spot is free and lego piece has dimension 2 X 4.

Simple example (small board for demonstration purposes, board length = 4 x 4, lego piece length = 2 x 4):
Empty Board:
O O O O
O O O O
O O O O
O O O O
Board after player 1 makes move, placing lego piece at Middle columns:
O X X O
O X X O
O X X O
O X X O
At this point, player 2 can't make a move and player 1 wins
 * @author Ekansh
 *
 */
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
