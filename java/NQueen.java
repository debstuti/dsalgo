package dsalgo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueen {
	public static void main(String[] args){
		int n=8;
		List<Integer> columns=new ArrayList<Integer>();
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		placeQueen(0,n,columns,result);
		System.out.println(result.size());	
		
		
	}
	private static void placeQueen(int row, int n ,List<Integer> columns,List<List<Integer>> result){
		if(row==n){
			result.add(new ArrayList<Integer>(columns));
			return;
		}
		
		for(int c=0;c<n;c++){
			
			if(isValid(row, c, columns)){
				columns.add(c);
				placeQueen(row+1,n,columns,result);
				columns.remove(columns.size()-1);
			}		
				
				
		
		}
	}
	
	private static boolean isValid(int row, int col, List<Integer> columns){
		
		for(int r=0;r<columns.size();r++){
			int c=columns.get(r);
			if(c+r==row+col)
				return false;
			if(c-r==col-row)
				return false;
			if(c==col)
				return false;
		}
		return true;
	}
	

}
