import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int map[][];
    static boolean visited[][];
    static int N;
    static int M;
    static int[] moveX = { 0, 0, 1, -1 };
    static int[] moveY = { 1, -1, 0, 0 };

    public static void solveBFS() {
        Queue<Coordinate> queue = new LinkedList<>();
        Coordinate start = new Coordinate(0, 0);
        queue.add(start);
        visited[0][0] = true;

        while (queue.size() > 0) {
            Coordinate v = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = v.x + moveX[i];
                int nextY = v.y + moveY[i];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }
                if (visited[nextX][nextY] || map[nextX][nextY] == 0) {
                    continue;
                }
                queue.add(new Coordinate(nextX, nextY));
                map[nextX][nextY] = map[v.x][v.y] + 1;
                visited[nextX][nextY] = true;
            }
        }

    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                map[i][j] = Integer.parseInt(s.substring(j, j + 1));
            }
        }
        solveBFS();
        bw.write(map[N - 1][M - 1] + "\n");
        bw.close();
    }
}

class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
