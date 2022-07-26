class Solution1 {

    public static boolean findWinnerHelper(int n, int x, int y) {

        if (n == 1 || n == x || n == y)
            return true;

        boolean res1 = false, res2 = false, res3 = false;

        if (n - 1 >= 1)
            res1 = !findWinnerHelper(n - 1, x, y);

        if (n - x >= 1)
            res2 = !findWinnerHelper(n - x, x, y);

        if (n - y >= 1)
            res3 = !findWinnerHelper(n - y, x, y);

        return res1 || res2 || res3;

    }

    public static String findWinner(int n, int x, int y) {

        if (findWinnerHelper(n, x, y))
            return "Beerus";
        else
            return "Whis";

    }
}

class Solution2 {

    public static boolean findWinner(int n, int x, int y, Boolean[] dp) {

        if (n == 1 || n == x || n == y)
            return true;

        boolean res1 = false, res2 = false, res3 = false;

        if (dp[n] == null) {

            if (n - 1 >= 1)
                res1 = !findWinner(n - 1, x, y, dp);

            if (n - x >= 1)
                res2 = !findWinner(n - x, x, y, dp);

            if (n - y >= 1)
                res3 = !findWinner(n - y, x, y, dp);

            dp[n] = res1 || res2 || res3;
        }

        return dp[n];

    }

    public static String findWinner(int n, int x, int y) {

        Boolean[] dp = new Boolean[n + 1];

        if (findWinner(n, x, y, dp))
            return "Beerus";
        else
            return "Whis";

    }
}
