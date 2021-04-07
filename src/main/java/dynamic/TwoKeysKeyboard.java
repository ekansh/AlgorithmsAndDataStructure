package dynamic;

import java.util.*;

class TwoKeysKeyboard {
	public static void main(String[] args) {
		String[] split = "/a".split("/");
		System.out.println(split[0]);
		TwoKeysKeyboard s = new TwoKeysKeyboard();
		int wordBreak = s.minDifficulty(new int[] {7,1,7,1,7,1},3);
		System.out.println(wordBreak);
	}

	public int minDifficulty(int[] jobDifficulty, int d) {
        int res[][] = new int[jobDifficulty.length+1][d+1];
        init(res);
        for ( int jd =1;jd<=jobDifficulty.length; jd++){
            
            for ( int days =1 ; days<=d; days++){
                if ( days> jd) break;
                int maxJD =-1;
                List<Integer> ls = new ArrayList<Integer>() ;
                ls.add(100);
                for ( int k =jd-1 ; k>=0; k--){
                    maxJD= Math.max(maxJD,jobDifficulty[k]);
                    if(res[k][days-1]==-1) 
                    	continue;
                    ls.add(maxJD+res[k][days-1]);
                }
                Optional<Integer> min = ls.stream().min((x,y)-> x-y);
				int r =min.get() ;
                res[jd][days] = r;
                System.out.println("---"+jd+"--"+days);
                print(res);
            }
        }
        return res[jobDifficulty.length-1][d-1];
    }

	private void init(int[][] res) {
		for ( int i =0 ;i<res.length; i++) {
			for ( int j=0 ;j<res[0].length; j++) {
				res[i][j]= j==0 || j>i?-1: 0;
			}
		}
		res[0][0]=0;
	}

	private void print(int[][] res) {
		for ( int i =0 ;i<res.length; i++) {
			for ( int j=0 ;j<res[0].length; j++) {
				System.out.print(res[i][j]+":");
			}
			System.out.println();
		}
		
	}

}
