package Backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        int[] day = new int[testcase + 1];
        int[] pay = new int[testcase + 1];
        int[] dp = new int[testcase + 2];
        int max = 0;

        for (int i = 1; i <= testcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= testcase; i++) {
            // 현재까지의 최대 수익을 유지
            dp[i] = Math.max(dp[i], max);
            // 일을 끝낸 날의 수익을 갱신
            if (i + day[i] <= testcase + 1) {
                dp[i + day[i]] = Math.max(dp[i + day[i]], dp[i] + pay[i]);
            }
            // 최대 수익 갱신
            max = Math.max(max, dp[i]);
        }

        // 전체 최대값을 찾아 출력
        max = Math.max(max, dp[testcase + 1]);
        System.out.println(max);
    }
}
