import javax.swing.JTextArea;

public class Stack {
    private int Maxsize;
    public int[] arrs;
    public int top;

    public Stack(int size) {
        this.Maxsize = size;
        this.arrs = new int[Maxsize];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == Maxsize - 1;
    }

    public void push(int elem) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            top++;
            arrs[top] = elem;
        }
    }

    public int peak() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return '\0';
        } else {
            return arrs[top];
        }
    }

    int  pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
             int elem = arrs[top];
            top--;
            return elem;
        }
    }
   public void remove(int value) {
    int index = -1;

    // Find the index of the element to remove
    for (int i = 0; i <= top; i++) {
        if (arrs[i] == value) {
            index = i;
            break;
        }
    }

    // Check if the element was found
    if (index != -1) {
        // Shift elements to the left to remove the element at the found index
        for (int i = index; i < top; i++) {
            arrs[i] = arrs[i + 1];
        }

        // Decrement the top to reflect the removal
        top--;
    } else {
        throw new IllegalArgumentException("Element not found in the stack.");
    }
}


    void print() {
        System.out.print("[");
        for (int i = 0; i <= top; i++) {
            System.out.print(arrs[i]);
            if (i < top) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
}
