import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class 곱셈_1629 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());
        long answer = mul(a,b,c);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }

    public static long mul(long a, long b, long c){
        if(b == 1){
            return a%c;
        }
        long temp = mul(a,b/2,c);
        if(b%2 == 1){
            return(temp*temp%c)*a%c;
        }
        return temp*temp%c;
    }
}
