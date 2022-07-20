//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution {
   
    public int maxProfit(int[] prices) {
        
        if(prices.length<=1)
            return 0;
        
    	int[] maxRight = new int[prices.length];
    	
        int max = prices[prices.length-1];
        
    	for(int i=prices.length-2;i>=0;i--) {
    		max = Math.max(max,prices[i]);
    		maxRight[i]=max;
    	}
    	
    	int maxProfit = maxRight[0]-prices[0];
    	
    	for(int i=1;i<prices.length;i++)
    		maxProfit = Math.max(maxProfit, maxRight[i]-prices[i]);
    	
    	return maxProfit;
    }
}