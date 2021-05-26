package dsalgo;
/*
https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately/0/

*/
import java.util.Arrays;

/**
 * 
 * @author debstutidas
 *
 */
class MaxMinArray {
	public static void main(String[] args){
		int[] arr={2,3,4,5,6}; //sorted array
		maxMinArr(arr);
		for(int num: arr){
			System.out.print(num+" ");
		}
	}
	private static void maxMinArr(int[] arr){
		int count=0; // keep a count of swap, n-1 swap required
		int index=0;
		while(count<arr.length-1){
			int correctPos= -1;
			if(index%2==0){
			    correctPos= arr.length-1-index/2;
			
			}else{
			    correctPos = (index-1)/2;
				
			}
			//swap
			int tmp=arr[correctPos];
			arr[correctPos]=arr[index];
			arr[index]=tmp;
			
			
			//change index to its correct pos, and start from there
			index= correctPos;
			count++;
		}
		
	}
	
	
}
