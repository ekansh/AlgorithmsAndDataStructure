package algos.utils;

public class SimpleMatrixUtilsChar {
	public static void main(String[] args) {
		if (args != null && args.length>0 ) {
			char mat[][]=constructMatrixFromArgs(args);
			printMat(mat);
		} else {
			char matEager[][] = new char[5][3];
			printMat(matEager);
			char[][] mat = initalizeMatrix(3, 4);
			printMat(mat);
		}
	}

	/**
	 * first argument is row second is column and then row*column number of
	 *  argument should be supplied which will be converted to matrix
	 * @param args
	 * @return
	 */
	private static char[][] constructMatrixFromArgs(String[] args) {
		char mat[][] = null;
		int i=0; int j=0;
		try {
			int r = Integer.valueOf(args[0]);
			int c = Integer.valueOf(args[1]);
			mat= new char[r][c];
			for ( int k =2; k<args.length;k++) {
				if (j==c && i ==r){
					break;
				}
				if(j==c) {
					j=0;
					i++;
				}
				mat[i][j]=String.valueOf(args[k]).charAt(0);
				j++; 
			}
		} catch (Exception e) {
			System.out.println("input is wrong");
		}
		return mat;
	}

	public static void printMat(char[][] matEager) {
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

	public static char[][] initalizeMatrix(int r, int c) {
		int count = 67;
		char mat[][] = new char[r][];
		for (int i = 0; i < r; i++) {
			mat[i] = new char[c];
			for (int j = 0; j < c; j++) {
				mat[i][j] = (char) count++;
			}
		}
		return mat;
	}
}
