class Solution1{

	public static int lcs(String s, String t) {
		
		if(s.length()==0 || t.length()==0)
			return 0;
		
		if(s.charAt(0)==t.charAt(0))
			return 1 + lcs(s.substring(1),t.substring(1));
		
		return Math.max(lcs(s,t.substring(1)), lcs(s.substring(1),t));
    }

}


class Solution2{

	public static int lcs(String s, String t, int i, int j, Integer[][] dp) {

		if (s.length() == i || t.length() == j)
			return 0;

		if (dp[i][j] == null) {

			if (s.charAt(i) == t.charAt(j))
				dp[i][j] =  1 + lcs(s, t, i + 1, j + 1, dp);

			else
				dp[i][j] = Math.max(lcs(s, t, i, j + 1, dp), lcs(s, t, i + 1, j, dp));

		}
		return dp[i][j];
	}

	public static int lcs(String s, String t) {

		Integer[][] dp = new Integer[s.length()][t.length()];
		return lcs(s, t, 0, 0, dp);
	}

}

class Solution3{

	public static int lcs(String s, String t) {

		int n1 = s.length();
		int n2 = t.length();
		
		int[][] dp = new int[n1+1][n2+1];
		
		for(int i = 1 ;i<=n1 ;i++) {
			for(int j = 1 ;j<=n2 ;j++) {
				if(s.charAt(i-1) == t.charAt(j-1))
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		
		return dp[n1][n2];
	}

}