/**
In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

    The town judge trusts nobody.
    Everybody (except for the town judge) trusts the town judge.
    There is exactly one person that satisfies properties 1 and 2.

You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

https://leetcode.com/problems/find-the-town-judge/

 Idea : judge Node will have 0 outdegree , and N-1 indegree 

**/


class FindJudge {
    public int findJudge(int N, int[][] trust) {
        int[] indegree = new int[N];
        int[] outdegree = new int[N];
        
        for(int[] edge: trust){
            outdegree[edge[0]-1]++;
            indegree[edge[1]-1]++;
        }
        
        for(int i=0;i<N;i++){
            if(indegree[i]==N-1 && outdegree[i]==0){
                return i+1;
            }
        }
        return -1;
    }
}
