package come.eClass6_DFS_Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q7_DeepCopyUndirectedGraph {
    class GraphNode {
        public int key;
        public List<GraphNode> neighbors;

        public GraphNode(int key) {
            this.key = key;
            this.neighbors = new ArrayList<GraphNode>();
        }
    }

    public List<GraphNode> copy(List<GraphNode> graph) {
        Map<GraphNode, GraphNode> map = new HashMap<>();
        for (GraphNode node : graph) {
            if (!map.containsKey(node)) {
                map.put(node, new GraphNode(node.key));
                dfsHelper(node, map);
            }
        }
        return new ArrayList<>(map.values());
    }

    private void dfsHelper(GraphNode node, Map<GraphNode, GraphNode> map) {
        GraphNode copy = map.get(node);
        for (GraphNode neighbor : node.neighbors) {
            if (!map.containsKey(neighbor)) {
                map.put(neighbor, new GraphNode(neighbor.key));
                dfsHelper(neighbor, map);
            }
            copy.neighbors.add(map.get(neighbor));
        }
    }
}
