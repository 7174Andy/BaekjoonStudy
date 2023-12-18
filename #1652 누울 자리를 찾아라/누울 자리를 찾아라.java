import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int lineNumber = Integer.parseInt(br.readLine());
        int[][] graph = new int[lineNumber][lineNumber];
        int horizontal = 0;
        int vertical = 0;
        for (int i = 0; i < lineNumber; i++) {
            String s = br.readLine();
            for (int j = 0; j < lineNumber; j++) {
                String room = s.substring(j, j + 1);
                if (room.equals(".")) {
                    graph[i][j] = 0;
                } else if (room.equals("X")) {
                    graph[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < lineNumber; i++) {
            int blankCount = 0;
            for (int j = 0; j < lineNumber; j++) {
                if (graph[i][j] == 1) { // Reached the wall?
                    if (blankCount >= 2) { // can lay down?
                        horizontal++;
                    }
                    blankCount = 0;
                    continue;
                } else if (j == lineNumber - 1 && graph[i][j] == 0) { // reached the end?
                    blankCount++;
                    if (blankCount >= 2) { // can lay down?
                        horizontal++;
                    }
                } else {
                    blankCount++;
                }
            }
        }

        for (int i = 0; i < lineNumber; i++) {
            int blankCount = 0;
            for (int j = 0; j < lineNumber; j++) {
                if (graph[j][i] == 1) { // Reached the wall?
                    if (blankCount >= 2) { // can lay down?
                        vertical++;
                    }
                    blankCount = 0;
                    continue;
                } else if (j == lineNumber - 1 && graph[j][i] == 0) { // reached the end?
                    blankCount++;
                    if (blankCount >= 2) { // can lay down?
                        vertical++;
                    }
                } else {
                    blankCount++;
                }
            }
        }

        bw.write(horizontal + " " + vertical);
        bw.close();
    }
}
