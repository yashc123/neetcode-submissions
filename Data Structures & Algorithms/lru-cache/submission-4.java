class LRUCache {

    class Node{
        int key;
        int val;

        Node prev;
        Node next;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, Node> map;
    int capacity;
    Node head, tail;

    public LRUCache(int capacity) {
      map = new HashMap<>();
      this.capacity = capacity;
      head = new Node(0, 0);
      tail = new Node(0, 0);
      head.next = tail;
      tail.prev = head;
    }

    private void remove(Node daNode){
        daNode.prev.next = daNode.next;
        daNode.next.prev = daNode.prev;
    }

    private void addToTail(Node daNode){
        daNode.prev = tail.prev;
        daNode.next = tail;
        tail.prev.next = daNode;
        tail.prev = daNode;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node daNode = map.get(key);
            remove(daNode);
            addToTail(daNode);
            return daNode.val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }

        Node node = new Node(key, value);
        map.put(key, node);
        addToTail(node);

        if(map.size() > capacity){
            Node lru = head.next;
            remove(lru);
            map.remove(lru.key);
        }
    }


}
