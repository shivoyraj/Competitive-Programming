import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class Solution {

	public static void intersection(int[] arr1, int[] arr2) {
    	
		Map<Integer,Integer> map = new HashMap<>();
    	   
    	for(int i:arr1)
            map.put(i,map.getOrDefault(i,0)+1);
    	
        Arrays.sort(arr2);
        
    	for(int i:arr2) {
    		if(map.containsKey(i)) {
    			if(map.get(i)>0) {
    				System.out.print(i+" ");
    				map.put(i,map.get(i)-1);
    			}
    			else
    				map.remove(i);
    		}
    	}
    	
	}

}