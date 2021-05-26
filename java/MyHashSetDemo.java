import java.util.*;
class MyHashSet {
    List<Node> set ;
    int size;
    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new ArrayList<Node>();
        this.size = 100000;
        for(int i = 0;i<this.size;i++){
            set.add(null);
        }
    }

    public void add(int key) {
        int hash = key%this.size;
        //System.out.println(key+" "+hash+" "+set.size());
        if(set.get(hash) == null){
            set.set(hash,new Node(key));
        }else{
            Node prev = null;
            boolean exists = false;
            Node head = set.get(hash);
            while(head !=null){
                if(head.data != key){
                    prev= head;
                    head = head.next;
                }else{
                    exists = true;
                    break;
                }
            }
            if(exists == false){
                prev.next = new Node(key);
            }
        }
    }

    public void remove(int key) {
        int hash = key%this.size;
        Node prev = null;
        if(set.get(hash) != null){
            Node head = set.get(hash);
            while(head != null){
                if(head.data == key){
                    Node next = head.next;
                    if(prev != null){
                        prev.next = next;
                    }else{
                        set.set(hash, null);
                    }
                }
                prev = head;
                head = head.next;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = key%this.size;
        Node prev = null;
        if(set.get(hash) != null){
            Node head = set.get(hash);
            while(head != null){
                if(head.data == key){
                    return true;
                }
                prev = head;
                head = head.next;
            }
        }
        return false;
    }
}
class Node{
    int data;
    Node next;
    Node(int data){
        this.data= data;
    }
}
public class MyHashSetDemo{
    public static void main(String args[]) {
        MyHashSet obj = new MyHashSet();
        obj.add(1);
        obj.remove(2);
        obj.contains(1);
        boolean param_3 = obj.contains(1);
    }

}

