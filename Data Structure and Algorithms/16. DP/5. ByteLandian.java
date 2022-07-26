import java.util.HashMap;

class Solution {
    
	public static long bytelandian(long n, HashMap<Long, Long> memo) {

        if(n<=1)
            return n;
        
        if(memo.get(n)==null){
            long res  = bytelandian(n/2,memo)+bytelandian(n/3,memo)+bytelandian(n/4,memo);
    	    res = Math.max(n,res);
        	memo.put(n,res);
        }
        
        return memo.get(n);
	}

}