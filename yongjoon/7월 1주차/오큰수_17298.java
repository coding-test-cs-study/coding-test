import java.io.*;
import java.util.*;

public class main_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int [] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] =Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<N;i++){
            while(!stack.isEmpty() && arr[i]>arr[stack.peek()]){
                 arr[stack.pop()]=arr[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }
        for(int i=0;i<N;i++){
            bw.write(String.valueOf(arr[i])+" ");
        }

        bw.flush();
        bw.close();
    }
}
