package dsalgo;

import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * @author debstutidas
 *
 */

class Node{
	int val;
	Node next;
	Node(int val){
		this.val=val;
	}
}
class MakeRowColZero {
	public static void main(String[] args){
		int[][] matrix={{1,2,3,0},{3,0,5,7},{2,8,8,4},{3,6,2,9}};
		int[][] ans= makeRowColZero(matrix);
		for(int i=0;i<ans.length;i++){
			for(int j=0;j<ans[0].length;j++){
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	public static int[][] makeRowColZero(int[][] matrix){
		int rowOrCol =-1; // 0 for row, 1 for col, 2 for both , need to decide about 0th row /column
		for(int i=0;i<matrix[0].length;i++){
			if(matrix[0][i]==0){
				rowOrCol=0; // for row
			}
		}
		for(int j=0;j<matrix.length;j++){
			if(matrix[j][0]==0){
				if(rowOrCol == 0)
					rowOrCol=2; // both 0th row and col needs to 0
				else
					rowOrCol=1; // for col
			}
		}
		
		for(int i=1;i<matrix.length;i++){
			for(int j=1;j<matrix[0].length;j++){
				if(matrix[i][j]==0){
					matrix[i][0]=0;
					matrix[0][j]=0;
				}
			}
		}
		
		for(int i=1;i<matrix.length;i++){
			if(matrix[i][0]==0){
				for(int j=0;j<matrix[0].length;j++){
					matrix[i][j]=0;
				}
			}
		}
		for(int j=1;j<matrix[0].length;j++){
			if(matrix[0][j]==0){
				for(int i=0;i<matrix.length;i++){
					//System.out.println("i,j = "+i+" "+j);
					matrix[i][j]=0;
				}
			}
		}
		if(rowOrCol==0 || rowOrCol ==2){
			for(int i=0;i<matrix[0].length;i++){
				matrix[0][i]=0;
			}
		}else if(rowOrCol==1 || rowOrCol==2){
			for(int j=0;j<matrix.length;j++){
				matrix[j][0]=0;
			}
		}
		
		return matrix;
	}
	
}
