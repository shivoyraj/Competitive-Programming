class Solution {

	public static void print(int n) {

		int t = 2 * n - 1;

		for (int i = 0; i < t; i++) {

			int k = (i <= t / 2) ? i : t - i - 1;
			int a = n;

			for (int j = 0; j < k; j++)
				System.out.print(a--);
			for (int j = 0; j < t - 2 * k; j++)
				System.out.print(a);
			for (int j = 0; j < k; j++)
				System.out.print(++a);

			System.out.println();
		}
	}
}

class test {
	public static void main(String[] args) {
		Solution.print(5);
	}
}

// OUTPUT

// 555555555
// 544444445
// 543333345
// 543222345
// 543212345
// 543222345
// 543333345
// 544444445
// 555555555