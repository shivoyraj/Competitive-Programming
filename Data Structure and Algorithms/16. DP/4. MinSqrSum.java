// Given an integer N, find and return the count of minimum numbers required to represent N as a sum of squares.
// That is, if N is 4, then we can represent it as : {1^2 + 1^2 + 1^2 + 1^2} and {2^2}.
//  The output will be 1, as 1 is the minimum count of numbers required to represent N as sum of squares.

import java.util.Arrays;

//Recursive Solution
class Solution1{

    public static int minCount(int n){
        
		if (n == 0)
			return 0;

		int min = Integer.MAX_VALUE;

		for (int i = (int)Math.sqrt(n); i>=1; i--) 
			min = Math.min(min,minCount(n - (i * i)));
		
		return min + 1;
        
    }
}

// with memoization
class Solution2 {

	public static int minCount(int n, int dp[]) {

		if (n == 0)
			return 0;

		int min = Integer.MAX_VALUE;

		for (int i = (int) Math.sqrt(n); i >= 1; i--) {

			if (dp[n - (i * i)] == -1)
				dp[n - (i * i)] = minCount(n - (i * i), dp);

			min = Math.min(min, dp[n - (i * i)]);
		}
		
		return min + 1;
	}

	public static int minCount(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		return minCount(n, dp);

	}
}

// dp iterative
class Solution3{
	
	public static int minCount(int n) {
		
		if (n == 0)
			return 0;

		int[] dp = new int[n+1];
		dp[1] = 1;

		for(int i=2;i<=n;i++) {
			
			int min = Integer.MAX_VALUE;
			
			for (int j = 1; j*j<=i ; j++)
				min = Math.min(min, dp[i - (j * j)]);
			
			dp[i] = 1+min;
		}
		
		return dp[n];
	}
}



class test {

	public static void main(String[] args) {
		System.out.println(Solution3.minCount(99));
	}
}
