class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int low= 0;
        int high =0;
        for(int num:weights){
            high+=num;
            if(num>low)
                low=num;
        }
       
        while(low<=high){
            int mid=(low+high)/2;
            int day = getDayCount(weights,mid, D);
            if(day !=-1 && day<=D){
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return low;
    }
    private int getDayCount(int[] weights, int cap, int D){
        int wt=0;
        int day=1;
        for(int i=0;i<weights.length;i++){
            if(weights[i]>cap || day>D )
                return -1;
            if(wt+weights[i]<=cap){
                wt+=weights[i];
            }else{
                wt=weights[i];
                day++;
            }
        }
        
        return day;
    }
}
