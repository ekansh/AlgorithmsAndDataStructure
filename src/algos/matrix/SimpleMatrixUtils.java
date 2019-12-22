package algos.matrix;

public class SimpleMatrixUtils {
	public static void main(String[] args) {
		if (args != null) {
			int mat[][]=constructMatrixFromArgs(args);
			printMat(mat);
		} else {
			int matEager[][] = new int[5][3];
			printMat(matEager);
			int[][] mat = initalizeMatrix(3, 4);
			printMat(mat);
		}
	}

	private static int[][] constructMatrixFromArgs(String[] args) {
		int mat[][] = null;
		int i=0; int j=0;
		try {
			int r = Integer.valueOf(args[0]);
			int c = Integer.valueOf(args[1]);
			mat= new int[r][c];
			for ( int k =2; k<args.length;k++) {
				if (j==c && i ==r){
					break;
				}
				if(j==c) {
					j=0;
					i++;
				}
				mat[i][j]=Integer.valueOf(args[k]);
				j++; 
			}
		} catch (Exception e) {
			System.out.println("input is wrong");
		}
		return mat;
	}

	public static void printMat(int[][] matEager) {
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

	public static int[][] initalizeMatrix(int r, int c) {
		int count = 0;
		int mat[][] = new int[r][];
		for (int i = 0; i < r; i++) {
			mat[i] = new int[c];
			for (int j = 0; j < c; j++) {
				mat[i][j] = count++;
			}
		}
		return mat;
	}
}
