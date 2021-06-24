package all.p15;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 双指针法
public class Solution2 {
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
            int target = -a;
            // 第一个数大于0，那么a+b+c必大于0
            if (a > 0) {
                break;
            }
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int b = nums[left];
                int c = nums[right];
                if (b + c == target) {
                    res.add(new LinkedList<Integer>() {{
                        add(a);
                        add(b);
                        add(c);
                    }});
                    left++;
                    right--;
                    // 不与上一个数相同
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    // 不与上一个数相同
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (b + c < target) {
                    left++;
                } else if (b + c > target) {
                    right--;
                }
            }
        }
        return res;
    }


    @Test
    public void test() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums);
        System.out.println(res);

        int[] nums2 = new int[]{-2, 0, 0, 2, 2};
        List<List<Integer>> res2 = threeSum(nums2);
        System.out.println(res2);

    }
}
