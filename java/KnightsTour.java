package dsalgo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*

Need to correct

*/

public class KnightsTour {
    /**
     * 
     * @param args
     */
	static int[] pathRow={2,2,-2,-2,1,1,-1,-1};
	static int[] pathCol={1,-1,1,-1,2,-2,-2,2};
	
	public static void main(String[]args){
		int[][] visited=new int[4][4];
		visited[0][0]=1;
		
		//boolean found = knightMove(visited,0,2,1);
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				visited[i][j]=1;
				boolean found = knightMove(visited,i,j,1);
				System.out.print(found);
				visited[i][j]=0;
			}
			System.out.println();
		}
		
	}
	private static boolean knightMove(int[][] visited, int row, int col, int move){
		
		//System.out.println(row+" "+col+" move :"+move);
		if(move==16){
			for(int i=0;i<4;i++){
				for(int j=0;j<4;j++){
					System.out.print(visited[i][j]+" ");
				}
				System.out.println();
			}
			return true;
		}else{
			for(int i=0;i<8;i++){
				int newRow=pathRow[i]+row;
				int newCol=pathCol[i]+col;
				
				if(isValidMove(visited,newRow,newCol)){
					//System.out.println("valid move :"+newRow+" "+newCol);
					
					
					move++;
					visited[newRow][newCol]=move;
					if(knightMove(visited, newRow,newCol,move)){
						return true;
					}
					
					move--;
					visited[newRow][newCol]=0;
					
				}
			}
		}
		return false;
	}
	private static boolean isValidMove(int[][] visited, int row, int col){
		if(row>=0 && row<visited.length && col>=0 && col<visited.length && visited[row][col] ==0)
			return true;
		
		return false;
	}
	
}
