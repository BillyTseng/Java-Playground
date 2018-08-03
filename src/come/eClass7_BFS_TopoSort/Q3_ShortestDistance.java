package come.eClass7_BFS_TopoSort;

import java.util.*;

public class Q3_ShortestDistance {
    static class Node {
        int val;
        List<Node> neighbors;

        Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }

    /* Get a shortest distance in the given root and target*/
    public int shortestDistance(Node root, Node target) {
        // Assume root and target are not null.
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        visited.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (Node neighbor : cur.neighbors) {
                if (neighbor == target) {
                    return level + 1;
                }
                if (visited.add(neighbor)) {
                    queue.offer(neighbor);
                }
            }
            level++;
        }
        return -1;
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

        Q3_ShortestDistance solution = new Q3_ShortestDistance();
        System.out.print("Shortest Distance is " + solution.shortestDistance(n1, n3));
    }
}
