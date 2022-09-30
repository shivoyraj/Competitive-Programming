class Solution {

	public static int arrayRotateCheck(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1])
				return (i + 1);
		}
		return 0;
	}
}

public class test {
	public static void main(String[] args) {

		int[] a = { 4, 6, 9, 10 };
		int[] b = { 4, 5,6, 1, 2, 3 };

		System.out.println(Solution.arrayRotateCheck(a));
		System.out.println(Solution.arrayRotateCheck(b));

	}
}