package dsalgo;
import java.util.ArrayList;
/*
 * https://practice.geeksforgeeks.org/problems/inversion-of-array/0/
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


class InversionArray {
	static int count =0;
	public static void main(String[] args){
		int[] arr={2,4,1,3,5};
		inversionArr(arr);
	}
	
    public static void inversionArr(int[] arr) {
       mergeSort(arr,0,arr.length-1);
       System.out.println(count);
     
       
    }
    private static void mergeSort(int[] arr, int low, int high){
    	if(low<high){
    		System.out.println(low+" *** "+high);
    		int mid=(low+high)/2;
    		mergeSort(arr,low,mid);
    		mergeSort(arr,mid+1,high);
    		merge(arr,low,mid,high);
    	}
    }
    private static void merge(int[] arr, int low,int mid, int high){
    	int i=low,j=mid+1;
    	System.out.println("low ,mid ,high ="+low+" "+mid+" "+high);
    	while(i<=mid && j<=high){
    		if(arr[i]>arr[j]){
    			System.out.println(arr[i]+" "+arr[j]);
    			count++;
    			j++;
    		}else{
    			i++;
    		}
    	}
    	if(i<mid)
    		count++;
    }
}
