import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int[][] map;
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };
    static boolean[][] visited;
    static int N;
    static int M;

    public static void solveBFS(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        int[] coordinate = { startX, startY };
        queue.add(coordinate);
        visited[startX][startY] = true;
        while (queue.size() > 0) {
            int[] temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = temp[0] + dx[i];
                int newY = temp[1] + dy[i];
                if (newX >= 0 && newY >= 0 && newX < M && newY < N) {
                    if (!visited[newX][newY] && map[newX][newY] == 1) {
                        queue.add(new int[] { newX, newY });
                        visited[newX][newY] = true;
                    }
                }

            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int count = 0;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            map = new int[M][N];
            visited = new boolean[M][N];
            int n = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k] && map[j][k] == 1) {
                        solveBFS(j, k);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
