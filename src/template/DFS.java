package template;

import ds.MyLinkList;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Billy
 * @date 2020/7/21 7:40 上午
 */
public class DFS {
    private Set<Node> visited = new HashSet<>();

    public void dfs(Node node, Set<Node> visited) {
        visited.add(node);
        //处理当前层
        //process()

        while (node.next != null) {
            if (!visited.contains(node.next)) {
                dfs(node.next, visited);
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
