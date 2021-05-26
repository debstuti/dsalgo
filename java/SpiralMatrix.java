package dsalgo;


/**
 * 
 * @author debstutidas
 *
 */
class SpiralMatrix {
	public static void main(String[] args){
		int[][] arr={{1,2,3,4},
						{5,6,7,8},
						{9,10,11,12},
						{13,14,15,16}};
		spiral(arr);
	}
	private static void spiral(int[][] arr){
		int m=arr.length;
		int n=arr[0].length;
		
		int minRow=0,maxRow=m-1,minCol=0,maxCol=n-1;
		
		while(minRow<maxRow && minCol<maxCol){
			
			for(int i=minCol;i<=maxCol;i++){
				System.out.print(arr[minRow][i]+" ");
			}
			
			minRow++;
			
			for(int i=minRow;i<=maxRow;i++){
				System.out.print(arr[i][maxCol]+" ");
			}
			maxCol--;
			
			for(int i=maxCol;i>=minCol;i--){
				System.out.print(arr[maxRow][i]+" ");
			}
			maxRow--;
			
			for(int i=maxRow;i>=minRow;i--){
				System.out.print(arr[i][minCol]+" ");
			}
			minCol++;
			
		}
		
		
		
		
		
	}
	
	
}
