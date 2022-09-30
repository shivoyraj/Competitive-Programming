import java.util.Arrays;

class Solution {

	public static int tripletSum(int[] arr, int num) {

		int count = 0, n = arr.length;
		Arrays.sort(arr);

		for (int i = 0; i < n - 1; i++) {

			int j = i + 1;
			int k = n - 1;

			while (j < k) {

				if (arr[i] + arr[j] + arr[k] < num)
					j++;

				else if (arr[i] + arr[j] + arr[k] > num)
					k--;

				else {
                    
					if (arr[j] == arr[k]) {
						int m = k - j + 1;
						count += (m * (m - 1)) / 2;
						break;
					}

					int k1 = j, k2 = k, f1 = 1, f2 = 1;
					while (k1 < arr.length && arr[++k1] == arr[j])
						f1++;

					while (k2 >= 0 && arr[--k2] == arr[k])
						f2++;

					count = count + f1 * f2;
					j = k1;
					k = k2;
				}
			}
		}
		return count;
	}
}

public class test {
	public static void main(String[] args) {

		int[] a = { 6, 1, 6, 5, 3, 2, 5, 0, 5, 6, 0 };

		int res = Solution.tripletSum(a, 5);
		System.out.println(res);
	}
}
