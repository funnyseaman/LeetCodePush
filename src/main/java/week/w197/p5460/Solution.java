package week.w197.p5460;

import java.util.HashMap;

public class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int pairCount = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            int curr = nums[i];
            if (map.containsKey(curr)) {
                int value = map.get(curr);
                pairCount += value;
                map.put(curr, value + 1);
            } else {
                map.put(curr, 1);
            }
        }

        return pairCount;
    }


    public static void main(String[] args) {
        Solution so = new Solution();
        int[] nums = {1, 1, 1, 1};
        int pairCount = so.numIdenticalPairs(nums);
        System.out.println(pairCount);
    }
}
