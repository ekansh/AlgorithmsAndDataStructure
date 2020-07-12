import java.util.*;

import dataStructure.TreeNode;

class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		List<List<Integer>> connections = new ArrayList<List<Integer>>();
		connections.add(Arrays.asList(0,1));
		connections.add(Arrays.asList(2,0));
		connections.add(Arrays.asList(1,3));
		connections.add(Arrays.asList(1,2));
//		s.dietPlanPerformance(new int[] {3,6,5,4,11,10},1,0,5);
		int numEquivDominoPairs = s.numEquivDominoPairs(new int[][] {{1,2},{1,2},{1,1},{1,2},{2,2}});
		System.out.println(numEquivDominoPairs);
//		System.out.println(longestPalindrome);
		Integer a= 1;
		Integer b = null;
		System.out.println(a==b);
	}
	
	int sum =0;
	int counter=0;
	int s ;
	  public void MovingAverage(int size) {
		  s =size;
	     
	    }
	    
	    public double next(int val) {
	        LinkedList<Integer> l = new LinkedList<Integer>();
	        if(counter ==s) {
	        	sum =sum - l.getFirst();
	        	l.removeFirst();
	        	counter--;
	        }
	    	sum =sum +val;
	    	l.add(val);
	        counter++;
	        
	        return sum/counter;
	    }
	 public int numEquivDominoPairs(int[][] dominoes) {
	        int n  =0;
	        Map<String,List<String>> m = new HashMap<>();
	        for (int i =0;i<dominoes.length;i++) {
	        	int[] js = dominoes[i];
				Arrays.sort(js);
				String k =js[0]+":"+js[1];
				m.putIfAbsent(k, new  ArrayList<String>());
				m.get(k).add(k);
			}
	        
	        for ( String l: m.keySet()) {
				int a =m.get(l).size();
				int f =getAc2(a);
				n+=f;
			}
//	        
//	        for (int i =0;i<dominoes.length;i++) {
//	        	int[] js = dominoes[i];
//				Arrays.sort(js);
//			}
//	        Arrays.sort(dominoes, (a,b)->a[0] ==b[0] ?a[1]-b[1]: a[0]-b[0]);
//	        int  p =0;
//	        while( p+1<dominoes.length) {
//	        	if(dominoes[p][0] == dominoes[p+1][0] && dominoes[p][1] == dominoes[p+1][1]) {
//	        		n++;
//	        	}else if(dominoes[p][1] == dominoes[p+1][0] && dominoes[p][0] == dominoes[p+1][1]) {
//	        		n++;
//	        	}
//	        	p++;
//	        }
	        return n;
	    }
	private int getAc2(int a) {
		int v = (a-1)*a/2;
		return v;
	 
	}
	public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int sum =0,points =0;
        int l =0, r=k-1;
        for( int i =0; i<calories.length && i<k; i++) sum+=calories[i];
        if(sum<lower) points--;
    	if(sum>upper) points++;
        while(r+1<calories.length) {
        	sum =sum + calories[r+1] -calories[l];
        	if(sum<lower) points--;
        	if(sum>upper) points++;
        	r++;
        	l++;
        }
        return points;
    }
	
	public boolean isSubtree(TreeNode s, TreeNode t) {
	        return inorder(s,t);
	}
	public boolean inorder(TreeNode s, TreeNode t) {
		Stack<TreeNode> stk = new Stack<TreeNode>();
		TreeNode cur  =s;
		while ( cur!=null || !stk.isEmpty()) {
			while( cur!=null) {
				stk.push(cur);
				cur = cur.left;
			}
			TreeNode pop = stk.pop();
			if( pop.val == t.val) {
				boolean f = checkSubtreeStruct(pop,t);
				if (f) return true;
			}
			cur = cur.right;
		}
		return false;
	}
	 private boolean checkSubtreeStruct (TreeNode pop, TreeNode t) {
		 if( pop ==null && t == null ) return true;
		 if ( pop ==null  || t == null ) return false;
		 if(pop.val != t.val ) return false;
		 return checkSubtreeStruct1(pop.left, t.left) &&	 checkSubtreeStruct1(pop.right, t.right);
	 }
	 private boolean checkSubtreeStruct1(TreeNode pop, TreeNode t) {
			Stack<TreeNode> stk1= new Stack<TreeNode>();
			Stack<TreeNode> stk2 = new Stack<TreeNode>();
			stk1.add(pop);stk2.add(t);
			while (  !stk1.isEmpty()  &&  !stk2.isEmpty() ) {
				TreeNode a = stk1.pop();
				TreeNode b = stk2.pop();
				if(     a.val!=b.val ) {
					return false;
				}
				if(a.right!=null && b.right==null) {
					return false;
				}else if(a.right!=null && b.right!=null){
					stk1.push(a.right);
					stk2.push(b.right);
				}
				if(a.left!=null && b.left==null) {
					return false;
				}else if(a.left!=null && b.left!=null) {
					stk1.push(a.left);
					stk2.push(b.left);
				}
			 
			}
			return true;
		}
	    

	/**
	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
		HashMap<Integer, Node> m = new HashMap< >();
		for (List<Integer> list : connections) {
			Integer i1 = list.get(0);
			m.putIfAbsent(i1,new Node(i1));
			
			Integer i2 = list.get(1);
			m.putIfAbsent(i2,new Node(i2));
			Node n1 = m.get(i1);
			Node n2 = m.get(i2);
			n1.l.add(n2);
			n2.l.add(n1);
		}
		Set<String> tested= new HashSet<String>();
		for (Integer i : m.keySet()) {
			Node node = m.get(i);
			for ( Node con  : node.l) {
				String testingA = i+":"+con.v;
				String testingB =con.v +":"+i;
				if(tested.contains(testingA) ||tested.contains(testingB)) {
					continue;
				}
				boolean r =conTest(con,node);
				if(!r) {
					result.add(new ArrayList<Integer>() {{add(i);add(con.v);}});
				}
				tested.add(testingB);tested.add(testingA);
			}
		}
		return result;
		
	}
	private boolean conTest( Node n1, Node n2) {
		Queue<Node> q  = new LinkedList<>();
		q.add(n1);
		Set<Node > seen  = new HashSet<> ();
		boolean reached =false;
		while(!reached && !q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node poll = q.poll();
				if(seen.contains(poll)) continue;
				seen.add(poll);
				if( poll.v ==n2.v) {
					reached = true;
					break;
				}
				for(Node conns : poll.l) {
					if(poll.v == n1.v && conns.v == n2.v) {
						continue;
					}
					q.add(conns);
				}
			}
		
		}
		return reached;
	}
	private static class Node{
		int v;
		List<Node> l  = new ArrayList<>();
		Node(int a ) {
			v =a;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return v+"";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + v;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (v != other.v)
				return false;
			return true;
		}
		
	}
	*/
}
