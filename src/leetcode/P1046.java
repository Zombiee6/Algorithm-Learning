package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1046. 最后一块石头的重量
 *
 * @author billy
 * @date 2020/12/30 5:23 下午
 */
public class P1046 {
    /**
     * 最大堆
     * 时间复杂度 : O(nlogn)
     * 空间复杂度 : O(n)
     */
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return -1;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while (maxHeap.size() > 1) {
            Integer max = maxHeap.poll();
            Integer secMax = maxHeap.poll();
            maxHeap.offer(max - secMax);
        }
        return maxHeap.poll();
    }

    public static void main(String[] args) {
        int[] stones = new int[]{2, 7, 4, 1, 8, 1};
        System.out.println(new P1046().lastStoneWeight(stones));
    }
}
