import java.util.HashMap;
import java.util.Map;

class Solution {

	static int count = 0;
	
	public static int PairSum(int[] input, int size) {
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i : input)
			map.put(i, map.getOrDefault(i, 0) + 1);
		
		map.forEach((k, v) -> {
			if (map.containsKey(-k)) {
				if (k == 0)
					count = count + (v * (v - 1)) / 2;
				else
					count = count + map.get(k) * map.get(-k);
				map.put(-k, 0);
			}
		});
		return count;
	}
}