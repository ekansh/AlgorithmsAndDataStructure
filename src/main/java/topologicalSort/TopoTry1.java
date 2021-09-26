package topologicalSort;

import java.util.*;
import java.util.stream.IntStream;

public class TopoTry1 {
	Map<Integer, List<Integer>> preq = new HashMap<>();
	Map<Integer, Integer> indegree = new HashMap<>();
	Map<Integer, Integer> seen = new HashMap<>();
	Stack<Integer> stk = new Stack<>();

	public static void main(String[] args) {
		TopoTry1 t = new TopoTry1();
		int[] findOrder = t.findOrder(2, new int[][] { { 1, 0 } });
		System.err.println(findOrder);
	}

	public void createGraph(int num, int[][] pr) {
		IntStream.range(0, num).forEach(e -> {
			preq.put(e, new ArrayList<>());
			indegree.put(e, 0);
		});
		for (int[] c : pr) { // s = source and d= destination
			int s = c[1], d = c[0];
			preq.get(s).add(d);
			indegree.put(d, indegree.get(d) + 1);
		}
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		createGraph(numCourses, prerequisites);
		for (Integer start : preq.keySet()) {
			int res = dfs(start);
			if (res == -1)
				return new int[0];
		}
		int[] order = new int[numCourses];
		int k = 0;
		while (!stk.isEmpty()) {
			order[k++] = stk.pop();
		}
		return order;
	}

	public int dfs(int node) {
		if (seen.containsKey(node)) {
			return seen.get(node);
		}
		seen.put(node, -1);

		for (Integer relatedNodes : preq.get(node)) {
			int k = dfs(relatedNodes);
			if (k == -1)
				return -1;
		}
		seen.put(node, 1);
		stk.push(node);
		return 1;
	}
}
 

class Solution {
    int sum =0;
    public boolean canPartition(int[] nums) {
        for ( int i =0; i<nums.length; i++){
            sum+=nums[i];
        }
        return fx(nums,0,0);
    }
    //Sort and two pointer 
    
    // Brute Force here
    public boolean fx(int[] n, int pos , int cs){
        if( cs == sum/2){
            return true;
        }
        if( pos ==n.length)return false;
        boolean res =false;
        for ( int i =pos; i<n.length; i++){
            res = fx(n,i+1,cs+n[i]);
        }
        return res;
    }
}