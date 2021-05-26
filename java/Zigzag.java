/**
      print array in zigzag order

**/


/**
 * 
 * @author debstutidas
 *
 */
class Zigzag {
	public static void main(String[] args){
		int[] arr={1,3,8,9,15,28};
		int[] zigzagArr= zigzag(arr);
		for(int num: zigzagArr){
			System.out.print(num+" ");
		}
	}
	private static int[] zigzag(int[] arr){
		int flag=0;
		int i=0;
		while(i<arr.length-1){
			if(flag==0){
				if(arr[i]>arr[i+1]){
					int tmp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=tmp;
				}
				flag=1;
			}else if(flag==1){
				if(arr[i]<arr[i+1]){
					int tmp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=tmp;
				}
				flag =0;
			}
			i++;
		}
		return arr;
		
	}
	
	
}
