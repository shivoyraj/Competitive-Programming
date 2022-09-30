import java.util.ArrayList;

class Solution {

    static ArrayList<Integer> res;
    
    public static void printBoundariesClockwise(int[][] mat,int a, int b , int m , int n){
        
        for (int j = b;  j < n ; j++)
			res.add(mat[a][j]);
            
		for (int i = a;  i < m ; i++)
			res.add(mat[i][n]);
                
		for (int j = n;  j > b ; j--)
			res.add(mat[m][j]);
                
		for (int i = m;  i > a ; i--)
			res.add(mat[i][b]);
        
    }
    
    static ArrayList<Integer> boundaryTraversal(int mat[][], int m, int n)
    {
        res = new ArrayList<>();
        
        if(m==1 && n==1)                                // if matix has only one element
            res.add(mat[0][0]);
        
        else if(m==1)                                   // if matix has only one row
            for(int j =0 ; j< mat[0].length;j++)
                res.add(mat[0][j]);
                
        else if(n==1)                                   // if matix has only one column
            for(int i =0 ; i< mat.length;i++)
                res.add(mat[i][0]);
        
        else
            printBoundariesClockwise(mat,0,0,m-1,n-1);
        
        return res;
    }
}
