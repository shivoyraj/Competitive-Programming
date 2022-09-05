class Solution {
    
    public static void DFS(int[][] mat, int k , boolean[] visited) {

    	visited[k] = true;
    	for(int i = 0; i < mat.length ; i++)
    		if(mat[k][i]==1 && !visited[i])
    			DFS(mat,i,visited);
                
	}
    
	public static int countComponents(int[][] mat, int V) {
        
		boolean[] visited = new boolean[mat.length];
		
        int count = 0;
        for(int i =0;i<mat.length;i++)
            if(!visited[i]){
	    		DFS(mat,i,visited);
                count++;
            }   
        return count;
	}
}