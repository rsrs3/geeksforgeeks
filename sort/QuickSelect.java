public class QuickSelect {

    public int select(int[] nums, int k) {
        shuffle(nums);
        int start = 0, end = nums.length - 1;
        while(start < end) {
            int j = partition(nums, start, end);
            if(j == k) return nums[j];
            else if(j > k) end = j - 1;
            else start = j + 1;
        }
        return nums[k];
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


    private void shuffle(int[] nums) {
        int N = nums.length - 1;
        for(int i = 0; i < N; ++i) {
            int index = (int) Math.random() * (i + 1);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        QuickSelect q = new QuickSelect();
        int[] nums = new int[]{8, 3, 5, 1, 4, 6,10};
        int val = q.select(nums, 3);
        System.out.println(val);
    }
}
