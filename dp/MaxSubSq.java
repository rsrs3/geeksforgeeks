public class MaxSubSq {

    public int maxSubSquare(int[][] matrix) {
        int M = matrix.length, N = matrix[0].length;
        int[][] sq = new int[M][N];

        for(int i = 0; i < M; ++i){
            sq[i][0] = matrix[i][0];
        }

        for (int j = 0;j < N; ++j) {
            sq[0][j] = matrix[0][j];
        }

        for(int i = 1; i < M; ++i) {
            for(int j = 1; j < N; ++j) {
                if(matrix[i][j] == 1) {
                    sq[i][j] = min(sq[i - 1][j], sq[i][j - 1],
                        sq[i - 1][j - 1]) + 1;
                }
            }
        }

        int mI = 0, mJ = 0, max = Integer.MIN_VALUE;

        for(int i = 0; i < M; ++i) {
            for(int j = 0; j < N; ++j) {
                if(sq[i][j] > max) {
                    max = sq[i][j];
                    mI = i;
                    mJ = j;
                }
            }
        }

        for(int i = mI; i > mI - max; --i) {
            for(int j = mJ; j > mJ - max; --j) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
        return max;
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{0, 1, 1, 0, 1},
                   {1, 1, 0, 1, 0},
                   {0, 1, 1, 1, 0},
                   {1, 1, 1, 1, 0},
                   {1, 1, 1, 1, 1},
                   {0, 0, 0, 0, 0}};
        MaxSubSq m = new MaxSubSq();
        System.out.println(m.maxSubSquare(matrix));
    }
}
