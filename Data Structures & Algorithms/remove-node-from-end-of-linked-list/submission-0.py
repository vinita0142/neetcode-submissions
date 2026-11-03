# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy=ListNode(0)
        dummy.next=head

        right=head

        for i in range(n):
            right=right.next

        left=dummy
        while right is not None:
            left=left.next
            right=right.next
        
        nodeToRemove=left.next

        if nodeToRemove.next is not None:
            left.next=left.next.next
        else:
            left.next=None
            
        return dummy.next