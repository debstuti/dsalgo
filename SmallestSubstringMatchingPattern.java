/**
 * 		String str="adobecodebanc"; 
		String pattern ="abc";
		
		Smallest substring in str which contains all chars of pattern
 */

package dsalgo;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author debstutidas
 *
 */
public class SmallestSubstringMatchingPattern {
    /**
     * 
     * @param args
     */
	public static void main(String[]args){
		String str="adobecodebanc"; 
		String pattern ="abc";
		
		int[] parr=new int[26];
		int[] sarr=new int[26];
		for(int i=0;i<pattern.length();i++){ //populate pattern array with char counts in pattern
			int pos=(int)pattern.charAt(i)-(int)'a';
			parr[pos]++;
		}
		int start=0;
		int count=0;
		int window=0;
		int minWindow=0;
		for(int i=0;i<str.length();i++){
			System.out.println(" i ="+i);
			int pos=(int)str.charAt(i)-(int)'a';
			sarr[pos]++; // increase str char entry
			if(parr[pos]==sarr[pos]) // if count matches for that char increase total char match count
				count++;
			if(count==pattern.length() && window ==0){ // match found time
				
				window=i-start+1;
				if(minWindow == 0 || window<minWindow){
					minWindow=window;
				}
				//System.out.println(start+" "+window);
			}
			if(start !=i && str.charAt(start)==str.charAt(i)){// reduce window  from left side
				start++;
				while(start<str.length() && (parr[(int)str.charAt(start)-(int)'a']==0) ){ // char not present in pattern
					
					start++;
				}
				while(start<str.length() && 
				 (sarr[(int)str.charAt(start)-(int)'a']> parr[(int)str.charAt(start)-(int)'a'])){ //char count in str is more that required in pattern
					sarr[(int)str.charAt(start)-(int)'a']--; //decrease count from str array
					start++;
				}
				window=i-start+1; // new window
				if(minWindow == 0 || window<minWindow){ //update minWindow
					minWindow=window;
				}
				//System.out.println(start+" *** "+window);
				
			}
			
			System.out.println(minWindow);
			
		}
	
		
	}
	
	private static boolean matches(int[] sarr, int[] parr){
		for(int i=0;i<26;i++){
			if(sarr[i] !=parr[i]){
				return false;
			}
				
		}
		return true;
	}
}
