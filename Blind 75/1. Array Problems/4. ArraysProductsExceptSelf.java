// https://leetcode.com/problems/product-of-array-except-self/

class Solution {
    
    public int[] productExceptSelf(int[] nums) {
        
    	int[] res  = new int[nums.length];
    	List<Integer> zerosIndexs = new ArrayList<>();
    	
    	int totalProd = 1;
    	for(int i=0;i<nums.length;i++) {
    		if(nums[i]==0)
    			zerosIndexs.add(i);
    		else
    			totalProd = totalProd*nums[i];
    	}
    	
    	if(zerosIndexs.size()==0)
    		for(int i=0;i<nums.length;i++)
    			res[i] = totalProd / nums[i];
    	
    	else if(zerosIndexs.size()==1) 
    		res[zerosIndexs.get(0)] = totalProd;
    	
    	return res;

    }
}