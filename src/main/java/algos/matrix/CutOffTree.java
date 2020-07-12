package algos.matrix;

import java.util.*;

class CutOffTree {
	public static void main(String[] args) {
		CutOffTree c = new CutOffTree();
		List<List<Integer>> forest =new ArrayList<>();
		forest.add(Arrays.asList(1,2,3));
		forest.add(Arrays.asList(0,0,4));
		forest.add(Arrays.asList(7,6,5));
		
		c.cutOffTree(forest);
	}
    int[][] grid = null;
    public int cutOffTree(List<List<Integer>> forest) {
        int steps =0, smallSteps =0;
        PriorityQueue<List<Integer>> pq = createPQ(forest); // y , x and h
        Queue<List<Integer>> q  = new LinkedList<>(); // only y and x
        q.offer( Arrays.asList(0,0));
        Set<List<Integer>> seen = new HashSet<>(); // only y and x
        
        while(!pq.isEmpty() && !q.isEmpty()){
            List<Integer> tree = pq.poll();    
            List<Integer> sp =q.peek();
              smallSteps = cutTree(grid, sp.get(0),sp.get(1) , tree.get(0),tree.get(1));
            if(smallSteps ==-1){
                break;
            }
            steps+=smallSteps;
            q.clear();
            seen.clear();
            q.offer(  Arrays.asList(tree.get(0),tree.get(1)) );
            
        }
        return pq.isEmpty() && smallSteps>=0 ?  steps:-1;
    }
    public int cutTree(int[][] grid, int start_row, int start_col, int end_row, int end_col) {
		HashSet<List<Integer>> seen = new HashSet<>();
		Queue<List<Integer>> q = new LinkedList<>();
		q.offer(Arrays.asList(start_row, start_col));
		int len = 0;

		while (!q.isEmpty()) {
			int breadth = q.size();
			for (int i = 0; i < breadth; i++) {
				List<Integer> e = q.poll();
				if (seen.contains(e)) {
					continue;
				}
				seen.add(e);
				if (e.get(0) == end_row && e.get(1) == end_col) {
					return len;
				}
				pushAdjacentInQ(grid, q, e, seen);
				print(q, seen);
			}
			len++;
		}
		return -1;
	}
    private void pushAdjacentInQ(int[][] grid, Queue<List<Integer>> q, List<Integer> e, Set<List<Integer>> seen) {
		int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		for (int i = 0; i < dir.length; i++) {
			int Y = dir[i][0] + e.get(0);
			int X = dir[i][1] + e.get(1);
			List<Integer> n = Arrays.asList(Y, X);
			if (X >= 0 && X < grid[0].length && Y >= 0 && Y < grid.length && grid[Y][X] > 1 && !seen.contains(n)) {
				q.offer(n);
			}
		}
	}
	private PriorityQueue<List<Integer>> createPQ(List<List<Integer>> forest) {
        grid = new int [forest.size()][forest.get(0).size()];
        PriorityQueue<List<Integer>> pq =  new PriorityQueue<>((a,b)->a.get(2)-b.get(2));
        for ( int i =0; i< forest.size(); i++){
            for ( int j =0 ; j<forest.get(0).size(); j++){
            	if(forest.get(i).get(j) <=1)  continue;
                pq.offer(Arrays.asList(i,j,forest.get(i).get(j)));
                grid[i][j]= forest.get(i).get(j);
            }
        }
        return pq;
    }
	private void print(Queue<List<Integer>> q, HashSet<List<Integer>> seen) {
		if (q instanceof LinkedList<?>) {
			System.out.print("q= ");
			LinkedList<List<Integer>> l = (LinkedList<List<Integer>>) q;
			for (List<Integer> is : l) {
				System.out.print(is.get(0) + ":" + is.get(1) + ", ");
			}
			System.out.println();
		}
		System.out.print("seen= ");
		for (List<Integer> is : seen) {
			System.out.print(is.get(0) + ":" + is.get(1) + ", ");
		}
		System.out.println();
	}
}
