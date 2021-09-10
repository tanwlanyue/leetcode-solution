package LC0146;

import java.util.HashMap;

/**
 * @author zhanglei211 on 2021/9/10.
 */
class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class NodeList {
        Node head = null;
        Node tail = null;

        public void add(Node node) {
            if (tail == null) {
                head = tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }

        /**
         * 注意空指针
         * @param node
         */
        public void remove(Node node) {
            if (node == head && node == tail) {
                head = tail = null;
            } else if (node == head) {
                head = head.next;
                head.prev = null;
            } else if (node == tail) {
                tail = tail.prev;
                tail.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }

        public void moveToTail(Node node) {
            remove(node);
            add(node);
        }

        public Node removeHead() {
            Node removed = head;
            Node next = head.next;
            next.prev = null;
            head = next;
            return removed;
        }

    }

    HashMap<Integer, Node> nodeMap;
    NodeList nodeList;
    int capacity;

    public LRUCache(int capacity) {
        this.nodeMap = new HashMap<>();
        this.nodeList = new NodeList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            nodeList.moveToTail(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.value = value;
            nodeList.moveToTail(node);
        } else {
            Node node = new Node(key, value);
            nodeMap.put(key, node);
            nodeList.add(node);
            if (nodeMap.size() > capacity) {
                removeLeastRecentUsed();
            }
        }
    }

    private void removeLeastRecentUsed() {
        Node node = nodeList.removeHead();
        nodeMap.remove(node.key);
    }
}
