import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static boolean[][] visited;
    static int[][] board;
    static int[] dx = { -2, -1, -2, -1, 1, 2, 1, 2 };
    static int[] dy = { 1, 2, -1, -2, 2, 1, -2, -1 };
    static int size;

    public static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { startX, startY });
        visited[startX][startY] = true;
        while (!queue.isEmpty()) {
            int[] tempCoor = queue.poll();
            for (int i = 0; i < 8; i++) {
                int currX = tempCoor[0] + dx[i];
                int currY = tempCoor[1] + dy[i];
                if (currX >= 0 && currY >= 0 && currX < size && currY < size) {
                    if (!visited[currX][currY]) {
                        queue.add(new int[] { currX, currY });
                        visited[currX][currY] = true;
                        board[currX][currY] = board[tempCoor[0]][tempCoor[1]] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            size = Integer.parseInt(br.readLine());
            board = new int[size][size];
            visited = new boolean[size][size];
            st = new StringTokenizer(br.readLine());
            bfs(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            bw.write(board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] + "\n");
        }
        bw.close();
    }
}
