package algos.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import dataStructure.TreeNode;

public class ItterativeTreeTravel {
	public static void levelOrderWithMultiLineV2(TreeNode root) {

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		int curLvl = 1;
		int nextLvl = 0;

		while (root != null && !q.isEmpty()) {
			TreeNode poll = q.poll();
			curLvl--;
			System.out.print(poll.val + ", ");
			if (poll.left != null) {
				q.offer(poll.left);
				nextLvl++;
			}
			if (poll.right != null) {
				q.offer(poll.right);
				nextLvl++;
			}
			if (curLvl == 0) {
				curLvl = nextLvl;
				nextLvl = 0;
				System.out.println();
			}

		}
	}

	public static void levelOrderWithMultiLineV1(TreeNode root) {

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		int curLvl = 1;
		int nextLvl = 0;

		while (root != null && !q.isEmpty()) {
			int breadth = q.size();
			for (int i = 0; i < breadth; i++) {
				TreeNode poll = q.poll();
				System.out.print(poll.val + ", ");
				if (poll.left != null) {
					q.offer(poll.left);
				}
				if (poll.right != null) {
					q.offer(poll.right);
				}
			}
			System.out.println();
		}
	}

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;

		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			// main function lies below
			curr = stack.pop();
			res.add(curr.val);
			curr = curr.right;
		}
		return res;
	}

	public List<Integer> preorderTraversal1(TreeNode root) {
		LinkedList<TreeNode> stack = new LinkedList<>();
		LinkedList<Integer> output = new LinkedList<>();
		if (root == null) {
			return output;
		}

		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pollLast();
			output.add(node.val);
			if (node.right != null) {
				stack.add(node.right);
			}
			if (node.left != null) {
				stack.add(node.left);
			}
		}
		return output;
	}
	public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        while(cur!= null || !st.isEmpty()){
            while(cur!=null){
                res.add(cur.val);
                if( cur.right!=null)st.push(cur.right);
                cur  = cur.left;
            }
            cur = st.isEmpty()? null:st.pop();
        }
        return res;
        
    }
	 public List<Integer> postorderTraversal(TreeNode root) {
		    LinkedList<TreeNode> stack = new LinkedList<>();
		    LinkedList<Integer> output = new LinkedList<>();
		    if (root == null) {
		      return output;
		    }

		    stack.add(root);
		    while (!stack.isEmpty()) {
		      TreeNode node = stack.pollLast();
		      output.addFirst(node.val);
		      if (node.left != null) {
		        stack.add(node.left);
		      }
		      if (node.right != null) {
		        stack.add(node.right);
		      }
		    }
		    return output;
		  }
}
