package algos.tree;

public class Tree1 {
	public static void main(String[] args) {
		String s ="h";
		int map [] = new int[26];// all 0 in the begining
		for ( int i =0 ; i< s.length(); i++){
			map[s.charAt(i)-'a'] = map[s.charAt(i)-'a'] == 0?1 :0;		
		}
		int sum =0;
		for ( int i =0 ; i< map.length; i++){
			sum +=map[i];		
		}
		System.out.println( sum == 0 || sum ==1);
	}

	public static class BinaryTreeNode {

		public int value;
		public BinaryTreeNode left;
		public BinaryTreeNode right;

		public BinaryTreeNode(int value) {
			this.value = value;
		}

		public BinaryTreeNode insertLeft(int leftValue) {
			this.left = new BinaryTreeNode(leftValue);
			return this.left;
		}

		public BinaryTreeNode insertRight(int rightValue) {
			this.right = new BinaryTreeNode(rightValue);
			return this.right;
		}
		public String toString() {
			return value+"";
		}
	}

	public static boolean isBalanced(BinaryTreeNode treeRoot) {

		sbal = true;
		int k = po(treeRoot);
//		System.out.println(sbal);
		return sbal;
	}

	static boolean sbal = true;

	public static int po(BinaryTreeNode n) {
		if (!sbal)
			return 0;
		if (n == null)
			return 0;
		int l = 1 + po(n.left);
		int r = 1 + po(n.right);
		if( n.left == null) {
			return r ;
		}
		if( n.right== null) {
			return l ;
		}
		if (l - r < -1 || l - r > 1) {
			sbal = false;
		}
		return Math.min(l, r);
	}
}