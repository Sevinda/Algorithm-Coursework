package iit.algocw.code;

/**
 * <h1>Node</h1>
 * <p>row - row of the node</p>
 * <p>col - col of the node</p>
 * <p>isWall - is the node a wall (obstacle)</p>
 * <p>gCost - is a distance from a starting node</p>
 * <p>hCost (Heuristic) - Euclidean distance between the goal and the current node.</p>
 * <p>fCost - gCost + hCost</p>
 */
public class Node {
    private int row;
    private int col;
    private boolean isWall;
    private int gCost;
    private int hCost;
    private int fCost;

    public Node(int row, int col, boolean isWall) {
        this.row = row;
        this.col = col;
        this.isWall = isWall;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public boolean isWall() {
        return isWall;
    }

    public void setWall(boolean wall) {
        isWall = wall;
    }

    public int getgCost() {
        return gCost;
    }

    public void setgCost(int gCost) {
        this.gCost = gCost;
    }

    public int gethCost() {
        return hCost;
    }

    public void sethCost(int hCost) {
        this.hCost = hCost;
    }

    public int getfCost() {
        return fCost;
    }

    public void setfCost(int fCost) {
        this.fCost = fCost;
    }

    @Override
    public String toString() {
        return "Node {" +
                "row=" + row +
                ", col=" + col +
                ", isWall=" + isWall +
                ", gCost=" + gCost +
                ", hCost=" + hCost +
                ", fCost=" + fCost +
                '}';
    }
}
