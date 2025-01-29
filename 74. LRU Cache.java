class LRUCache {
    // Constructor for initializing the cache capacity with the given value.
    private final int capacity;
    private final Map<Integer, Node> map;
    private final DoublyLinkedList dll;
    LRUCache(int cap) {
        // code here
        this.capacity = cap;
        this.map = new HashMap<>();
        this.dll = new DoublyLinkedList();
    }

    // Function to return value corresponding to the key.
    public int get(int key) {
        // your code here
        if (!map.containsKey(key)) 
            return -1;
        Node node = map.get(key);
        dll.moveToFront(node);
        return node.value;
    }

    // Function for storing key-value pair.
    public void put(int key, int value) {
        // your code here
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            dll.moveToFront(node);
        } else {
            if (map.size() >= capacity) {
                Node lru = dll.removeLast();
                map.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            dll.addToFront(newNode);
            map.put(key, newNode);
        }
    }
    
    private static class Node {
        int key, value;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private static class DoublyLinkedList {
        private final Node head, tail;
        DoublyLinkedList() {
            head = new Node (0, 0);
            tail = new Node (0, 0);
            head.next = tail;
            tail.prev = head;
        }
        void addToFront(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        void moveToFront(Node node) {
            remove(node);
            addToFront(node);
        }
        Node removeLast() {
            if(tail.prev == head)
                return null;
            Node last = tail.prev;
            remove(last);
            return last;
        }
    }
}
