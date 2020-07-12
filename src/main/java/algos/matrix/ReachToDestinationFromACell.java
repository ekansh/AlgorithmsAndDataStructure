package algos.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ReachToDestinationFromACell {
	 
	public static void main(String[] args) {
		
		System.out.println(1073741829*2);
		ReachToDestinationFromACell r = new ReachToDestinationFromACell();
		List<List<Integer>> forest = new ArrayList<>();
		
		forest.add(Arrays.asList(1, 2, 3));
		forest.add(Arrays.asList(0, 0, 4));
		forest.add(Arrays.asList(7, 6, 5));
		int cutOffTree = r.cutOffTree(forest);
		System.out.println(cutOffTree);
	}
	 
	int numberOfReachableTrees=0;
	int numberOfSteps=0;
	int lastTreeCut[]= {0,0};
	Set<List<Integer>> seen = new HashSet<>();
	
	public int cutOffTree(List<List<Integer>> forest) {
		List<Integer> forestCol  = forest.get(0);
		Integer cell= forestCol.get(0);
		if(cell==0) return -1;
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		long numberOfTrees = forest.stream().flatMap(e->e.stream()).filter(e-> e>1).count();
		forest.stream().flatMap(e->e.stream()).filter(e-> e>1).forEach(e -> pq.add(e));
		
		getNumberOfReachableTrees( forest,0,0,pq);
		seen.clear();
		if(numberOfReachableTrees<numberOfTrees) {
			return -1;
		}
		
		System.out.println("tree cut off");	
		Queue<List<Integer>> q = new LinkedList<List<Integer>>();
		q.add(new ArrayList<Integer>(){{add(0);add(0);}});
		while(!q.isEmpty()) {
			q.peek();
		}
		while(!pq.isEmpty()) {
			
			/* 
			cutOfTrees(forest,lastTreeCut,pq,0);
			System.out.println(forest.get(lastTreeCut[0]).get(lastTreeCut[1])   );
			seen.clear();
			*/
			
		}
		return numberOfSteps;
		
		
		 
	}
	private void cutOfTrees(List<List<Integer>> forest, int[] p, PriorityQueue<Integer> pq, int k) {
		int r=p[0],c=p[1];
		if(isRestricted(forest, r, c, 0)) {
			return;
		}
		seen.add( new ArrayList<Integer>() {{add(r);add(c);}});
//		System.out.println("cell: "+forest.get(r).get(c));
		
		Integer ele =forest.get(r).get(c);
  		if(ele==pq.peek()) {
  			numberOfSteps+=k;
			pq.poll();
			ele=1;
			lastTreeCut= new int[] {r,c};
			return;
		}
  		
  		
  		cutOfTrees(forest,new int []{r+1,c},pq,k+1);
  		cutOfTrees(forest,new int []{r-1,c},pq,k+1);
  		cutOfTrees(forest,new int []{r,c+1} ,pq,k+1);
  		cutOfTrees(forest,new int []{r,c-1}, pq,k+1);
  		
	}
	private void getNumberOfReachableTrees(List<List<Integer>> forest, int r,int c, PriorityQueue<Integer> pq) {
		if(isRestricted(forest, r, c, 0)) {
			return;
		}
		seen.add( new ArrayList<Integer>() {{add(r);add(c);}});
		System.out.println("cell: "+forest.get(r).get(c));
		numberOfReachableTrees++;
		getNumberOfReachableTrees(forest,r+1,c,pq);
		getNumberOfReachableTrees(forest,r-1,c,pq);
		getNumberOfReachableTrees(forest,r,c+1,pq);
		getNumberOfReachableTrees(forest,r,c-1, pq);
	}
	private boolean isRestricted(List<List<Integer>> forest,int r, int c , int condition) {
		if(r>=forest.size()||r<0 ||c>=forest.get(0).size() || c<0||forest.get(r).get(c)==condition) {
			return true;
		}
		ArrayList<Integer> cell = new ArrayList<Integer>() {{add(r);add(c);}};
		if(seen.contains(cell)) {
			return true;
		}
		
		return false;
	}
	
		 
}
