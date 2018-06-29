package come.class06_Heap_GraphI_BFS.attempt02;

import java.util.*;

class GraphNode {
    public int key;
    public List<GraphNode> neighbors;
    public GraphNode(int key) {
      this.key = key;
      this.neighbors = new ArrayList<GraphNode>();
    }
  }

public class Bipartite {
    public boolean isBipartite(List<GraphNode> graph) {
        Map<GraphNode, Integer> map = new HashMap<>();
        for (GraphNode node : graph) {
            if (!bfsHelper(node, map)) {
                return false;
            }
        }
        return true;
    }

    private boolean bfsHelper(GraphNode node, Map<GraphNode, Integer> map) {
        if (map.containsKey(node)) {
            return true;
        }
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(node);
        map.put(node, 1);
        while (!queue.isEmpty()) {
            GraphNode curr = queue.poll();
            Integer groupNum = map.get(curr) == 1 ? 2 : 1;
            for (GraphNode neigh : curr.neighbors) {
                Integer neighGroupNum = map.get(neigh);
                if (neighGroupNum == null) {
                    queue.offer(neigh);
                    map.put(neigh, groupNum);
                } else if (neighGroupNum != groupNum) {
                    return false;
                }
            }
        }
        return true;
    }
}
