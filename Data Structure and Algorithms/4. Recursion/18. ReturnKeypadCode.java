class Solution {

	public static String[] keypadCodes(int n) {

		switch (n) {

			case 2:
				return new String[] { "a", "b", "c" };
			case 3:
				return new String[] { "d", "e", "f" };
			case 4:
				return new String[] { "g", "h", "i" };
			case 5:
				return new String[] { "j", "k", "l" };
			case 6:
				return new String[] { "m", "n", "o" };
			case 7:
				return new String[] { "p", "q", "r", "s" };
			case 8:
				return new String[] { "t", "u", "v" };
			case 9:
				return new String[] { "w", "x", "y", "z" };
			default:
				return new String[] {""};
                
		}
	}
	
	public static String[] keypad(int n) {

		if(n==0)
			return new String[] {""};
		
		String[] res1 = keypad(n/10);
		String[] res2 = keypadCodes(n%10);
		
		String[] res = new String[res1.length*res2.length];
		
		int k =0;
		for(int i=0;i<res1.length;i++)
			for(int j=0;j<res2.length;j++)
				res[k++] = res1[i]+res2[j];
		
		
		return res;
	}
}

class test {

	public static void print(String[] a) {
		for (String i : a)
			System.out.print(i + " ");
	}

	public static void main(String[] args) {

		String[] res = Solution.keypad(23);
		print(res);
	}
}
