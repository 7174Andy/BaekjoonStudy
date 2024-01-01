import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int lowmul = 1;
        int highbound = 1;
        int lowbound = 1;
        int cnt = 1;
        while (highbound < N) {
            if (cnt == 1) {
                lowbound++;
                highbound += 6;
                cnt++;
                continue;
            }
            lowbound += (lowmul * 6);
            lowmul++;
            highbound += (lowmul * 6);
            cnt++;
        }
        bw.write(cnt + "\n");
        bw.close();
    }
}
