/**

pair sum of two array elements that is closest to a target.

start from 0-n-1 position and increment i if sum<target, else decrement j
**/


package dsalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClosestSum {
	public static void main(String[] args){
		int[] a={4,7,9,2};
		int[] b={3,5,8,9};
		closestTarget(a,b,4);
		
		
	}
	
	public static void closestTarget(int[] arr1, int[] arr2, int target){
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int minDiff=Integer.MAX_VALUE;
		int closest=Integer.MAX_VALUE;
		for(int i=0;i<arr1.length;){
			int diff = Integer.MAX_VALUE;
			boolean found = false;
			for(int j=arr2.length-1;j>=0;){
				System.out.println(" i j "+i+" "+j);
				diff=target-arr1[i]-arr2[j];
				int absDiff=Math.abs(diff);
				if(absDiff<minDiff){
					minDiff=absDiff;
					closest=arr1[i]+arr2[j];
				}
				
				if(diff==0 || i==arr1.length || j==0){
					System.out.println(" found :"+i+" "+j);
					found=true;
					break;
				}else if(diff>0 && i<arr1.length-1){
					i++;
				}else if(j>0){
					j--;
				}
				
			}
			if(i==arr1.length-1 || diff==0 || found){
				break;
			}
		}
		System.out.println("closest :"+closest);
		
		
	}
	
	
	
}
