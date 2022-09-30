//https://leetcode.com/problems/maximum-product-subarray/

class Solution {
	
    public int maxProduct(int[] nums) {
        
    	int resMax = nums[0];
        int maxProd =1 ,prod = 1;
        
        for(int i : nums) {
        	
        	List<Integer> list = List.of(i,prod*i,maxProd*i);
        	prod = Collections.min(list);
        	maxProd = Collections.max(list);
        	resMax = Math.max(resMax, maxProd);
            
        }
        
        return resMax;
    	
    }  
}