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
    
    public static int fib(int n, Integer[] dp) {
        
        if(n<=1)
            return n;
        
        if(dp[n]==null)
            dp[n] = fib(n-1,dp)+fib(n-2,dp);
                
        return dp[n];
    }
    
    public static int fib(int n) {
        Integer[] dp = new Integer[n+1];
        return fib(n,dp);
    }
}

// solution using (DP Iterative method) time complexity T(n) = O(n) and AS(n) = O(n)
class Solution3{
    
    public static int fib(int n) {
        
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

// Most optimized form of dp since its calculating using last two indexed better is to store them in a variable
// T(n) = O(n) and AS = O(c)
class Solution4{
    
    public static int fib(int n) {
        
        if(n==0 || n==1)
            return n;
        
        int a = 0;
        int b = 1,c=0;
        
        for(int i=2;i<=n;i++){
           c = a + b;
           a = b;
           b = c;
        }
        
        return c;
    }
}

//using formula T(n) = O(1) and AS = O(c)
class Solution5{
    
    public static int fib(int n) {
        double temp = (Math.sqrt(5)+1)/2;
        int ans = (int)Math.round(Math.pow(temp, n) / Math.sqrt(5));
        return ans;
    }
}

class test {
	public static void main(String[] args) {
		System.out.println(Solution4.fib(5));
	}
}
