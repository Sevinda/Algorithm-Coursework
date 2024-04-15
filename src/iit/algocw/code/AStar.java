package iit.algocw.code;

import java.util.*;

/**
 * <h1>AStar</h1>
 * <p>One of the methods to find the shortest distance from one node to another (use findShortestDistance function)</p>
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
        start.sethCost(calculateHeuristicValue(start, finish));
        start.setfCost(calculateFCost(start));

        openQueue.add(start);

        while (!openQueue.isEmpty()) {
            Node currentNode = openQueue.poll();

            if (currentNode.equals(finish))
                return reconstructPath(cameFrom, finish);

            closedSet.add(currentNode);

            Map<Node, Integer> neighborNodes = maze.getNeighborNodes(currentNode);

            for (Map.Entry<Node, Integer> entry : neighborNodes.entrySet()) {
                Node neighbor = entry.getKey();
                Integer gCost = entry.getValue();

                if (closedSet.contains(neighbor)) continue;

                double newGCost = currentNode.getgCost() + gCost;

                // if the neighbor is not in the openQueue or the new gCost is less than the current gCost of the neighbor.
                if (!openQueue.contains(neighbor) || newGCost < neighbor.getgCost()) {
                    neighbor.setgCost(newGCost);
                    neighbor.sethCost(calculateHeuristicValue(neighbor, finish));
                    neighbor.setfCost(calculateFCost(neighbor));
                    cameFrom.put(neighbor, currentNode);

                    if (!openQueue.contains(neighbor)) {
                        System.out.println(neighbor + "\n");
                        openQueue.add(neighbor);
                    }
                }
            }
        }

        return null;
    }

    /**
     * <h2>calculateHeuristicValue</h2>
     * @param node the current node
     * @param finishNode the finishing node
     * @return the heuristic value
     */
    private double calculateHeuristicValue(Node node, Node finishNode) {
        return Math.sqrt(Math.pow((finishNode.getRow() - node.getRow()), 2) + Math.pow((finishNode.getCol() - node.getCol()), 2));
    }

    /**
     * <h2>calculateFCost</h2>
     * @param node the current node
     * @return the fCost
     */
    private double calculateFCost(Node node) {
        return node.getgCost() + node.gethCost();
    }

    /**
     * <h2>reconstructPath</h2>
     * @param cameFrom the map of the nodes
     * @param currentNode the current node
     * @return the path in a list
     */
    private List<Node> reconstructPath(Map<Node, Node> cameFrom, Node currentNode) {
        List<Node> path = new ArrayList<>();
        path.add(currentNode);

        while (cameFrom.containsKey(currentNode)) {
            currentNode = cameFrom.get(currentNode);
            path.add(currentNode);
        }

        Collections.reverse(path);
        return path;
    }
}
