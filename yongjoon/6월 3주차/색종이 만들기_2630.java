import java.io.*;
import java.util.StringTokenizer;


public class main_2630 {
    public static int blue = 0;
    public static int white = 0;
    public static int [][]arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        parase(0,0,N);

        bw.write(String.valueOf(white));
        bw.write("\n");
        bw.write(String.valueOf(blue));
        bw.flush();
        bw.close();
    }
    public static void parase(int row, int col, int n){
        if(colorcheck(row,col,n)){
            if(arr[row][col] == 0){
                white++;
            }
            else{
                blue++;
            }
            return;
        }
        parase(row,col,n/2);
        parase(row+n/2,col,n/2);
        parase(row,col+n/2,n/2);
        parase(row+n/2,col+n/2,n/2);
    }
    public static boolean colorcheck(int row, int col, int n){
        int key = arr[row][col];
        for(int i=row;i<row+n;i++){
            for(int j=col;j<col+n;j++){
                if(arr[i][j] != key){
                    return false;
                }
            }
        }
        return true;
    }

}
