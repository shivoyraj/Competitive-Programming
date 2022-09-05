import java.util.LinkedList;
import java.util.Queue;

class Solution {
	
    public static void BFS(int[][] mat, int k , boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();
    	q.add(k);
    	visited[k] = true;
    	
		while(!q.isEmpty()) {
			int i = q.peek();
			for(int j =0;j<mat.length;j++) {
				if(mat[i][j]==1 && !visited[j]) {
					q.add(j);
					visited[j] = true;
				}
			}
			System.out.print(q.poll()+" ");
		}
                
	}
    
    public static void BFS(int[][] mat) {
    	
		boolean[] visited = new boolean[mat.length];
    	
    	for(int i =0;i<mat.length;i++)
            if(!visited[i])
	    		BFS(mat,i,visited);
	}
	
}

class Test {

	public static void main(String[] args) {

		int V = 9, E = 10;
		
		int[][] adjMatrix = new int[V][V];
		int[][] edges = {{1,6},{0,8},{1,7},{1,8},{5,8},{6,0},{7,3},{7,4},{8,7},{2,5}};
		
		for(int i=0;i<E;i++) {
			adjMatrix[edges[i][0]][edges[i][1]] = 1;
			adjMatrix[edges[i][1]][edges[i][0]] = 1;
		}
		
		print(adjMatrix);
		Solution.BFS(adjMatrix);
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