package dataStructure;


public class TreeNode<T> {
	public T t;
	public Integer val;
	public TreeNode<T> left;
	public TreeNode<T> right;

	public TreeNode(T t) {
		this.t = t;
		this.val=(Integer) t;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public TreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	public TreeNode<T> getRight() {
		return right;
	}

	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	 @Override
	public String toString() {
		// TODO Auto-generated method stub
		return t.toString();
	}

	
}
