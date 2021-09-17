package offer.zhaoshang;

import java.util.Scanner;

public class Main1 {
    public static void calc(String s) {
        String[] splits = s.split(" ");
        int[] nums = new int[]{Integer.parseInt(splits[0]), Integer.parseInt(splits[2]), Integer.parseInt(splits[4])};
        String[] opts = new String[]{splits[1], splits[3]};
        int firstRes = calcRes(calcRes(nums[0], nums[1], opts[0]), nums[2], opts[1]);
        int secondRes = calcRes(nums[0], calcRes(nums[1], nums[2], opts[1]), opts[0]);
        if (firstRes < secondRes) {
            System.out.println(firstRes);
            System.out.println(secondRes);
        } else {
            System.out.println(secondRes);
            System.out.println(firstRes);
        }
    }

    public static int calcRes(int a, int b, String opt) {
        int res = 0;
        switch (opt) {
            case "+":
                res = a + b;
                break;
            case "-":
                res = a - b;
                break;
            case "*":
                res = a * b;
                break;
            case "/":
                res = a / b;
                break;
            default:
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        calc(line);
    }
}
