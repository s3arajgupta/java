package practice.neetCode150.part11Graphs.medium;

import java.util.*;
import modules.GraphNode;

public class cloneGraph {

    public static void main(String[] args) {

        GraphNode node1 = new GraphNode();
        GraphNode node2 = new GraphNode();
        GraphNode node3 = new GraphNode();
        GraphNode node4 = new GraphNode();

        node1 = new GraphNode(1, new ArrayList<GraphNode>(Arrays.asList(node2, node4)));
        node2 = new GraphNode(2, new ArrayList<GraphNode>(Arrays.asList(node1, node3)));
        node3 = new GraphNode(3, new ArrayList<GraphNode>(Arrays.asList(node2, node4)));
        node4 = new GraphNode(4, new ArrayList<GraphNode>(Arrays.asList(node1, node3)));

        cloneGraph sol = new cloneGraph();
        GraphNode node5 = sol.cloneGraphFuncBFS(node1);
        System.out.println(node5);
        GraphNode node6 = sol.cloneGraphFuncDFS(node1);
        System.out.println(node6);

    }

    Map<Integer, GraphNode> oldToNewDFS = new HashMap<>();

    public GraphNode cloneGraphFuncDFS(GraphNode node) {

        if (node == null)
            return node;

        if (oldToNewDFS.containsKey(node.val))
            return oldToNewDFS.get(node.val);

        GraphNode newNode = new GraphNode(node.val, new ArrayList<>());
        oldToNewDFS.put(node.val, newNode);

        for (GraphNode neighbour : node.neighbors) {

            newNode.neighbors.add(cloneGraphFuncDFS(neighbour));

        }

        return newNode;

    }

    public GraphNode cloneGraphFuncBFS(GraphNode node) {

        if (node == null)
            return null;

        Map<GraphNode, GraphNode> oldToNewBFS = new HashMap<>();
        Deque<GraphNode> deque = new LinkedList<>();

        deque.add(node);
        oldToNewBFS.put(node, new GraphNode(node.val));

        while (!deque.isEmpty()) {

            GraphNode curr = deque.removeLast();

            for (GraphNode neighbour : curr.neighbors) {

                if (!oldToNewBFS.containsKey(neighbour)) {

                    oldToNewBFS.put(neighbour, new GraphNode(neighbour.val));
                    deque.add(neighbour);

                }

                oldToNewBFS.get(curr).neighbors.add(oldToNewBFS.get(neighbour));

            }

        }

        return oldToNewBFS.get(node);

    }

}
