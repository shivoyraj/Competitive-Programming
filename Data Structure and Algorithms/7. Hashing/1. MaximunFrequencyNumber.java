// If two or more elements contend for the maximum frequency
// then return the element which occurs in the array first

import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    
    static int max,ans;
    
	public static int maxFrequencyNumber(int[] arr) {
        
        max = 0; ans = -1;
        Map<Integer,Integer> map = new LinkedHashMap<>();
   
        for(int i:arr)
            map.put(i,map.getOrDefault(i,0)+1);
                
        map.forEach((k,v)->{
            if(v>max) {
                ans = k;
                max =v;
            }
        });
        return ans;
	}
}


