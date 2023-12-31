import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visitedLetters = new boolean[26];
    static int[][] baord;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int max = 0;
    static int vertical;
    static int horizontal;

    public static void DFS(int startX, int startY, int prev_length) {
        if (visitedLetters[baord[startX][startY]]) {
            max = Math.max(max, prev_length);
            return;
        } else {
            visitedLetters[baord[startX][startY]] = true;
            for (int i = 0; i < 4; i++) {
                int currX = startX + dx[i];
                int currY = startY + dy[i];
                if (currX >= 0 && currY >= 0 && currX < vertical && currY < horizontal) {
                    DFS(currX, currY, prev_length + 1);
                }
            }
            visitedLetters[baord[startX][startY]] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        vertical = Integer.parseInt(st.nextToken());
        horizontal = Integer.parseInt(st.nextToken());
        baord = new int[vertical][horizontal];
        for (int i = 0; i < vertical; i++) {
            String s = br.readLine();
            for (int j = 0; j < horizontal; j++) {
                baord[i][j] = s.charAt(j) - 'A';
            }
        }
        DFS(0, 0, 0);
        if (max == 0) {
            max = 1;
        }
        bw.write(max + "\n");
        bw.close();
    }
}
