package jianzhi.p13;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int movingCount(int m, int n, int k) {
        if (m == 0 && n == 0) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        int[] dx = new int[]{0, 1};
        int[] dy = new int[]{1, 0};

        boolean[][] vis = new boolean[m][n];
        vis[0][0] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        int count = 1;

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 2; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || vis[nx][ny] || transfer(nx) + transfer(ny) > k) {
                    continue;
                }
                vis[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
                count++;
            }
        }
        return count;
    }

    private int transfer(int num) {
        int temp = 0;
        while (num != 0) {
            temp += num % 10;
            num /= 10;
        }
        return temp;
    }


    @Test
    public void test() {
        int res = movingCount(2, 3, 17);
        System.out.println(res);
    }
}
