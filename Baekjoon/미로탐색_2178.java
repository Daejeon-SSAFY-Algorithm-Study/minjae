import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 미로탐색_2178 {
    static int count = 1; // 도착점까지 사용한 칸 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            String numbers = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = numbers.charAt(j)-'0';
            }
        }

        int result = BFS(map, visited);
        System.out.println(result);
    }

    public static int BFS(int[][] map, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            System.out.println(Arrays.toString(now));

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length) {
                    if(map[nx][ny] == 1 && !visited[nx][ny]){
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        map[nx][ny] = map[x][y]+1;

                        if(nx == map.length - 1 && ny == map[0].length - 1) {
                            return map[nx][ny];
                        }
                    }
                }
            }
        }
        return -1;
    }
}
