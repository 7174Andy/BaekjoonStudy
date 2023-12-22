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
        String sValue = br.readLine();
        int value = Integer.parseInt(sValue);
        int original = value;
        int cnt = 0;
        while(true) {
            value = ((value % 10) * 10) + ((value/10 + value % 10) % 10);
            cnt++;
            if (value == original) {
                break;
            }
        }
        bw.write(cnt + "\n");
        bw.close();
    }
}
