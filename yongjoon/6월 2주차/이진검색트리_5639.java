import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.w3c.dom.Node;

public class 이진검색트리_5639 {
    static class Node{
        int num;
        Node left, right;

        Node(int num){
            this.num=num;
        }
        Node(int num,Node left,Node right){
            this.num=num;
            this.left=left;
            this.right=right;
        }
        void insert(int n){
            if(n<this.num){ //현재 노드보다 작으면 왼쪽 서브트리로
                if(this.left==null)
                    this.left=new Node(n);
                else this.left.insert(n);
            }else{ //현재 노드보다 크면 오른쪽 서브트리로
                if(this.right==null)
                    this.right=new Node(n);
                else this.right.insert(n);
            }
        }
    }

    static BufferedWriter bw;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Node root=new Node(Integer.parseInt(br.readLine())); 
        String s;
        while (true){
            s=br.readLine();
            if(s==null||s.equals("")) break;
            root.insert(Integer.parseInt(s));
        }
        postOrder(root);
    }

    static void postOrder(Node node)throws IOException{
        if(node==null) return;
        postOrder(node.left); 
        postOrder(node.right); 
        bw.write(String.valueOf(node.num)+ "\n");
        bw.flush();
    }
    
}
