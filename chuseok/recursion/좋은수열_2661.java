import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        backtracking("");
    }

    private static void backtracking(String str) {
        if (str.length() == N) {
            System.out.print(str);
            System.exit(0);
        }
        for(int i = 1; i <= 3; i++) {
            if(isSame(str + i)) {
                backtracking(str + i);
            }
        }
    }

    private static boolean isSame(String str) {
        int len = str.length() / 2;
        for (int i = 1; i <= len; i++) {
            if(str.substring(str.length()-i).equals(str.substring(str.length() - 2 * i, str.length() -i)))
                return false;

        }
        return true;
    }
}
