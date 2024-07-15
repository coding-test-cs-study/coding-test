import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int answer = 1;
            Map<String, Integer> map = new HashMap<>();
            int typeNum = Integer.parseInt(br.readLine());

            for (int i = 0; i < typeNum; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken(); //name
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 0)+1);
            }

            for(int val: map.values())
                answer *= (val + 1);//안 입는 경우 포함
            sb.append(answer - 1).append("\n"); //모두 안입는 경우 제거
        }
        System.out.print(sb);
    }
}