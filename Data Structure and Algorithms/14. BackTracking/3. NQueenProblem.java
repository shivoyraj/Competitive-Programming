class Solution {

	static int[][] board;

	public static boolean isSafe(int a, int b) {

		for (int i = a; i >= 0; i--)
			if (board[i][b] == 1)
				return false;

		for (int i = a, j = b; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;

		for (int i = a, j = b; i >= 0 && j < board.length; i--, j++)
			if (board[i][j] == 1)
				return false;

		return true;
	}

	public static void placeNQueens(int n, int row) {

		if (row == n) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					System.out.print(board[i][j] + " ");
				System.out.println();
			}
			System.out.println();
			return;
		}

		for (int j = 0; j < n; j++) {
			if (isSafe(row, j)) {
				board[row][j] = 1;
				placeNQueens(n, row + 1);
                board[row][j] = 0;
			}
		}
	}

	public static void placeNQueens(int n) {
		board = new int[n][n];
		placeNQueens(n, 0);
	}

}

class Test {

	public static void main(String[] args) {

		Solution.placeNQueens(8);
		System.out.println();

	}
}
