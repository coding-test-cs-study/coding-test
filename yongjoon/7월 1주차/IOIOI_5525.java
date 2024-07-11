//import java.io.BufferedWriter;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//
//public class main_5525 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int N = Integer.parseInt(br.readLine());
//        int M = Integer.parseInt(br.readLine());
//
//        String S = br.readLine();
//
//        String p = "I";
//        for(int i = 0; i < N; i++){
//            p = p+"OI";
//        }
//        int cnt = 0;
//        for(int i = 0; i < M-(2*N+1); i++){
//            if(S.charAt(i) != 'I'){
//                continue;
//            }
//            if(S.substring(i,i+(2*N+1)).equals(p)){
//                cnt++;
//            }
//        }
//        bw.write(String.valueOf(cnt));
//        bw.flush();
//        bw.close();
//    }
//}


import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class main_5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        String S = br.readLine();

        int cnt = 0;
        int answer = 0;

        for(int i = 1; i < M-1; i++){
            if(S.charAt(i-1) == 'I' &&S.charAt(i) == 'O' && S.charAt(i+1) == 'I'){
                cnt++;
                if(cnt == N){
                    cnt--;
                    answer++;
                }
                i++;
            }
            else{
                cnt = 0;
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
