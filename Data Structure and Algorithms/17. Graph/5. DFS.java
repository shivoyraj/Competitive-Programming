class Solution {
	
    public static void DFS(int[][] mat, int k , boolean[] visited) {

    	visited[k] = true;
    	System.out.print(k+" ");

    	for(int i = 0; i < mat.length ; i++)
    		if(mat[k][i]==1 && !visited[i])
    			DFS(mat,i,visited);
                
	}
    
    public static void DFS(int[][] mat) {
    	
		boolean[] visited = new boolean[mat.length];
    	
    	for(int i =0;i<mat.length;i++)
            if(!visited[i])
	    		DFS(mat,i,visited);
	}
	
}

class Test {

	public static void main(String[] args) {

		int[][] edges = {{1,6},{0,8},{1,7},{1,8},{5,8},{6,0},{7,3},{7,4},{8,7},{2,5},{9,11},{9,12},{11,14},{12,10},{12,15},{14,13},{15,13},{10,15}};
		int V = 16, E = edges.length;
		int[][] adjMatrix = new int[V][V];
		
		for(int i=0;i<E;i++) {
			adjMatrix[edges[i][0]][edges[i][1]] = 1;
			adjMatrix[edges[i][1]][edges[i][0]] = 1;
		}
		
		print(adjMatrix);
		Solution.DFS(adjMatrix);
	}

	public static void print(int[][] res) {
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++)
				System.out.print(res[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}
}