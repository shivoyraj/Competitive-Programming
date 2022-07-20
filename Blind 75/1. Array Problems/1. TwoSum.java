//https://leetcode.com/problems/two-sum/

import java.util.Map;
import java.util.HashMap;

class Solution {
    
    Map<Integer,Integer> map = new HashMap<>();
    
    public int[] twoSum(int a[], int x) {
                
        for(int i=0;i<a.length;i++){
            
            if(!map.containsKey(x-a[i]))
            	map.put(a[i],i);
            else
            	return new int[] {map.get(x-a[i]),i};
        }
    	return new int[] {};
    }
}