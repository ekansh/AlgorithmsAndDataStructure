package topologicalSort;

import java.util.*;

/*
 * graph.put("a",Arrays.asList("g","e"));
		graph.put("d",Arrays.asList("f","c"));
		graph.put("e",Arrays.asList("f"));
		graph.put("c",Arrays.asList("g","e"));
		graph.put("f",Arrays.asList("g"));
 * a-> g,e
 * 
 * d-> f c
 * e- f
 * f g
 * c e g 
 * 
 */
public class TopologicalSort1 {
	/*
	 * 		A			B
	 * 		   \  	   / \
	 * 			\     /	
	 * 			   C      |
	 *        /			  D	
	 *        E			  |
	 *        |	\_________F->G
	 *        H	
	 */
	public static void main(String[] args) {
		Map<String,List<String>> graph = new LinkedHashMap<>();
		graph.put("e",Arrays.asList("h","f"));
		graph.put("b",Arrays.asList("d","c"));
		graph.put("a",Arrays.asList("c"));
		graph.put("c",Arrays.asList("e"));
		graph.put("f",Arrays.asList("g"));
		graph.put("d",Arrays.asList("f"));
		Stack<String> res = new TopologicalSort1().sort(graph);
		for (String string : res) {
			System.out.print (string+"-->");
		}
	}

	private Stack<String> sort(Map<String, List<String>> graph) {
		Set<String> seen = new HashSet<>();
		Stack<String> res = new Stack<>();
		for (String node : graph.keySet()) {
			dfs(node,graph, seen, res);
			
		}
		return res;
	}

	private void dfs(String node, Map<String, List<String>> graph, Set<String> seen, Stack<String> res) {
		if (node == null || seen .contains(node)) return;
		seen.add(node);
		for(String neighbor: graph.getOrDefault(node, new ArrayList<String>()) ) {
			dfs(neighbor,graph, seen, res);
		}
		res.push(node);
		
	}	
	
	
	
	
}
