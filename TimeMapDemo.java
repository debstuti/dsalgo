/**
https://leetcode.com/problems/time-based-key-value-store/

Create a timebased key-value store class TimeMap, that supports two operations.

1. set(string key, string value, int timestamp)

    Stores the key and value, along with the given timestamp.

2. get(string key, int timestamp)

    Returns a value such that set(key, value, timestamp_prev) was called previously, with timestamp_prev <= timestamp.
    If there are multiple such values, it returns the one with the largest timestamp_prev.
    If there are no values, it returns the empty string ("").

**/

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
class TimeMap {
    Map<String, ArrayList<Node>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<String, ArrayList<Node>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new ArrayList<Node>());
        }
        map.get(key).add(new Node(key,value,timestamp));
        
        
    }
    
    public String get(String key, int timestamp) {
        ArrayList<Node> lst = map.get(key);
        int low = 0;
        int high = lst.size()-1;
        while(low<=high){
            if(low==high){
                if(lst.get(low).ts<=timestamp)
                    return lst.get(low).val;
                else if(low>0 && lst.get(low-1).ts<timestamp)
                    return lst.get(low-1).val;
            }

            int mid = (low+high)/2;
            
            if(timestamp== lst.get(mid).ts){
                return lst.get(mid).val;
            }
           
            if(timestamp<lst.get(mid).ts){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return "";
    }
}
class Node{
    String key;
    String val;
    int ts;
    Node(String k, String v, int ts){
        key = k;
        val = v;
        this.ts = ts;
    }
}
class TimeMapDemo{
  public static void main(String args[]){
  	TimeMap obj = new TimeMap();
  	obj.set("foo","bar",5);
	obj.set("foo","bar2",8);
  	String param_2 = obj.get("foo",10);
	System.out.println(param_2);
	}
 }

