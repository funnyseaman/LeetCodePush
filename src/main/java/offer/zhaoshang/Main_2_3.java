package offer.zhaoshang;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Main_2_3 {
    public static int calc(int[] opts) {
        int total = 0;
        int count = 0;
        Set<String> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (int opt : opts) {
            if (opt != -1) {
                stack.push(opt);
                count++;
            } else {
                if (stack.isEmpty()) {
                    continue;
                }
                stack.pop();
                if (set.add(stack.toString())) {
                    total += count;
                }
                count = 0;
            }
        }
        return total + count;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        int[] opts = new int[n];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
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