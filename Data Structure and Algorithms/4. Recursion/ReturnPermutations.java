class solution {

	public static String[] permutationOfString(String input) {
	
		if (input.length() == 0)
			return new String[] {""};
		
		String[] smallerOutput = permutationOfString(input.substring(1));
		String output[] = new String[input.length() * smallerOutput.length];
		
		int k = 0;
		
		for (int i = 0; i < smallerOutput.length; i++)
			for (int j = 0; j <= smallerOutput[i].length(); j++)
				output[k++] = smallerOutput[i].substring(0, j) + input.charAt(0) + smallerOutput[i].substring(j);
		
		return output;
	}
}

class Test {

	public static void main(String[] args) {

		int[] a = { 1, 2, 3 };
		String[] res = solution.permutationOfString("abc");

		for (String s : res)
			System.out.println(s);
	}
}
