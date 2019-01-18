package algos.matrix;

public class NumberOfPathsPossibleInNxNMatrixRecursive {
	public static void main(String[] args) {
		int N=4;
		int computePath = computePath(0,0,N);
		System.out.println(computePath);
	}
	public static int computePath(int i, int j,  int N){
		int count =0;
		if (i == N-1 && j == N-1 ){
			return 1;
		}else if (i == N-1  ){
			return  computePath(i,j+1,N);
		}else if (j == N-1  ){
			return  computePath(i+1,j,N);
		}else {
			count =  computePath(i,j+1,N);
			count = count + computePath(i+1,j,N);
			return count;
		}
	}
}

