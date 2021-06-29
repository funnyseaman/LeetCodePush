package all.p168;

import org.junit.Test;

public class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            // 如果不减1，1%26=1，(char)('A'+1)='B'；26%26=0，(char)('A'+0)='A'
            // 减去1之后，(1-1)%26=0，(char)('A'+0)='A'；(26-1)%26=25，(char)('A'+25)='Z'
            columnNumber--;
            sb.append((char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(26));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(701));
    }
}
