import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int[][] mapHuman;
    static int[][] mapNonHuman;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    // 0: blue
    // 1: Red
    // 2: Green
    static boolean[][] visitedHuman;
    // 0: blue
    // 1: Red-Green
    static boolean[][] visitiedNonHuman;

    public static void solveHumanBFS(int startX, int startY, int value) {
        Queue<int[]> queue = new LinkedList<>();
        int[] starting = { startX, startY };
        queue.add(starting);
        visitedHuman[startX][startY] = true;
        while (queue.size() > 0) {
            int[] xy = queue.poll();
            for (int i = 0; i < 4; i++) {
                int currentX = xy[0] + dx[i];
                int currentY = xy[1] + dy[i];
                if (currentX >= 0 && currentY >= 0 && currentX < N && currentY < N) {
                    if (!visitedHuman[currentX][currentY] && mapHuman[currentX][currentY] == value) {
                        queue.add(new int[] { currentX, currentY });
                        visitedHuman[currentX][currentY] = true;
                    }
                }
            }
        }
    }

    public static void solveNonHumanBFS(int startX, int startY, int value) {
        Queue<int[]> queue = new LinkedList<>();
        int[] starting = { startX, startY };
        queue.add(starting);
        visitiedNonHuman[startX][startY] = true;
        while (queue.size() > 0) {
            int[] xy = queue.poll();
            for (int i = 0; i < 4; i++) {
                int currentX = xy[0] + dx[i];
                int currentY = xy[1] + dy[i];
                if (currentX >= 0 && currentY >= 0 && currentX < N && currentY < N) {
                    if (!visitiedNonHuman[currentX][currentY] && mapNonHuman[currentX][currentY] == value) {
                        queue.add(new int[] { currentX, currentY });
                        visitiedNonHuman[currentX][currentY] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        mapHuman = new int[N][N];
        mapNonHuman = new int[N][N];
        visitedHuman = new boolean[N][N];
        visitiedNonHuman = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                String color = s.substring(j, j + 1);
                if (color.equals("R")) {
                    mapHuman[i][j] = 1;
                    mapNonHuman[i][j] = 1;
                } else if (color.equals("G")) {
                    mapHuman[i][j] = 2;
                    mapNonHuman[i][j] = 1;
                } else if (color.equals("B")) {
                    mapHuman[i][j] = 0;
                    mapNonHuman[i][j] = 0;
                }
            }
        }

        int cntHuman = 0;
        int cntNonHuman = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visitedHuman[i][j]) {
                    solveHumanBFS(i, j, mapHuman[i][j]);
                    cntHuman++;
                }
                if (!visitiedNonHuman[i][j]) {
                    solveNonHumanBFS(i, j, mapNonHuman[i][j]);
                    cntNonHuman++;
                }
            }
        }

        bw.write(cntHuman + " " + cntNonHuman);
        bw.close();
    }
}
