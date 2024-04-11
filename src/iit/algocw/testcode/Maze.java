package iit.algocw.testcode;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    private int rows;
    private int cols;
    private Cell[][] cells;

    public Maze(char[][] mazeData) {
        rows = mazeData.length;
        cols = mazeData[0].length;
        cells = new Cell[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell(i, j, mazeData[i][j] == '0');
            }
        }
    }

    public List<Cell> getNeighbors(Cell cell) {
        List<Cell> neighbors = new ArrayList<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int newRow = cell.getRow() + dx[i];
            int newCol = cell.getCol() + dy[i];
            while (isValid(newRow, newCol) && !cells[newRow][newCol].isWall()) {
                neighbors.add(cells[newRow][newCol]);
                newRow += dx[i];
                newCol += dy[i];
            }
        }

        return neighbors;
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
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

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
}
