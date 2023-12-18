import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static Integer[] dp;

    public static int solve(int N) {
        if (dp[N] == null) {
            if (N % 6 == 0) {
                dp[N] = Math.min(solve(N / 3), solve(N / 2)) + 1;
            } else if (N % 3 == 0) {
                dp[N] = Math.min(solve(N / 3), solve(N - 1)) + 1;
            } else if (N % 2 == 0) {
                dp[N] = Math.min(solve(N / 2), solve(N - 1)) + 1;
            } else {
                dp[N] = solve(N - 1) + 1;
            }
        }
        return dp[N];
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        dp = new Integer[n + 1];
        dp[1] = 0;
        bw.write(solve(n) + "\n");
        bw.close();
    }
}
