import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[] visited;

    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        while (queue.size() > 0) {
            int temp = queue.poll();
            for (int i = 0; i < graph[temp].length; i++) {
                if (graph[temp][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodes = Integer.parseInt(st.nextToken());
        int connections = Integer.parseInt(st.nextToken());
        graph = new int[nodes][nodes];
        visited = new boolean[nodes];

        // Graph Setting
        for (int i = 0; i < connections; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            graph[m - 1][n - 1] = 1;
            graph[n - 1][m - 1] = 1;
        }

        // Solve
        int cnt = 0;
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                bfs(i);
                cnt++;
            }
        }

        bw.write(cnt + "\n");
        bw.close();
    }
}
