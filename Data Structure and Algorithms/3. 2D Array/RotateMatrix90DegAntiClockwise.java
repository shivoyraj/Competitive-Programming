class Solution {
    
	static void transpose(int mat[][], int n) {

		for (int i = 0; i < n; i++)
			for (int j = i; j < n; j++) {
				int tmp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = tmp;
			}
	}

	static void rowReverse(int[][] mat, int n) {

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n; j++) {
				int tmp = mat[i][j];
				mat[i][j] = mat[n - i - 1][j];
				mat[n - i - 1][j] = tmp;
			}
		}
	}

	static void rotateby90(int mat[][], int n) {
		transpose(mat, n);
		rowReverse(mat, n);
	}
}