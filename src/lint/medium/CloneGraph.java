package lint.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};

public class CloneGraph {
    /*
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return node;
        }

        ArrayList<UndirectedGraphNode> nodes = getNodes(node);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

        for (UndirectedGraphNode n : nodes) {
            map.put(n, new UndirectedGraphNode(n.label));
        }

        for (UndirectedGraphNode n : nodes) {
            UndirectedGraphNode newNode = map.get(n);
            for (UndirectedGraphNode neighbor : n.neighbors) {
                UndirectedGraphNode newNeighbor = map.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return map.get(node);
    }

    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        ArrayList<UndirectedGraphNode> nodes = new ArrayList<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();

        queue.offer(node);
        nodes.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();

            for (UndirectedGraphNode neighbor : head.neighbors) {
                if (!nodes.contains(neighbor)) {
                    nodes.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return nodes;
    }
}
