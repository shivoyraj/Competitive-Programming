// A magic grid A with R rows and C columns. 
// In the cells of the grid, you will either get magic juice, which increases your strength by |A[i][j]| points,
// or poison, which takes away |A[i][j]| strength points. 
// If at any point of the journey, the strength points become less than or equal to zero, then you will die.
// You have to start from the top-left corner cell (0,0) and reach at the bottom-right corner cell (R,C). 
// From a cell (i,j), you can only move either one cell down or right 
// i.e., to cell (i+1,j) or cell (i,j+1) and you can not move outside the magic grid. 
// You have to find the minimum number of strength points with which you will be able to reach the destination cell.

class Solution1{
	
    public static int getMinimumStrength(int[][] grid,int i,int j) {
        
    	if(i==grid.length || j == grid[0].length)
        	return Integer.MAX_VALUE;
        
        if(i==grid.length-1 && j == grid[0].length-1)
        	return 1;
    	
    	int res1  = getMinimumStrength(grid,i+1,j);
    	int res2  = getMinimumStrength(grid,i,j+1);
    		
    	return Math.max(Math.min(res1,res2)-grid[i][j],1);
    }

    public static int getMinimumStrength(int[][] grid) {
        return getMinimumStrength(grid,0,0);
    }
}

class Solution2{

	public static int getMinimumStrength(int[][] grid, int i, int j, Integer[][] dp) {

		if (i == grid.length || j == grid[0].length)
			return Integer.MAX_VALUE;

		if (i == grid.length - 1 && j == grid[0].length - 1)
			return 1;

		if (dp[i][j] == null) {

			int res1 = getMinimumStrength(grid, i + 1, j, dp);
			int res2 = getMinimumStrength(grid, i, j + 1, dp);

			dp[i][j] = Math.max(Math.min(res1, res2) - grid[i][j], 1);
		}
		return dp[i][j];
	}

	public static int getMinimumStrength(int[][] grid) {
		Integer dp[][] = new Integer[grid.length][grid[0].length];
		return getMinimumStrength(grid, 0, 0, dp);
	}
}

class Solution3{

	public static int getMinimumStrength(int[][] grid) {
		
		int n = grid.length;
		int m = grid[0].length;
		
		int[][] dp = new int[n][m];
        dp[n-1][m-1] = 1;
        
        for (int i=m-2;i>=0;i--)
        	dp[n-1][i]=dp[n-1][i+1]-grid[n-1][i];
            
        for (int i=n-2;i>=0;i--)
            dp[i][m-1]=dp[i+1][m-1]-grid[i][m-1];
				
		for (int i = n - 2; i >= 0; --i)
			for (int j = m - 2; j >= 0; --j)
				dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - grid[i][j],1);
			
		return dp[0][0];
	}
}