package dsalgo;


/**
 
 * 
 * find median of two sorted array
 * divide the arrays in two parts (x1,x2) and (y1,y2) 
 * such that (x1+y1)=(x2+y2) and x1<y2 && y1<x2
 * then median = (Math.max(x1,y1)+Math.min(x2,y2))/2 -- if total length is even
 * 				Math.max(x1,y1)    -- if total length is odd
 * 
 * @author debstutidas
 *
 */
class FindMedian {
	public static void main(String[] args){
		int[] arr1={1,3,8,9,15,28};
		int[] arr2={7,11,18,19,21,25};
		int median = findMedian(arr1, arr2);
		System.out.println(median);
	}
	
	
	public static int findMedian(int[] arr1, int[] arr2){
		int totalLength=arr1.length+arr2.length;
		totalLength=(totalLength%2==0)?totalLength:totalLength+1;
		int partition = totalLength/2;
		
		
		int maxLeftX=0;
		int maxLeftY=partition-maxLeftX-2;
		int minRightX=maxLeftX+1;
		int minRightY=maxLeftY+1;
		
		while(true){
			
			if(arr1[maxLeftX]<arr2[minRightY] && arr2[maxLeftY]<arr1[minRightX]){
				break;
			}else if(arr1[maxLeftX]>arr2[minRightY]){
				maxLeftX--;
			}else{
				maxLeftX++;
			}
			maxLeftY=partition-maxLeftX-2;
			minRightX=maxLeftX+1;
			minRightY=maxLeftY+1;
			
		}
		System.out.println(maxLeftX+" "+maxLeftY+" "+minRightX+" "+minRightY);
		if((arr1.length+arr2.length)%2==1)
			return Math.max(arr1[maxLeftX], arr2[maxLeftY]);
		else
			return (Math.max(arr1[maxLeftX], arr2[maxLeftY])+Math.min(arr1[minRightX], arr2[minRightY]))/2;
		
	}
}
