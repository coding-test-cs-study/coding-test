import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class main_25501 {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String []arr = new String[n];

        for(int i = 0; i < n; i++){
            arr[i] = br.readLine();
        }

        for(int i = 0; i < n; i++){
            count = 0;
            bw.write(String.valueOf(isPalindrome(arr[i])));
            bw.write(" ");
            bw.write(String.valueOf(count));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    public static int recursion(String s, int l, int r){
        count++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
}
