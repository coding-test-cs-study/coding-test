// 참고
// https://velog.io/@topqr123q/%EB%B0%B1%EC%A4%80-2504%EB%B2%88%EC%9E%90%EB%B0%94
import java.io.*;
import java.util.Stack;

public class 괄호의값 {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String input = bfr.readLine();

        Stack<Character> stk = new Stack<>();
        int result = 0;
        int tmp = 1;

        L1: for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);

            switch(c){
                case '(':
                    stk.add('(');
                    tmp *= 2;
                    break;

                case '[':
                    stk.add('[');
                    tmp *= 3;
                    break;

                case ')':
                    if(stk.isEmpty() || stk.peek()!='('){
                        result = 0;
                        break L1;
                    }
                    else{
                        if(input.charAt(i-1)=='(')  result += tmp;
                        stk.pop();
                        tmp /= 2;
                    }
                    break;

                case ']':
                    if(stk.isEmpty() || stk.peek()!='['){
                        result = 0;
                        break L1;
                    }
                    else{
                        if(input.charAt(i-1)=='[')  result += tmp;
                        stk.pop();
                        tmp /= 3;
                    }
                    break;
            }
        }

        if(!stk.isEmpty()) System.out.println(0);
        else System.out.println(result);
    }
}