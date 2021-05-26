/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class SwapListInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next ==null)
            return head;
       ListNode tmp=head;
        ListNode ans=head.next;
        while(tmp!=null && tmp.next !=null){
            ListNode nxt=tmp.next;
            ListNode nxtnxt=nxt.next;
            nxt.next=tmp;
            if(nxtnxt != null && nxtnxt.next !=null)
                tmp.next=nxtnxt.next;
            else
                tmp.next=nxtnxt;
            tmp=nxtnxt;
        }
        return ans;
    }
}
