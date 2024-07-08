//import java.io.*;
//import java.util.*;
//
//public class main_5397 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int L = Integer.parseInt(br.readLine());
//
//        String []lines = new String[L];
//        for(int i = 0; i < L; i++)
//        {
//            lines[i] = br.readLine();
//        }
//
//        for(int i = 0; i < L; i++){
//            List<Character> list = new ArrayList<Character>();
//            int index = 0;
//            for(int j = 0; j < lines[i].length(); j++) {
//                char c = lines[i].charAt(j);
//                if(c == '<') {
//                    if(index > 0) {
//                        index--;
//                    }
//                }
//                else if(c == '>') {
//                    if(index < list.size()) {
//                        index++;
//                    }
//                }
//                else if(c == '-'){
//                    if(!list.isEmpty()){
//                        if(index == list.size()){
//                            list.remove(index-1);
//                        }
//                        else{
//                            list.remove(index);
//                        }
//                    }
//                }
//                else{
//                    list.add(index,c);
//                    index++;
//                }
//            }
//            for(int j = 0; j < list.size(); j++) {
//                bw.write(list.get(j));
//            }
//            bw.newLine();
//        }
//        bw.flush();
//        bw.close();
//    }
//}

import java.io.*;
import java.util.Stack;


public class main_5397 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            String line = br.readLine();
            Stack<Character> pwdStack = new Stack<>();
            Stack<Character> deleteStack = new Stack<>();
            int cursor = 0;
            for(int j=0; j<line.length(); j++) {
                char pos = line.charAt(j);
                if(pos == '<') {
                    if(!pwdStack.isEmpty()) {
                        deleteStack.push(pwdStack.pop());
                    }
                }else if(pos == '>') {
                    if(!deleteStack.isEmpty()) {
                        pwdStack.push(deleteStack.pop());
                    }
                }else if(pos == '-') {
                    if(!pwdStack.isEmpty()) {
                        pwdStack.pop();
                    }
                }else {
                    pwdStack.push(line.charAt(j));
                }
            }

            while(!deleteStack.isEmpty()) {
                pwdStack.push(deleteStack.pop());
            }

            for(int k=0; k<pwdStack.size(); k++) {
                bw.write(pwdStack.get(k));
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();

    }
}