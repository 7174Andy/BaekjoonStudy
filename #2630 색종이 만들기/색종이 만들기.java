import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int blue = 0;
    static int white = 0;
    static int[][] board;

    public static int solveBlue(int N, int[][] tempBoard) {
        if (tempBoard.length == 1) {
            if (tempBoard[0][0] == 1) {
                return 1;
            } else {
                return 0;
            }
        }
        boolean allBlue = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tempBoard[i][j] != 1) {
                    allBlue = false;
                    break;
                }
            }
        }
        if (allBlue) {
            return 1;
        }

        int[][] I = new int[N / 2][N / 2];
        int[][] II = new int[N / 2][N / 2];
        int[][] III = new int[N / 2][N / 2];
        int[][] IV = new int[N / 2][N / 2];
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N / 2; j++) {
                I[i][j] = tempBoard[i][j];
            }
        }
        for (int i = N / 2; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                II[i - N / 2][j] = tempBoard[i][j];
            }
        }
        for (int i = 0; i < N / 2; i++) {
            for (int j = N / 2; j < N; j++) {
                III[i][j - N / 2] = tempBoard[i][j];
            }
        }
        for (int i = N / 2; i < N; i++) {
            for (int j = N / 2; j < N; j++) {
                IV[i - N / 2][j - N / 2] = tempBoard[i][j];
            }
        }
        return solveBlue(N / 2, I) + solveBlue(N / 2, II) + solveBlue(N / 2, III) + solveBlue(N / 2, IV);
    }

    public static int solveWhite(int N, int[][] tempBoard) {
        if (tempBoard.length == 1) {
            if (tempBoard[0][0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        boolean allWhite = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tempBoard[i][j] != 0) {
                    allWhite = false;
                    break;
                }
            }
        }
        if (allWhite) {
            return 1;
        }

        int[][] I = new int[N / 2][N / 2];
        int[][] II = new int[N / 2][N / 2];
        int[][] III = new int[N / 2][N / 2];
        int[][] IV = new int[N / 2][N / 2];
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N / 2; j++) {
                I[i][j] = tempBoard[i][j];
            }
        }
        for (int i = N / 2; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                II[i - N / 2][j] = tempBoard[i][j];
            }
        }
        for (int i = 0; i < N / 2; i++) {
            for (int j = N / 2; j < N; j++) {
                III[i][j - N / 2] = tempBoard[i][j];
            }
        }
        for (int i = N / 2; i < N; i++) {
            for (int j = N / 2; j < N; j++) {
                IV[i - N / 2][j - N / 2] = tempBoard[i][j];
            }
        }
        return solveWhite(N / 2, I) + solveWhite(N / 2, II) + solveWhite(N / 2, III) + solveWhite(N / 2, IV);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        blue = solveBlue(N, board);
        white = solveWhite(N, board);
        bw.write(white + "\n" + blue + "\n");
        bw.close();
    }
}
