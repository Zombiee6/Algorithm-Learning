package leetcode;

import java.util.HashMap;

/**
 * 146. LRU缓存机制
 *
 * @author Billy
 * @date 2020/7/12 4:39 下午
 */
public class P146 {
    class LRUCache {
        //key->Node(key,val)
        private HashMap<Integer, Node> map;
        //Node(k1,v1)->Node(k2,v2)...
        private DoubleList cache;
        //最大容量
        private int cap;

        public LRUCache(int capacity) {
            this.cap = capacity;
            map = new HashMap<>();
            cache = new DoubleList();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            int val = map.get(key).val;
            // 利用 put 方法把该数据提前
            put(key, val);
            return val;
        }

        public void put(int key, int val) {
            //创建新节点
            Node x = new Node(key, val);

            if (map.containsKey(key)) {
                //删除旧节点，新的插到链表头
                cache.remove(map.get(key));
                cache.addFirst(x);
                map.put(key, x);
            } else {
                if (cap == cache.getSize()) {
                    //删除链表最好一个节点
                    Node last = cache.removeLast();
                    map.remove(last.key);
                }
                //添加到链表头
                cache.addFirst(x);
                map.put(key, x);
            }
        }
    }

    class Node {
        public int key, val;
        public Node next, prev;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    class DoubleList {
        private Node head, tail;
        private int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addFirst(Node x) {
            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;
            size++;
        }

        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            x.prev = null;
            x.next = null;
            size--;
        }

        public Node removeLast() {
            if (tail.prev == head) {
                return null;
            }
            Node last = tail.prev;
            remove(last);
            return last;
        }

        public int getSize() {
            return size;
        }
    }
}
