import java.util.*;
public class MyHashMapDemo {
    public static void main(String args[]){
        MyHashMap obj = new MyHashMap();
    obj.put(1,1);
    int param_2 = obj.get(1);
    System.out.println("1->"+obj.get(1));
    obj.remove(2);
    System.out.println("2->"+obj.get(2));
    obj.put(3,3);
    obj.put(3,4);
    System.out.println("3->"+obj.get(3));
    obj.remove(3);
    System.out.println("3->"+obj.get(3));

    }
}
class MyHashMap {
    List<Node> map;
    int size;
    /** Initialize your data structure here. */
    public MyHashMap() {
        this.map = new ArrayList<Node>();
        this.size=1000000;
        for(int i=0;i<this.size;i++)
            map.add(null);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = key%this.size;
        if(map.get(hash)== null){
            map.set(hash,new Node(key,value));
        }else{
            Node prev = null;
            Node head = map.get(hash);
            boolean exists = false;
            while(head != null){
                if(head.key==key){
                    head.val=value;
                    exists = true;
                    break;
                }
                prev = head;
                head = head.next;
            }
            if(exists == false){
                prev.next=new Node(key,value);
            }
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = key%this.size;
        if(map.get(hash)==null)
            return -1;
        else{
            Node head = map.get(hash);
            while(head !=null){
                if(head.key==key){
                    return head.val;
                }
                head=head.next;
            }
            return -1;
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = key%this.size;
        if(map.get(hash)==null)
            return;
        else{
            Node head = map.get(hash);
            Node prev = null;
            while(head !=null){
                if(head.key==key){
                    Node next = head.next;
                    if(prev !=null){
                        prev.next = next;
                    }else{
                        map.set(hash,null);
                    }
                }
                prev=head;
                head=head.next;
            }
        }
    }
}
class Node{
    int key;
    int val;
    Node next;
    Node(int key, int val){
        this.key=key;
        this.val=val;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
