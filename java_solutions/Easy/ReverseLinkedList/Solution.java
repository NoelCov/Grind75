class Solution {
    // Time Complexity O(n)
    // Space Complexity O(1)
    public ListNode reverseList(ListNode head) {
        ListNode slow = null;
        ListNode fast = head;

        while (fast != null) {
            ListNode next = fast.next;

            fast.next = slow;
            slow = fast;
            fast = next;
        }

        return slow;
    }
}
