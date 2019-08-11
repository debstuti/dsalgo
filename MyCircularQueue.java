class MyCircularQueue {
    int[] arr;
    int front;
    int rear;
    int size;
    int capacity;
    
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.arr = new int[k];
        this.front=0;
        this.rear=-1;
        this.size=0;
        this.capacity=k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        
        if(isFull()){
            return false;
        }

        this.rear = (this.rear+1)%this.capacity;
        this.arr[this.rear]=value;
        this.size++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }
        if(this.front==this.rear){
            this.front=0;
            this.rear=-1;
        }else
            this.front=(this.front+1)%this.capacity;
        this.size--;
        return true;

    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty())
            return 0;
        return this.arr[this.front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty())
            return -1;
        return this.arr[this.rear];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return this.size==0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return this.size==this.capacity;
    }

    public void printQueue(){
        System.out.println("\nPrinting Queue : isEmpty= "+this.isEmpty());

        int count=0;
        for(int i=this.front;count<this.size;i++){
            System.out.print(this.arr[i]+" ");
            count++;
            if(i==this.capacity)
                i=0;
        }
        System.out.println();
    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args){
        MyCircularQueue obj = new MyCircularQueue(3);
        boolean param_1 = obj.enQueue(1);
        obj.printQueue();
        boolean param_2 = obj.deQueue();
        obj.printQueue();
        int param_3 = obj.Front();
        System.out.println("front "+param_3);
        int param_4 = obj.Rear();
        System.out.println("rear "+param_4);
        boolean param_5 = obj.isEmpty();
        boolean param_6 = obj.isFull();
        boolean param_7 = obj.enQueue(2);
        boolean param_8 = obj.enQueue(3);
        boolean param_9 = obj.enQueue(4);
        obj.printQueue();
        System.out.println("isFull ="+obj.isFull());


    }
}

