import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

	public static int kthLargest(int n, int[] input, int k) {
		
		Queue<Integer> heap = new PriorityQueue<>();
		
		for(int i=0;i<k;i++)
			heap.add(input[i]);
		
		for(int i=k;i<input.length;i++) {
			if(heap.peek()<input[i]){
            	heap.poll();
				heap.add(input[i]);
            }
		}
		
		return heap.peek();
	}
}