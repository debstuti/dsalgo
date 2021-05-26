package dsalgo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class StringPermutation {
    /**
     * 
     * @param args
     */
	
	
	public static void main(String[]args){
		String string="abca";
		
		
		Map<Character, Integer> map = calcCount(string);
		
		System.out.println(map);
		
		Object[] str=map.keySet().toArray();
		Object[] count=map.values().toArray();
		
		int[] countArr=new int[count.length];
		
		for(int i=0;i<count.length;i++){
			countArr[i]=(Integer)count[i];
		}
		
		char[] result=new char[string.length()];
		
		int length=0;
		permute(str, countArr, result,length);
	}
	
	private static Map<Character, Integer> calcCount(String string){
		Map<Character, Integer> map=new LinkedHashMap<Character, Integer>();
		
		
		int j=0;
		for(int i=0;i<string.length();){
			char ch=string.charAt(i);
			if(map.containsKey(ch)){
				i++;
				int count=map.get(ch);
				map.put(ch, count+1);
				
			}else{
				int count=0;
				while(i<string.length() && string.charAt(i)==ch){
					count++;
					i++;
				}
				
				map.put(ch, count);
			}
			
		}
		return map;
	}
	private static void permute(Object[] str, int[] count, char[] result, int length ){
		if(length==result.length){
			System.out.println(result);
		}
		for(int i=0;i<str.length;i++){
			if(count[i]>0){
				count[i]--;
				result[length++]=(Character)str[i];
				permute(str,count,result,length);
				count[i]++;
				length--;
			}
		}
	}
	
}
