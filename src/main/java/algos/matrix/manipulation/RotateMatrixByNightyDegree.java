package algos.matrix.manipulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RotateMatrixByNightyDegree {
	private Integer[][] matrix;
	private Integer DIMENSION=3;
	
	public static void main(String[] args) {
		new RotateMatrixByNightyDegree().roateMatrixbyNightyDegree();
	}
	
	private void roateMatrixbyNightyDegree() {
		matrix = new Integer[DIMENSION][DIMENSION];
		createMockMatrix();
		displayMatrix();
		int N=DIMENSION-1;
		for (int k =0; k< DIMENSION ; k++){
			for ( int row=k, col=k ; row<DIMENSION && col< DIMENSION ; row++,col ++){
				int c1 = matrix[row][col+k];
				int c2 = matrix [row+k][N-col];
				int c3 = matrix[N][N-k];
				int c4 = matrix[N-k][col];
				matrix [row+k][N-col] =c1;
				matrix[N][N-k]= c2;
				matrix[N-k][col]=c3;
				matrix[row][col+k]=c4;
				System.out.println("intermediate matrix");
				displayMatrix();
			}
		}
		displayMatrix();
	}
	
	private void createMockMatrix() {
		int i =0;
		for ( int row=0 ; row<DIMENSION  ; row++){
			for ( int col=0 ; col<DIMENSION  ; col++){
				matrix[row][col]=i++;
			}
		}
	}
	private void displayMatrix() {
		int i =0;
		for (Integer[] rows : matrix) {
			for (Integer cell : rows) {
				
				System.out.print(cell +" ");
				
			}
			System.out.println("");
		}
		
	}
	
	
}
