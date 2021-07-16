package all.p3;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int p = 0;
        int q = 0;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        while (q < chars.length) {
            if (set.add(chars[q])) {
                // 返回true表示不重复，此时需要：q右移一位；
                q++;
            } else {
                // 返回false表示重复，此时需要：记录当前子串长度；将chars[p]从set中删除；p右移一位；
                maxLen = Math.max(maxLen, q - p);
                set.remove(chars[p]);
                p++;
            }
        }
        maxLen = Math.max(maxLen, q - p);
        return maxLen;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
