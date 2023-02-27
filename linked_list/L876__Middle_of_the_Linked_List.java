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
    public ListNode middleNode(ListNode head) {
        int counter = 0;
        ListNode middle = head;

        while (head != null) {
            head = head.next;
            counter++;
        }
        counter = counter / 2;
        for (; counter > 0; counter--) {
            middle = middle.next;
        }

        return middle;

    }
}
