import java.io.*;

public class 스도쿠_2580 {
    static int[][] arr = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 스도쿠 보드 입력
        for (int i = 0; i < 9; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        dfs(sb);
        System.out.print(sb);
    }

    public static boolean dfs(StringBuilder sb) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (arr[row][col] == 0) { // 빈 칸 발견
                    int[] numbers = new int[10];

                    //행
                    for (int j = 0; j < 9; j++) {
                        numbers[arr[row][j]] = 1;//
                    }

                    //열
                    for (int i = 0; i < 9; i++) {
                        numbers[arr[i][col]] = 1;
                    }

                    //3*3박스
                    int startRow = (row / 3) * 3;
                    int startCol = (col / 3) * 3;
                    for (int i = startRow; i < startRow + 3; i++) {
                        for (int j = startCol; j < startCol + 3; j++) {
                            numbers[arr[i][j]] = 1;
                        }
                    }

                    // 가능한 숫자 시도
                    for (int num = 1; num <= 9; num++) {
                        if (numbers[num] == 0) {  // 사용 가능한 숫자라면
                            arr[row][col] = num;
                            if (dfs(sb)) return true;
                            arr[row][col] = 0;  //아니면 0으로
                        }
                    }
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return true;
    }
}
