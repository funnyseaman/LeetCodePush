package offer.shopee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 数字候选列表
        List<Integer> numList = new ArrayList<>();
        int temp = n;
        while (temp != 0) {
            numList.add(0, temp % 10);
            temp /= 10;
        }
        StringBuilder sb = new StringBuilder();
        boolean isSmaller = false;
        for (char c : String.valueOf(n).toCharArray()) {
            int max = -1;
            if (!isSmaller) {
                for (int i = 0; i < numList.size(); i++) {
                    if (numList.get(i) > max && numList.get(i) < ((int) c - (int) '0')) {
                        max = numList.get(i);
                        isSmaller = true;
                    }
                }
                if (max == -1) {
                    max = (int) c - (int) '0';
                }
            } else {
                for (int i = 0; i < numList.size(); i++) {
                    if (numList.get(i) > max) {
                        max = numList.get(i);
                    }
                }
            }
            sb.append(max);
            numList.remove((Object) max);
        }
        System.out.println(sb);
    }
}
