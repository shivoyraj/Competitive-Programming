class Solution1{
	
	public static int minCostPath(int[][] input, int i , int j) {
				
		if(i==input.length || j==input[0].length)
			return Integer.MAX_VALUE;
		
		if(i==input.length-1 && j==input[0].length-1)
			return input[i][j];
		
		int min = Integer.MAX_VALUE;
		
		min = Math.min(min,minCostPath(input,i+1,j+1));
		min = Math.min(min,minCostPath(input,i+1,j));
		min = Math.min(min,minCostPath(input,i,j+1));
		
		return min+input[i][j];
		
	}

	public static int minCostPath(int[][] input) {
		return minCostPath(input,0,0);
	}
}


class Solution2{

	public static int minCostPath(int[][] input, Integer[][] dp, int i, int j) {

		if (i == input.length || j == input[0].length)
			return Integer.MAX_VALUE;

		if (i == input.length - 1 && j == input[0].length - 1)
			return input[i][j];

		if (dp[i][j] == null) {

			int min = Integer.MAX_VALUE;

			min = Math.min(min, minCostPath(input,dp, i + 1, j + 1));
			min = Math.min(min, minCostPath(input,dp, i + 1, j));
			min = Math.min(min, minCostPath(input,dp, i, j + 1));

			dp[i][j]=input[i][j]+min;
		}
		
		return dp[i][j];

	}

	public static int minCostPath(int[][] input) {
		Integer[][] dp = new Integer[input.length][input[0].length];
		return minCostPath(input,dp, 0, 0);
	}
}

class Solution3{

	public static int minCostPath(int[][] input) {
		
		int n = input.length;
		int m = input[0].length;
		
		Integer[][] dp = new Integer[n][m];
		dp[0][0] = input[0][0];
		
		for(int i=1;i<n;i++)
			dp[i][0] = dp[i-1][0] + input[i][0];
		
		for(int j=1;j<m;j++)
			dp[0][j] = dp[0][j-1] + input[0][j];
				
		for(int i=1;i<n;i++) 
			for(int j=1;j<m;j++)		
				dp[i][j] = input[i][j]+Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]));
		
		return dp[n-1][m-1];
	}
}