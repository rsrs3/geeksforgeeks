import java.util.*;

public class LargetBitonicSubsequence {


    public int getLength(int[] nums) {
            int N = nums.length;
            int[] forward = new int[N], backward = new int[N];
            Arrays.fill(forward, 1);

            // Get longest increasing sunsequence
            for(int i = 1; i < N; ++i) {
                for(int j = 0; j < i; ++j) {
                    if(nums[i] > nums[j])
                        forward[i] = Math.max(forward[i], forward[j] + 1);
                }
            }

            Arrays.fill(backward, 1);

            // Get longest decreasing sunsequence
            for(int i = N - 2; i >= 0; --i) {
                for(int j = N - 1; j > i; --j) {
                    if(nums[i] > nums[j])
                        backward[i] = Math.max(backward[i], backward[j] + 1);
                }
            }

            int max = 0;

            for(int i = 0; i < N; ++i) {
                max = Math.max(max, forward[i] + backward[i] - 1);
            }
            return max;
    }

    public static void main(String[] args) {
        LargetBitonicSubsequence l = new LargetBitonicSubsequence();
        int[] nums1 = new int[] {1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println(l.getLength(nums1));
        int[] nums2 = new int[]{12, 11, 40, 5, 3, 1};
        System.out.println(l.getLength(nums2));
        int[] nums3 = new int[] {80, 60, 30, 40, 20, 10};
        System.out.println(l.getLength(nums3));
    }


}
