package algos.tree;

import dataStructure.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class X{
	    public boolean isSubtree(TreeNode s, TreeNode t) {
	        Queue<TreeNode> q = new LinkedList<>();
	        q.offer(s);
	        while( !q.isEmpty()){
	            TreeNode  p = q.poll();
	            if ( p.val == t.val && inorder( p,t)){
	                return true;
	            }
	            if ( p.left != null )
	            q.offer(p.left);
	            if( p.right!=null)
	            q.offer(p.right);
	        }
	        return   false;
	         
	    }
	     public boolean inorder(TreeNode s, TreeNode t) {
	         if(  t== null && s== null){
	            return true;
	         }else  if(  s== null && t!=null ){
	            return false;
	         }else  if(  s!= null && t==null ){
	            return false;
	         }else if (s.val!=t.val){
	             return false;
	         }
	         
	         boolean l = inorder(s.left,t.left);
	         boolean r = inorder(s.right,t.right);
	         return s.val == t.val && l && r;
	         
	        
	    }
	    
	     
}
class S {
	public boolean isSymmetric(TreeNode root) {
		return isMirror("0", root, root);
	}

	public boolean isMirror(String st, TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return true;
		if (t1 == null || t2 == null)
			return false;

		boolean mirror1 = isMirror("f", t1.left, t2.right);
		System.out.println(st + " : T1 " + t1.val + " T2 " + t2.val);
		boolean mirror2 = isMirror("s", t1.right, t2.left);
		return (t1.val == t2.val) && mirror1 && mirror2;
	}

	public boolean isSymmetricV1(TreeNode root) {
		if (root == null)
			return true;
		return isMirrorV1("0", root, root);
	}

	public boolean isMirrorV1(String st, TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return true;
		if (t1 == null || t2 == null)
			return false;

		boolean mirror1 = isMirrorV1("f", t1.left, t2.right);
		System.out.println(st + " : T1 " + t1.val + " T2 " + t2.val);
		boolean mirror2 = isMirrorV1("s", t1.right, t2.left);
		return (t1.val == t2.val) && mirror1 && mirror2;
	}
}

class Solution {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		TreeNode s1 = inorder(s, t);
		if (s1 == null)
			return false;
		System.out.println("node found " + s1.val);
		return sub(s1, t, "");
	}

	public TreeNode inorder(TreeNode s, TreeNode t) {
		if (s == null)
			return null;
		if (s.val == t.val)
			return s;
		TreeNode r = null, r1 = null;
		if (s.left != null) {
			r = inorder(s.left, t);
		}
		if (s.right != null) {
			r1 = inorder(s.right, t);
		}

		return r == null ? r1 : r;
	}

	public boolean sub(TreeNode s, TreeNode t, String msg) {
		if (s == null && t == null)
			return true;
		if (s == null || t == null)
			return false;
		System.out.println("node found by " + msg + ":" + s.val + ":" + t.val);
		boolean r1 = sub(s.left, t.left, "f");
		boolean r2 = sub(s.right, t.right, "s");
		return s.val == t.val && r1 && r2;
	}
	   
}


public class ValidateBinaryTree {
	
	
	  private static boolean isValid(String s){
	        int op=0, cl =0;
	        for ( int i =0; i< s.length(); i++){
	            if(s.charAt(i)=='(') op++;
	            else if(s.charAt(i)==')' && op<=0){
	                return false;
	            }else if(s.charAt(i)==')' && op>0){
	                op--;
	            }
	        }
	       return op == 0?  true: false;
	    }
	public static void main(String[] args) {
		boolean valid = isValid("");
		System.out.println(valid);
		System.exit(0);
//		List<Integer> range = IntStream.rangeClosed(1, 15)
//			    .boxed().collect(Collectors.toList());
//		TreeNode<Integer> t1 = ArrayToTree.insertLevelOrder(range, null, 0);
//		ItterativeTreeTravel.levelOrderWithMultiLine(t1);
//		System.out.println("----------------");

		TreeNode<Integer> t2 = ArrayToTree.insertLevelOrder(Arrays.asList(3,4,5,1,2), null, 0);
		ItterativeTreeTravel.levelOrderWithMultiLineV1(t2);
		TreeNode<Integer> t3 = ArrayToTree.insertLevelOrder(Arrays.asList(4,1,2), null, 0);
		ItterativeTreeTravel.levelOrderWithMultiLineV1(t3);
//		
		List<Integer> collect = Stream.of(1, 2, 3, 4, 5, 6, 7, 8).collect(Collectors.toList());
		List<Integer> asList = Arrays.asList(11, 8, 4, 4, 5, 8, 8, 10, 15, 12, 12, 14, 15, 15, 16);
		asList.sort((a, b) -> a - b);

		TreeNode<Integer> bst1 = ArrayToTree.createBSTFromSortedArray(asList, 0, asList.size() - 1);
//		
		System.out.println("-------------");
		TreeTravel.levelOrderWithMultiLine(bst1);
		ItterativeTreeTravel.levelOrderWithMultiLineV1(bst1);
		System.out.println("-------------");
//		TreeTravel.inorder(t1);
//		System.out.println();
//		System.out.println("max stack size " + TreeTravel.maxStackSize);

		boolean trimBST = new X().isSubtree(t2, t3) ;
		System.out.println();
//		System.out.println("--->" + findMode);
//		TreeTravel.preorder(bst1);
//		System.out.println();
//		TreeTravel.postorder(bst1);
		List<Integer> t9 = Arrays.asList(28,12,45,4,24,35,47,2,9,14,25,31,42,46,48,0,3,8,11,13,20,26,30,33,41,43,49,1,7,10,17,22,27,29,32,34,36,44,6,16,18,21,23,37,5,15,19,40,39,38);

		t9.sort((a, b) -> a - b);
		TreeNode<Integer> bst9 = ArrayToTree.createBSTFromSortedArray(t9, 0, t9.size() - 1);
		int closestValue = new Y().closestValue(bst9, 2.0000);
		System.out.println(closestValue);
	}

	
	
}
class Y{
	  public int closestValue(TreeNode root, double target) {
	        ArrayList<Integer> l  = new ArrayList<>();
	        inorder(root,l);
	        int start =0, end = l.size()-1;
	        while (start<=end){ // start  ==end
	            int mid  = start + (end-start)/2;
	            if( mid+1 == l.size()) return mid+1;
	            if(   l.get(mid) <target && l.get(mid+1) >target) {
	                return  target -l.get(mid) < l.get(mid+1)-target ? l.get(mid): l.get(mid+1); // Big Integer
	            }else if ( l.get(mid) >target){
	                end = mid-1;
	            }else if ( l.get(mid) <target){
	            	start = mid+ 1;
	            }
	           
	        }
	         return l.get(0);
	    }
	    public void inorder(TreeNode root, ArrayList<Integer> l ){
	        if ( root == null ) return ;
	        inorder(root.left,l);
	        l.add(root.val);
	        inorder(root.right,l);
	    }
}