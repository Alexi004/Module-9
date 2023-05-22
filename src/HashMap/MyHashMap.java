package HashMap;

public class MyHashMap {
    private Node[] buckets;
    private int size;

    private static class Node {
        Object key;
        Object value;
        Node next;

        Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        buckets = new Node[16]; // Initial size of the array
        size = 0;
    }

    public void put(Object key, Object value) {
        int index = getIndex(key); // Calculate the index in the array

        Node newNode = new Node(key, value); // Create a new Node

        if (buckets[index] == null) {
            // If the bucket is empty, store the new Node directly
            buckets[index] = newNode;
        } else {
            Node current = buckets[index];

            while (current.next != null) {
                if (current.key.equals(key)) {
                    // If a Node with the same key exists, update its value
                    current.value = value;
                    return;
                }
                current = current.next;
            }

            if (current.key.equals(key)) {
                // If the last Node has the same key, update its value
                current.value = value;
            } else {
                // Add the new Node to the end of the bucket
                current.next = newNode;
            }
        }

        size++;
    }

    public void remove(Object key) {
        int index = getIndex(key);

        Node previous = null;
        Node current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    // If the first Node in the bucket has the key, update the bucket reference
                    buckets[index] = current.next;
                } else {
                    // Remove the current Node by updating the previous Node's next reference
                    previous.next = current.next;
                }
                size--;
                return;
            }

            previous = current;
            current = current.next;
        }
    }

    public void clear() {
        buckets = new Node[16]; // Clear the array by creating a new empty array
        size = 0; // Reset the size to 0
    }

    public int size() {
        return size;
    }

    public Object get(Object key) {
        int index = getIndex(key);

        Node current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                // Return the value if a Node with the specified key is found
                return current.value;
            }
            current = current.next;
        }

        return null; // Return null if the key is not found
    }

    private int getIndex(Object key) {
        return Math.abs(key.hashCode()) % buckets.length; // Calculate the index using the key's hashCode
    }
}
