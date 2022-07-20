class Solution {

    static int[][] visited;
	
	public static void ratInAMaze(int maze[][],int i, int j,int n){
		
		if(i == n-1 && j == n-1){
            visited[i][j] = 1;
            for(int p=0;p<n;p++)
                for(int q=0;q<n;q++)
                    System.out.print(visited[p][q]+" ");
            System.out.println();
            visited[i][j] = 0;
			return;
        }
		
		if(i<0 || j<0 || i>=maze.length || j>=maze.length || maze[i][j]==0 || visited[i][j]==1)
			return;
		
		visited[i][j] = 1;
				
		ratInAMaze(maze,i,j-1,n);
        ratInAMaze(maze,i,j+1,n);
        ratInAMaze(maze,i-1,j,n);
        ratInAMaze(maze,i+1,j,n);
        
        visited[i][j] = 0;
        
	}
    
	static void ratInAMaze(int maze[][], int n) {
		visited = new int[maze.length][maze.length];
		ratInAMaze(maze,0,0,n);	
	}

}

class Test {

	public static void main(String[] args) {

		int[][] a = {{1,1,1},{1,1,0},{0,1,1}};
		Solution.ratInAMaze(a,a.length);

	}
}
