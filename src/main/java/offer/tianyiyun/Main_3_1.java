package offer.tianyiyun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            return;
        }
        List<Integer> l0 = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> lx = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int cur = sc.nextInt();
            if (cur == 0) {
                l0.add(cur);
            } else if (cur == 1) {
                l1.add(cur);
            } else if (cur == 2) {
                l2.add(cur);
            } else {
                lx.add(cur);
            }
        }
        l0.addAll(l1);
        l0.addAll(l2);
        l0.addAll(lx);
        int[] nums = l0.stream().mapToInt(Integer::valueOf).toArray();
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
