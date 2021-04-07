package algos.tree;

import java.util.*;

import dataStructure.TreeNode;

public class SerializeDeserializeTree {
	public static void main(String[] args) {
		//deserialize
		TreeNode<Integer> t2 = ArrayToTree.insertLevelOrder(Arrays.asList(3,null,5,null,null,1,2), null, 0);
		ItterativeTreeTravel.levelOrderWithMultiLineV1(t2);
		//serialize
		List<Integer> g = new ArrayList<Integer>();
		TreeToArray.copyBST(t2, g, 0);
		g.stream().forEach(e->System.out.print(e+","));
	}
}
