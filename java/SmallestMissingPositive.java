package dsalgo;
/*
 * https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/
 */
import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * @author debstutidas
 *
 */


class SmallestMissingPositive {
	public static void main(String[] args){
		int[] arr={ 2, 3, -7, 6, 8, 1, -10, 15 ,4};
		int j=0;
		for(int i=0;i<arr.length;i++){ // segregate the positive numbers only
			if(arr[i]>0){
				arr[j++]=arr[i];
				
			}
		}
		int length=j; // new length with only positive numbers
		for(int i=0;i<length;i++){
			int abs=Math.abs(arr[i]);
			if(abs<length && arr[abs-1]>0){ // if positive number found , mark the value at that index negative
				arr[abs-1]=arr[abs-1]*-1;
			}
		}
		for(int i=0;i<length;i++){
			if(arr[i]>0){ // positive number found , return
				System.out.println("ans ="+(i+1));
				break;
			}
		}
		
	}
	
	
}
