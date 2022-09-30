class Solution {

	public static void pushZerosAtEnd(int[] arr) {
		int nonZero = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				int temp = arr[i];
				arr[i] = arr[nonZero];
				arr[nonZero] = temp;
				nonZero++;
			}
		}
	}
}

public class test {
	public static void main(String[] args) {

		int[] a = { 1, 0, 0, 1, 1, 1, 0, 0, 1, 1 };

		Solution.pushZerosAtEnd(a);

		for (int i : a)
			System.out.print(i + " ");

	}
}