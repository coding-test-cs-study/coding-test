import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> left = new ArrayDeque<>(), right = new ArrayDeque<>();

        int T = Integer.parseInt(br.readLine());
        String input;
        char ch;
        while(T --> 0) {
            input = br.readLine();
            for (int i = 0; i < input.length(); i++) {
                ch = input.charAt(i);
                if(ch == '<') {
                    if(left.isEmpty()) continue;
                    right.addFirst(left.pollLast());
                } else if(ch == '>') {
                    if(right.isEmpty()) continue;
                    left.add(right.pollFirst());
                } else if(ch == '-') {
                    left.pollLast();
                } else left.add(ch);
            }
            while(!left.isEmpty()) sb.append(left.pop());
            while(!right.isEmpty()) sb.append(right.pop());
            sb.append("\n");
            left.clear();
            right.clear();
        }
        System.out.print(sb);
    }
}