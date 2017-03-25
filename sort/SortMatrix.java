import java.util.Arrays;
public class SortMatrix {


    public void sort(int[][] matrix) {
        int M = matrix.length, N = matrix[0].length;
        int[] nums = new int[M * N];
        for(int i = 0; i < M; ++i) {
            for(int j = 0; j < N; ++j) {
                nums[M*i + j] = matrix[i][j];
            }
        }

        Arrays.sort(nums);

        for(int i = 0; i < M*N; ++i) {
            int row = i/N;
            int col = i%N;
            matrix[row][col] = nums[i];
        }

    }

    public static void main(String[] args) {
        SortMatrix s = new SortMatrix();
        int[][] matrix = new int[][]{
            {1, 4, 2},
            {3, 5, 6},
            {9, 7, 8}
        };
        s.sort(matrix);
        for(int i = 0; i < matrix.length; ++i) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
