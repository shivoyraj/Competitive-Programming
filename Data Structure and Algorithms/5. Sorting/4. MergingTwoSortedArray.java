// two sorted array a[] and b[]
// size of a = (m+n) first mth filled with sorted numbers
// size of b = n
// merge b[] in a[] final result should also sorted

class Solution {

	public void merge(int[] a, int m, int[] b, int n) {
		int i = m - 1, j = n - 1, k = n + m - 1;
		while (i >= 0 && j >= 0) {
			if (a[i] > b[j])
				a[k--] = a[i--];
			else
				a[k--] = b[j--];
		}
		while (i >= 0)
			a[k--] = a[i--];
		while (j >= 0)
			a[k--] = b[j--];
	}
}

public class Test {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 0, 0, 0 };
		int[] b = { 2, 5, 6 };
		new Solution().merge(a, 3, b, 3);
		for (int i : a)
			System.out.print(i + " ");
	}
}

