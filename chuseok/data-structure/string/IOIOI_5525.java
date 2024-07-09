import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int strLen = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringBuilder sb = new StringBuilder("IOI");

        int cnt = 0;
        int result = 0;
        for (int i = 0; i < strLen-2; i++) {
            String tmp = str.substring(i, i + 2 + 1);
            if(tmp.equals(sb.toString())) {
                cnt++;
                if(n == cnt) {
                    cnt--;
                    result++;
                }
                i++;//다음 i로 이동
            } else
                cnt = 0;
        }
        System.out.println(result);
    }
}