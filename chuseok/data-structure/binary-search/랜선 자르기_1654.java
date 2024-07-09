import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long low = 0, mid = 0;
        //min = 0, max = 1일때 mid는 0을 방지
        long high = max+1;

        while(low < high) {
            int cnt = 0;
            mid = (low + high) / 2;

            for(int i = 0; i < arr.length; i++)
                cnt += arr[i] / mid;

            if(cnt < N)
                high = mid;
            else
                low = mid + 1;
        }
        //UpperBound로 얻어진 값에 -1이 최대 길이
        System.out.print(low - 1);
    }
}