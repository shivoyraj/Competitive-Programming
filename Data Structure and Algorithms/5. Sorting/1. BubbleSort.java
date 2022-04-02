class Solution {

	public void bubbleSort(int[] a, int n) {
		boolean isSwapped = false;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (a[j] < a[i]) {
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
					isSwapped = true;
				}
			}
			if (!isSwapped)
				break;
		}
	}

}


public class Test {
	public static void main(String[] args) {
		int[] a = { 8, 4, 2, 45, -3, 5, -54, 9, 5, 0 };
		new Solution().bubbleSort(a,a.length);
		for (int i : a)
			System.out.print(i + " ");
	}
}


