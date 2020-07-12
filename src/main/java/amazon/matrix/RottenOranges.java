package amazon.matrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import algos.matrix.utils.CreateIntMatrix;
import algos.matrix.utils.SimpleMatrixUtils;

public class RottenOranges {
	public static void main(String[] args) {
		RottenOranges r = new RottenOranges();
		int[][] m = CreateIntMatrix.constructMatrixFromIntArgs(new int [] {3,3,2,1,1,0,1,1,1,0,1});
		SimpleMatrixUtils.printMat(m);
		r.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit."
				,new String[] {"hit"});
	}
	int dir[][] = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	
	
	
	
	    public String mostCommonWord(String paragraph, String[] banned) {
	        
	        Set<String> ban = Arrays.stream(banned).collect(Collectors.toSet());
	        Map<String, Integer> m = new HashMap<>();
	        String[]  w = paragraph.split("\\W+");
	        for ( String s : w){
	            if(! ban.contains(s.toLowerCase())){
	                m.put(s.toLowerCase(), m.getOrDefault(s.toLowerCase(),0)+1);
	            }
	        }
	        int max =-1;
	        String most ="";
	        for( String s : m.keySet()){
	            Integer k=m.get(s);
	            if( k>max){
	                max =k;
	                most =s;
	            }
	        }
	        return most;
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	public int orangesRotting(int[][] grid) {
		Set<int[]> s = new HashSet<>();
		int m = grid.length, n = grid[0].length, min =0, fresh = 0, rotten = 0;
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 2) {
					q.offer(new int[] { i, j });
					rotten++;
				} else if (grid[i][j] == 1) {
					fresh++;
				}
			}
		}
		while (fresh !=0 && !q.isEmpty()) {
			int size = q.size();

			for (int j = 0; j < size; j++) {
				int[] ele = q.poll();
				if( s.contains(ele)) {
					continue;
				}
				s.add(ele);
				for (int i = 0; i < dir.length; i++) {
					int y = ele[0] + dir[i][0];
					int x = ele[1] + dir[i][1];
					int [] neighbours = new int[] {y,x};
					if (x >= 0 && y >= 0 && x < n && y < m && grid[y][x] == 1 && !s.contains(neighbours)) {
						grid[y][x] = 2;
						fresh--;
						q.offer(neighbours);
					}
				}
				 
			}
			min++;
		}
        
		return fresh == 0? min :-1;
	}
}
