package dsalgo;

import java.util.Arrays;

/**
 * 
 * @author debstutidas
 *
 */
class PythagorianTriplet {
	public static void main(String[] args){
		int[] arr={3,2,6,5,4};
		boolean ans = pythagoreanTriplet(arr);
		System.out.println(ans);
	}
	private static boolean pythagoreanTriplet(int[] arr){
		
		for(int i=0;i<arr.length;i++){
			arr[i]=arr[i]*arr[i];
		}
		Arrays.sort(arr);
		for(int i=arr.length-1;i>=2;i--){
			int c=arr[i];
			
			for(int j=0, k=i-1;j<k;){
				if(arr[j]+arr[k]==c){
					return true;
				}else if(arr[j]+arr[k]<c){
					j++;
				}else{
					k--;
				}
			}
		}
		return false;
		
	}
	
	
}
