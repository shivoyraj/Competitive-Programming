class Solution {

	public static boolean interprt(String s1, String s2) {
    	
    	if (s2.length() < s1.length())
			return false;

		int i = 0, j = 0;
		while (i < s1.length() && j < s2.length()) {

			if (s1.charAt(i) == s2.charAt(j)) {

				char ch = s1.charAt(i);

				int count1 = 0;
				while (i < s1.length() && s1.charAt(i) == ch){
                    i++;
					count1++;
                }

				int count2 = 0;
				while (j < s2.length() && s2.charAt(j) == ch){
                    j++;
					count2++;
                }

				if (count1 > count2)
					return false;

			} else
				return false;
		}

		if(i==s1.length() && j==s2.length())
			return true;
		else
			return false;
	}
}

class test {
	public static void main(String[] args) {
		
		String s1 = "code";
		String s2 = "cooodeee";
		
		System.out.println(Solution.interprt(s1,s2));
		
		String s3 = "hello";
		String s4 = "hheeeloo";
		
		System.out.println(Solution.interprt(s3,s4));
	}
}