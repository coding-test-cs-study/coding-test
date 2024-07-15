import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalCnt = Integer.parseInt(st.nextToken());
        int findCnt = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        while (totalCnt-->0) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }
        while (findCnt-->0) {
            sb.append(map.get(br.readLine())).append("\n");
        }
        System.out.print(sb);
    }
}