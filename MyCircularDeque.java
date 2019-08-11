class MyCircularDeque {
    int size;
    int capacity;
    int front;
    int rear;
    int[] arr;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.front=0;
        this.rear=-1;
        this.size=0;
        this.capacity=k;
        arr =new int[k];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        System.out.println("inserting at front :"+value);
        if(isFull())
            return false;
        if(isEmpty()){
            this.arr[this.front]=value;
            this.rear=this.front;
        }else{
            if(this.front==0){
                this.front=this.capacity-1;
            }else
                this.front=this.front-1;
            this.arr[this.front]=value;


        }
        this.size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        System.out.println("inserting at last :"+value);
        if(isFull())
            return false;

        if(this.rear==this.capacity-1)
            this.rear=0;
        else
            this.rear= this.rear+1;

        this.arr[this.rear]=value;
        this.size++;
        return true;

    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        System.out.println("deleting front :");
        if(isEmpty())
            return false;
        if(this.front==this.rear){
            this.front=0;
            this.rear=0;
        }
        if(this.front==this.capacity-1)
            this.front=0;
        else
            this.front=this.front+1;

        this.size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        System.out.println("deleting last :");
        if(isEmpty()){
            return false;
        }
        if(this.front==this.rear){
            this.front=0;
            this.rear=-1;
        }else{
            if(this.rear==0){
                this.rear=this.capacity-1;
            }else{
                this.rear=this.rear-1;
            }
        }
        this.size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty())
            return -1;
        return this.arr[this.front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty())
            return -1;
        return this.arr[this.rear];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return this.size==0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return this.size==this.capacity;
    }

    public void printQueue(){
        System.out.println("printing queue");
        int count=0;
        for(int i=this.front;count<size;i++){
            System.out.print(this.arr[i]+" ");
            if(i==this.capacity-1)
                i=0;
            count++;
        }
        System.out.println();
    }
    public static void main(String[] args){
         MyCircularDeque obj = new MyCircularDeque(3);
         boolean param_1 = obj.insertFront(1);
         obj.printQueue();
         boolean param_2 = obj.insertLast(2);
         obj.printQueue();
         boolean param_3 = obj.deleteFront();
         obj.printQueue();
         boolean param_4 = obj.deleteLast();
         obj.printQueue();
         int param_5 = obj.getFront();
         int param_6 = obj.getRear();
         boolean param_7 = obj.isEmpty();
         boolean param_8 = obj.isFull();

    }
}

