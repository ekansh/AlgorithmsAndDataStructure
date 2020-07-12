package algos.matrix;
/**
 possible paths: right and down
**/
import java.util.Arrays;
import java.util.Collections;

import algos.matrix.utils.SimpleMatrixUtils;

public class DisplayAllPathsToReachFromTopToBottom {
	static String ar[] ;
	static int mat[][];
	public static void main(String[] args) {
		//M x N matrix
		int row=5;
		int col=4;
		mat= SimpleMatrixUtils.initalizeMatrix(row, col);
		SimpleMatrixUtils.printMat(mat);
		System.out.println("******************************");
		ar= new String[row+col-1];
		int computePath = computePath(0,0,0,row,col);
		System.out.println(computePath);
	}
	public static int computePath(int i, int j, int index,  int row, int col){
		int count =0;
		if(index>=row+col-1) {
			System.out.println("index "+index);
		}
		ar[index]=i+"," +j;
		if (i == row-1 && j == col-1 ){
			print();
			return 1;
		}else if (i == row-1  ){
			return  computePath(i,j+1,index+1,row,col);
		}else if (j == col-1  ){
			return  computePath(i+1,j,index+1,row,col);
		}else {
			count =  computePath(i,j+1,index+1,row,col);
			count = count + computePath(i+1,j,index+1,row,col);
			return count;
		}
	}
	private static void print() {
		for ( int i =0;i<ar.length;i++) {
			System.out.print(ar[i]+":: ");
		}
		System.out.println();
	}
}

