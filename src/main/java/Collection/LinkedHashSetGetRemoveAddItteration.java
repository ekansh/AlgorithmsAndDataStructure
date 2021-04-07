package Collection;

import java.util.*;

public class LinkedHashSetGetRemoveAddItteration {
	public static void main(String[] args) {
		addTest();
//		 Set<Integer>  l = new  HashSet<Integer>( );
//		l.add(0);
//		l.add(1); l.add(2);l.add(1);l.add(0);l.add(0);l.add(0);l.add(0);l.add(2);
//		for (Integer integer : l) {
//			System.out.println(integer);
//		}
	}
	private static void addTest() {
		Map<Integer, Integer> m = new LinkedHashMap<>();
		m.put(1,2);m.put(2,4);m.put(3,5);m.put(1,2);
//		for (Integer i : m.keySet()) {
//			System.out.println(i);
//		}
		Integer next = m.keySet().iterator().next();
		System.out.println(next);
	}
}


 

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
