package LinkedList;

public class MyLinkedList {
    private MyLinkedList.Node head; // First node of the list
    private MyLinkedList.Node tail; // Last node of the list
    private int size; // Last node of the list

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Adding an element to the end of the list
    public void add(Object value) {
        MyLinkedList.Node newNode = new MyLinkedList.Node(value); // Creating a new node

        if (isEmpty()) {
            // If the list is empty, the new node becomes the first and last node
            head = newNode;
            tail = newNode;
        } else {
            // If the list is not empty, add the new node after the last node
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }

        size++;
    }

    // Removing an element at the specified index
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (index == 0) {
            // If it's the index of the first element, update the reference to the first node
            head = head.next;
            if (head != null) {
                head.previous = null;
            }
        } else if (index == size - 1) {
            // If it's the index of the last element, update the reference to the last node
            tail = tail.previous;
            tail.next = null;
        } else {
            // If it's an index in the middle of the list, find the node at the specified index and update the references to the next and previous nodes
            MyLinkedList.Node currentNode = getNode(index);
            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;
        }

        size--;
    }

    // Clearing the list
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    // Getting the size of the list
    public int size() {
        return size;
    }

    // Getting the element at the specified index
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        MyLinkedList.Node node = getNode(index);
        return node.value;
    }

    // Getting the node at the specified index
    private MyLinkedList.Node getNode(int index) {
        MyLinkedList.Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    // Checking if the list is empty
    private boolean isEmpty() {
        return size == 0;
    }

    // Inner class representing a node of the list
    private class Node {
        private Object value;
        private MyLinkedList.Node previous;
        private MyLinkedList.Node next;

        public Node(Object value) {
            this.value = value;
            previous = null;
            next = null;
        }
    }
}