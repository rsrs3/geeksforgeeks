import java.util.Arrays;
import java.util.Collections;
/*

Given an array of integers (both odd and even), sort them in such a way that
the first part of the array contains odd numbers sorted in descending order,
rest portion contains even numbers sorted in ascending order.

*/


public class OddEvenSort {

    public void sort(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; ++i) {
            if((nums[i] & 1) == 1)  {
                if(nums[i] > 0) {
                    count++;
                }
                nums[i] *= -1;
            }
        }
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; ++i) {
            if((nums[i] & 1) == 1) nums[i] *= -1;
        }

        Arrays.sort(nums, count, nums.length);
    }

    public void sort2(Integer[] nums) {
        int l = 0, r = nums.length - 1, k = 0;

        while(l < r) {
            while(l < r && nums[l] % 2 != 0) {
                l++;
                k++;
            }

            while(l < r && nums[r] % 2 == 0) {
                r--;
            }

            if(l < r) swap(nums, l, r);
        }

        Arrays.sort(nums, 0, k, Collections.reverseOrder());
        Arrays.sort(nums, k, nums.length);
    }

    private void swap(Integer[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        OddEvenSort o = new OddEvenSort();
        int[] nums = new int[]{0, 4, 5, 3, -7, 2, 1};
        o.sort(nums);
        System.out.println(Arrays.toString(nums));
        Integer[] nums2 = new Integer[]{0, 4, 5, 3, -7, 2, 1};
        o.sort2(nums2);
        System.out.println(Arrays.toString(nums2));
    }
}
