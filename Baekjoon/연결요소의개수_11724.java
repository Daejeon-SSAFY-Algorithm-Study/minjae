import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class 연결요소의개수_11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        LinkedList<Integer>[] linkedlist = new LinkedList[n + 1];
        boolean[] isvisited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            linkedlist[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            linkedlist[u].add(v);
            linkedlist[v].add(u);
        }

        int nodelikedlists = 0;
        for (int i = 1; i <= n; i++) {
            if (!isvisited[i]) {
                nodelikedlists++;
                DFS(linkedlist, i, isvisited);
            }
        }

        System.out.print(nodelikedlists);
    }

    public static void DFS(LinkedList<Integer>[] linkedlist, int currentNode, boolean[] isvisited) {
        isvisited[currentNode] = true;

        for (int i = 0; i < linkedlist[currentNode].size(); i++) {
            int nextNode = linkedlist[currentNode].get(i);
            if (!isvisited[nextNode]) {
                DFS(linkedlist, nextNode, isvisited);
            }
        }
    }
}
