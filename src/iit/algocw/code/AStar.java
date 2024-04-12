package iit.algocw.code;

import java.util.*;

/**
 * <h1>AStar</h1>
 * <p>Method to find the shortest distance (findShortestDistance)</p>
 */
public class AStar {
    /**
     * <h2>findShortestDistance</h2>
     * <p>Given the maze, start node, and end node, the shortest distance will be returned</p>
     * @param maze the maze that we want to find the shortest distance
     * @param start start node
     * @param finish finishing node
     * @return the shortest path in a list. If there is no path, it returns null.
     */
    public List<Node> findShortestDistance(Maze maze, Node start, Node finish) {
        // 👇👇 Stores the nodes in the ascending order 👇👇
        PriorityQueue<Node> openQueue = new PriorityQueue<>(Comparator.comparingDouble(Node::getfCost));
        Set<Node> closedSet = new HashSet<>();
        Map<Node, Node> cameFrom = new HashMap<>();

        start.setgCost(0);
        start.sethCost(calculateHCost(start, finish));
        start.setfCost(calculateFCost(start));
        openQueue.add(start);

        while (!openQueue.isEmpty()) {
            Node currentNode = openQueue.poll();

            // TODO: if current == goal return the path (you have to construct the path somehow) idk yet THINK!!!

            if (currentNode.equals(finish)) {
                return reconstructPath(cameFrom, finish);
            }

            closedSet.add(currentNode);

            Map<Node, Integer> neighborNodes = maze.getNeighborNodes(currentNode);

            for (Map.Entry<Node, Integer> entry: neighborNodes.entrySet()) {
                Node neighbor = entry.getKey();
                Integer gCost = entry.getValue();

                if (closedSet.contains(neighbor)) continue;

                double newGCost = currentNode.getgCost() + gCost;

                if (!openQueue.contains(neighbor) || newGCost < neighbor.getgCost()) {
                    cameFrom.put(currentNode, neighbor);
                    neighbor.setgCost(newGCost);
                    neighbor.sethCost(calculateHCost(neighbor, finish));
                    neighbor.setfCost(calculateFCost(neighbor));

                    if (!openQueue.contains(neighbor)) {
                        openQueue.add(neighbor);
                    }
                }
            }
        }

        return null;
    }

    /**
     * <h2>Calculating heuristic cost</h2>
     * @param node the current node
     * @param finishNode the finishing node
     * @return the heuristic value between the nodes.
     */
    private double calculateHCost(Node node, Node finishNode) {
        return Math.sqrt(Math.pow((finishNode.getRow() - node.getRow()), 2) + Math.pow((finishNode.getCol() - node.getCol()), 2));
    }

    /**
     * <h2>Calculate the f cost</h2>
     * <p>FCost = HCost + GCost</p>
     * @param node the node we want to find the FCost
     * @return the FCost
     */
    private double calculateFCost(Node node) {
        return node.getgCost() + node.gethCost();
    }

    /**
     * <h2>Reconstruct Path</h2>
     * <p>This method reconstructs the shortest path and returns the list</p>
     * @param cameFrom a map where the previous and the current nodes are stored
     * @param current the current node
     * @return the shortest path list
     */
    private List<Node> reconstructPath(Map<Node, Node> cameFrom, Node current) {
        List<Node> path = new ArrayList<>();
        path.add(current);

        while (cameFrom.containsKey(current)) {
            current = cameFrom.get(current);
            path.add(0, current);
        }

        return path;
    }
}
