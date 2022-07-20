class Solution {

	public static String[] subsequence(String input){

		if(input.length()==1)
			return new String[] {input};
				
		String[] smallop = subsequence(input.substring(1));
		String[] res = new String[2*smallop.length+1];
		
		int k=0;
		for(int i=0;i<smallop.length;i++)
			res[k++] = smallop[i];
		
		res[k++] = ""+input.charAt(0);
		
		for(int i =0;i<smallop.length;i++)
			res[k++] = input.charAt(0)+smallop[i];
		
		return res;
	}
}


public class Test {
	public static void main(String[] args) {
		String[] res = Solution.subsequence("abc");
		for(String s : res)
			System.out.println(s);
	}
}
