//https://leetcode.com/problems/contains-duplicate/

class Solution {
    
    Set<Integer> set = new HashSet<>();
    
    public boolean containsDuplicate(int[] nums) {
        
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]))
            	return true;
            else
            	set.add(nums[i]);
        }
        
        return false;
    }
}