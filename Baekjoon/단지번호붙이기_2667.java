import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 단지번호붙이기_2667 {
    private static int[][] map;
    private static boolean[][] visited;
    private static int n;
    private static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동
    private static int[] dy = {0, 0, -1, 1}; // 상하좌우 이동

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        // 지도 입력
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> complexSizes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int size = dfs(i, j);
                    complexSizes.add(size);
                }
            }
        }

        Collections.sort(complexSizes);
        System.out.println(complexSizes.size());
        for (int size : complexSizes) {
            System.out.println(size);
        }
    }

    private static int dfs(int x, int y) {
        visited[x][y] = true;
        int size = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] == 1 && !visited[nx][ny]) {
                size += dfs(nx, ny);
            }
        }

        return size;
    }
}
