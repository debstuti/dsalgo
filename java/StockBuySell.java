package dsalgo;
import java.util.ArrayList;
/*
 * https://practice.geeksforgeeks.org/problems/stock-buy-and-sell/0
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author debstutidas
 *
 */
class ListNode{
	int val;
	ListNode next;
	ListNode(int val){
		this.val=val;
	}
}

class StockBuySell {
	public static void main(String[] args){
		int[] arr={11,23 ,13 ,25, 29 ,33 ,19 ,34 ,45 ,65, 67,45};
		stockBuySell(arr);
	}
	
    public static void stockBuySell(int[] arr) {
       
       int min=0,max=0;
       int profit=0;
       for(int i=0;i<arr.length;i++){
    	   if(arr[i]<arr[max]){
    		   if(min != max){
    		   profit+=arr[max]-arr[min];
    		   System.out.println(min+" "+max);
    		   }
    		   min=i;
    		  
    	   }else{
    		   max=i;
    		   if(i==arr.length-1){
    			   profit+=arr[max]-arr[min];
    			   System.out.println(min+" "+max);
    		   }
    	   }
       }
       
    }
}
