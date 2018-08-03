package come.eClass7_BFS_TopoSort;

import java.util.*;

public class Q4_ShortestPath {
    static class Node {
        int val;
        List<Node> neighbors;

        Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }

    /* Find a shortest path in the given root and target*/
    public List<Node> shortestPath(Node root, Node target) {
        // Assume root and target are not null. There is an existed path between root and target.
        Map<Node, Node> prevMap = new HashMap<>();

        bfs(root, target, prevMap);
        return reconstruct(root, target, prevMap);
    }

    private void bfs(Node root, Node target, Map<Node, Node> prevMap) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        visited.add(root);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur == target) {
                return;
            }
            for (Node neighbor : cur.neighbors) {
                if (visited.add(neighbor)) {
                    queue.offer(neighbor);
                    prevMap.put(neighbor, cur);
                }
            }
        }
    }

    private List<Node> reconstruct(Node root, Node target, Map<Node, Node> prevMap) {
        List<Node> res = new ArrayList<>();
        res.add(target);
        Node cur = target;

        while (cur != root) {
            cur = prevMap.get(cur);
            res.add(cur);
        }

        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n3);
        n3.neighbors.add(n1);
        n4.neighbors.add(n3);

        Q4_ShortestPath solution = new Q4_ShortestPath();
        List<Node> res = solution.shortestPath(n1, n3);
        for (Node cur : res) {
            System.out.print(cur.val + " ");
        }
    }
}
