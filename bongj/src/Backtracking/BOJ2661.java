package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2661 {
    static int min = Integer.MAX_VALUE;
    static int n;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = new int[n];
        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == n) {
            for (int num : answer) {
                System.out.print(num);
            }
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            answer[depth] = i;
            if (isValid(depth)) {
                dfs(depth + 1);
            }
        }
    }

    private static boolean isValid(int depth) {
        for (int len = 1; len <= (depth + 1) / 2; len++) {
            boolean isSame = true;
            for (int k = 0; k < len; k++) {
                if (answer[depth - k] != answer[depth - len - k]) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                return false;
            }
        }
        return true;
    }
}

