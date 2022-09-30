import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    
    public static String BFS(int[][] mat, int source , int target) {

        Map<Integer,Integer> map = new HashMap<>();
        map.put(source,-1);
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        boolean[] visited = new boolean[mat.length];
    	visited[source] = true;
    	
		while(!q.isEmpty()) {
			int i = q.peek();
           	if(i==target)
                break;
			for(int j =0;j<mat.length;j++) {
				if(mat[i][j]==1 && !visited[j]) {
					q.add(j);
					visited[j] = true;
                    map.put(j,i);
				}
			}
			q.poll();
		}
        String path = "";
        if(!map.containsKey(target))
 	   		return path;
        
        int curr = target;
        while(curr!=-1){
            path = path + curr + " ";
            curr = map.get(curr);
        }
        
        return path;
	}
    
	public static void main(String[] args){
	
        Scanner sc = new Scanner(System.in);
        
		String[] ip1 = sc.nextLine().split(" ");
		
		int V = Integer.parseInt(ip1[0]);
		int E = Integer.parseInt(ip1[1]);
		
        if(V==0)
            return;
        
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
		
        String[] vertices = sc.nextLine().split(" ");
        int v1 = Integer.parseInt(vertices[0]);
        int v2 = Integer.parseInt(vertices[1]);
        
        System.out.println(BFS(adjMatrix,v1,v2));
	}

}