import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import java.util.Scanner;
//
//public class N과M_15651 {
//
//    public static int[] arr;
//    public static boolean[] visit;
//
//    public static void main(String[] args) {
//
//        Scanner in = new Scanner(System.in);
//
//        int N = in.nextInt();
//        int M = in.nextInt();
//
//        arr = new int[M];
//        visit = new boolean[N];
//        dfs(N, M, 0);
//
//    }
//
//    public static void dfs(int N, int M, int depth) {
//        if (depth == M) {
//            for (int val : arr) {
//                System.out.print(val + " ");
//            }
//            System.out.println();
//            return;
//        }
//
//        for (int i = 0; i < N; i++) {
//            if (!visit[i]) {
//                visit[i] = true;
//                arr[depth] = i + 1;
//                dfs(N, M, depth + 1);
//                visit[i] = false;
//            }
//        }
//    }
//
//}
import java.io.*;
import java.util.*;

public class N과M_15651 {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[M];

        dfs(0);
        System.out.print(sb);
    }

    public static void dfs(int depth) {
        // 깊이가 M이 되면 수열 출력
        if (depth == M) {
            for (int val : arr) {
                System.out.print(val+" ");
            }
            System.out.println();
            return;
        }

        // 1부터 N까지의 수를 현재 위치에 넣어봄
        for (int i = 1; i <= N; i++) {
            arr[depth] = i;
            dfs(depth + 1);
        }
    }
}
/*public class N과M_15651{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);



    }
}*/
