package dsalgo;

import java.util.HashSet;

import java.util.Set;

class QuickSort {
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
