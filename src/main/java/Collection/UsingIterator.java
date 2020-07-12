package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

class UsingIterator {
	Set<List<Integer>> r= new HashSet<>();
	public static void main1(String[] args) {
		UsingIterator s = new UsingIterator();
//		int[][] i = { { 0, 1 }, { 1, 2 }, { 2, 0 }, { 1, 3 } };
		List<Integer> asList = Arrays.asList(1,2,3,4);
		System.out.println(asList.getClass());
	}
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>() ;
		l.add(1); l.add(2);l.add(3);l.add(4);
//		l.remove(1);
//		for (Integer integer : l) {
//			l.add(12);
//			System.out.println(integer);
//			l.stream().forEach(System.out::print);
//		}
		
//		for (int j = 0; j < l.size(); j++) {
//			l.add(1);
//			System.out.println(l.get(j));
//			if(j==10)break;
//			l.remove(1);
//		}
		int k =0;
		
		for ( ListIterator< Integer >iterator = l.listIterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.println(integer);
//			iterator.add(1);;
			iterator.remove();
			l.stream().forEach(System.out::print);
			System.out.println();
		}
//		l.stream().forEach(System.out::print);
		System.out.println(l.size());
	}

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		return connections;
		
	}
	public List<List<Integer>> allCriticalConnections(int n, List<List<Integer>> connections) {
		int i =0; 
		for (List<Integer> path : connections) {
			connections.remove(path);
			boolean ifAllAccessible = ifAllAccessible(path,connections);
			if(ifAllAccessible) {
				r.add(path);
			}
			connections.add(path);
		}
		
		return connections;
		
	}

	public boolean ifAllAccessible(List<Integer> path, List<List<Integer>> connections ) {
		return true;
	}

	public Set<Integer> allNodes(Integer[][] x) {
		Set<Integer> collect = Arrays.stream(x).flatMap(e -> Arrays.stream(e)).collect(Collectors.toSet());
		return collect;
	}
}