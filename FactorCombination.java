/*
Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.

Write a function that takes an integer n and return all possible combinations of its factors.

Note:

    You may assume that n is always positive.
    Factors should be greater than 1 and less than n.

Example 1:

Input: 1
Output: []

Example 2:

Input: 37
Output:[]

Example 3:

Input: 12
Output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]

Example 4:

Input: 32
Output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]

*/

class Solution {
    public List<List<Integer>> getFactors(int n) {
       List<List<Integer>> factors= new ArrayList<List<Integer>>();
        //for(int i=2;i<n/2;i++)
        factors(n, new ArrayList<Integer>(), factors,2);
        return factors;
    }
    private void factors(int n, List<Integer> lst, List<List<Integer>> factors, int start){
        if(n<=1){
            if(lst.size()>1)
                factors.add(new ArrayList<Integer>(lst));
            return;
        }
        System.out.println("lst n ="+lst+" "+n+" factors ="+factors+" start "+start);
         for(int i=start;i<=n;i++){
             //System.out.println("here i , n "+i+" "+n);
           if(n%i==0){
               lst.add(i);
               factors(n/i, lst, factors, i);
               lst.remove(lst.size()-1);
           }
       }
    }
}

Improved??

class Solution {
    public List<List<Integer>> getFactors(int n) {
       List<List<Integer>> factors= new ArrayList<List<Integer>>();
        //for(int i=2;i<n/2;i++)
        factors(n, new ArrayList<Integer>(), factors,2);
        return factors;
    }
    private void factors(int n, List<Integer> lst, List<List<Integer>> factors, int start){
      
        //System.out.println("n ="+n+" "+lst);
        int upper=(int)Math.sqrt(n);
         for(int i=start;i<=upper;i++){
             //System.out.println("here i , n "+i+" "+n);
           if(n%i==0 && n/i>=i){
               lst.add(i);
               lst.add(n/i); 
               factors.add(new ArrayList(lst));
               lst.remove(lst.size()-1);
               factors(n/i, lst, factors, i);
               lst.remove(lst.size()-1);
           }
       }
    }
}
