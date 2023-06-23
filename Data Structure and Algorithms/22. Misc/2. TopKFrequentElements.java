// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

// Example 1:

// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]


import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

//solution using comperable Interface
class Pair implements Comparable<Pair> {

	Integer num;
	Integer freq;

	public Pair(int num, int freq) {
		this.num = num;
		this.freq = freq;
	}

	@Override
	public int compareTo(Pair o) {
		return o.freq - freq;
	}
	
}

class Solution {

	public static int[] topKFrequent(int[] nums, int k) {
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i : nums)
			map.put(i, map.getOrDefault(i, 0) + 1);
		
		List<Pair> list = new ArrayList<>();
		map.forEach((key,val)->{
			list.add(new Pair(key,val));
		});

		Collections.sort(list);
		
		int[] res = new int[k];
		for(int i = 0 ; i < k ; i++)
			res[i] = list.get(i).num;
			
		return res;
	}
}


//solution using comperator Interface
class Pair{

	Integer num;
	Integer freq;

	public Pair(int num, int freq) {
		this.num = num;
		this.freq = freq;
	}
	
}

class Solution {

	public static int[] topKFrequent(int[] nums, int k) {
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i : nums)
			map.put(i, map.getOrDefault(i, 0) + 1);
		
		List<Pair> list = new ArrayList<>();
		map.forEach((key,val)->{
			list.add(new Pair(key,val));
		});

		Collections.sort(list, new Comparator<Pair>() {
				@Override
				public int compare(Pair p1, Pair p2) {
						return p2.freq - p1.freq;
				}
		});
		
		int[] res = new int[k];
		for(int i = 0 ; i < k ; i++)
			res[i] = list.get(i).num;
			
		return res;
	}
}

//using List and Map with customized sorting
class Solution {

	public static int[] topKFrequent(int[] nums, int k) {
		
		Map<Integer, Integer> freqMap = new HashMap<>();
		for (int num : nums)
				freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		
		List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(freqMap.entrySet());
		
		entryList.sort((a, b) -> b.getValue() - a.getValue());
		
		int[] res = new int[k];
		for (int i = 0; i < k; i++)
				res[i] = entryList.get(i).getKey();
						
		return res;
	}
}

//using priority queue
class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> map = new HashMap();
        for(int n : nums)
            map.put(n,map.getOrDefault(n,0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->map.get(b) - map.get(a));
        pq.addAll(map.keySet());

        int[] res = new int[k];
        for(int i = 0;i<k;i++)
            res[i] = pq.poll();
    
        return res;
    }
}

//solution using priority queue (mean heap)
class Solution {

    public static int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int n : nums)
            map.put(n,map.getOrDefault(n,0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> map.get(a) - map.get(b));
        
        for(int i : map.keySet()) {
        	pq.offer(i);
        	if(pq.size()>k)
        		pq.poll();
        }

        int[] res = new int[k];
        for(int i = k-1 ; i >=0 ;i--)
            res[i] = pq.poll();
    
        return res;
    }
}

//solution using stream
class Solution {

	public static int[] topKFrequent(int[] nums, int k) {
		return Arrays.stream(nums)
						.boxed()
						.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
						.entrySet().stream()
						.sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
						.limit(k)
						.mapToInt(Map.Entry::getKey)
						.toArray();
	}

}