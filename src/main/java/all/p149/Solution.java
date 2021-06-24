package all.p149;


import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;

public class Solution {
    public int maxPoints(int[][] points) {
        int max = 0;
        for (int i = 0; i < points.length - 1; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int diffX = points[i][0] - points[j][0];
                int diffY = points[i][1] - points[j][1];
                // 横线和竖线
                if (diffX == 0) {
                    diffY = 1;
                } else if (diffY == 0) {
                    diffX = 1;
                }
                // 化简
                else {
                    if (diffX < 0) {
                        diffX *= -1;
                        diffY *= -1;
                    }
                    int gcd = gcd(Math.abs(diffX), Math.abs(diffY));
                    diffX /= gcd;
                    diffY /= gcd;
                }
                map.merge(diffX + "," + diffY, 1, Integer::sum);
            }
            max = Math.max(max, Collections.max(map.values()));
        }
        return max + 1;
    }

    // 求两个非负整数的最大公约数
    public int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }


    @Test
    public void test() {
        int[][] points1 = new int[][]{{1, 1}, {2, 2}, {3, 3}};
        System.out.println(maxPoints(points1));

        int[][] points2 = new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        System.out.println(maxPoints(points2));

    }

}
