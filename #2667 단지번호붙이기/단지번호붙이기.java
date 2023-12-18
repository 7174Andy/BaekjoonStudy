import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int lineNumber;

    // BFS to find different areas within the graph
    public static int solveBFS(int startX, int startY) {
        int cntHouse = 1;
        Queue<int[]> queue = new LinkedList<>();
        int[] coordinate = { startX, startY };
        queue.add(coordinate);
        visited[startX][startY] = true;
        while (queue.size() > 0) {
            int[] current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int currX = current[0] + dx[i];
                int currY = current[1] + dy[i];
                if (currX >= 0 && currY >= 0 && currX < lineNumber && currY < lineNumber) {
                    if (!visited[currX][currY] && map[currX][currY] == 1) {
                        cntHouse++;
                        queue.add(new int[] { currX, currY });
                        visited[currX][currY] = true;
                    }
                }
            }
        }
        return cntHouse;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        lineNumber = Integer.parseInt(br.readLine());

        // Processing Input Data
        map = new int[lineNumber][lineNumber];
        visited = new boolean[lineNumber][lineNumber];
        for (int i = 0; i < lineNumber; i++) {
            String s = br.readLine();
            for (int j = 0; j < lineNumber; j++) {
                map[i][j] = Integer.parseInt(s.substring(j, j + 1));

            }
        }

        // BFS
        int cntArea = 0;
        ArrayList<Integer> numHouses = new ArrayList<>();
        for (int i = 0; i < lineNumber; i++) {
            for (int j = 0; j < lineNumber; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    numHouses.add(solveBFS(i, j));
                    cntArea++;
                }
            }
        }
        bw.write(cntArea + "\n");
        numHouses.sort(Comparator.naturalOrder());
        for (int i = 0; i < numHouses.size(); i++) {
            bw.write(numHouses.get(i) + "\n");
        }
        bw.close();
    }
}
