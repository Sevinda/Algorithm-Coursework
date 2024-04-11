package iit.algocw.testcode;

import java.util.*;

public class MazeAStar {
    public List<Cell> findShortestDistance(Maze maze, Cell start, Cell goal) {
        PriorityQueue<Cell> openSet = new PriorityQueue<>(Comparator.comparingInt(cell -> cell.getFCost()));
        Set<Cell> closedSet = new HashSet<>();
        Map<Cell, Cell> cameFrom = new HashMap<>();

        start.setGCost(0);
        start.setHCost(heuristic(start, goal));
        start.setFCost(start.getFCost() + start.getHCost());
        openSet.add(start);

        while (!openSet.isEmpty()) {
            Cell current = openSet.poll();

            if (current == goal) {
                return reconstructPath(cameFrom, current);
            }

            closedSet.add(current);

            for (Cell neighbor : maze.getNeighbors(current)) {
                if (closedSet.contains(neighbor)) continue;

                int tentativeGCost = current.getGCost() + 1; // Assuming each move has a cost of 1

                if (!openSet.contains(neighbor) || tentativeGCost < neighbor.getGCost()) {
                    cameFrom.put(neighbor, current);
                    neighbor.setGCost(tentativeGCost);
                    neighbor.setHCost(heuristic(neighbor, goal));
                    neighbor.setFCost(neighbor.getGCost() + neighbor.getHCost());
                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    }
                }
            }
        }

        return null;
    }

    private int heuristic(Cell a, Cell b) {
        return Math.abs(b.getRow() - a.getRow()) + Math.abs(b.getCol() - a.getCol());
    }

    private List<Cell> reconstructPath(Map<Cell, Cell> cameFrom, Cell current) {
        List<Cell> path = new ArrayList<>();
        path.add(current);
        while (cameFrom.containsKey(current)) {
            current = cameFrom.get(current);
            path.add(current);
        }
        Collections.reverse(path);
        return path;
    }
}
