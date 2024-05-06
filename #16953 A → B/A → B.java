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

        int ans = 0;
        Queue<Long> queue = new LinkedList<>();
        queue.add(A * 2);
        queue.add(A * 10 + 1);
        while (!queue.isEmpty()) {
            ans++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                long curr = queue.poll();
                if (curr > B) {
                    continue;
                }
                if (curr == B) {
                    System.out.println(ans + 1);
                    return;
                }
                queue.add(curr * 2);
                queue.add(curr * 10 + 1);
            }
        }

        System.out.println(-1);
    }
}
