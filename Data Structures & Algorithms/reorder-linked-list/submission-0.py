# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        res=head
        slow=head
        fast=head

        while fast is not None and fast.next is not None:
            slow=slow.next
            fast=fast.next.next
        
        curr=slow.next
        slow.next=None

        prev=None

        while curr is not None:
            temp=curr.next
            curr.next=prev
            prev=curr
            curr=temp

        l2=prev
        l1=head

        while l2 is not None:
            temp1=l1.next
            temp2=l2.next
            l1.next=l2
            l2.next=temp1
            l1=temp1
            l2=temp2

        

