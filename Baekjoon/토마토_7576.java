import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 토마토_7576 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int days = 0;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        boolean flag = false;

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] input1 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(input1[j]);
                if (arr[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
                if (arr[i][j] == 0) {
                    flag = true;
                }
            }
        }

        if (!flag) {
            System.out.println(0);
            return;
        }

        int result = bfs(arr);
        boolean flag2 = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    flag2 = false;
                    break;
                }
            }
        }

        if (flag2) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    public static int bfs(int[][] arr) {
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] now = q.poll();
                int x = now[0];
                int y = now[1];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[0].length && arr[nx][ny] == 0) {
                        arr[nx][ny] = 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }

            days++;
        }

        return days - 1;
    }
}
