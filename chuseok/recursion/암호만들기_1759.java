import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    static int L;
    static int C;
    static char[] chars;
    static StringBuilder ans;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());//문자의 길이
        C = Integer.parseInt(st.nextToken());//c개의 문자 조합

        ans = new StringBuilder();
        visited = new boolean[C];

        chars = new char[C];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(chars);

        backtrack(0, 0, new StringBuilder(), 0, 0);

        System.out.println(ans);
    }
    private static void backtrack(int start, int cnt, StringBuilder currs, int aeiou, int other) {//len 4
        if (cnt == L) {
            if(aeiou != 0 && other > 1) {
                ans.append(currs).append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            currs.append(chars[i]);

            if(chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
                backtrack(i + 1, cnt + 1, currs,aeiou + 1, other);
            }
            else {
                backtrack(i + 1, cnt + 1, currs, aeiou, other + 1);
            }

            currs.setLength(currs.length() - 1);
        }
    }
}
