package topologicalSort;

import java.util.*;

class TopologicalSort2 {
	public static void main(String[] args) {
		TopologicalSort2 topo = new TopologicalSort2();
		int[] findOrder = topo.findOrder(3, new int[][] { { 1, 0 }, { 2, 0 }, { 1, 2 } });
		for (int i = 0; i < findOrder.length; i++) {
			System.out.println(findOrder[i]+":: ");
		}
	}

	Map<Integer, Integer> inDegree = new HashMap();

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] res = new int[numCourses];

		Map<Integer, List<Integer>> graph = createGraph(prerequisites, numCourses);
		Map<Integer, Integer> _inDegree = inDegree;
		Queue<Integer> q = new LinkedList<Integer>();
		inDegree.entrySet().stream().filter(e -> e.getValue() == 0).forEach(e -> q.add(e.getKey()));
		int i = 0;
		while (!q.isEmpty()) {
			int node = q.poll();
			res[i++] = node;
			for (Integer course : graph.get(node)) {// there could be a chance that node is not present in graph!
				int ind = inDegree.get(course);
				inDegree.put(course, --ind);
				if (inDegree.get(course) == 0) {
					q.add(course);
				}
			}
		}
		if (i == numCourses) {
			return res;
		}
		return new int[0];
	}

	Map<Integer, List<Integer>> createGraph(int[][] prerequisites, int num) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < num; i++) {
			graph.put(i, new ArrayList<Integer>());
			inDegree.put(i, 0);
		}
		for (int i = 0; i < prerequisites.length; i++) {
			int dependent = prerequisites[i][0];
			int dependee = prerequisites[i][1];

			List<Integer> dependents = graph.getOrDefault(dependee, new ArrayList<Integer>());
			dependents.add(dependent);
			graph.put(dependee, dependents);
			inDegree.put(dependent, inDegree.getOrDefault(dependent, 0) + 1);

			// This is to make sure we have info about this node in graph too and avoid NPE
			// .
			graph.put(dependent, graph.getOrDefault(dependent, new ArrayList<Integer>()));
			inDegree.put(dependee, inDegree.getOrDefault(dependee, 0));
		}
		return graph;
	}

}
