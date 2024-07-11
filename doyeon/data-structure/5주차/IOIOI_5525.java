// import java.io.*;
// import java.util.Stack;

// public class Main {

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//         int n = Integer.parseInt(br.readLine());
//         int m = Integer.parseInt(br.readLine());

//         String s = br.readLine();

//         StringBuilder target = new StringBuilder();

//         target.append('I');
//         for(int i=0; i<n; i++){
//             target.append("OI");
//         }
// //        System.out.println(target.toString());
//         int answer=0;
//         for(int i=0; i<s.length()-target.length()+1; i++){
//             boolean trigger = true;
//             for(int j=0; j<target.length(); j++){
//                 if(s.charAt(i+j) != target.charAt(j)){
//                     trigger = false;
//                     break;
//                 }
//             }
//             if(trigger){
//                 answer++;
//             }
//         }
//         bw.write(answer+"");

//         bw.close();
//     }
// }


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