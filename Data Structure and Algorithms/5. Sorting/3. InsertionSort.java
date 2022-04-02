class Solution {

	public void insertionSort(int[] a, int n) {
		for (int i = 1; i < n; i++) {
			int key = a[i];  //key which need to place in left on correct sorting position
			int j=i-1;
			while(j>=0 && a[j]>key) {
				a[j+1]=a[j];  //right shifting if position not found
				j--;
			}
			a[j+1]=key;      // position found then placing [(j+1) because extra decrement of j in last iteration]  
		}
	}

}

public class Test {
	public static void main(String[] args) {
		int[] a = { 8, 4, 2, 45, -3, 5, -54, 9, 5, 0 };
		new Solution().insertionSort(a, a.length);
		for (int i : a)
			System.out.print(i + " ");
	}
}

