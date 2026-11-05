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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1){
            return head;
        }

        ListNode left=head;

        ListNode newHead=null;
        ListNode prevGroupTail=null;



        while(left!=null){
            ListNode curr=left;
            int count=1;

            while(count<k && curr!=null){
                curr=curr.next;
                count++;
            }

            if(curr==null){
                if(prevGroupTail!=null){
                    prevGroupTail.next=left;
                }
                break;
            }

            ListNode nextGroupStart=curr.next;

            ListNode prev=null;
            ListNode movingCurr=left;

            while(movingCurr!=nextGroupStart){
                ListNode next=movingCurr.next;
                movingCurr.next=prev;
                prev=movingCurr;
                movingCurr=next;
            }

            if(newHead==null){
                newHead=prev;
            }
            else{
                prevGroupTail.next=prev;
            }

            prevGroupTail=left;
            left=nextGroupStart;
        }
        return newHead;
    }
}
