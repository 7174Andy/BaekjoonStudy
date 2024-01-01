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
        int[] triangle = { -1, -1, -1 };
        while (triangle[0] != 0 || triangle[1] != 0 || triangle[2] != 0) {
            st = new StringTokenizer(br.readLine());
            triangle[0] = Integer.parseInt(st.nextToken());
            triangle[1] = Integer.parseInt(st.nextToken());
            triangle[2] = Integer.parseInt(st.nextToken());
            if (triangle[0] == 0 && triangle[1] == 0 && triangle[2] == 0) {
                break;
            }
            int max = 0;
            int maxIndex = -1;
            for (int i = 0; i < 3; i++) {
                if (triangle[i] > max) {
                    max = triangle[i];
                    maxIndex = i;
                }
            }
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                if (i != maxIndex) {
                    sum += triangle[i];
                }
            }
            if (max >= sum) {
                bw.write("Invalid\n");
                continue;
            }
            if (triangle[0] == triangle[1] && triangle[1] == triangle[2] && triangle[0] == triangle[2]) {
                bw.write("Equilateral\n");
            } else if (triangle[0] == triangle[1] || triangle[1] == triangle[2] || triangle[0] == triangle[2]) {
                bw.write("Isosceles\n");
            } else {
                bw.write("Scalene\n");
            }

        }

        bw.close();
    }
}
