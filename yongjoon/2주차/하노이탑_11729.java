import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 하노이탑_11729 {
    static int count;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        hanoi(n, 1, 3, 2);

        bw.write(String.valueOf(count) + "\n");
        bw.write(String.valueOf(sb));
        bw.flush();
    }

    public static void hanoi(int n, int from, int to, int other) {
		if (n == 0)
			return;
		else {
			count++;
			hanoi(n - 1, from, other, to);
			sb.append(from + " " + to + "\n");
			hanoi(n - 1, other, to, from);
		}
	}

}
