package iit.algocw.code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/iit/algocw/example_mazes/maze10_2.txt"));
            List<String> lines = new ArrayList<>();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            bufferedReader.close();

            char[][] mazeData = new char[lines.size()][];
            for (int i = 0; i < lines.size(); i++) {
                mazeData[i] = lines.get(i).toCharArray();
            }

            Maze maze = new Maze(mazeData);
            AStar aStar = new AStar();

            Node start = null;
            Node finish = null;

            for (int i = 0; i < maze.getRows(); i++) {
                for (int j = 0; j < maze.getCols(); j++) {
                    if (maze.getMaze()[i][j].isWall()) continue;
                    if (mazeData[i][j] == 'S') {
                        start = maze.getMaze()[i][j];
                        maze.getMaze()[i][j].setIsStart();
                    } else if (mazeData[i][j] == 'F') {
                        finish = maze.getMaze()[i][j];
                        maze.getMaze()[i][j].setIsFinish();
                    }
                }
            }

            if (start != null && finish != null) {
                List<Node> shortestPath = aStar.findShortestDistance(maze, start, finish);
                if (shortestPath != null) {
                    System.out.println("Shortest path from start to finish:");
                    for (int i = 0; i < shortestPath.size(); i++) {
                        Node node = shortestPath.get(i);
                        System.out.println((i + 1) + ". Move to (" + node.getRow() + "," + node.getCol() + ")");
                    }
                    System.out.println("Done!");
                } else {
                    System.out.println("No path found from start to finish.");
                }
            } else {
                System.out.println("Start or finish cell not found in the maze.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
