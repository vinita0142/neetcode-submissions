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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        

        ListNode head=null;

        if(list1==null) return list2;
        else if(list2==null) return list1;


        ListNode x=list1;
        ListNode y=list2;

        if(list1.val<=list2.val){
            head=list1;
            x=x.next;
        }
        else{
            head=list2;
            y=y.next;
        }

        ListNode ans=head;
        while(x!=null && y!=null){
            if(x.val<y.val){
                head.next=x;
                x=x.next;
            }
            else{
                head.next=y;
                y=y.next;
            }
            head=head.next;
        }

        while(x!=null){
            head.next=x;
            x=x.next;
            head=head.next;
        }

        while(y!=null){
            head.next=y;
            y=y.next;
            head=head.next;
        }
        return ans;


    }
}