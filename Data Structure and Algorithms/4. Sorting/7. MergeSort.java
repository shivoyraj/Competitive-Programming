class Solution {
	
	public static void merge(int[] a, int[] a1, int[] a2, int h) {
		
		int m = a1.length;
		int n = a2.length;
		
		int i = m - 1, j = n - 1, k = h;
		while (i >= 0 && j >= 0) {
			if (a1[i] > a2[j])
				a[k--] = a1[i--];
			else
				a[k--] = a2[j--];
		}
		
		while (i >= 0)
			a[k--] = a1[i--];
		while (j >= 0)
			a[k--] = a2[j--];
	}

	public static void partition(int[] a, int l, int mid, int h) {

		int m = mid - l + 1;
		int n = h - mid;

		int[] a1 = new int[m];
		int[] a2 = new int[n];

		for (int i = 0; i < m; i++)
			a1[i] = a[i + l];
		for (int j = 0; j < n; j++)
			a2[j] = a[mid + 1 + j];
		
		merge(a,a1,a2,h);
	}

	public static void mergeSort(int arr[], int l, int r) {
		if (r > l) {
			int m = l + (r - l) / 2;
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);
			partition(arr, l, m, r);
		}
	}
}

public class Test {
	public static void main(String[] args) {
		int[] a = { 5, 2, 3, 1, 0, 2, 5, 6 };
		Solution.mergeSort(a, 0, a.length - 1);
		for (int i : a)
			System.out.print(i + " ");
	}
}

