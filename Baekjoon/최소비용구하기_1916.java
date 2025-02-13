import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Point1 implements Comparable<Point1> {
    int x, y, value;

    Point1(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public int compareTo(Point1 other) {
        return this.value - other.value;
    }
}

public class 최소비용구하기_1916 {
    public static int dijkstra(List<List<Point1>> graph, int start, int end ,int n) {
        int [] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] =0;

        PriorityQueue<Point1>pq = new PriorityQueue<>();
        pq.add(new Point1(start,start,0));

        while(!pq.isEmpty()){
            Point1 current = pq.poll();
            int currentNode = current.y;
            int currentValue = current.value;

            if(currentNode == end){
                return currentValue;
            }

            if(currentValue > dist[currentNode]){
                continue;
            }
            for(Point1 neighbor : graph.get(currentNode)){
                int newDist = currentValue + neighbor.value;
                if(newDist < dist[neighbor.y]){
                    dist[neighbor.y]=newDist;
                    pq.add(new Point1(currentNode, neighbor.y, newDist));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<Point1>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]) - 1;
            int v = Integer.parseInt(input[1]) - 1;
            int w = Integer.parseInt(input[2]);
            graph.get(u).add(new Point1(u, v, w));
        }
        String[] input = br.readLine().split(" ");
        int k = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);

        int result = dijkstra(graph, k-1, e-1, n);
        System.out.println(result);
    }
}
