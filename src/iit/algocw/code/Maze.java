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
    private Node[][] maze;

    /**
     * <h2>Maze Constructor</h2>
     *
     * @param mazeData the data of the maze in the format of a 2d array
     */
    public Maze(char[][] mazeData) {
        rows = mazeData.length;
        cols = mazeData[0].length;
        maze = new Node[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = new Node(i, j, mazeData[i][j] == '0');
            }
        }
    }

    /**
     * <h2>getNeighborNodes function</h2>
     * <p>Neighbors are nodes where it is adjacent to a wall or it is the last node in the maze</p>
     * @param currentNode the current node where the pointer is.
     * @return the map of neighbors the "current node" and gCost.
     */
    public Map<Node, Integer> getNeighborNodes(Node currentNode) {
        Map<Node, Integer> neighbors = new HashMap<>();

        int[] x = {1, 0, -1, 0};
        int[] y = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int tempRow = currentNode.getRow();
            int tempCol = currentNode.getCol();
            int gCostCounter = 0;

            while (tempRow + x[i] >= 0 && tempRow + x[i] < maze.length && tempCol + y[i] >= 0 && tempCol + y[i] < maze[0].length && !maze[tempRow + x[i]][tempCol + y[i]].isWall()) {
                // if maze[tempRow + x[i]][tempCol + y[i]] is the finish node add to the neighbors and break the loop
                if (maze[tempRow][tempCol].isFinish()) {
                    neighbors.put(maze[tempRow][tempCol], gCostCounter);
                    break;
                }
                tempRow += x[i];
                tempCol += y[i];
                gCostCounter++;
            }

            if (tempRow != currentNode.getRow() || tempCol != currentNode.getCol())
                neighbors.put(maze[tempRow][tempCol], gCostCounter);
        }

        System.out.println(neighbors);
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

    public Node[][] getMaze() {
        return maze;
    }

    public void setMaze(Node[][] maze) {
        this.maze = maze;
    }
}
