// A child runs up a staircase with 'n' steps and can hop either 1 step, 2 steps or 3 steps at a time.
// Implement a method to count and return all possible ways in which the child can run-up to the stairs.

class Solution {

	public static long staircase(int n) {
		
        if(n==0)
            return 1;
        
		if(n<=2)
            return n;
        
        long[] dp = new long[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        
        for(int i = 4;i<=n;i++)
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        
        return dp[n];
	}

}