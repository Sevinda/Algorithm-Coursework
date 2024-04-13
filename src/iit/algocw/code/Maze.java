package iit.algocw.code;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>Maze</h1>
 * <p>rows - number of rows of the maze</p>
 * <p>cols - number of columns of the maze</p>
 * <p>nodes - each element in the maze is a node</p>
 */
public class Maze {
    private int rows;
    private int cols;
    private Node[][] nodes;

    /**
     * <h2>Maze Constructor</h2>
     *
     * @param mazeData the data of the maze in the format of a 2d array
     */
    public Maze(char[][] mazeData) {
        rows = mazeData.length;
        cols = mazeData[0].length;
        nodes = new Node[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                nodes[i][j] = new Node(i, j, mazeData[i][j] == '0');
            }
        }
    }

    /**
     * <h3>getNeighborNodes function</h3>
     * <p>Neighbors are nodes where it is adjacent to a wall or it is the last node in the maze</p>
     *
     * @param currentNode the current node where the pointer is.
     * @return the map of neighbors the "current node" and gCost.
     */
    public Map<Node, Integer> getNeighborNodes(Node currentNode) {
        Map<Node, Integer> neighbors = new HashMap<>();

        int[] xDirection = {0, 0, -1, 1};
        int[] yDirection = {-1, 1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int newNodeRow = currentNode.getRow();
            int newNodeCol = currentNode.getCol();
            int gCostCounter = 0;

            while ((newNodeRow + xDirection[i] >= 0 && newNodeRow + xDirection[i] < nodes.length) && (newNodeCol + yDirection[i] >= 0 && newNodeCol + yDirection[i] < nodes[0].length) && !nodes[newNodeRow + xDirection[i]][newNodeCol + yDirection[i]].isWall()) {
                newNodeRow += xDirection[i];
                newNodeCol += yDirection[i];
                gCostCounter++;
            }

            if (newNodeRow != currentNode.getRow() || newNodeCol != currentNode.getCol())
                neighbors.put(nodes[newNodeRow][newNodeCol], gCostCounter);
        }

        return neighbors;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public Node[][] getNodes() {
        return nodes;
    }

    public void setNodes(Node[][] nodes) {
        this.nodes = nodes;
    }
}

//    public Map<Node, Integer> getNeighborNodes(Node currentNode) {
//        Map<Node, Integer> neighbors = new HashMap<>();
//
//        int[] xDirection = {0, 0, -1, 1};
//        int[] yDirection = {-1, 1, 0, 0};
//
//        for (int i = 0; i < 4; i++) {
//            int newNodeRow = currentNode.getRow() + xDirection[i];
//            int newNodeCol = currentNode.getCol() + yDirection[i];
//            int gCostCounter = 0;
//
//            while (newNodeRow >= 0 && newNodeRow < nodes.length && newNodeCol >= 0 && newNodeCol < nodes[0].length && nodes[newNodeRow][newNodeCol].isWall()) {
//                newNodeRow += xDirection[i];
//                newNodeCol += yDirection[i];
//                gCostCounter++;
//            }
//
//            // Add the neighbor node and its associated gCost to the map
//            if (newNodeRow != currentNode.getRow() || newNodeCol != currentNode.getCol()) {
//                neighbors.put(nodes[newNodeRow][newNodeCol], gCostCounter);
//            }
//        }
//
//        return neighbors;
//    }
