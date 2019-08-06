/**
https://leetcode.com/problems/letter-tile-possibilities/

You have a set of tiles, where each tile has one letter tiles[i] printed on it.  Return the number of possible non-empty sequences of letters you can make.

(need to improve complexity)

**/


import java.util.*;
class LetterPermutation {
    static Set<String> set = new HashSet<String>();
    public static int numTilePossibilities(String tiles) {

        recurse(tiles,"");
        //System.out.println(set);
        return set.size();
    }
    public static void recurse(String sb1, String sb2){
        if(sb1==null || sb1.length()==0){

            return;
        }
        for(int i=0;i<sb1.length();i++){
            String s = new String(sb1);
            String t = new String(sb2);
            char tmp = s.charAt(i);

            String  tmps = s;
            t = t+tmp;

            s=s.substring(0,i)+s.substring(i+1,s.length());
            //System.out.println(s+" "+t);
            set.add(t);
            recurse(s, t);

            //sb1 = tmpSb1;
            t = t.substring(0,t.length()-1);

        }

    }
    public static void main(String args[]){
        System.out.println(numTilePossibilities("abd"));
        System.out.println(set);
    }
}
