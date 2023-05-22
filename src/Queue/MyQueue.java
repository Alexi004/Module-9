package Queue;

import java.util.NoSuchElementException;
public class MyQueue {
    private Node front;
    private Node rear;
    private int size;

    // Inner class representing a queue element
    private static class Node {
        Object data;
        Node next;

        Node(Object data){
            this.data = data;
            this.next = null;
        }
    }

    public MyQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void add(Object value){
        Node newNode = new Node(value);
        if (rear == null){
            // If the queue is empty, the new element becomes the first and the last
            front = newNode;
            rear = newNode;
        } else {
            // If the queue is not empty, add the new element to the end of the queue
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public void clear() {
        // Clear the queue by setting the pointers to null and resetting the size
        front = null;
        rear = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public Object peek(){
        if (front == null) {
            // Throw an exception if the queue is empty
            throw new NoSuchElementException("Queue is empty");
        }
        return front.data; // Return the first element of the queue
    }

    public Object poll(){
        if (front == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        Object value = front.data;
        front = front.next;
        if (front == null) {
            // If the queue is now empty, update the pointer to the last element
            rear = null;
        }
        size --;
        return value; // Return the value of the removed element
    }
}
