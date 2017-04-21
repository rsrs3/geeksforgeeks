import java.util.*;

public class QuickSort {

    public void sort(int[] nums) {
        shuffle(nums);
        sortOp(nums, 0, nums.length - 1);
    }

    private int partition(int[] nums, int start, int end) {
        int i = start + 1, j = end;
        while(i <= j) {
            while(i <= j && nums[i] <= nums[start]) i++;

            while(i <= j && nums[j] > nums[start]) j--;

            if(i < j) swap(nums, i, j);
        }
        swap(nums, start, j);
        return j;
    }

    private void sortOp(int[] nums, int start, int end) {
        if(start >= end) return;
        int val = nums[start];
        int lt = start, i = start, gt = end;
        while(i <= gt) {
            if(nums[i] < val) swap(nums, lt++, i++);
            else if(nums[i] > val) swap(nums, i, gt--);
            else i++;
        }
        sort(nums, start, lt - 1);
        sort(nums, gt + 1, end);
    }

    private void sort(int[] nums, int start, int end) {
        if(start >= end) return;
        int j = partition(nums, start, end);
        sort(nums, start, j - 1);
        sort(nums, j + 1, end);
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    private void shuffle(int[] nums) {
        int N = nums.length;
        for(int i = 0; i < N; ++i) {
            int index = (int) Math.random() * (i + 1);
            swap(nums, i, index);
        }
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] nums = new int[] {7,3,5,3,4,2,1, 9, 6, 4,2, 3};
        q.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
