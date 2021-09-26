package backtracking;

import java.util.*;

public class StockWithCoolDown {
	Map<Integer, Integer> m = new HashMap<>();

	public int maxProfit(int[] prices, int bd) {
		if (bd >= prices.length - 1) {
			return 0;
		}

		int pr = 0;
		for (int i = bd; i < prices.length; i++) {
			if (prices[bd] < prices[i]) {
				pr = Math.max((prices[i] - prices[bd]) + maxProfit(prices, i + 2), pr);
			} else {
				bd = i;
			}
		}

		return pr;
	}
	
	public void relevantString() {
		String s[][] = new String[][]{{"c", "p", "w"},{"p", "w", "t"},{"w", "t", "pe"}};
		Map<String , TreeMap<String, Integer >> graph  = new HashMap<>();
		for (int i = 0; i < s.length; i++) {
			String[] mainList = s[i];
			for (int j = 0; j < mainList.length; j++) {
				String ele = mainList[j];
				graph.putIfAbsent(	ele	,new TreeMap<String,Integer>());
				for ( int k =j+1;k<mainList.length;k++) {
					TreeMap<String, Integer> treeMap = graph.get(ele);
					treeMap.put(mainList[k],treeMap.getOrDefault(mainList[k], 0)+1);
					
					graph.putIfAbsent(mainList[k], new TreeMap<String,Integer>());
					TreeMap<String, Integer> treeMap2 = graph.get(mainList[k]);
					treeMap2.put(ele,treeMap2.getOrDefault(ele, 0)+1);
				}
			}
		}
		Map<String, List<String>>  res = new HashMap<>();
		for(String key: graph.keySet()) {
			TreeMap<String, Integer> treeMap = graph.get(key);
			System.out.print(key+"=>");
			int min =0;
			res.put(key, new ArrayList<String>());
			for (String	k :treeMap.keySet()) {
				System.out.print(k+":"+treeMap.get(k));
				if ( treeMap.get(k)>min) {
					min = treeMap.get(k);
					res.put(key, new ArrayList<String>());
				}
				if ( treeMap.get(k)==min) {
					res.get(key).add(k);
				}
			}
			System.out.println();
		}
		for(String key: res.keySet()) {
			List<String> list = res.get(key);
			System.out.print(key+"=");
			list.forEach(e->System.out.print(":"+e));
			System.out.println();
		}
		
		/*
		 * c: p 1 w 1
		 * p: c:1 w 2
		 * w : c:1 , p 2 t 2 pe 1
		 * t : w 2 t 1
		 * pe w 1 t1
		 */
	}
	public static void main(String[] args) {
		StockWithCoolDown st = new StockWithCoolDown();
		st.relevantString();
	}
} 
