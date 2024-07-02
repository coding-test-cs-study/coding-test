import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 별찍기_2447 {
    static String[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

        arr = new String[N][N];

        star(0, 0, N);

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                bw.write(arr[i][j] != null ? arr[i][j] : " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }

    public static void star(int x, int y, int size) {
        if(size == 1){
            arr[x][y] = "*";
            return;
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(!(i==1 && j==1)) 
                    star(x + i*size/3, y + j*size/3, size/3);
            }
        }
    }
}
