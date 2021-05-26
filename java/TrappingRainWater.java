package dsalgo;
/*
https://practice.geeksforgeeks.org/problems/trapping-rain-water/0

*/

/**
 * 
 * @author debstutidas
 *
 */
class TrappingRainWater {
	public static void main(String[] args){
		int[] arr={6,9,9};
		int ans = rainWater(arr);
		System.out.println(ans);
	}
	private static int rainWater(int[] arr){
		int[] left=new int[arr.length];
		int[] right= new int[arr.length];
		
		int max=-1;
		for(int i=0;i<arr.length;i++){
			if(arr[i]>max)
				max=arr[i];
			left[i]=max;
			System.out.print(left[i]+" ");
		}
		System.out.println();
		max=-1;
		for(int i=arr.length-1;i>=0;i--){
			if(arr[i]>max)
				max=arr[i];
			right[i]=max;
			System.out.print(right[i]+" ");
		}
		System.out.println();
		
		int total=0;
		for(int i=0;i<arr.length;i++){
			total+=Math.min(left[i], right[i])-arr[i];
		}
		return total;
		
	}
	
	
}
