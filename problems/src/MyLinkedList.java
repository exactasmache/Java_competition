class MyLinkedList {
    
    private class Node {
        private Node prev;
        private Node next;
        private int value;
        private Node(int val) { value = val; }
    }
    
    private int size;
    private Node head;
    private Node tail;
    
    
    private Node findNode(int index) {
        Node n = head;
        for(int i = 0; i < index; i++)
            n = n.next;
        return n;
    }
    
    private void deleteHead() {
        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return;
    }
    
    private void deleteTail() {
        if (tail.prev == null) {
            tail = null;
            head = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return;
    }
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
        return;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index > size-1 || index < 0)
            return -1;
        Node n = findNode(index);
        return n.value;
    }
    
    /* Add a node of value val before the first element of the linked list. 
     * After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            Node tmp = new Node(val);
            tmp.next = head;
            head.prev = tmp;
            head = tmp;
        }
        size++;
        return;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (tail == null) {
            tail = new Node(val);
            head = tail;
        } else {
            Node tmp = new Node(val);
            tmp.prev = tail;
            tail.next = tmp;
            tail = tmp;
        }
        size++;
        return;
    }
    
    /* Add a node of value val before the index-th node in the linked list. 
     * If index equals to the length of linked list, the node will be appended 
     * to the end of linked list. If index is greater than the length, the node 
     * will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size || index < 0)
            return;
        
        if(index == size)
            addAtTail(val);
        else if(index == 0)
            addAtHead(val);
        else {
            Node h = head;
            for(int i = 0; i < index; i++)
                h = h.next;

            Node tmp = new Node(val);
            h.prev.next = tmp;
            tmp.prev = h.prev;
            tmp.next = h;
            h.prev = tmp;
            size++;
        }
    }
    
    
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index > size -1 || index < 0)
            return;
        if(index == 0)
            deleteHead();
        else if(index == size-1)
            deleteTail();
        else { 
            Node n = findNode(index);
            n.prev.next = n.next;
            n.next.prev = n.prev;
            size--;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
