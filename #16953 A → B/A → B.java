import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int cnt = 1;

        while (A != B) {
            if (A > B) {
                bw.write(-1 + "\n");
                bw.close();
                return;
            }
            String s = String.valueOf(B);
            if (B % 2 == 0) {
                B /= 2;
            } else if (s.charAt(s.length() - 1) == '1') {
                s = s.substring(0, s.length() - 1);
                B = Integer.parseInt(s);
            } else {
                bw.write(-1 + "\n");
                bw.close();
                return;
            }
            cnt++;
        }
        bw.write(cnt + "\n");
        bw.close();
    }
}
