class Solution1{
	
	public static int countWaysToMakeChange(int coins[],int index, int value){
		
		if(index==coins.length || value<0)
			return 0;
		
		if(value==0)
			return 1;
		
		int res1 = countWaysToMakeChange(coins,index,value-coins[index]);
		int res2 = countWaysToMakeChange(coins,index+1,value);
		
		return res1 + res2;
	}
	
	public static int countWaysToMakeChange(int coins[], int value){
		return countWaysToMakeChange(coins,0,value);
	}
	
}

class Solution2{

	public static int countWaysToMakeChange(int coins[], int index, int value, Integer[][] dp) {

		if (index == coins.length || value < 0)
			return 0;

		if (value == 0)
			return 1;

		if (dp[index][value] == null) {
			int res1 = countWaysToMakeChange(coins, index, value - coins[index], dp);
			int res2 = countWaysToMakeChange(coins, index + 1, value, dp);
			dp[index][value] = res1 + res2;
		}

		return dp[index][value];
	}

	public static int countWaysToMakeChange(int coins[], int value) {
		Integer[][] dp = new Integer[coins.length][value+1];
		return countWaysToMakeChange(coins, 0, value, dp);
	}

}

class Solution3{

	public static int countWaysToMakeChange(int coins[], int value) {

		int[][] dp = new int[coins.length+1][value+1];
		
		for(int i=0;i<=coins.length;i++)
			dp[i][0] = 1;
		
		for(int i=1;i<=coins.length;i++) {
			for(int j=1;j<=value;j++) {
				dp[i][j] = dp[i-1][j];
				if(j>=coins[i-1])
					dp[i][j] = dp[i][j] + dp[i][j-coins[i-1]];
			}
		}
		
		return dp[coins.length][value];
	}

}

class Solution4{

	public static int countWaysToMakeChange(int coins[], int value) {

		int[] dp = new int[value+1];
		int[] tmp = new int[value+1];
		
		dp[0] = 1;
		tmp[0] = 1;
		
		for(int i=1;i<=coins.length;i++) {
			for(int j=1;j<=value;j++) {
				tmp[j] = dp[j];
				if(j>=coins[i-1])
					tmp[j] = tmp[j] + tmp[j-coins[i-1]];
			}
			for(int j=1;j<=value;j++)
				dp[j] = tmp[j]; 
		}
		return dp[value];
	}

}

class test {

	public static void main(String[] args) {
		int[] coins = {1,2,3,4,5,6,7,8};
		int v = 301;
		System.out.println(Solution4.countWaysToMakeChange(coins,v));
	}

}
