package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU缓存机制
 *
 * @author Billy
 * @date 2020/7/12 10:00 下午
 */
public class P146LinkedHashMap {
    class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }
}
