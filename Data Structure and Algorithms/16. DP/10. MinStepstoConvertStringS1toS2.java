// can perform deletion insertion and updation of char

class Solution1{

	public static int editDistance(String s, String t, int i, int j) {
		
		if(i>=s.length())
		return t.length()-j; // no of char remaining in t (so can delete all)
	
		if(j>=t.length())
		return s.length()-i; // no of char remaining in s (so can delete all)
		
		if(s.charAt(i)==t.charAt(j)) 
			return editDistance(s,t,i+1,j+1);  //moving forward without change anything
		
		int res1 = editDistance(s,t,i,j+1); // delete
		int res2 = editDistance(s,t,i+1,j); // insert
		int res3 = editDistance(s,t,i+1,j+1); // replaced and moving forward
		
		return 1+Math.min(res1, Math.min(res2, res3));
		
	}
	
	public static int editDistance(String s, String t) {
		return editDistance(s,t,0,0);
	}

}

class Solution2{

	public static int editDistance(String s, String t, int i, int j, Integer[][] dp) {

		if (i >= s.length())
			return t.length() - j; // no of char remaining in t (so can delete all)

		if (j >= t.length())
			return s.length() - i; // no of char remaining in s (so can delete all)

		if (s.charAt(i) == t.charAt(j))
			return editDistance(s, t, i + 1, j + 1, dp); // moving forward without change anything

		if (dp[i][j] == null) {

			int res1 = editDistance(s, t, i, j + 1, dp); // delete
			int res2 = editDistance(s, t, i + 1, j, dp); // insert
			int res3 = editDistance(s, t, i + 1, j + 1, dp); // replaced and moving forward

			dp[i][j] = 1 + Math.min(res1, Math.min(res2, res3));

		}
		return dp[i][j];
	}

	public static int editDistance(String s, String t) {
		Integer[][] dp = new Integer[s.length()][t.length()];
		return editDistance(s, t, 0, 0, dp);
	}

}


class Solution3{

	public static int editDistance(String s, String t) {
		
		int[][] dp = new int[s.length()+1][t.length()+1];
		
		for(int i=1;i<=s.length();i++)
				dp[i][0] = i;
		
		for(int j=1;j<=t.length();j++)
				dp[0][j] = j;
		
		for(int i=1;i<=s.length();i++) {
			for(int j=1;j<=t.length();j++) {
				if(s.charAt(i-1)==t.charAt(j-1))
					dp[i][j] = dp[i-1][j-1];
				else
					dp[i][j] = 1+ Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
			}
		}
		
		return dp[s.length()][t.length()];
	}

}


class Solution4{

	public static int editDistance(String s, String t) {
		
		int[] dp = new int[t.length()+1];
		int[] tmp = new int[t.length()+1];
		
		for(int j=1;j<=t.length();j++)
				dp[j] = j;
		
		for(int i=1;i<=s.length();i++) {
            
            tmp[0] = i;
			
            for(int j=1;j<=t.length();j++) {
				if(s.charAt(i-1)==t.charAt(j-1))
					tmp[j] = dp[j-1];
				else
					tmp[j] = 1+ Math.min(dp[j], Math.min(dp[j-1], tmp[j-1]));
			}
            
            for(int j=0;j<=t.length();j++)
                dp[j] = tmp[j];
		}
		
		return dp[t.length()];
	}

}