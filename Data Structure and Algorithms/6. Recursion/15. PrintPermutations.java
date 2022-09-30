class solution {

	public static void permutationsHelper(String input, String output) {
		
		if (input.length() == 0) {
			System.out.println(output);
			return;
		}
		
		for (int i = 0; i < input.length(); i++)
			permutationsHelper((input.substring(0, i) + input.substring(i + 1)), output + input.charAt(i));
	}

	public static void permutations(String input) {
		permutationsHelper(input, "");
	}
}

class Test {

	public static void main(String[] args) {
		solution.permutations("abc");
	}
}
