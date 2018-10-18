package come.eClass6_DFS_Graph.attempt02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q133_CloneGraph {
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        // key: old node, value: new node
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        map.put(node, new UndirectedGraphNode(node.label));
        cloneGraph(node, map);
        return map.get(node);
    }

    private void cloneGraph(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        UndirectedGraphNode copiedNode = map.get(node);
        for (UndirectedGraphNode nei : node.neighbors) {
            if (!map.containsKey(nei)) {
                map.put(nei, new UndirectedGraphNode(nei.label));
                cloneGraph(nei, map);
            }
            copiedNode.neighbors.add(map.get(nei));
        }
    }
}
