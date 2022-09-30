import java.util.LinkedList;
import java.util.Queue;

class Solution {
	
    public static boolean BFS(int[][] mat, int source , int target) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[mat.length];
    	q.add(source);
    	visited[source] = true;
    	
		while(!q.isEmpty()) {
			int i = q.peek();
           	if(i==target)
                return true;
			for(int j =0;j<mat.length;j++) {
				if(mat[i][j]==1 && !visited[j]) {
					q.add(j);
					visited[j] = true;
				}
			}
			q.poll();
		}
    	return false;
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
		
		//print(adjMatrix);
		
		
		int v1 = 1;
		int v2 = 9;
		System.out.println(Solution.BFS(adjMatrix,v1,v2));
		
		int v3 = 5;
		int v4 = 0;
		System.out.println(Solution.BFS(adjMatrix,v3,v4));
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
