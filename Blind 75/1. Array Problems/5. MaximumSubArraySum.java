//https://leetcode.com/problems/maximum-subarray/

class Solution {
	
    public int maxSubArray(int[] nums) {
        
    	int resMax = nums[0];
        int max = nums[0];
        
        for(int i=1;i<nums.length;i++) {
        	max = max +nums[i];
        	max = Math.max(max, nums[i]);
        	resMax = Math.max(resMax, max);
        }
        
        return resMax;
    }    
}