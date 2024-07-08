//import java.io.*;
//import java.util.*;
//
//
//public class main_1654 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int K = Integer.parseInt(st.nextToken());
//        int N = Integer.parseInt(st.nextToken());
//
//        int []arr = new int[K];
//        for(int i = 0; i < K; i++){
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//
//        int length = Arrays.stream(arr).max().getAsInt();
//
//        while(true){
//            int index = 0;
//            for(int i = 0; i < K; i++){
//                index = index + arr[i] / length;
//            }
//            if(index == N){
//                break;
//            }
//            else {
//                length--;
//            }
//        }
//        bw.write(String.valueOf(length));
//        bw.flush();
//        bw.close();
//    }
//}

import java.io.*;
import java.util.*;
public class main_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lines = new int[K];
        for (int i = 0; i < K; i++){
            lines[i] = Integer.parseInt(in.readLine());
        }
        Arrays.sort(lines);

        long right = lines[K - 1];
        long left = 1;
        long count, half;

        while (left <= right) {
            count = 0;
            half = (left + right) / 2;

            for (int i = 0; i < K; i++){
                count += lines[i] / half;
            }

            if (count < N){
                right = half - 1;
            }
            else{
                left = half + 1;
            }
        }

        System.out.println(right);
    }
}