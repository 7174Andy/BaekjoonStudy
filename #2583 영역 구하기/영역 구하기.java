import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N;
    static int M;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void createRect(int[] start, int[] end) {
        for (int i = start[1]; i < end[1]; i++) {
            for (int j = start[0]; j < end[0]; j++) {
                if (map[i][j] == 1) {
                    continue;
                }
                map[i][j] = 1;
            }
        }
    }

    public static int solveBFS(int startY, int startX) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { startY, startX });
        visited[startY][startX] = true;
        count++;
        while (queue.size() > 0) {
            int[] coordinate = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newY = coordinate[0] + dy[i];
                int newX = coordinate[1] + dx[i];
                if (newY >= 0 && newX >= 0 && newY < M && newX < N) {
                    if (!visited[newY][newX] && map[newY][newX] == 0) {
                        queue.add(new int[] { newY, newX });
                        visited[newY][newX] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];
        int cntSquares = Integer.parseInt(st.nextToken());
        for (int i = 0; i < cntSquares; i++) {
            st = new StringTokenizer(br.readLine());
            int[] start = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
            int[] end = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
            createRect(start, end);
        }
        int cnt = 0;
        ArrayList<Integer> sizes = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    sizes.add(solveBFS(i, j));
                    cnt++;
                }
            }
        }
        sizes.sort(Comparator.naturalOrder());
        bw.write(cnt + "\n");
        for (int i = 0; i < sizes.size(); i++) {
            bw.write(sizes.get(i) + " ");
        }
        bw.write("\n");
        bw.close();
    }
}
