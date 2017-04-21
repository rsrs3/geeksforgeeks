public class RodCut {


    public int maxVal(int[] value) {
        int N = value.length;
        int[] dp = new int[N + 1];
        for(int i = 1; i <= N; ++i) {
            for(int j = 0; j < i; ++j) {
                dp[i] = Math.max(dp[i], value[j] + dp[i - j - 1]);
            }
        }

        return dp[N];
    }

    public static void main(String[] args) {
        RodCut r = new RodCut();
        System.out.println(r.maxVal(new int[] {1, 5, 8, 9, 10, 17, 17, 20}));
    }
}
