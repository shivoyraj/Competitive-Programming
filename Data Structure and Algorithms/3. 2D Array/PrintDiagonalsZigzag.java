/**
 * Simulate Diagonal Order Traversal
 *
 * if i states current row and j states current column
 * i+j determines which diagonal you are on. For ex: [2,0],[1,1],[0,2] are all
 * on same diagonal with i+j =2. If you check the directions of diagonals, first
 * diagonal is up, second diagonal is down, third one is up and so on..
 * Therefore (i+j)%2 simply determines direction. Even is UP direction. Odd is
 * DOWN direction.
 *
 * Time Complexity: O(M*N)
 *
 * Space Complexity: O(1) without considering result space.
 *
 * M = Number of rows. N = Number of columns.
 */
class Solution {
	
    public static int[] printDiagonalsZigzag(int[][] a) {
    	
        if (a == null) {
            throw new IllegalArgumentException("Input matrix is null");
        }
        if (a.length == 0 || a[0].length == 0) {
            return new int[0];
        }

        int i = 0 , j = 0 ,rows = a.length ,cols = a[0].length;
        int[] res = new int[rows * cols];
        
        for (int k = 0; k < res.length; k++) {
            res[k] = a[i][j];
            if ((i + j) % 2 == 0) { // Move Up
                if (j == cols - 1) {
                    // Reached last column. Now move to below cell in the same column.
                    // This condition needs to be checked first due to top right corner cell.
                    i++;
                } else if (i == 0) {
                    // Reached first row. Now move to next cell in the same row.
                    j++;
                } else {
                    // Somewhere in middle. Keep going up diagonally.
                    i--;
                    j++;
                }
            } 
            else { // Move Down
                if (i == rows - 1) {
                    // Reached last row. Now move to next cell in same row.
                    // This condition needs to be checked first due to bottom left corner cell.
                    j++;
                } else if (j == 0) {
                    // Reached first columns. Now move to below cell in the same column.
                    i++;
                } else {
                    // Somewhere in middle. Keep going down diagonally.
                    i++;
                    j--;
                }
            }
        }

        return res;
    }
}