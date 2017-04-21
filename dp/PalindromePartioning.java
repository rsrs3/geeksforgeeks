public class PalindromePartioning {

    public int minCuts(String input) {
        int N = input.length();
        boolean[][] palindrome = new boolean[N][N];
        for(int i = 0; i < N; ++i) {
            palindrome[i][i] = true;
        }
        for(int L = 2; L <= N; ++L) {
            for(int i = 0; i <= N-L; ++i) {
                int j = i + L - 1;
                if(L == 2)
                    palindrome[i][j] = (input.charAt(i) == input.charAt(j));
                else
                    palindrome[i][j] = (input.charAt(i) == input.charAt(j)) &&
                                        palindrome[i  + 1][j - 1];
            }
        }

        int[] dp = new int[N];
        for(int i = 0; i < N; ++i) {
            if(palindrome[0][i]) dp[i] = 0;
            else {
                dp[i] = N;
                for(int j = 0; j < i; ++j) {
                    if(palindrome[j + 1][i])
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[N - 1];
    }

    public static void main(String[] args) {
        PalindromePartioning p = new PalindromePartioning();
        System.out.println(p.minCuts("ababbbabbababa"));
    }
}
