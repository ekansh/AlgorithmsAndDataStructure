package backtracking;

import java.util.*;

public class StockWithTxn {
	public static void main(String[] args) {
		StockWithTxn s = new StockWithTxn();
		int st[]= new int[] {1036,2413,2776,825,2640,31,1560,2917,4282,783};
		int maxProfit = s.maxProfit(st,655);

		System.out.println(maxProfit);
	}   

	public int maxProfit(int[] prices, int fee) {
		int pr = 0;
		pr = Math.max(pr, fx(prices, fee, 0));
		return pr;
	}

	Map<Integer, Integer> m = new HashMap<>();

	public int fx(int[] prices, int fee, int bd) {
		if (bd >= prices.length - 1)
			return 0;
		if (m.containsKey(bd)) {
			System.out.println("returningn " + bd + ":" + m.get(bd));
			return m.get(bd);
		}
		int profitUsingThisBuyDay = Integer.MIN_VALUE;
		for (int i = bd; i < prices.length; i++) {
			int profitUsingThisSalesDay = Integer.MIN_VALUE;
			for (int sd = i + 1; sd < prices.length; sd++) {
				int profit = prices[sd] - prices[i] - 1 * fee + fx(prices, fee, sd + 1);
				profitUsingThisSalesDay = Math.max(profit, profitUsingThisSalesDay);
				
			}
			profitUsingThisBuyDay = Math.max(profitUsingThisBuyDay, profitUsingThisSalesDay);
		}
		System.out.println("Starting from  " + bd + ":" + profitUsingThisBuyDay);
		m.put(bd, profitUsingThisBuyDay);
		return profitUsingThisBuyDay;
	}
}
