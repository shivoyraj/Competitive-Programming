import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

	public static ArrayList<Integer> kLargest(int input[], int k) {
		
		ArrayList<Integer> res = new ArrayList<>();
		Queue<Integer> heap = new PriorityQueue<>();
		
		for(int i=0;i<k;i++)
			heap.add(input[i]);
		
		for(int i=k;i<input.length;i++) {
			if(heap.peek()<input[i]){
            	heap.poll();
				heap.add(input[i]);
            }
		}
				
		while(!heap.isEmpty())
			res.add(heap.poll());
		
		return res;
	}
}