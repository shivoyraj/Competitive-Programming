class Solution {

	public static void totalSum(int[][] mat) {
                
        int n = mat.length;
        
        if (n==0){
            System.out.println(0);
            return;
        }
        
        //adding corners
        int tsum = mat[0][0]+mat[n-1][n-1]+mat[n-1][0]+mat[0][n-1];
        
        //adding first daigonal + first row + first column excluded corners
        for(int i=1;i<=n-2;i++)
            tsum = tsum + mat[i][i]+ mat[i][0]+mat[0][i];
        
        //adding second daigonal + last row + last column excluded corners
        for(int i=1,j= n-2;i<=n-2 && j>=1;i++,j--)            
           tsum = tsum + mat[i][j]+ mat[i][n-1]+mat[n-1][i];
        
        if(n%2!=0)
            tsum = tsum - mat[n/2][n/2];
        
        System.out.println(tsum);
        
        
	}

}