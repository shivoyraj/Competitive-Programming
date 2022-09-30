class Solution {

	public void selectionSort(int[] a, int n) {
		for (int i = 0; i < n; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++)
				if (a[j] < a[minIndex])
					minIndex = j;
			int temp = a[i];
			a[i] = a[minIndex];
			a[minIndex] = temp;
		}
	}

}

public class Test {
	public static void main(String[] args) {
		int[] a = { 8, 4, 2, 45, -3, 5, -54, 9, 5, 0 };
		new Solution().selectionSort(a, a.length);
		for (int i : a)
			System.out.print(i + " ");
	}
}

