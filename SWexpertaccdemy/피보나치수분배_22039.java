import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 피보나치수분배_22039 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++)
        {
            int idx = sc.nextInt();
            if(idx % 3 ==0)
            {
                String ans = "BBA";
                for(int j=1; j< idx/3; j++)
                {
                    ans += "BBA";
                }
                System.out.println(ans);
            }
            if(idx % 3 ==1)
            {
                System.out.println("impossible");
            }
            if(idx % 3 ==2)
            {
                String ans = "B";
                for(int j=0; j<idx/3; j++)
                {
                    ans += "ABB";
                }
                ans += "A";
                System.out.println(ans);
            }
        }
    }
}

/*
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수분배_22039 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            long[] fib = new long[n + 1];
            long totalSum = fibonachi(n, fib);

            // 피보나치 수열의 합이 홀수인 경우
            if (totalSum % 2 != 0) {
                System.out.println("impossible");
            } else {
                long halfSum = totalSum / 2;
                StringBuilder result = new StringBuilder();

                for (int i = n; i > 0; i--) {
                    if (halfSum >= fib[i]) {
                        result.append("A");
                        halfSum -= fib[i];
                    } else {
                        result.append("B");
                    }
                }

                System.out.println(result.reverse().toString());
            }
        }
    }

    static long fibonachi(int a, long[] fib) {
        if (a == 0) return 0;
        if (a == 1) return 1;

        fib[0] = 0;
        if (a > 0) {
            fib[1] = 1;
        }

        long sum = fib[0] + fib[1];

        for (int i = 2; i <= a; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
            sum += fib[i];
        }

        return sum;
    }
}
*/
