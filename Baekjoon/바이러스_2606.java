import java.util.LinkedList;
import java.util.Scanner;

public class 바이러스_2606 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        LinkedList<Integer>[] linkedlist = new LinkedList[n+1];
        int m = sc.nextInt();
        for(int i=1; i<=n; i++){
            linkedlist[i] = new LinkedList<>();
        }
        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            linkedlist[u].add(v);
            linkedlist[v].add(u);
        }
        boolean[] isvisited = new boolean[n+1];
        int count = Dfs(linkedlist, 1, isvisited);
        System.out.println(count);

    }
    static int cnt=0;
    public static int Dfs(LinkedList<Integer>[] linkedlist, int currentNode, boolean[] isvisited){
        isvisited[currentNode] = true;
        //System.out.println(currentNode+" ");
        for(int i=0; i<linkedlist[currentNode].size(); i++){
            int nextNode = linkedlist[currentNode].get(i);
            if(!isvisited[nextNode]){
                cnt++;
                Dfs(linkedlist, nextNode, isvisited);
            }
        }
        return cnt;
    }
}
