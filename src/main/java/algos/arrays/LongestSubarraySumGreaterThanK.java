package algos.arrays;

import java.util.*;
import java.util.Map.Entry;

public class LongestSubarraySumGreaterThanK {
	public static void main(String[] args) {
		LongestSubarraySumGreaterThanK m = new LongestSubarraySumGreaterThanK();
		List<Integer> asList = Arrays.asList(-2, 3,1,-2,1,1);
		int k1 = m.maximumContiguousSubArrayBFS(asList, 3);
	}

	private int maximumContiguousSubArrayBFS(List<Integer> list, int k) {
		LinkedList<Integer> prefixSum = createPrefixSum(list);
		
		Map<String,LinkedList<Integer>> subArray = new HashMap<>();
		subArray.put(0+"-"+(list.size()-1), prefixSum);
		Queue<Map<String,LinkedList<Integer>>> q = new LinkedList<>();
		q.add(subArray);
		
		String indexFound =null;
		while(!q.isEmpty() && indexFound==null) {
			int breadth = q.size();
			for (int i = 0; i < breadth; i++) {
				Map<String, LinkedList<Integer>> currentSubArrayMap = q.poll();
				Entry<String, LinkedList<Integer>> next = currentSubArrayMap.entrySet().iterator().next();
				String currentSubArrayIndex = next.getKey();
				LinkedList<Integer> currentSubArray = next.getValue();
				if(currentSubArray.get(currentSubArray.size()-1)>=k) {
					indexFound = currentSubArrayIndex;
					break;
				}else {
					int start =Integer.valueOf(currentSubArrayIndex.split("-")[0]), 
							end = Integer.valueOf(currentSubArrayIndex.split("-")[1]);
					int last =currentSubArray.removeLast();
					
					Map<String,LinkedList<Integer>> m = new HashMap<>();
					m.put(start+"-"+(end-1), new LinkedList<Integer>(currentSubArray));
					q.add(m);
					
					currentSubArray.addLast(last);
					
					int first =currentSubArray.removeFirst();
					Map<String,LinkedList<Integer>> m1 = new HashMap<>();
					LinkedList<Integer> linkedList = new LinkedList<Integer>( );
					for (int j = 0; j < currentSubArray.size(); j++) {
						Integer integer = currentSubArray.get(j);
						linkedList.add(integer-first);
					}
					m1.put(start+1+"-"+(end), linkedList);
					q.add(m1);
					currentSubArray.addFirst(first);
				}
				 
				
			}
		}
		System.out.println(indexFound);
		return 0;
		
	}
	
	private LinkedList<Integer> createPrefixSum(List<Integer> list) {
		LinkedList<Integer> prefixSum = new LinkedList<>();
		int sum =0;
		for (Integer integer : list) {
			sum+=integer;
			prefixSum.add(sum);
		}
		return prefixSum;
	}
	 

	private int maximumContiguousSubArraySumBruteForce(List<Integer> list, int k) {
		int sum = list.get(0), t_sum = 0, L = 0, R = 0;
		for (int i = 0; i < list.size(); i++) {
			t_sum = 0;
			for (int g = i; g < list.size(); g++) {
				t_sum = t_sum + list.get(g);
				if (t_sum >= k && (g - i + 1) > (R - L + 1)) {
					R = g;
					L = i;
				}
			}
		}
		System.out.println("->:" + L + ":" + R);
		return 0;
	}
}
