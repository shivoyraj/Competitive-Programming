import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.IOException;

class Solution {
    
    public static boolean BFS(int[][] mat) {
		
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		boolean[] visited = new boolean[mat.length];
		visited[0] = true;

		while(!q.isEmpty()) {
			int i = q.peek();
			for(int j =0;j<mat.length;j++) {
				if(mat[i][j]==1 && !visited[j]) {
					q.add(j);
					visited[j] = true;
				}
			}
			q.poll();
		}

        for(int i = 0; i < mat.length ; i++)
            if(!visited[i])
                return false;
        
        return true;        
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
        
        Scanner sc = new Scanner(System.in);
        
		String[] ip1 = sc.nextLine().split(" ");
		
		int V = Integer.parseInt(ip1[0]);
		int E = Integer.parseInt(ip1[1]);
		
        if(V==0){
            System.out.println(true);
            return;
        }
        
        int[][] edges = new int[E][2];
        
        for(int k = 0 ; k<E;k++){
            String input = sc.nextLine();
            String[] ip = input.split(" ");
            edges[k][0] = Integer.parseInt(ip[0]);
            edges[k][1] = Integer.parseInt(ip[1]);
        }
        
        int[][] adjMatrix = new int[V][V];
		
		for(int i=0;i<edges.length;i++) {
			adjMatrix[edges[i][0]][edges[i][1]] = 1;
			adjMatrix[edges[i][1]][edges[i][0]] = 1;
		}
		
		System.out.println(BFS(adjMatrix));
	}

}