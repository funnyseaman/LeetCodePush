package all.p206;

import bean.ListNode;
import org.junit.Test;

public class Solution2 {
    // 递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode root = reverseList(head.next);
        head.next.next = head;      // head.next.next=head即将head后一个节点指向head自身；这里不能用root.next=head，因为root指向原链表的尾节点
        head.next = null;
        return root;
    }

    @Test
    public void test() {
        ListNode head = ListNode.createFromArrays(new int[]{1, 2, 3, 4, 5});
        head = reverseList(head);
        System.out.println(head);
    }
}
