package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //N만큼 배열
        int N = Integer.parseInt(st.nextToken());
        //k개의 수
        int K = Integer.parseInt(st.nextToken());
        char[] input = new char[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            input[i] = st.nextToken().charAt(0);
        }
        char[] answer = new char[N];
        Arrays.sort(input);
        new BOJ1759().dfs(input, N, 0, 0, answer);
    }

    private void dfs(char[] input, int n, int start, int depth, char[] answer) {
        if (depth == n) {
            if (visited(answer)) {
                System.out.println(new String(answer));
            }
            return;
        }


        for (int i = start; i < input.length; i++) {
            answer[depth] = input[i];
            dfs(input, n, i + 1, depth + 1, answer);
        }
    }

    private boolean visited(char[] answer) {
        int j = 0;
        int m = 0;
        for (int i = 0; i < answer.length; i++) {
            if(answer[i]=='a'|| answer[i]=='e'|| answer[i]=='i' || answer[i]=='o' || answer[i]=='u') m++;
            else j++;
        }
        if (m >= 1 && j >=2) {
            return true;
        } else return false;
    }
}
