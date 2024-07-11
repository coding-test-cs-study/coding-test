import java.io.*;

public class main_1992 {
    static int [][]arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt((br.readLine()));
        arr = new int[n][n];
        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<n;j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        dividing(0,0,n);
    }
    static void dividing(int row, int col, int n){

        if(checking(row,col,n)){
            if(arr[row][col]==0){
                System.out.print(0);
            }
            else{
                System.out.print(1);
            }
            return;
        }
        System.out.print("(");
        dividing(row,col,n/2);
        dividing(row,col+n/2,n/2);
        dividing(row+n/2,col,n/2);
        dividing(row+n/2,col+n/2,n/2);
        System.out.print(")");
    }
    static boolean checking(int row, int col, int n){
        int key = arr[row][col];
        for(int i=row;i<row+n;i++){
            for(int j=col;j<col+n;j++){
                if(arr[i][j]!=key){
                    return false;
                }
            }
        }
        return true;
    }
}

