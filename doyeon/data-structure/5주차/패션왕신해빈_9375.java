import java.io.*;
import java.util.*;

public class main_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        for(int i = 1; i <= k; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String,Integer> map = new HashMap<>();
            for(int j = 1; j <= n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String category = st.nextToken();

                
                map.put(category,map.getOrDefault(category, 0) +1);
            }
            int answer = 1;
            for(int m:map.values()){
                answer = answer*(m+1);
            }
            bw.write(String.valueOf(answer-1)+"\n");
        }
        bw.flush();
        bw.close();
    }
}