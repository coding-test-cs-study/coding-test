// 참고: https://velog.io/@yoonuk/%EB%B0%B1%EC%A4%80-14501-%ED%87%B4%EC%82%AC-Java%EC%9E%90%EB%B0%94
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] schedule;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); // N까지만 일 함
        schedule = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            schedule[i][0] = Integer.parseInt(st.nextToken()); // 상담 하는데 걸리는 일 수
            schedule[i][1] = Integer.parseInt(st.nextToken()); // 돈
        }

        result = 0;

        backtrack(0, 0);
        bw.write(result + "");

        bw.close();
    }
    static void backtrack(int idx, int pay){
        if(idx>=N){
            result = Math.max(pay, result);
            return;
        }

        if(idx+schedule[idx][0]<=N){
            backtrack(idx+schedule[idx][0], pay+schedule[idx][1]);
        }else{
            backtrack(idx+schedule[idx][0], pay);
        }

        backtrack(idx+1, pay);
    }
}