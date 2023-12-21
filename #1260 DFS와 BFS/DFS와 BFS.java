import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.StringTokenizer;
import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static ArrayList<Integer> dfs(int[][] graph, int start) {
        // order of the dfs
        ArrayList<Integer> result = new ArrayList<>();

        // marked array
        boolean[] visited = new boolean[graph.length];

        // stack for the dfs
        Stack<Integer> stack = new Stack<>();

        // added the start to the stack
        stack.add(start);

        while (stack.size() > 0) {
            int v = stack.pop();

            if (!visited[v - 1]) {
                visited[v - 1] = true;
                result.add(v);
                for (int i = graph[v - 1].length - 1; i >= 0; i--) {
                    if (graph[v - 1][i] == 1 && !visited[i]) {
                        stack.add(i + 1);
                    }
                }
            }
        }
        return result;
    }

    public static ArrayList<Integer> bfs(int[][] graph, int start) {
        // order of the dfs
        ArrayList<Integer> result = new ArrayList<>();

        // marked array
        boolean[] visited = new boolean[graph.length];

        // queue for the dfs
        Queue<Integer> queue = new LinkedList<>();

        // added the start to the stack
        queue.add(start);

        while (queue.size() > 0) {
            int v = queue.poll();

            if (!visited[v - 1]) {
                visited[v - 1] = true;
                result.add(v);
                for (int i = 0; i < graph[v - 1].length; i++) {
                    if (graph[v - 1][i] == 1 && !visited[i]) {
                        queue.add(i + 1);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x - 1][y - 1] = 1;
            graph[y - 1][x - 1] = 1;
        }
        ArrayList<Integer> resultDFS = dfs(graph, start);
        for (int i = 0; i < resultDFS.size(); i++) {
            bw.write(resultDFS.get(i) + " ");
        }
        bw.write("\n");
        ArrayList<Integer> resultBFS = bfs(graph, start);
        for (int i = 0; i < resultBFS.size(); i++) {
            bw.write(resultBFS.get(i) + " ");
        }
        bw.write("\n");

        bw.close();
    }
}
