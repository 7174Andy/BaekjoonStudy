import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static ArrayList<Integer> solvedfs(int[][] graph) {
        ArrayList<Integer> result = new ArrayList<>();

        int start = 1;

        boolean[] visited = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();
        stack.add(start);

        while (stack.size() > 0) {
            int v = stack.pop();
            if (!visited[v - 1]) {
                visited[v - 1] = true;
                result.add(v);
                for (int i = 0; i < graph[v - 1].length; i++) {
                    if (graph[v - 1][i] == 1)
                        stack.add(i + 1);
                }
            }
        }
        return result;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x - 1][y - 1] = 1;
            graph[y - 1][x - 1] = 1;
        }
        ArrayList<Integer> result = solvedfs(graph);
        bw.write((result.size() - 1) + "\n");
        bw.close();
    }
}
