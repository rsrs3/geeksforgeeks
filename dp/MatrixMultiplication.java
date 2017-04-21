public class MatrixMultiplication {


    public int minCost(int[] arr) {
        int N = arr.length;
        int[][] dp = new int[N][N];

        for(int l = 2; l < N; ++l) {
            for(int i = 0; i < N - l; ++i) {
                int j = i + l;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i + 1; k < j; ++k) {
                    dp[i][j] = Math.min(dp[i][j] ,
                        dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j]);
                }
            }
        }

        return dp[0][N-1];
    }

    public static void main(String[] args) {
        MatrixMultiplication mmc = new MatrixMultiplication();
       int arr[] = {4,2,3,5,3};
       int cost = mmc.minCost(arr);
       System.out.println(cost);
    }
}
