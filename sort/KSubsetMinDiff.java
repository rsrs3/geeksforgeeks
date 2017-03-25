import java.util.Arrays;
public class KSubsetMinDiff {


    public int minDiff(int[] input, int k) {

        Arrays.sort(input);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= input.length - k; ++i) {
            min = Math.min(min, input[i + k - 1] - input[i]);
        }

        return min;
    }

    public static void main(String[] args) {
        KSubsetMinDiff s = new KSubsetMinDiff();
        int[] input = new int[]{102, 101, 100, 5, 3};
        System.out.println(s.minDiff(input, 3));
        input = new int[]{5, 1, 10, 6};
        System.out.println(s.minDiff(input, 2));
    }
}
