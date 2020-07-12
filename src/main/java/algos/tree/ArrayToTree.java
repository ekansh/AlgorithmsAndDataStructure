package algos.tree;

import java.util.List;

import dataStructure.TreeNode;

public class ArrayToTree {
	public static <T> TreeNode<T> insertLevelOrder(List<T> list, TreeNode<T> root, int i) {
		if (i < list.size() && list.get(i)!=null) {
			root  =new TreeNode<T>(list.get(i));
			root.left = insertLevelOrder(list, root.left, 2 * i + 1);
			root.right = insertLevelOrder(list, root.right, 2 * i + 2);
		}
		return root;
	}
	public static <T> TreeNode<T> insertLevelOrder_original(List<T> list, TreeNode<T> root, int i) {
		if (i < list.size() ) {
			root  =new TreeNode<T>(list.get(i));
			root.left = insertLevelOrder(list, root.left, 2 * i + 1);
			root.right = insertLevelOrder(list, root.right, 2 * i + 2);
		}
		return root;
	}
	public static <T>  TreeNode<T> createBSTFromSortedArray(List<T> list, int start, int end) {
		if (end<start) {
			return null;
		}
		int mid = (start+end)/2;
		TreeNode<T> temp = new TreeNode<T>(list.get(mid));
		temp.left = createBSTFromSortedArray(list, start,mid-1);
		temp.right = createBSTFromSortedArray(list, mid+1,end);
		return temp;
	}
}
