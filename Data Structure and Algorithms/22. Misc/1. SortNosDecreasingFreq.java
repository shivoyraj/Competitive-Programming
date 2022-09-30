// Given an array A[] of integers, 
// sort the array according to frequency of elements. 
// e.i. elements that have higher frequency come first. 
// If frequencies of two elements are same, then smaller number comes first.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;


// using heap bucket
class Solution1{
    
	public static void sortFrequency(int[] arr) {
		
        Map<Integer,Integer> map = new HashMap<>();
        Object[] freq = new Object[arr.length+1];
        
        for(Integer i : arr)
        	map.put(i,map.getOrDefault(i,0)+1);
                        
        map.forEach((k,v)->{
            PriorityQueue<Integer> q = null;
        	if(freq[v]==null) 
                q = new PriorityQueue<>();
        	else
        		q= (PriorityQueue<Integer>) freq[v];
            q.add(k);
        	freq[v] = q;
        });
        
        for(int i = freq.length-1; i>=0 ; i--)
            if(freq[i]!=null) {
        		PriorityQueue<Integer> q = (PriorityQueue<Integer>) freq[i];
        		while(q.size()>0) {
        			int x = q.poll();
        			for(int j =0 ; j < i ; j++)
        				System.out.print(x+" ");
            	}
            }
	}

}

// using comparator implementation
class Solution2{
	
	public static void sortFrequency(int[] arr) {
		
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> nums = new ArrayList<>();
        
        for(Integer i : arr) {
        	map.put(i,map.getOrDefault(i,0)+1);
        	nums.add(i);
        }
                
        Comparator<Integer> myComp = new Comparator<>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(map.get(o1)!=map.get(o2))
					return map.get(o2).compareTo(map.get(o1));
				return o1 -o2;
			}
        	
        };
        
        Collections.sort(nums,myComp);
        
        for(int i : nums)
        	System.out.print(i+" ");
	}
}

class Test{
    public static void main(String[] args){

        Scanner s=new Scanner (System.in);
    	int n=s.nextInt();
        int arr[]=new int[n];
        
        for(int i=0;i<n;i++)
            arr[i]=s.nextInt();
		
        Solution1.sortFrequency(arr);
    }
}