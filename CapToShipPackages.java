/**

https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

A conveyor belt has packages that must be shipped from one port to another within D days.

The i-th package on the conveyor belt has a weight of weights[i].  Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within D days.

**/
class CapToShipPackages{
    public static int shipWithinDays(int[] weights, int D) {
	//capacity will be at least the amount of the max weight package
	//capacity will be at most the total weight of all packages
	//find low and high value
        int low= 0;
        int high =0;
        for(int num:weights){
            high+=num;
            if(num>low)
                low=num;
        }
        // Start binary search from low to high, where we can get a perfect solution (least capacity per day)
        while(low<=high){
            int mid=(low+high)/2;
            int day = getDayCount(weights,mid, D);
		
	    //day = -1 when we cant ship packages in mid number of days
	    //if day<= D then we have a solution, but check if we can have a solution with less capacity
            if(day !=-1 && day<=D){
                high=mid-1;
            }
            else  // if day>D capacity should be increased
                low=mid+1;
        }
        return low;
    }
    private static int getDayCount(int[] weights, int cap, int D){
        int wt=0;
        int day=1;
        for(int i=0;i<weights.length;i++){
            if(weights[i]>cap || day>D ) 
                return -1;
            if(wt+weights[i]<=cap){ // add package weight to current day
                wt+=weights[i];
            }else{
                wt=weights[i];  // start new day with current package
                day++;		// increase day count 
            }
        }
        
        return day;
    }
    public static void main(String args[]){
        int[] weights ={1,2,3,4,5,6,7,8,9,10}; //package weights
	int D = 5; // number of days we have to ship all packages in order
        int capacityOfShip = shipWithinDays(weights,5); // capacity of per day ship if we have to ship all packages in D days
	System.out.println(capacityOfShip);
        
    }
}
