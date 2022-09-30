class solution {

	public static int[][] subsetsSumKHelper(int[] input, int beginIndex, int k) {
	
		if (beginIndex == input.length) {
			
			if (k == 0)
				return new int[1][0];
			else
				return new int[0][0];
			
		}
		
		int[][] smallOutput1 = subsetsSumKHelper(input, beginIndex + 1, k);
		int[][] smallOutput2 = subsetsSumKHelper(input, beginIndex + 1, k - input[beginIndex]);
		
		int[][] output = new int[smallOutput1.length + smallOutput2.length][];
		
		int index = 0;
		for (int i = 0; i < smallOutput1.length; i++)
			output[index++] = smallOutput1[i];
		
		for (int i = 0; i < smallOutput2.length; i++) {
			
			output[index] = new int[smallOutput2[i].length + 1];
			output[index][0] = input[beginIndex];
			
			for (int j = 0; j < smallOutput2[i].length; j++)
				output[index++][j + 1] = smallOutput2[i][j];
			
		}
		return output;
	}

	public static int[][] subsetsSumK(int input[], int k) {
		return subsetsSumKHelper(input, 0, k);
	}
}

class Test {

	public static void main(String[] args) {

		int[] a = { 5, 12, 3, 17, 1, 18, 15, 3, 17 };
		int[][] res = solution.subsetsSumK(a, 6);

		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++)
				System.out.print(res[i][j] + " ");
			System.out.println();
		}

	}
}
