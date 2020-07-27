package template;

import leetcode.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Billy
 * @date 2020/7/21 7:45 上午
 */
public class BFS {
    private Set<Node> visited = new HashSet<>();

    public void bfs(Node start) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            //处理当前节点
            //process(node)
            //探索下一节点
            if (node.next != null && !visited.contains(node.next)) {
                queue.add(node.next);
            }
        }
    }

    public void bfs2(Node start) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.remove();
                //处理当前节点
                //process(node)
                //探索下一节点
                if (node.next != null) {
                    queue.add(node.next);
                }
            }
        }
    }

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
