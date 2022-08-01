class Solution1 {

    public static int findMaxSquareWithAllZeros(int[][] input, int i, int j) {

        if (i >= input.length || j >= input[0].length || input[i][j] == 1)
            return 0;

        int res1 = findMaxSquareWithAllZeros(input, i + 1, j);
        int res2 = findMaxSquareWithAllZeros(input, i, j + 1);
        int res3 = findMaxSquareWithAllZeros(input, i + 1, j + 1);

        return 1 + Math.min(res1, Math.min(res2, res3));
    }

    public static int findMaxSquareWithAllZeros(int[][] input) {

        if (input.length == 0)
            return 0;

        int max = 0;
        for (int i = 0; i < input.length; i++)
            for (int j = 0; j < input[0].length; j++)
                max = Math.max(max, findMaxSquareWithAllZeros(input, i, j));

        return max;
    }

}

class Solution2 {

    public static int findMaxSquareWithAllZeros(int[][] input, int i, int j, Integer[][] dp) {

        if (i >= input.length || j >= input[0].length || input[i][j] == 1)
            return 0;

        if (dp[i][j] == null) {

            int res1 = findMaxSquareWithAllZeros(input, i + 1, j, dp);
            int res2 = findMaxSquareWithAllZeros(input, i, j + 1, dp);
            int res3 = findMaxSquareWithAllZeros(input, i + 1, j + 1, dp);

            dp[i][j] = 1 + Math.min(res1, Math.min(res2, res3));
        }
        return dp[i][j];
    }

    public static int findMaxSquareWithAllZeros(int[][] input) {

        if (input.length == 0)
            return 0;

        Integer[][] dp = new Integer[input.length][input[0].length];

        int max = 0;
        for (int i = 0; i < input.length; i++)
            for (int j = 0; j < input[0].length; j++)
                max = Math.max(max, findMaxSquareWithAllZeros(input, i, j, dp));

        return max;
    }

}

class Solution3 {

    public static int findMaxSquareWithAllZeros(int[][] input) {

        if (input.length == 0)
            return 0;

        int max = 0;

        int[][] dp = new int[input.length][input[0].length];

        for (int i = 0; i < input.length; i++)
            if (input[i][0] == 0)
                max = dp[i][0] = 1;

        for (int j = 0; j < input[0].length; j++)
            if (input[0][j] == 0)
                max = dp[0][j] = 1;

        for (int i = 1; i < input.length; i++) {
            for (int j = 1; j < input[0].length; j++) {
                if (input[i][j] != 1) {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

}

class Solution4 {

    public static int findMaxSquareWithAllZeros(int[][] input) {

        if (input.length == 0)
            return 0;

        int[][] dp = new int[input.length + 1][input[0].length + 1];

        int max = 0;
        for (int i = 1; i <= input.length; i++) {
            for (int j = 1; j <= input[0].length; j++) {
                if (input[i - 1][j - 1] != 1) {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

}

class Solution5 {

    public static int findMaxSquareWithAllZeros(int[][] input) {

        if (input.length == 0)
            return 0;

        int[] dp = new int[input[0].length + 1];
        int[] tmp = new int[input[0].length + 1];

        int max = 0;
        for (int i = 1; i <= input.length; i++) {
            for (int j = 1; j <= input[0].length; j++) {
                if (input[i - 1][j - 1] != 1) {
                    tmp[j] = 1 + Math.min(dp[j], Math.min(tmp[j - 1], dp[j - 1]));
                    max = Math.max(max, tmp[j]);
                } else
                    tmp[j] = 0;
            }
            for (int j = 1; j <= input[0].length; j++)
                dp[j] = tmp[j];
        }
        return max;
    }

}

class Solution6 {

    public static int findMaxSquareWithAllZeros(int[][] input) {

        if (input.length == 0)
            return 0;

        int[] dp = new int[input[0].length + 1];
        int max = 0, prev = 0;

        for (int i = 1; i <= input.length; i++) {
            for (int j = 1; j <= input[0].length; j++) {
                int tmp = dp[j];
                if (input[i - 1][j - 1] != 1) {
                    dp[j] = 1 + Math.min(dp[j], Math.min(dp[j - 1], prev));
                    max = Math.max(max, dp[j]);
                }
                else
                    dp[j] = 0;
                prev = tmp;
            }
        }
        return max;
    }

}