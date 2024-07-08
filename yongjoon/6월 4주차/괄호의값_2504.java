//import java.io.*;
//import java.util.*;
//
//public class main_2504 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        String arr = br.readLine();
//
//        int a = 0;
//        int b = 0;
//        int c = 0;
//        int d = 0;
//        for (int i = 0; i < arr.length(); i++) {
//            if(arr.charAt(i) == '(') {a++;}
//            else if(arr.charAt(i) == ')') {b++;}
//            else if(arr.charAt(i) == '[') {c++;}
//            else if(arr.charAt(i) == ']') {d++;}
//        }
//        if(a !=b || c !=d){
//            bw.write("0");
//        }
//        else {
//            List<Character> list = new ArrayList<Character>();
//            for (int i = 0; i < arr.length(); i++) {
//                if (arr.charAt(i) == '(' && arr.charAt(i + 1) == ')') {
//                    list.add('2');
//                    i++;
//                } else if (arr.charAt(i) == '[' && arr.charAt(i + 1) == ']') {
//                    list.add('3');
//                    i++;
//                } else {
//                    list.add(arr.charAt(i));
//                }
//            }
//            //Character.isDigit()
//            while(list.size() == 1){
//                for(int i=0;i<list.size();i++){
//                    if (arr.charAt(i) == '(' && arr.charAt(i + 1) == ')') {
//                        list.set(i,'2');
//                        list.remove(i+1);
//                    } else if (arr.charAt(i) == '[' && arr.charAt(i + 1) == ']') {
//                        list.set(i,'3');
//                        list.remove(i+1);
//                    } else if(Character.isDigit(arr.charAt(i)) && Character.isDigit(arr.charAt(i+1))){
//                        int num = (arr.charAt(i)-'0')+(arr.charAt(i+1)-'0');
//                        list.set(i,(char)num);
//                        list.remove(i+1);
//                    } else if(arr.charAt(i) == '(' && arr.charAt(i + 2) == ')' && Character.isDigit(arr.charAt(i + 1))){
//                        int num = (arr.charAt(i+1)-'0')*2;
//                        list.set(i,(char)num);
//                        list.remove(i+1);
//                        list.remove(i+2);
//                    } else if(arr.charAt(i) == '[' && arr.charAt(i + 2) == ']' && Character.isDigit(arr.charAt(i + 1))){
//                        int num = (arr.charAt(i+1)-'0')*3;
//                        list.set(i,(char)num);
//                        list.remove(i+1);
//                        list.remove(i+2);
//                    }else{
//                        continue;
//                    }
//                }
//            }
//            bw.write(list.get(0));
//        }
//        bw.flush();
//        bw.close();
//    }
//}


import java.io.*;
import java.util.Stack;

public class main_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String  N = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int value = 1;

        for(int i = 0; i < N.length(); i++) {
            if(N.charAt(i) == '(') {
                stack.push(N.charAt(i));
                value *= 2; //( : 2
            } else if(N.charAt(i) == '[') {
                stack.push(N.charAt(i));
                value *= 3; //[ : 3
            } else if(N.charAt(i) == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                } else if(N.charAt(i-1) == '(') {
                    result += value;
                }
                stack.pop();
                value /= 2;
            } else if(N.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                } else if (N.charAt(i - 1) == '[') {
                    result += value;
                }
                stack.pop();
                value /= 3;
            }
        }
        if(!stack.isEmpty()) sb.append(0).append("\n");
        else sb.append(result).append("\n");
        System.out.println(sb);
    }
}