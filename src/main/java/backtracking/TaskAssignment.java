package backtracking;

import java.util.*;

/**
 * Given list of people and task they can do We need to assign task to people
 * such that every person gets one task and no one is idle. Lets say for
 * simplicity we number of people = number of tasks  
 * if we assign a= 1 , b=3, c=2,d wont have any eligible task
 * example:
 * people : task
 * a: 		1,2 
 * b: 		3,4
 * c:		2,4
 * d:  		1,3
 * however a= 2 , b=3, c=4,d =1 is perfect. 
 * If there are multiple solutions return any solution 
 */
public class TaskAssignment {
	public static void main(String[] args) {
		TaskAssignment t = new TaskAssignment();
		t.getTaskAssignment(Arrays.asList("a", "b", "c", "d"),
				Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(2, 4), Arrays.asList(1, 3)));
		t.finalRes.entrySet().forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));
	}

	public Map<String, Integer> getTaskAssignment(List<String> people, List<List<Integer>> tasks) {
		Map<String, Integer> m = new HashMap<>();
		backtrack(people, tasks, 0, new HashSet<>());
		return finalRes;
	}

	Map<String, Integer> res = new HashMap<>(), finalRes = null;

	private void backtrack(List<String> people, List<List<Integer>> tasks, int pos, Set<Integer> assigned) {
		if (finalRes != null)
			return;
		if (pos == people.size()) {
			System.out.println(res.size());
			if (res.size() == people.size()) {
				finalRes = new HashMap<>(res);
			}
		}

		for (int i = pos; i < people.size(); i++) {
			String thisPerson = people.get(i);
			List<Integer> thisPersonsElligbleTasks = tasks.get(i);
			for (Integer aTask : thisPersonsElligbleTasks) {
				if (assigned.contains(aTask))
					continue;
				assigned.add(aTask);
				res.put(thisPerson, aTask);
				backtrack(people, tasks, pos + 1, assigned);
				res.remove(thisPerson);
				assigned.remove(aTask);
			}
		}
	}

}
