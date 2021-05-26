package dsalgo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class LongestIncreasingSubSeqNlogn {
    /**
     * 
     * @param args
     */
	public static void main(String[]args){
		int[] arr={-1,3,4,2,5,-2,6};
		
		int[] T=new int[arr.length];
		int[] pos=new int[arr.length];
		
		int len=0;
		T[0]=0;
		pos[0]=-1;
		
		
		for(int i=1;i<arr.length;i++){
			if(arr[T[len]]<=arr[i]){
				pos[i]=T[len];
				T[++len]=i;
				
				
			}else{
				if(arr[i]>arr[T[0]]){
					int newPosition = binSearch(T,arr,0,len,arr[i]);
					//System.out.println(len+" "+arr[i]);
					pos[i]=T[newPosition-1];
					T[newPosition]=i;
					
				}
			}
		}
		System.out.println(" printing T");
		
		for(int i=0;i<arr.length;i++){
			System.out.print(T[i]+" ");
		}
		
		System.out.println("\n printing pos");
		int end=-1;
		for(int i=0;i<arr.length;i++){
			if(pos[i]==len)
				end=i;
			System.out.print(pos[i]+" ");
		}
		System.out.println(" \nprinting longest non -decreasing subsequence in reverse order");
		while(end !=-1){
			System.out.print(arr[end]+" ** ");
			end=pos[end];
		}
		System.out.println();
		System.out.println("length of subsequence "+len+1);
		
	}
	
	private static int binSearch(int[] T, int[] arr, int low, int high, int elem){
		if(low>=high){
			return low;
		}
		if(low<high){
			int mid=(low+high)/2;
			if(arr[T[mid]]==elem){
				return mid;
			}
			if(elem<=arr[mid]){
				return binSearch(T,arr,low,mid,elem);
			}else{
				return binSearch(T,arr,mid+1,high,elem);
			}
		}
		return -1;
	}
	
	
}
