public class queue {
    private int MAX_SIZE ; // Maximum size of the queue
    private int front, rear, size;
    private int[] array;

    public queue(int MAX_SIZE) {
        this.MAX_SIZE=MAX_SIZE;
        this.array = new int[MAX_SIZE];
        this.front = 0;
        this.rear = -1;
       this.size = 0;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == MAX_SIZE;
    }

    // Get the size of the queue
    public int size() {
        return size;
    }

    // Add an element to the rear of the queue
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue element.");
            return;
        }
        rear = (rear + 1) % MAX_SIZE;
        array[rear] = item;
        size++;
    }

    // Remove and return an element from the front of the queue
    public int dequeue(int s) {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return -1; // or throw an exception
        }
        int item = array[front];
        front = (front + 1) % MAX_SIZE;
        size--;
        return item;
    }

    // Peek at the front element of the queue without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1; // or throw an exception
        }
        return array[front];
    }

    public static void main(String[] args) {
        queue queue = new queue(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());

        System.out.println("Dequeue: " + queue.dequeue(1));
        System.out.println("Dequeue: " + queue.dequeue(2));

        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
    }
}
