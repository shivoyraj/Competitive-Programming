import java.util.HashMap;
import java.util.Map;

class Solution {

	public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
		
		Map<Integer, Integer> map = new HashMap<>();
		int max = -1,sum = 0;
		
		for(int i=0;i<arr.length;i++) {
			sum = sum + arr[i];
			if(sum==0)
				max = i+1;
			if(map.containsKey(sum))
				max = Math.max(max, i-map.get(sum));	
			map.put(sum,i);
		}
		
		return max;
	}
}