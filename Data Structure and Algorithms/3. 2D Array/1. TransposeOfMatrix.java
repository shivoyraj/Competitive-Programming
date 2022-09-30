class Solution{
    
    static void transpose(int mat[][], int n){
     
        for(int i = 0; i < n ; i++)
            for(int j = i ; j < n ; j++){
                int tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
    }
}