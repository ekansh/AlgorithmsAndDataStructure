package algos.tree;

import java.util.List;

import dataStructure.TreeNode;

public class TreeToArray {
	public static <T >void copyBST(TreeNode<T> root, List<T> l,int index){
		if (root == null) return;
		copyBST(root.left,l,index);
		l.set(index,root.t);
		index++;
		copyBST(root.right,l,index);
	}
	 
}
