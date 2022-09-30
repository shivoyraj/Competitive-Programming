// A thief wants to loot houses. He knows the amount of money in each house.
//  He cannot loot two consecutive houses.
//  Find the maximum amount of money he can loot.


import java.util.Arrays;

class Solution1{
	
	public static int maxMoneyLooted(int i , int[] a) {
        
        if(i>=a.length)
            return 0;
        
		if(i==a.length-1)
            return a[i];
		
		int op1  = a[i] + maxMoneyLooted(i+2,a);
        int op2  = maxMoneyLooted(i+1,a);

		return Math.max(op1, op2);
	}

	public static int maxMoneyLooted(int[] houses) {
		return maxMoneyLooted(0,houses);
	}

}

class Solution2 {
	
	public static int maxMoneyLooted(int i , int[] a, int[] dp) {
        
        if(i<0)
            return 0;
        
		if(i==0)
            return a[0];
        
        if(dp[i]==-1){
			int op1  = a[i] + maxMoneyLooted(i-2,a,dp);
        	int op2  = maxMoneyLooted(i-1,a,dp);
	        dp[i] =  Math.max(op1, op2);    
        }
        
		return dp[i];
	}

	public static int maxMoneyLooted(int[] houses) {
        int[] dp = new int[houses.length+1];
        Arrays.fill(dp,-1);
		return maxMoneyLooted(houses.length-1,houses,dp);
	}

}

class Solution3{

	public static int maxMoneyLooted(int[] houses) {
        
        if(houses.length == 0)
            return 0;
        
        if(houses.length == 1)
            return houses[0];

        int[] dp = new int[houses.length];
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0],houses[1]);
        
        for(int i=2;i<houses.length;i++)
            dp[i] = Math.max(dp[i-1],houses[i]+dp[i-2]);
        
        return dp[houses.length-1];
	}

}