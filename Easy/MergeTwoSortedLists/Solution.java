class Solution {
    // Time Complexity O(n) where n is the length of the shorterst list.
    // Space Complexity O(1)
    public ListNode mergeToLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;
        }

        if (list1 != null) {
            curr.next = list1;
        } else if (list2 != null) {
            curr.next = list2;
        }

        return dummy.next;
    }
}