package all.p25;

import bean.ListNode;
import org.junit.Test;

public class Solution {
    /*
        每次K个节点翻转的步骤：
        1）记录起始节点startNode和起始节点前一个节点prevNode，向后数k个节点记为endNode
        2）翻转[startNode,endNode]
        3）将反转后的链表连入原链表中，并更新指针
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;

        ListNode root = new ListNode();
        ListNode prevNode = root;
        ListNode startNode = curr;
        ListNode endNode = findEndNode(curr, k);
        while (endNode != null) {
            while (prev != endNode) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            startNode.next = curr;
            prevNode.next = endNode;
            // refresh pointers
            prevNode = startNode;
            prev = prevNode;
            startNode = curr;
            endNode = findEndNode(curr, k);
        }
        return root.next;
    }

    // [1,2,3,4],k=3 -> [3]
    private ListNode findEndNode(ListNode node, int k) {
        ListNode endNode = node;
        k--;
        while (k > 0) {
            if (endNode != null) {
                endNode = endNode.next;
                k--;
            } else {
                return null;
            }
        }
        return endNode;
    }


    @Test
    public void test() {
        ListNode head1 = ListNode.createFromArrays(new int[]{1, 2, 3, 4, 5});
        System.out.println(reverseKGroup(head1, 6));
    }
}
