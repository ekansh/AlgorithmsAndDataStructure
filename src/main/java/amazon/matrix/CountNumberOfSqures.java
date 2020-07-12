package amazon.matrix;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

class CountNumberOfSqures {
	public static void main(String[] args) {
		CountNumberOfSqures solution = new CountNumberOfSqures();
		int [][] m= {{1,1,0},
					 {1,1,1},
					 {1,1,0}};
		int countSquares = solution.countSquares(m);
		
		System.out.println(countSquares);
		
	}

	private static void display(int[][] m ) {
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(m[i][j] + ":");
			}
			System.out.println();
		}
	}

	  public int countSquares(int[][] matrix) {
	        int r=matrix.length;
	        int c=matrix[0].length;
	        int min=r;
	        if (c<r){
	            min=c;
	        }
	        int count=0;
	        for (int x=1; x<=min; x++){
	            for (int i = 0; i < r; i++) {
	                if(i+x>r){
	                    break;
	                }
				    for (int j = 0; j < c; j++) {
	                    if(j+x>c){
	                        break;
	                    }
	                    int[][] constructMatrix = constructMatrix(matrix, i,j, x);
	                    if(checkAllOne(constructMatrix)){
	                    	count++;
	                    }
	                }
	            }
	        }
	        
	        return count;
	    }
	    public boolean checkAllOne(int[][]  m){
	    	int r=m.length;
	    	int c =m[0].length;
	    	int a=0;
	        for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
				    a+=m[i][j];
				}	
			} 
	        if(a == r*c) {
	        	return true;
	        }else {
	        	return false;
	        }
	    }
	    public int[][] constructMatrix(int [][] m,int r, int c , int n){
	        int a[][]=  new int[n][n];
	           for (int i = r,i1=0; i < r+n; i1++ ,i++) {
				for (int j = c,j1=0; j < c+n;j1++, j++) {
				    a[i1][j1]=m[i][j];
				}	
	           }
	        return a;
	    }   
	    

}