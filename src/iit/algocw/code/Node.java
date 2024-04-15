package iit.algocw.code;

/**
 * <h1>Node</h1>
 * <p>row - row of the node</p>
 * <p>col - col of the node</p>
 * <p>isWall - is the node a wall (obstacle)</p>
 * <p>gCost - is a distance from a starting node</p>
 * <p>hCost (Heuristic) - Euclidean distance between the finishing node and the current node.</p>
 * <p>fCost - gCost + hCost</p>
 */
public class Node {
    private int row;
    private int col;
    private boolean isWall;
    private double gCost;
    private double hCost;
    private double fCost;
    private boolean isStart = false;
    private boolean isFinish = false;

    /**
     * <h2>Node Constructor</h2>
     * @param row the row number in which the node is located
     * @param col the col number in which the node is located
     * @param isWall if true, the node is a wall
     */
    public Node(int row, int col, boolean isWall) {
        this.row = row;
        this.col = col;
        this.isWall = isWall;
    }

    public boolean isStart() {
        return isStart;
    }

    public void setIsStart() {
        this.isStart = true;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void setIsFinish() {
        this.isFinish = true;
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

    public double getgCost() {
        return gCost;
    }

    public void setgCost(double gCost) {
        this.gCost = gCost;
    }

    public double gethCost() {
        return hCost;
    }

    public void sethCost(double hCost) {
        this.hCost = hCost;
    }

    public double getfCost() {
        return fCost;
    }

    public void setfCost(double fCost) {
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
