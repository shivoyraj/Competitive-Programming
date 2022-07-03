class Solution {

	public static int maxSum(int arr[], int n, int k) {

		int res = 0;
		for (int i = 0; i < k; i++)
			res += arr[i];

		int ms = res;
		for (int i = k; i < n; i++) {
			ms = ms + arr[i] - arr[i - k];
			res = Math.max(res, ms);
		}

		return res;
	}
}

public class test {
	public static void main(String[] args) {
		
		int[] a = {7 ,5 ,10, 14, 10, 16, 3 };
		System.out.println(Solution.maxSum(a,a.length,3));
	}
}