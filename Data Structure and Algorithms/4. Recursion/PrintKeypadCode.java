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
	
	public static void printKeypad(int input,String res2) {

		if(input<1) {
			System.out.println(res2);
			return;
		}	
		
		String[] res1 = keypadCodes(input%10);
		
		for(int i=0;i<res1.length;i++) 
			printKeypad(input/10,res1[i]+res2);
			
	}

	public static void printKeypad(int input) {
			
		printKeypad(input,"");
	}
}

class test {

	public static void main(String[] args) {

		Solution.printKeypad(23);
	}
}
