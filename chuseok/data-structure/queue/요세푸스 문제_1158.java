import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalCnt = Integer.parseInt(st.nextToken());
        int findIdx = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= totalCnt; i++) {
            queue.add(i);
        }
        int cnt = 0;
        sb.append("<");
        while (!queue.isEmpty()) {
            cnt++;
            if(cnt%findIdx == 0) {
                sb.append(queue.poll());
                if(queue.isEmpty()) sb.append(">");
                else sb.append(", ");
            } else {
                queue.add(queue.poll());
            }
        }
        System.out.print(sb);
    }
}