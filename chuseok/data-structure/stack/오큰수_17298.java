import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        int[] arr = new int[T];
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            int element = Integer.parseInt(st.nextToken());
            arr[i] = element;
        }
        for (int i = 0; i < T; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }
        for (int i = 0; i < T; i++) {
            sb.append(arr[i]).append(" ");
        }System.out.print(sb);
    }
}