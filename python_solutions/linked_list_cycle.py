# Time Complexity O(n)
# Space Complexity O(1)
class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        slow, fast = head, head
        while fast != None and fast.next != None:
            slow = slow.next
            fast = fast.next.next

            if fast == slow:
                return True
        return False