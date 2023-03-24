public class Test {

	public static String sort1(String s) {

		if (s.length() == 1)
			return s;

		String smallSortedString = sort1(s.substring(1));
		String sortedString = "";
		char ch = s.charAt(0);

		for (int i = 0; i < smallSortedString.length(); i++) {
			if (smallSortedString.charAt(i) > ch) {
				sortedString = smallSortedString.substring(0, i) + ch + smallSortedString.substring(i);
				break;
			} else if (i == smallSortedString.length() - 1) {
				sortedString = smallSortedString + ch;
			}
		}

		return sortedString;
	}

	public static String sort2(String s) {

		int[] index = new int[256];
		String sortedString = "";

		for (int i = 0; i < s.length(); i++)
			index[s.charAt(i)] = 1;

		for (int i = 0; i < 256; i++)
			if (index[i] == 1)
				sortedString = sortedString + (char) i;

		return sortedString;

	}

	public static void main(String[] args) {
		String s = "webhilvjk";
		System.out.println(sort1(s));
		System.out.println(sort2(s));
		System.out.println(sort1(s).equals(sort2(s)));
	}
}
