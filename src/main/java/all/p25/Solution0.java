package all.p25;

import bean.ListNode;
import org.junit.Test;

public class Solution0 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = new ListNode();
        root.next = head;
        ListNode prev = root;
        while (head != null) {
            ListNode tail = prev;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return root.next;
                }
                // 不满k个也进行反转
//                if (tail.next == null && i < k - 1) {
//                    break;
//                }
            }
            ListNode temp = tail.next;
            // [head,tail]
            ListNode[] res = reverse(head, tail);
            head = res[0];
            tail = res[1];
            prev.next = head;
            tail.next = temp;
            prev = tail;
            head = temp;
        }
        return root.next;
    }


    public ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode curr = head;
        while (prev != tail) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return new ListNode[]{tail, head};
    }


    @Test
    public void test() {
        ListNode head1 = ListNode.createFromArrays(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(reverseKGroup(head1, 4));
    }
}
