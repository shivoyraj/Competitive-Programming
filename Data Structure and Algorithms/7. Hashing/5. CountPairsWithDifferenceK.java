import java.util.Map;
import java.util.HashMap;

class Solution {

	public static int getPairsWithDifferenceK(int arr[], int k) {

		Map<Integer, Integer> map = new HashMap<>();

		int count = 0;
		for (int i : arr) {
			
			int d1 = i + k;
			int d2 = i - k;
			
			if(map.containsKey(d1))
				count = count + map.get(d1);
			
			if(k!=0 && map.containsKey(d2))
				count = count + map.get(d2);
			
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		return count;
	}
}