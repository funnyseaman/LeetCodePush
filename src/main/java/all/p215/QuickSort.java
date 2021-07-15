package all.p215;

import org.junit.Test;

import java.util.Arrays;

public class QuickSort {
    // 先来个手撕快排
    public void quickSort(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        mySort(nums, 0, nums.length - 1);
    }

    // 递归函数
    private void mySort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = merge(nums, start, end);
        mySort(nums, start, pivot - 1);
        mySort(nums, pivot + 1, end);
    }

    // 原地分区算法
    private int merge(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (nums[j] < pivot) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
        nums[end] = nums[i];
        nums[i] = pivot;
        return i;
    }


    @Test
    public void test() {
        int[] nums = {5, 4, 3, 2, 1};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
