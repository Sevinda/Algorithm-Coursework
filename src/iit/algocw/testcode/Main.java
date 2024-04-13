//package iit.algocw.testcode;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/iit/algocw/example_mazes/maze10_1.txt"));
//            List<String> lines = new ArrayList<>();
//            String line;
//
//            while ((line = bufferedReader.readLine()) != null) {
//                lines.add(line);
//            }
//            bufferedReader.close();
//
//            char[][] mazeData = new char[lines.size()][];
//            for (int i = 0; i < lines.size(); i++) {
//                mazeData[i] = lines.get(i).toCharArray();
//            }
//
//            Maze maze = new Maze(mazeData);
//            MazeAStar mazeAStar = new MazeAStar();
//
//            Cell start = null;
//            Cell finish = null;
//
//            for (int i = 0; i < maze.getRows(); i++) {
//                for (int j = 0; j < maze.getCols(); j++) {
//                    if (maze.getCells()[i][j].isWall()) continue;
//                    if (mazeData[i][j] == 'S') {
//                        start = maze.getCells()[i][j];
//                    } else if (mazeData[i][j] == 'F') {
//                        finish = maze.getCells()[i][j];
//                    }
//                }
//            }
//
//            if (start != null && finish != null) {
//                List<Cell> shortestPath = mazeAStar.findShortestDistance(maze, start, finish);
//                if (shortestPath != null) {
//                    System.out.println("Shortest path from start to finish:");
//                    for (int i = 0; i < shortestPath.size(); i++) {
//                        Cell cell = shortestPath.get(i);
//                        System.out.println((i + 1) + ". Move to (" + cell.getRow() + "," + cell.getCol() + ")");
//                    }
//                    System.out.println("Done!");
//                } else {
//                    System.out.println("No path found from start to finish.");
//                }
//            } else {
//                System.out.println("Start or finish cell not found in the maze.");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
