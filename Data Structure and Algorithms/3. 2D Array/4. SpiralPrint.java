class Solution {
    
    static int count,total;

    public static void printBoundariesClockwise(int[][] mat,int a, int b , int m , int n){
        
        for (int j = b;  j < n && count++ < total ; j++)
			System.out.print(mat[a][j]+" ");
            
		for (int i = a;  i < m && count++ < total ;  i++)
			System.out.print(mat[i][n]+" ");
                
		for (int j = n;  j > b && count++ < total ;  j--)
			System.out.print(mat[m][j]+" ");
                
		for (int i = m;  i > a && count++ < total  ;  i--)
			System.out.print(mat[i][b]+" ");
        
    }
    
	public static void spiralPrint(int[][] mat) {

        if(mat.length==0)
            return;
        
		int M = mat.length , N = mat[0].length ,a = 0, b = 0;
		int m = M-1, n = N-1;
        count = 0;
        total = M*N;
        
		while (a<=m && b<=n) {
            printBoundariesClockwise(mat,a,b,m,n);
            a++;b++;m--;n--;
		}
        // if Matrix is square Mid central is mat[N/2][N/2]
        if(count < total)
            System.out.print(mat[N/2][N/2]+" ");
	}
}