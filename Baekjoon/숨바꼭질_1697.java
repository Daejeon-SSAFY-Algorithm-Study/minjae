import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 숨바꼭질_1697  {
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int result = bfs(x,k);
        System.out.println(result);
    }
    public static int bfs(int x,int k){
        Queue<int[]> queue = new LinkedList<>();
        boolean [] visited = new boolean[100001];
        queue.add(new int[]{x,0});//위치랑 시간 저장

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int gps = current[0];
            int time = current[1];

            if(gps == k){
                return time;
            }

            if(gps>=0 && gps<100001 && !visited[gps]){
                visited[gps] = true;
                queue.add(new int[]{gps-1,time+1});
                queue.add(new int[]{gps+1,time+1});
                queue.add(new int[]{gps*2,time+1});
            }
        }
        return -1;
    }
}
