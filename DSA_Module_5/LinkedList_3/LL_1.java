package com.scaler.module_2.assignments.DSA_Module_5.LinkedList_3;
import java.util.HashMap;
/*Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.
Definition of "least recently used" : An access to an item is defined as a get or a set operation of the item. "Least recently used" item is the one with the oldest access time.
NOTE: If you are using any global variables, make sure to clear them in the constructor.
Example :
Input :
         capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full.
         get(5)        returns -1
Expected Output
Enter your input as per the following guideline:
There are 1 lines in the input
Line 1 ( Corresponds to arg 1 ) : The line starts with a pair of number numOperations, capacity. capacity is the number your constructor is initialized with.
Then numOperation operations follow.
Each operation is either :
 * G  : This corresponds to a function call get()
 * S   : This corresponds to a function call set(num1, num2)
Note that the function calls are made in order.  */
public class LL_1 {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;
    public LL_1(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    // Remove a node from its current position
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    // Insert node immediately after head
    private void insertAtHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    // Move an existing node to the front
    private void moveToHead(Node node) {

        remove(node);
        insertAtHead(node);
    }
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        // Mark as recently used
        moveToHead(node);
        return node.value;
    }
    public void set(int key, int value) {
        // Key already exists
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            // Mark as recently used
            moveToHead(node);
            return;
        }
        // Cache is full
        if (map.size() == capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
        // Create and insert new node
        Node newNode = new Node(key, value);
        insertAtHead(newNode);
        map.put(key, newNode);
    }
}
