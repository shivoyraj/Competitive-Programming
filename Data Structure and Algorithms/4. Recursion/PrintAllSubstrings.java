class Solution {
	
	public static void printSubsequence(String input,String output){
		
		if(input.length()==0) {
			System.out.println(output);
			return;
		}
		
		printSubsequence(input.substring(1),output);
		printSubsequence(input.substring(1),output+input.charAt(0));
	}
	
	public static void printSubsequence(String input){
		printSubsequence(input,"");
	}
}


class Test {
	public static void main(String[] args) {
		Solution.printSubsequence("abc");
	}
}
