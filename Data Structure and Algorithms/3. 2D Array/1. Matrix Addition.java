class Solution{
    
    static int[][] sumMatrix(int A[][], int B[][]){
       
       int m1 = A.length;
       int n1 = A[0].length;
       
       int m2 = B.length;
       int n2 = B[0].length;
       
       if(m1!=m2 || n1!=n2)
            return new int[0][0];
       
       
       int[][] res = new int[m1][n1];
       
       for(int i = 0; i < m1 ; i++)
            for(int j = 0; j < n1 ;j++)
                res[i][j] = A[i][j] + B[i][j];
        
        return res;
    }
}
