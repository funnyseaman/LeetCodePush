package offer.shopee;

import org.junit.Test;

import java.util.Scanner;

public class Main2 {
    private static final String[] hex = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 转换为十六进制字符串
        String str = getHex(n);
        // 验证回文
        int i = 0;
        int j = str.length() - 1;
        char[] chars = str.toCharArray();
        while (i < j) {
            if (chars[i] != chars[j]) {
                System.out.println(0);
                return;
            }
            i++;
            j--;
        }
        System.out.println(1);
    }

    public static String getHex(int n) {
        if (n == 0) {
            return "";
        }
        return getHex(n / 16) + hex[n % 16];
    }


    @Test
    public void test() {
        System.out.println(getHex(417));
    }
}
