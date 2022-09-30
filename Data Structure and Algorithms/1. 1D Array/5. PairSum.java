import java.util.Arrays;

class Solution {

	public static int pairSum(int arr[], int x) {

		Arrays.sort(arr);

		int i = 0;
		int j = arr.length - 1;
		int c = 0;

		while (i < j) {

			if (arr[i] + arr[j] < x)
				i++;

			else if (arr[i] + arr[j] > x)
				j--;

			else {

				if (arr[i] == arr[j]) {
					int n = j - i + 1;
					c = c + (n * (n - 1)) / 2;
					break;
				}

				int k1 = i, k2 = j, f1 = 1, f2 = 1;
				while (k1 < arr.length && arr[++k1] == arr[i])
					f1++;

				while (k2 >= 0 && arr[--k2] == arr[j])
					f2++;

				c = c + f1 * f2;
				i = k1;
				j = k2;
			}
		}
		return c;
	}
}

public class test {
	public static void main(String[] args) {

		int[] a = { 0, 4, 1, 2, 5, 4 };

		int res = Solution.pairSum(a, 5);
		System.out.println(res);
	}
}