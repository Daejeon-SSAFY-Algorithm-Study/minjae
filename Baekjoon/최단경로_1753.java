import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Point implements Comparable<Point> {
    int x, y, time;

    Point(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }

    @Override
    public int compareTo(Point other) {
        return this.time - other.time;
    }
}

public class 최단경로_1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");

        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);
        int k = Integer.parseInt(br.readLine());//시작 노드

        List<List<Point>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]) - 1;
            int v = Integer.parseInt(edge[1]) - 1;
            int w = Integer.parseInt(edge[2]);
            graph.get(u).add(new Point(u, v, w));
        }

        int[] result = dijkstra(graph, k - 1, n);
        for (int i = 0; i < n; i++) {
            System.out.println(result[i] == Integer.MAX_VALUE ? "INF" : result[i]);
        }

    }

    public static int[] dijkstra(List<List<Point>> graph, int start, int n) {
        int [] times = new int[n];
        Arrays.fill(times,Integer.MAX_VALUE);
        times[start] = 0;

        PriorityQueue<Point>pq = new PriorityQueue<>();
        pq.add(new Point(start,start,0));

        while(!pq.isEmpty()){
            Point current = pq.poll();
            int currentNode = current.y;

            if (current.time > times[currentNode]) // 수정된 조건문
                continue;

            for(int i=0; i<graph.get(currentNode).size(); i++){
                Point neighbor = graph.get(currentNode).get(i);
                int nextNode = neighbor.y;
                int newTime = current.time + neighbor.time;
                if(newTime<times[nextNode]){
                    times[nextNode]=newTime;
                    pq.add(new Point(nextNode, nextNode, newTime));
                }
            }
        }

        return times;
    }
}
