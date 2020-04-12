/*
Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. Your method will be called repeatedly many times with different parameters. 

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3

Input: word1 = "makes", word2 = "coding"
Output: 1

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

*/
class WordDistance {
    Map<String, List<Integer>> locations;
    public WordDistance(String[] words) {
        locations= new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(!locations.containsKey(words[i])){
                locations.put(words[i],new ArrayList<Integer>());
            }
            locations.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> word1Locs= locations.get(word1);
        List<Integer> word2Locs= locations.get(word2);
        int min=Integer.MAX_VALUE;
        for(int i=0,j=0;i<word1Locs.size() && j<word2Locs.size();){
            int dist=word1Locs.get(i)-word2Locs.get(j);
            min=Math.min(min, Math.abs(dist));
            if(dist>0){
                j++;
            }else if(dist<0){
                i++;
            }else{
                i++;
                j++;
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
