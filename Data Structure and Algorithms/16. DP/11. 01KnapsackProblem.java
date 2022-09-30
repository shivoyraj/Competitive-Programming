class Solution1{
	
	public static int knapsack(int[] w, int[] v, int index, int maxW,int takenV) {
		
		if(maxW<0)
			return 0;
		
		if(maxW==0 || index==v.length)
			return takenV;
		
		int res1 = knapsack(w,v,index+1,maxW,takenV);
		int res2 = knapsack(w,v,index+1,maxW-w[index],takenV+v[index]);
		
		return Math.max(res1, res2);
	}

	public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
		return knapsack(weights,values,0,maxWeight,0);
	}

}

class Solution2{

	public static int knapsack(int[] w, int[] v, int index, int maxW, int takenV, Integer[][] dp) {

		if (maxW < 0)
			return 0;

		if (maxW == 0 || index == v.length)
			return takenV;

		if (dp[index][maxW] == null) {
			
			int res1 = knapsack(w, v, index + 1, maxW, takenV, dp);
			int res2 = knapsack(w, v, index + 1, maxW - w[index], takenV + v[index], dp);
			dp[index][maxW] = Math.max(res1, res2);
			
		}
		
		return dp[index][maxW];
	}

	public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
		Integer[][] dp = new Integer[n][maxWeight+1];
		return knapsack(weights, values, 0, maxWeight, 0, dp);
	}

}

class Solution3{

	public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
		
		int[][] dp = new int[n+1][maxWeight+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=maxWeight;j++) {
				if(j>=weights[i-1])
					dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weights[i-1]]+ values[i-1]);
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		
		return dp[n][maxWeight];
	}
}

class Solution4{

	public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
		
		int[] dp = new int[maxWeight+1];
		int[] tmp = new int[maxWeight+1];

		for(int i=1;i<=n;i++) {
			for(int j=1;j<=maxWeight;j++) { // or for(int j=maxWeight;j>0;j--)
				if(j>=weights[i-1])
					tmp[j] = Math.max(dp[j],dp[j-weights[i-1]]+ values[i-1]);
				else
					tmp[j] = dp[j];
			}
			for(int j=1;j<=maxWeight;j++)
				dp[j] = tmp[j];
		}
		
		return dp[maxWeight];
	}
}

class Solution5{

	public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
		
		int[] dp = new int[maxWeight+1];
		
		for(int i=1;i<=n;i++)
			for(int j=maxWeight;j>0;j--)
				if(j>=weights[i-1])
					dp[j] = Math.max(dp[j],dp[j-weights[i-1]]+ values[i-1]);

		return dp[maxWeight];
	}

}


class test {

	public static void main(String[] args) {

		int[] w = {1,2,4,5};
		int[] v = {5,4,8,6};
		int maxW = 5;
		System.out.println(Solution3.knapsack(w,v,v.length,maxW));
	}

}
