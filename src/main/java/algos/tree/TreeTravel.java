package algos.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import dataStructure.TreeNode;

public class TreeTravel {
	private static Stack<TreeNode> s = new Stack<>();
	public static int maxStackSize = Integer.MIN_VALUE;
	/**
	 * Use it like this : travel(root,new ArrayList<TreeNode>(), all); where all =>
	 * List<List<TreeNode>> all = new ArrayList<List<TreeNode>>();
	 * 
	 * @param root
	 * @param l
	 * @param all
	 */
	public static void listAllPaths(TreeNode root, List<TreeNode> l, List<List<TreeNode>> all) {
		if (root == null) {
			return;
		}
		l.add(root);
		if (root.left == null && root.right == null) {
			List<TreeNode> copy = new ArrayList<TreeNode>(l);
			all.add(copy);
		}
		listAllPaths(root.left, l, all);
		listAllPaths(root.right, l, all);
		l.remove(root);
		
	}
	/**
	 * inorder recursive travel . It will help in maintaining Prev and Current 
	 * @param root
	 */
	public static void inorder(TreeNode<Integer> root) {
		maxStackSize = Math.max( maxStackSize,s.size());
		if (root == null)
			return;
		inorder(root.getLeft());
			System.out.println("CUR: " + root.getT() + ",");
			TreeNode prev = null;
			if (!s.isEmpty())
				prev = s.pop();
			System.out.println("Prev: " + prev + ",");
			s.push(root);
		inorder(root.getRight());
//		if (!s.isEmpty())
//		s.pop();
	}

	public static void preorder(TreeNode<Integer> root) {
		if (root == null)
			return;
		System.out.print(root.val + ",");
		preorder(root.left);
		preorder(root.right);
	}

	public static void postorder(TreeNode<Integer> root) {
		if (root == null)
			return;
		postorder(root.getLeft());
		postorder(root.getRight());
		System.out.print(root.getT() + ",");
	}

	public static void levelOrder(TreeNode<Integer> root) {
		Queue<TreeNode<Integer>> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode<Integer> poll = q.poll();
			System.out.print(poll.getT() + ",");
			TreeNode<Integer> left = poll.getLeft();
			if (left != null) {
				q.add(poll.getLeft());
			}
			TreeNode<Integer> right = poll.getRight();
			if (right != null) {
				q.add(poll.getRight());
			}
		}
	}
	
	public static void levelOrderWithMultiLine(TreeNode<Integer> root) {
		System.out.println("WARNING : using number 88 to determine the next depth");
		Queue<TreeNode<Integer>> q = new LinkedList<>();
		q.add(root);
		Integer separator=188;
		q.add(new TreeNode<Integer>(separator));// this will help in identifying when we have completed first breadth
		while (!q.isEmpty()) {
			TreeNode<Integer> poll = q.poll();
			if (poll.t != null && poll.t == separator) {
				System.out.println();
				if (!q.isEmpty()) {
					q.add(new TreeNode<Integer>(separator));
				}
			} else {
				System.out.print(poll.getT() + ",");
				TreeNode<Integer> left = poll.getLeft();
				if (left != null) {
					q.add(poll.getLeft());
				}
				TreeNode<Integer> right = poll.getRight();
				if (right != null) {
					q.add(poll.getRight());
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		TreeTravel treeTravel = new TreeTravel();
		List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		TreeNode<Integer> root = ArrayToTree.insertLevelOrder(asList, null, 0);
		/*
		 * Tree will look => 1 2 3 4 5 6 7 8
		 */
		treeTravel.inorder(root);
		System.out.println();
		treeTravel.levelOrder(root);
		System.out.println();
		System.out.println("==================================");
		TreeNode<Integer> rootHeap = ArrayToTree.createBSTFromSortedArray(asList, 0, asList.size() - 1);
		/*
		 * Tree will look => 4 2 6 1 3 5 7 8
		 */
		treeTravel.inorder(rootHeap);
		System.out.println();
		treeTravel.levelOrder(rootHeap);

	}

}
