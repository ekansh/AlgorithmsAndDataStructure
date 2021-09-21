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
}
