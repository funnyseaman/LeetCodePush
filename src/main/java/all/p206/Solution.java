package all.p206;

import bean.ListNode;
import org.junit.Test;

public class Solution {
    // 迭代
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    @Test
    public void test() {
        ListNode head = ListNode.createFromArrays(new int[]{1, 2, 3, 4, 5});
        head = reverseList(head);
        System.out.println(head);
    }
}
