import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static int[][] graph;
    static int[][] count;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int v;
    static int h;

    public static int solveBFS(int startX, int startY) {
        int max = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { startX, startY });
        visited[startX][startY] = true;
        while (queue.size() > 0) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int currX = curr[0] + dx[i];
                int currY = curr[1] + dy[i];
                if (currX >= 0 && currY >= 0 && currX < v && currY < h) {
                    if (!visited[currX][currY] && graph[currX][currY] == 1) {
                        queue.add(new int[] { currX, currY });
                        visited[currX][currY] = true;
                        count[currX][currY] = count[curr[0]][curr[1]] + 1;
                        if (count[currX][currY] > max) {
                            max = count[currX][currY];
                        }
                    }
                }
            }
        }
        visited = new boolean[v][h];
        count = new int[v][h];
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // Create the graph
        v = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        graph = new int[v][h];
        for (int i = 0; i < v; i++) {
            String s = br.readLine();
            for (int j = 0; j < h; j++) {
                char c = s.charAt(j);
                if (c == 'W') {
                    graph[i][j] = 0;
                } else if (c == 'L') {
                    graph[i][j] = 1;
                }
            }
        }
        visited = new boolean[v][h];
        count = new int[v][h];

        // Solve by BFS
        int max = 0;
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < h; j++) {
                if (graph[i][j] == 1) {
                    int count = solveBFS(i, j);
                    if (count > max) {
                        max = count;
                    }
                }
            }
        }

        bw.write(max + "\n");
        bw.close();
    }
}
