class Solution {

	static boolean[][] visited;
	
	public static boolean ratInAMaze(int maze[][],int i, int j){
		
		if(i==maze.length-1 && j ==maze.length-1)
			return true;
		
		if(i<0 || j<0 || i>=maze.length || j>=maze.length || maze[i][j]==0 || visited[i][j])
			return false;
		
		visited[i][j] = true;
				
		return ratInAMaze(maze,i,j-1) || ratInAMaze(maze,i,j+1) || ratInAMaze(maze,i-1,j) || ratInAMaze(maze,i+1,j);
	}
	
	public static boolean ratInAMaze(int maze[][]){
		visited = new boolean[maze.length][maze.length];
		return ratInAMaze(maze,0,0);
	}
}

class Test {

	public static void main(String[] args) {

		int[][] a = {{1,1,1},{1,1,0},{0,1,1}};
		System.out.println(Solution.ratInAMaze(a));

	}
}
