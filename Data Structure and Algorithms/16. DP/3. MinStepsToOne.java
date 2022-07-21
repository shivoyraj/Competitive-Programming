// Given a positive integer 'n', 
// find and return the minimum number of steps that 'n' has to take to get reduced to 1.
//  You can perform any one of the following 3 steps:
// 1.) Subtract 1 from it. (n = n - ­1) ,
// 2.) If its divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
// 3.) If its divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).  


// Recursive Solution

import java.util.Arrays;

class Solution1 {

	public static int countMinStepsToOne(int n) {

        if(n==1)
            return 0;
        
        int res1 = Integer.MAX_VALUE,res2 = Integer.MAX_VALUE, res3 = Integer.MAX_VALUE;
        
        if(n%2==0)
            res1 = countMinStepsToOne(n/2);
        
        if(n%3==0)
            res2 = countMinStepsToOne(n/3);
        
        res3 = countMinStepsToOne(n-1);
        
        return 1+Math.min(res1,Math.min(res2,res3));
	}

}

// Recursive solution using memoization

class Solution2 {

	public static int countMinStepsToOne(int n, int[] dp) {

		if (n == 1)
			return 0;

		int res1 = Integer.MAX_VALUE, res2 = Integer.MAX_VALUE, res3 = Integer.MAX_VALUE;

		if (dp[n] == -1) {

			if (n % 2 == 0)
				res1 = countMinStepsToOne(n / 2);
			if (n % 3 == 0)
				res2 = countMinStepsToOne(n / 3);
			res3 = countMinStepsToOne(n - 1);
			
            dp[n] = 1+Math.min(res1, Math.min(res2, res3));
			return dp[n];
		} 
		
		else
			return dp[n];
	}

	public static int countMinStepsToOne(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		return countMinStepsToOne(n, dp);
	}

}

// dp solution

class Solution3 {

	public static int countMinStepsToOne(int n) {
		
        if(n<=1)
            return 0;
        
        int[] dp = new int[n + 1];
        dp[1] = 0;

        for(int i=2;i<=n;i++){
        	
            int res1 = Integer.MAX_VALUE, res2 = Integer.MAX_VALUE, res3 = Integer.MAX_VALUE;
            
            if (i % 2 == 0)
				res1 = dp[i/2];
			if (i % 3 == 0)
				res2 = dp[i/3];
			res3 = dp[i-1];
			
            dp[i] = 1+Math.min(res1, Math.min(res2, res3));
        }
        return dp[n];
	}
}