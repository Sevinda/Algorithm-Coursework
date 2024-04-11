package iit.algocw.testcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
    private final String filePath;

    public Parser(String filePath) {
        this.filePath = filePath;
    }

    public void getMap() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.filePath));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}