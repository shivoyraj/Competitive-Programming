import java.util.Arrays;

// solution using Normal Recursion time complexity T(n) = O(2^n) and AS(n) = O(1) + O(n) stack space

class Solution1{
    
    public static int fib(int n) {
        
        if(n==0 || n==1)
            return n;
        
        return fib(n-1)+fib(n-2);
    }
}

// solution using (DP Recursive method) memoization time complexity T(n) = O(n) and AS(n) = O(n) array + O(n) stack space
class Solution2{
    
    public static int fib(int n, int[] dp) {
        
        if(n==0 || n==1)
            return n;
        
        if(dp[n-1]==-1)
            dp[n-1] = fib(n-1,dp);
                
        if(dp[n-2]==-1)
            dp[n-2] = fib(n-2,dp);
                
        dp[n] = dp[n-1]+dp[n-2];     
        return dp[n];
    }
    
    public static int fib(int n) {
        
        if(n==0 || n==1)
            return n;
        
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return fib(n,dp);
    }
}

// solution using (DP Recursive method) memoization time complexity T(n) = O(n) and AS(n) = O(n) array + O(n) stack space
class Solution3{
    
    public int fib(int n) {
        
        if(n==0 || n==1)
            return n;
        
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        
        for(int i=2;i<=n;i++)
            dp[i] = dp[i-1]+dp[i-2];
        
        return dp[n];
    }
}

public class test {

	public static void main(String[] args) {
		System.out.println(Solution3.fib(5));
	}
}
