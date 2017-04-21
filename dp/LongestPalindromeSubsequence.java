public class LongestPalindromeSubsequence {


    public int longestPalindrome(String string) {
        int N = string.length();
        int[][] dp = new int[N][N];

        for(int i = 0; i < N; ++i) {
            dp[i][i] = 1;
        }

        for(int l = 2; l <= N; ++l) {
            for(int i = 0; i <= N-l; ++i) {
                int k = i + l - 1;
                if(string.charAt(i) == string.charAt(k)) {
                    dp[i][k] = 2 + dp[i + 1][k - 1];
                } else {
                    dp[i][k] = Math.max(dp[i + 1][k], dp[i][k - 1]);
                }
            }
        }

        return dp[0][N - 1];
    }

    public static void main(String[] args) {
        LongestPalindromeSubsequence l = new LongestPalindromeSubsequence();
        System.out.println(l.longestPalindrome("BBABCBCAB"));
    }
}
