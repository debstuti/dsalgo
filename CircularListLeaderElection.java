package dsalgo;
/*
There are n students. we are deleting every kth student. Whoever remains last will be the leader.

*/
import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * @author debstutidas
 *
 */

class Node{
	int val;
	Node next;
	Node(int val){
		this.val=val;
	}
}
class CircularListLeaderElection {
	public static void main(String[] args){
		int n=100, k=2;
		circRemove(n,k);
		
	}
	private static void circRemove(int n, int k){
		Node head=null;
		Node tmp=null;
		for(int i=0;i<n;i++){
			if(i==0){
				head=new Node(i+1);
				tmp=head;
			}else{
				tmp.next=new Node(i+1);
				tmp=tmp.next;
			}
		}
		
		tmp.next=head;
		
		/*tmp=head;
		do{
			System.out.print(tmp.val+" ");
			tmp=tmp.next;
		}while(tmp!=head);
		System.out.println();*/
		
		Node prev=null;
		do{
			for(int i=0;i<k-1;i++){
				prev=tmp;
				tmp=tmp.next;
			}
			prev.next=tmp.next;
			
			
		}while(tmp.next!=tmp);
		
		
		
		
		System.out.println(tmp.val+ " "+tmp.next.val);
	}
	
	
}
