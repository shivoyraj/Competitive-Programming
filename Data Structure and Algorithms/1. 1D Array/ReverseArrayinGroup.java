// Given an array arr[] of positive integers of size N. 
// Reverse every sub-array group of size K.

// Note: If at any instance, there are no more subarrays of size greater than or equal to K,
//  then reverse the last subarray (irrespective of its size).


// Input:
// N = 5, K = 3
// arr[] = {1,2,3,4,5}
// Output: 3 2 1 5 4
// Explanation: First group consists of elements
// 1, 2, 3. Second group consists of 4,5.

import java.util.ArrayList;

class Solution {

    static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        
        for(int start = 0 ; start < n ; start = start + k) {
        	
        	int end = Math.min(n-1,start + k -1);
        	int i = start;
        	int j = end;
        	
        	while(i < j){
        	    
                int tmp = arr.get(i);
                arr.set(i,arr.get(j));
                arr.set(j,tmp);
                i++;
                j--;
                
            }
        }

    }
}