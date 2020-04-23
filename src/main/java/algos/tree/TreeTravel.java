package algos.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executors;

import dataStructure.TreeNode;

class Solution{
	public void inorder(TreeNode<Integer> root) {
		if (root == null) return;
		inorder(root.getLeft());
		System.out.print(root.getT()+",");
		inorder(root.getRight());
	}
	public void preorder(TreeNode<Integer> root) {
		if (root == null) return;
		System.out.print(root.getT()+",");
		preorder(root.getLeft());
		preorder(root.getRight());
	}
	public void postorder(TreeNode<Integer> root) {
		if (root == null) return;
		postorder(root.getLeft());
		postorder(root.getRight());
		System.out.print(root.getT()+",");
	}
	public void levelOrder(TreeNode<Integer> root) {
		Queue<TreeNode<Integer>> q= new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode<Integer> poll = q.poll();
			System.out.print(poll.getT()+",");
			TreeNode<Integer> left = poll.getLeft();
			if ( left !=null ) {
				q.add(poll.getLeft());
			}
			TreeNode<Integer> right = poll.getRight();
			if( right!=null) {
				q.add(poll.getRight());
			}
		}
	}
}

public class TreeTravel {
	public static void main(String[] args) {
		Solution solution = new Solution();
		List<Integer> asList = Arrays.asList(1,2,3,4,5,6,7,8);
		TreeNode<Integer> root = ArrayToTree.insertLevelOrder(asList,null,0);
		/* Tree will look =>
		 * 		    1
		 * 	   2		3
		 *   4	5	   6	7
		 * 8
		 */
		solution.inorder(root);
		System.out.println();
		solution.levelOrder(root);
		System.out.println();
		System.out.println("==================================");
		TreeNode<Integer> rootHeap = ArrayToTree.createBSTFromSortedArray(asList,0,asList.size()-1);
		/* Tree will look =>
		 * 		    4
		 * 	   2		6
		 *   1	3	  5	  7
		 *                   8
		 */
		solution.inorder(rootHeap);
		System.out.println();
		solution.levelOrder(rootHeap);
		
	}
	
}

