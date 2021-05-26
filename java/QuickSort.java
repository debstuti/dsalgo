package dsalgo;

import java.util.HashSet;

import java.util.Set;
/**
 * Complexity : 
 * 	Best Case: when pivot is placed in middle every time after partition,
 * 				Each partition takes almost O(n) - total n elements we have to traverse combining both left & right subpart
 * 				recursive call happens logn time (height of the tree formed)
 * 				tree is balanced
 * 				Total : O(nlogn)
 * Worst case: when array is sorted already, hence pivot is placed in the low or high(depending on our choice)
 * 			  The tree formed will be skewed and will have height almost n
 * 				Hence Total complexity : O(n2)
 * Average Case: O(n2)
 * 
 * 
 * @author debstutidas
 *
 */
class Solution {
	public static void main(String[] args){
		int[] arr= {10,6,15,4,9,5,1,7,2,3,8};
		quickSort(arr,0, arr.length-1);
	}
	public static void quickSort(int[] arr, int low, int high){
		if(low<high){
			int pivotPosition=partition(arr,low,high);
			for(int num: arr){
				System.out.print(num+" ");
			}
			System.out.println();
			quickSort(arr,low,pivotPosition-1);
			quickSort(arr, pivotPosition+1, high);
		}
		
		
		
	}
	
	public static int partition(int[] arr, int low, int high){
		
		
		
		int pivot=arr[low];
		int pivotPosition = low;
		
		int left=low;
		int right=high;
		
		
		while(left<right){
			while(left<high && arr[left]<=pivot)
				left++;
			while(right>0 && arr[right]>pivot)
				right--;
			if(left<right){
				int tmp=arr[left];
				arr[left]=arr[right];
				arr[right]=tmp;
			}
			
			
		}
		arr[low]=arr[right];
		arr[right]=pivot;
		return right;
	}
}
