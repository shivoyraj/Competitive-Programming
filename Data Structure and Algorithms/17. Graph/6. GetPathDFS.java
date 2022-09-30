import java.util.Scanner;
import java.io.IOException;

class Solution {
        
    public static String DFS(int[][] mat, int k , boolean[] visited, int v1, int v2 , String output) {
        
        output = k + " " + output;

        if(k==v2)
            return output;
                
    	visited[k] = true;
        String res = "";
    	for(int i = 0; i < mat.length ; i++){
    		if(mat[k][i]==1 && !visited[i]){
    			res = DFS(mat,i,visited,v1,v2,output);
                if(res!="")
                    break;
            }
        }
    	return res;
	}
    
    public static void DFS(int[][] mat,int v1,int v2) {
    	
		boolean[] visited = new boolean[mat.length];
	    String res = DFS(mat,v1,visited,v1,v2,"");
	    System.out.print(res);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
	
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
        
        if(v1>=V || v2>=V)
            return;
        
        DFS(adjMatrix,v1,v2);
	}

}