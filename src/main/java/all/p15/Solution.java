package all.p15;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 二分法
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();

        if (nums == null || nums.length <= 2) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // 不与上一个数相同
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];
            // 第一个数大于0，那么a+b+c必大于0
            if (a > 0) {
                break;
            }
            int high = nums.length - 1;
            for (int j = i + 1; j < nums.length - 1; j++) {
                // 不与上一个数相同
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int b = nums[j];
                int need = 0 - a - b;
                int c_index = binarySearch(nums, j + 1, high, need);
                if (c_index == -1) {
                    continue;
                } else {
                    List<Integer> temp = new LinkedList<Integer>() {{
                        add(a);
                        add(b);
                        add(nums[c_index]);
                    }};
                    res.add(temp);
                    high = c_index - 1;
                }
            }
        }
        return res;
    }

    private int binarySearch(int[] nums, int low, int high, int value) {
        if (value < nums[low] || value > nums[high]) {
            return -1;
        }
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == value) {
                return mid;
            } else if (nums[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    @Test
    public void test() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums);
        System.out.println(res);

        int[] nums2 = new int[]{};
        List<List<Integer>> res2 = threeSum(nums2);
        System.out.println(res2);

        int[] nums3 = new int[]{0};
        List<List<Integer>> res3 = threeSum(nums3);
        System.out.println(res3);
    }
}
