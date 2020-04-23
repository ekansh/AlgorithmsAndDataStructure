package algos.arrays;

public class BuySellShareMultipleTxn {
	public static void main(String[] args) {
		BuySellShareMultipleTxn b = new BuySellShareMultipleTxn();
		b.init();
	}
	private void init() {
		Solution solution = new Solution();
		int n []= {7,1,5,3,6,4};
		int maxProfit = solution.maxProfit(n);
		System.out.println(maxProfit);		
	}
	class Solution {
		public int maxProfit(int[] prices) {
			int profit=0;
			for (int i =0;i+1<prices.length;) {
				int buy=0,sell=0;
				if(prices[i]<prices[i+1]) {
					buy=prices[i];
					while(i+1<prices.length && prices[i]<prices[i+1]) {
						i++;
					}
					sell =prices[i];
					profit =profit+sell - buy;
				}else {
					i++;
				}
				
			}
			return profit;
			
		}
	}
}
