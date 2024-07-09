import java.io.*;
import java.util.*;

public class main_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();

        for(int i=0;i<N;i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            map.put(st1.nextToken(), st1.nextToken());
        }

        String []pick = new String[M];
        for(int i=0;i<M;i++){
            pick[i] = br.readLine();
            bw.write(map.get(pick[i])+"\n");
        }


        bw.flush();
        bw.close();
    }
}
