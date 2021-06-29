package all.p23;

import bean.ListNode;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode root = new ListNode();
        ListNode curr = root;

        // 维护一个优先队列
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });
        pq.addAll(Arrays.stream(lists).filter(listNode -> listNode != null).collect(Collectors.toList()));

        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            if (temp != null) {
                if (temp.next != null) {
                    pq.add(temp.next);
                }
                curr.next = temp;
                curr = curr.next;
            }
        }
        return root.next;
    }


    @Test
    public void test() {
        ListNode a3 = new ListNode(5);
        ListNode a2 = new ListNode(4, a3);
        ListNode a1 = new ListNode(1, a2);

        ListNode b3 = new ListNode(4);
        ListNode b2 = new ListNode(3, b3);
        ListNode b1 = new ListNode(1, b2);

        ListNode c2 = new ListNode(6);
        ListNode c1 = new ListNode(2, c2);

        ListNode[] lists = new ListNode[]{a1, b1, c1};

//        System.out.println(mergeKLists(lists).toString());

        System.out.println(mergeKLists(new ListNode[]{null}));
    }
}
