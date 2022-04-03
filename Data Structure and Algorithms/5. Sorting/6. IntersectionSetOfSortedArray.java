import java.util.ArrayList;
import java.util.List;

class Solution {
	// the intersection of two sorted arrays with no duplicates.
	public static List<Integer> intersection(int[] A,int[] B) {
		int m = A.length;
		int n = B.length;
		List<Integer> common = new ArrayList<>();
		int i = 0, j = 0;
		while (i < m && j < n) {
			if (A[i] == B[j]) {
				common.add(A[i]);
				i++;
				j++;
				while (i < m && A[i] == A[i - 1]) // ingoring duplicates
					i++;
			} else {
				while (i < m && j < n && A[i] < B[j])
					i++;
				while (j < n && i < m && B[j] < A[i])
					j++;
			}
		}
		return common;
	}
}

public class Test {
	public static void main(String[] args) {
		int[] a = { 3, 5, 10, 10, 10, 15, 15, 20 };
		int[] b = { 5, 10, 10, 15, 30 };
		List<Integer> common = Solution.intersection(a, b);
		for (int i : common)
			System.out.print(i + " ");
	}
}

