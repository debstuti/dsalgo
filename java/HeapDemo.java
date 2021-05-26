package dsalgo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Heap{
	int[] array;
	int capacity;
	int count;
	public Heap(int capacity){
		this.array=new int[capacity];
		this.count=0;
		this.capacity=capacity;
	}
	public Heap(int capacity, int[] array){
		this.array=array;
		this.count=array.length;
		this.capacity=capacity;
	}
	
	public int getParent(int i){
		int parent =  (i-1)/2;
		if(parent>=0)
			return parent;
		else
			return -1;
	}
	public int getLeft(int i){
		int left= 2*i+1;
		if(left<this.count)
			return left;
		else
			return -1;
	}
	public int getRight(int i){
		int right= 2*i+2;
		if(right<this.count)
			return right;
		else
			return -1;
	}
	
	public void percolateDown(int i){
		if(i>=this.count)
			return;
		int left=getLeft(i);
		int right=getRight(i);
		
		int min=i;
		
		if(left != -1 && this.array[min]>this.array[left]){
			min=left;
		}
		if(right != -1 && this.array[min]> this.array[right]){
			min=right;
		}
		if(min != i){
			int tmp=this.array[i];
			this.array[i]=this.array[min];
			this.array[min]=tmp;
			
			percolateDown(min);
		}
	}
	
	
	public void percolateUp(int i){
		int parent = getParent(i);
		
		int elem = this.array[i];
		//System.out.println("elem "+elem);
		while(parent != -1 && this.array[parent]> this.array[i]){
			
			int tmp=this.array[i];
			this.array[i]=this.array[parent];
			this.array[parent]=tmp;
			i=parent;
			parent=getParent(i);
			
		}
		//System.out.println(i+" *** "+elem);
		this.array[i]= elem;
	}
	
	public boolean isFull(){
		return this.capacity==this.count;
	}
	
	public void addElement(int elem) throws Exception{
		if(isFull()){
			throw new Exception("heap full");
		}
		this.array[count++]=elem;
		percolateUp(count-1);
	}
	
	public boolean isEmpty(){
		return this.count==0;
	}
	
	public int deleteMin(){
		int min=this.array[0];
		this.array[0]=this.array[--count];
		percolateDown(0);
		return min;
		
	}
}

public class HeapDemo {
    /**
     * 
     * @param args
     */
	
	
	public static void main(String[]args){
		int[] arr={4,2,9,5,1,8};
		//Heap heap=new Heap(arr.length);
		
		
		
		//add element
		/*for(int num : arr){
			try {
				heap.addElement(num);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}*/
		
		// delete Min
		/*while(!heap.isEmpty()){
		
			System.out.println("deleted "+heap.deleteMin());
		
			for(int i=0;i<heap.count;i++){
				System.out.println(heap.array[i]);
			}
		}*/
		
		
		//Heapify array  // O(n) why??
		
		/*
		 * percolateDown for non leaf nodes
		 * => complaxity ~ the sum of heights of all nodes(S)
		 * 
		 * h-> height of heap
		 *
		 * no of nodes in each label i -> 2^i, with height=h-i
		 * total no of nodes = 1 +2+4+8+ ......+2^h = 2^(h+1) - 1
		 * 
		 * 
		 * S=Sum[2^i(h-i)] for i=0 to h
		 * 	h + 2(h-1) +4(h-2) + 8(h-3) + .....+ 2^(h-1)
		 * 
		 * 2S = 2h     +4(h-1) + 8(h-2) + .................+ 2^h
		 * 
		 * 
		 * 2S-S = -h +2+4+.....................2^h
		 * 
		 * 		= -h +  2^(h+1)
		 * 		= (2^(h+1)-1) - (h-1)   
		 * 		= n - h  = O(n-logn)   
		 * 		
		 * => heapify complexity = O(n)
		 * 
		 */
		Heap heap=new Heap(arr.length,arr);
		int lastPosition=heap.count-1;
		int nonleaf=heap.getParent(lastPosition);
		
		for(int i=nonleaf;i>=0;i--){
			//System.out.println(" i "+i);
			heap.percolateDown(i);
		}
		for(int num:heap.array){
			System.out.print(num+" ");
		}
		System.out.println();
		
	}
	
	
	

		
}
