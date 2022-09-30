class solution {

	public static void printSubsets(int input[], String s, int i) {

		if (i == input.length) {
			System.out.println(s);
			return;
		}

		printSubsets(input, s, i + 1);
		printSubsets(input, s + input[i] + " ", i + 1);
	}

	public static void printSubsets(int input[]) {
		printSubsets(input, "", 0);
	}
}

class Test {

	public static void main(String[] args) {

		int[] a = { 1, 2, 3 };
		solution.printSubsets(a);
	}
}
