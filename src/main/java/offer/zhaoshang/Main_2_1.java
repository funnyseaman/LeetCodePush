package offer.zhaoshang;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Main_2_1 {
    public static int calc(int[] opts) {
        Stack<Integer> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        int pre = -1;
        for (int opt : opts) {
            if (opt == -1) {
                if (!stack.isEmpty()) {
                    pre = stack.pop();
                }
            } else {
                stack.add(opt);
                if (pre == opt) {
                    pre = -1;
                } else {
                    set.add(stack.toString());
                }
            }
        }
        return set.size();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        String[] lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = sc.nextLine();
        }
        int[] opts = new int[n];
        for (int i = 0; i < n; i++) {
            String line = lines[i];
            if (line.contains("push")) {
                opts[i] = Integer.parseInt(line.trim().split(" ")[1]);
            } else {
                opts[i] = -1;
            }
        }
        int res = calc(opts);
        System.out.println(res);
    }
}
