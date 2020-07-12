package dataStructure;

public class ListNode<T> {

	 public T data;
	 public Integer val;
	 public ListNode<T> next;

	public ListNode(T data) {
	    this.data = data;
	    this.val = ( Integer) data;
	  }

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ListNode<T> getNext() {
		return next;
	}

	public void setNext(ListNode<T> next) {
		this.next = next;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ListNode))
			return false;

		ListNode listNode = (ListNode) o;

		if (!data.equals(listNode.data))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return data.hashCode();
	}

	@Override
	public String toString() {
//		ListNode l = this;
		StringBuilder sb = new StringBuilder();
//		while (l!= null) {
//			sb.append(l.val+"->");
//			l = l.next;
//		}
		return val.toString();
	}
	
	
}
