import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS와BFS_1260 {
    static LinkedList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int V = Integer.parseInt(input[2]);

        list = new LinkedList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            list[u].add(v);
            list[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }

        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();

        visited = new boolean[N + 1];
        bfs(V);
        System.out.println();
    }

    public static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[list.length];

        stack.push(start);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                visited[v] = true;
                System.out.print(v + " ");

                for (int i = list[v].size() - 1; i >= 0; i--) {
                    int neighbor = list[v].get(i);
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[list.length];

        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");

            for (int neighbor : list[v]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}
