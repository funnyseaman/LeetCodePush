package all.p912;

import org.junit.Test;

import java.util.Arrays;

public class QuickSort {
    public int[] sortArray(int[] nums) {
        mySort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mySort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = merge(nums, start, end);
        mySort(nums, start, pivot - 1);
        mySort(nums, pivot + 1, end);
    }

    private int merge(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (nums[j] < pivot) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        nums[end] = nums[i];
        nums[i] = pivot;
        return i;
    }

    @Test
    public void test() {
        int[] nums = {2, 5, 3, 7, 8, 4, 3, 7, 0, 9};
        int[] res = sortArray(nums);
        System.out.println(Arrays.toString(res));
    }
}
