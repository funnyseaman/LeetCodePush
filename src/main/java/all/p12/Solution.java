package all.p12;

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


public class Solution {
    public String intToRoman(int num) {
        String[] romanNum = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] decNum = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        StringBuilder sb = new StringBuilder();
        for (int i = 12; i >= 0; i--) {
            int count = num / decNum[i];
            addString(sb, romanNum[i], count);
            num %= decNum[i];
        }
        return sb.toString();
    }

    public void addString(StringBuilder sb, String add, int count) {
        while (count > 0) {
            sb.append(add);
            count--;
        }
    }


    @Test
    public void test() {
        System.out.println(intToRoman(1));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(1994));
        System.out.println(intToRoman(3999));
    }
}
