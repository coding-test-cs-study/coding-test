//import java.util.*;
//import java.io.*;
//public class main_2493 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        //StringBuilder sb = new StringBuilder();
//        int n= Integer.parseInt(br.readLine());
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int [] arr = new int[n];
//        int [] arr2 = new int[n];
//
//        for(int i=0;i<n;i++){
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        for(int i=n-1;i>0;i--){
//            for(int j=i-1;j>0;j--){
//                if(arr[i]<=arr[j]){
//                    //sb.append(j+1+" ");
//                    arr2[i] = j+1;
//                    break;
//                }
//                //sb.append(0 + " ");
//                arr2[i] = 0;
//            }
//        }
//        for(int i=0;i<n;i++){
//            bw.write(arr2[i]+" ");
//        }
//       // bw.write(sb.toString());
//        bw.flush();
//        bw.close();
//
//    }
//}

import java.io.*;
import java.util.*;


public class main_2493 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Stack<int[]> s = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(s.isEmpty()) {
                sb.append(0+" ");
            }
            else{
                while(true) {
                    int[] data = s.peek();
                    int tIdx = data[0];
                    int tHeight = data[1];
                    if(tHeight > num) {
                        sb.append(tIdx+" ");
                        break;
                    }else {
                        s.pop();
                    }

                    if(s.isEmpty()) {
                        sb.append(0+" ");
                        break;
                    }
                }
            }
            s.push(new int[] {i+1, num});
        }
        System.out.println(sb.toString());
    }
}
