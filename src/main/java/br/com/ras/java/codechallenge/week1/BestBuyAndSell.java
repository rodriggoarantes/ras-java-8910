package br.com.ras.java.codechallenge.week1;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (i.e., buy one and sell one share of the stock
 * multiple times).
 * 
 * Note: You may not engage in multiple transactions at the same time (i.e., you
 * must sell the stock before you buy again).
 * 
 * Example 1:
 * 
 * Input: [7,1,5,3,6,4] Output: 7 Explanation: Buy on day 2 (price = 1) and sell
 * on day 3 (price = 5), profit = 5-1 = 4. Then buy on day 4 (price = 3) and
 * sell on day 5 (price = 6), profit = 6-3 = 3.
 * 
 * Example 2:
 * 
 * Input: [1,2,3,4,5] Output: 4 Explanation: Buy on day 1 (price = 1) and sell
 * on day 5 (price = 5), profit = 5-1 = 4. Note that you cannot buy on day 1,
 * buy on day 2 and sell them later, as you are engaging multiple transactions
 * at the same time. You must sell before buying again.
 * 
 * Example 3:
 * 
 * Input: [7,6,4,3,1] Output: 0 Explanation: In this case, no transaction is
 * done, i.e. max profit = 0.
 * 
 * @author rodrigo.arantes
 */
public class BestBuyAndSell {

	public int solution(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int profit = 0;
		boolean have = false;
		int stockPrice = 0;

		for (int i = 0; i < nums.length - 1; i++) {
			final int future = nums[i + 1] - nums[i];
			final int price = nums[i];
			if (!have && future > 0) {
				have = true;
				stockPrice = price;
			} else if (have && future < 0) {
				have = false;
				profit += (price - stockPrice);
			}
		}

		if (have) {
			profit += (nums.length - 1) - stockPrice;
		}

		return profit;
	}

	public int alternative(int[] nums) {
		if (nums == null || nums.length <= 0)
			return 0;

		int profit = 0;

		for (int i = 1; i < nums.length; i++) {
			final int priceYesterday = nums[i - 1];
			final int priceToday = nums[i];
			if (priceToday > priceYesterday) {
				profit += (priceToday - priceYesterday);
			}
		}
		return profit;
	}
	
	public int best(int[] prices) {
	    int profit = 0;
	    
	    for (int i=1; i < prices.length; i++) {
	        if(prices[i] - prices[i-1] > 0) 
	        	profit += prices[i] - prices[i-1];
	    }
	        
	    return profit;
	}

}
