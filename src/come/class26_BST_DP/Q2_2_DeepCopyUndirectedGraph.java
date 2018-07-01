package come.class26_BST_DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q2_2_DeepCopyUndirectedGraph {
    class GraphNode {
        public int key;
        List<GraphNode> neighbors;
        GraphNode(int key) {
          this.key = key;
          this.neighbors = new ArrayList<GraphNode>();
        }
      }

    public List<GraphNode> copy(List<GraphNode> graph) {
        List<GraphNode> res = new ArrayList<>();
        if (graph == null) {
            return res;
        }
        Map<GraphNode, GraphNode> lookup = new HashMap<>();
        for (GraphNode node : graph) {
            res.add(cloneGraphNode(node, lookup));
        }
        return res;
    }

    private GraphNode cloneGraphNode(GraphNode node, Map<GraphNode, GraphNode> lookup) {
        if (node == null) {
            return null;
        }
        GraphNode newNode = lookup.get(node);
        if (newNode != null) {
            return newNode;
        }
        lookup.put(node, new GraphNode(node.key));
        newNode = lookup.get(node);
        for (GraphNode neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraphNode(neighbor, lookup));
        }
        return newNode;
    }
}
