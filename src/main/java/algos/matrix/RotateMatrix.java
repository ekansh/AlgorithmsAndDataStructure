package algos.matrix;

import algos.utils.SimpleMatrixUtilsInt;

public class RotateMatrix {
	static int n = 6;

	public static void main(String[] args) {
		int[][] mat = SimpleMatrixUtilsInt.initalizeMatrix(n, n);
		SimpleMatrixUtilsInt.printMat(mat);
//		int rMat[][] = rotateMatrix(mat, 0, 0);
		rotate(mat);
		SimpleMatrixUtilsInt.printMat(mat);
	}
	//2,2 to 4,4
	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < (n + 1) / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
				matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = matrix[i][j];
				matrix[i][j] = temp;
			}
		}
	}

	private static int[][] rotateMatrix(int[][] mat, int i, int j) {
		if (i == n - 1) {
			return mat;
		}
		for (int k = i; k < n; k++) {
			int t = mat[i][k]; // col

			mat[i][k] = mat[k][i];
			mat[k][i] = t;
		}
		return rotateMatrix(mat, i + 1, j + 1);

	}
}
