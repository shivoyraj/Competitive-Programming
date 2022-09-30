
class Solution{
    
    static int[][] multiplyMatrix(int A[][], int B[][]){
        
        int n1 = A.length;
        int m1 = A[0].length;
        
        int n2 = B.length;
        int m2 = B[0].length;
        
        if(m1!=n2)
            return new int[0][0];
            
        int[][] res = new int[n1][m2];
        
        for(int i = 0 ; i < n1 ; i++)
            for(int j = 0 ; j < m2 ; j++)
                for(int k = 0; k < m1 ; k++)
                    res[i][j] = res[i][j] + A[i][k]*B[k][j];
        
        return res;
    }
}