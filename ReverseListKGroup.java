/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ReverseListKGroup {
  
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ans=head;
      
        for(int i=0;i<k-1;i++){
            
            if(ans==null)
                return head;
            ans=ans.next;
        }
        if(ans==null)
            return head;
        ListNode tmp=head;
        ListNode last=null;
        
        while(tmp !=null){
            ListNode kth=kth(tmp,k);
            if(kth ==null){ // no need to reverse
                if(last==null){
                    last=tmp;
                }else{
                    last.next=tmp;
                }
                tmp=null;
                continue;
            }
            ListNode k1th=kth.next; // next slot start to reverse
            ListNode tmpNew=reverse(tmp, k);
            if(last== null)
                last=tmp;
            else{
                last.next=tmpNew;
                last=tmp;
            }
            tmp=k1th;
        }
    
        
        return ans;
        
    }
    private ListNode kth(ListNode head, int k){
        ListNode tmp=head;
        for(int i=0;i<k-1 && tmp != null;i++){
            tmp=tmp.next;
        }
        return tmp;
    }
    private ListNode reverse(ListNode head, int k){
        ListNode tmp=head;
        ListNode prev=null;
        for(int i=0;i<k && tmp !=null;i++){
          ListNode nxt=tmp.next;
            tmp.next=prev;
            prev=tmp;
            tmp=nxt;
        }
      
        return prev;
    }
}
