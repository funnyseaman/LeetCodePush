package all.p13;

/*
    I 1     IV 4
    V 5     IX 9
    X 10    XL 40
    L 50    XC 90
    C 100   CD 400
    D 500   CM 900
    M 1000
*/

import org.junit.Test;

import java.util.HashMap;

public class Solution {
    HashMap<Character, Integer> map = new HashMap<Character, Integer>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public int romanToInt(String s) {
        int totalNum = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length - 1; i++) {
            int curNum = map.get(c[i]);
            int nextNum = map.get(c[i + 1]);
            if (curNum < nextNum) {
                totalNum -= curNum;
            } else {
                totalNum += curNum;
            }
        }
        totalNum += map.get(c[c.length - 1]);

        return totalNum;
    }


    @Test
    public void test() {
        System.out.println(romanToInt("I"));            // 1
        System.out.println(romanToInt("IV"));           // 4
        System.out.println(romanToInt("MCMXCIV"));      // 1994
        System.out.println(romanToInt("MMMCMXCIX"));    // 3999
    }
}
