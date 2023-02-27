/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current_node = result;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val){
                current_node.next = l1;
                l1 = l1.next;
                System.out.print(current_node.val);
            }
            else {
                current_node.next = l2;
                l2 = l2.next;
                System.out.print(current_node.val);
            }
            current_node = current_node.next;
        }

        if (l1 != null) current_node.next = l1;
        else if (l2 != null) current_node.next = l2;


        return result.next;
    }
}
