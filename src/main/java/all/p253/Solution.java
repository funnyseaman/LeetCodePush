package all.p253;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int maxCount = 1;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>() {{
            add(-1);
        }};
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] < queue.peek()) {
                if (queue.size() >= maxCount) {
                    maxCount++;
                }
            } else {
                queue.poll();
            }
            queue.add(intervals[i][1]);
        }
        return maxCount;
    }


    @Test
    public void test() {
        int res1 = minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}});
        int res2 = minMeetingRooms(new int[][]{{7, 10}, {2, 4}});
        System.out.println(res2);

    }
}
