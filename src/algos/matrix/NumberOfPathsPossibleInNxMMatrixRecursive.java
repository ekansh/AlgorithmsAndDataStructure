package algos.matrix;
/**
 possible paths: right and down
**/
public class NumberOfPathsPossibleInNxMMatrixRecursive {
	public static void main(String[] args) {
		//M x N matrix
		int row=4;
		int col=3;
	
		int computePath = computePath(0,0,row,col);
		System.out.println(computePath);
	}
	public static int computePath(int i, int j,  int row, int col){
		int count =0;
		if (i == row-1 && j == col-1 ){
			System.out.print("("+i+","+j+")");
			System.out.println("");
			return 1;
		}else if (i == row-1  ){
			System.out.print("("+i+","+j+")");
			return  computePath(i,j+1,row,col);
		}else if (j == col-1  ){
			System.out.print("("+i+","+j+")");
			return  computePath(i+1,j,row,col);
		}else {
			System.out.print("("+i+","+j+")");
			count =  computePath(i,j+1,row,col);
			count = count + computePath(i+1,j,row,col);
			return count;
		}
	}
}

