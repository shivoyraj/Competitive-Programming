class Solution1{
	
	public static boolean isSubsetPresent(int[] arr,int index, int n, int sum) {
		
		if(sum==0)
			return true;
		
		if(sum<0 || index==n)
			return false;
		
		return isSubsetPresent(arr,index+1,n,sum) || isSubsetPresent(arr,index+1,n,sum-arr[index]);
    }

	public static boolean isSubsetPresent(int[] arr, int n, int sum) {
		return isSubsetPresent(arr,0,n,sum);
    }
}

class Solution2{
	
	public static boolean isSubsetPresent(int[] arr,int index, int n, int sum,Boolean[][] dp) {
		
		if(sum==0)
			return true;
		
		if(sum<0 || index==n)
			return false;
		
		if(dp[index][sum]==null)
			dp[index][sum] = isSubsetPresent(arr,index+1,n,sum,dp) || isSubsetPresent(arr,index+1,n,sum-arr[index],dp);
		
		return dp[index][sum];
    }

	public static boolean isSubsetPresent(int[] arr, int n, int sum) {
		Boolean[][] dp = new Boolean[n][sum+1];
		return isSubsetPresent(arr,0,n,sum,dp);
    }
}

class Solution3{
			
	public static boolean isSubsetPresent(int[] arr, int n, int sum) {
		
		boolean[][] dp = new boolean[n+1][sum+1];
		
		for(int i=0;i<=n;i++)
			dp[i][0] = true;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=sum;j++) {
				if(j>=arr[i-1])
					dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
			}
		}
		
		return dp[n][sum];
    }
}

class Solution4{
	
	public static boolean isSubsetPresent(int[] arr, int n, int sum) {
		
		boolean[] dp = new boolean[sum+1];
		boolean[] tmp = new boolean[sum+1];

		tmp[0] = true;
		dp[0]  = true;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=sum;j++) {
				if(j>=arr[i-1])
					tmp[j] = dp[j] || dp[j-arr[i-1]];
                else
                	tmp[j] = dp[j];
			}
			for(int j=1;j<=sum;j++)
				dp[j] = tmp[j];
		}
		
		return dp[sum];
    }
}

class Solution5{
	
	public static boolean isSubsetPresent(int[] arr, int n, int sum) {
		
		boolean[] dp = new boolean[sum+1];
		dp[0]  = true;
		
		for(int i=1;i<=n;i++)
			for(int j=sum;j>0;j--)
				if(j>=arr[i-1])
					dp[j] = dp[j] || dp[j-arr[i-1]];

		return dp[sum];
    }
}

class test {

	public static void main(String[] args) {
		int[] d = { 4,2,5,6,7};
		int v = 14;
		System.out.println(Solution5.isSubsetPresent(d,d.length, v));
	}
}
