package algos.arrays;

import java.util.HashMap;
import java.util.Map;

public class BuySellShareSingleTransaction {
	public static void main(String[] args) {
		BuySellShareSingleTransaction b = new BuySellShareSingleTransaction();
		b.init();
	}

	private void init() {
		Solution solution = new Solution();
		int n[] = { 7, 1, 5, 3, 6, 4 };
		int maxProfit = solution.maxProfit(n);
		System.out.println(maxProfit);
	}

	class Solution {
		public int maxProfit(int[] prices) {
			int buy = 0, sell = 0, profit = 0;
			Map<String, Integer> solution = new HashMap<String, Integer>();
			solution.put("B", buy);
			solution.put("S", sell);
			solution.put("P", profit);
			for (int i = 0; i < prices.length; i++) {
				if (prices[i] - prices[buy] > profit) {
					sell = i;
					profit = prices[i] - prices[buy];
					solution.put("B", buy);
					solution.put("S", sell);
					solution.put("P", profit);
				}
				if (prices[i] < prices[buy]) {
					buy = i;
				}
			}
			solution.forEach((k, v) -> System.out.println(k + ":" + v));
			return solution.get("P");

		}
		public int getMaxProfitOnly(int[] prices) {
			if(prices== null || prices.length==0) return 0;
			int buy = prices[0], sell = 0, profit = 0;
			 
			for (int i = 0; i < prices.length; i++) {
				buy=Math.min(prices[i],buy);
				profit= Math.max(prices[i]-buy, profit);
				 
			}
		 
			return profit;

		}
		//"abccba"
		public boolean palindrome(String s) {
			//65 90 97 122
			int i =0, j=s.length()-1; 
			s=s.toLowerCase();
			for (;i<=j;){
				if(! ((s.charAt(i)>='a' && s.charAt(i)<='z') ||
						(s.charAt(i)>='A' && s.charAt(i)<='Z') ||
						s.charAt(i)>=0 && s.charAt(i)<=9 ) ) {
					i++;
					continue;
				}
				if(! ((s.charAt(j)>='a' && s.charAt(j)<='z') ||
						(s.charAt(j)>='A' && s.charAt(j)<='Z')||
						s.charAt(j)>=0 && s.charAt(j)<=9 )) {
					j--;
					continue;
				}
				if(s.charAt(i)!=s.charAt(j)){
					return false;
				}
				i++;j--;
			}
			return true;
		}
	}
}
