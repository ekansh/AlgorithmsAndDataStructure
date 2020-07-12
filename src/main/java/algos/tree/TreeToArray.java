package algos.tree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import dataStructure.TreeNode;

public class TreeToArray {
	public static <T >void copyBST(TreeNode<T> root, List<T> l,int index){
		if (root == null) return;
		copyBST(root.left,l,index);
		l.set(index,root.t);
		index++;
		copyBST(root.right,l,index);
		
	}
	public static void main(String[] args) {
		String collect = Arrays.stream(new String[] {"1",null,"2"}).collect(Collectors.joining(","));
		System.out.println(collect);
	}
	 
}
