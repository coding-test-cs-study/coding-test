import java.util.*;
import java.io.*;

class Temp {
    static int n;
    static int m;
    static String[] alpha;
    static Set<String> answer = new HashSet<>();
    static Set<Character> gather = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        alpha = br.readLine().split(" ");

        Arrays.sort(alpha);
//        System.out.println(Arrays.toString(alpha));
        backtrack(new StringBuilder(), 0, 0, 0);

        answer.stream().sorted().forEach(System.out::println);
    }

    static void backtrack(StringBuilder s, int index, int gatherCount, int vowelCount) {
        if (s.length() == n) {
            if (gatherCount >= 1 && vowelCount >= 2) {
                answer.add(s.toString());
            }
            return;
        }

        for (int i = index; i < m; i++) {
            char currentChar = alpha[i].charAt(0);
            s.append(currentChar);
            if (gather.contains(currentChar)) {
                backtrack(s, i + 1, gatherCount + 1, vowelCount);
            } else {
                backtrack(s, i + 1, gatherCount, vowelCount + 1);
            }
            s.deleteCharAt(s.length() - 1);
        }
    }
}

// import java.util.*;
// import java.io.*;
// class Temp {
//     // 4 6
//     // a t c i s w
//     static int n;
//     static int m;
//     static String[] alpha;
//     static Set<String> answer = new HashSet<>();
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//         String[] temp = br.readLine().split(" ");
//         n = Integer.parseInt(temp[0]);
//         m = Integer.parseInt(temp[1]);
//         alpha = br.readLine().split(" ");

// //        System.out.println(Arrays.toString(alpha));
// //        System.out.println(alpha[0].getClass().getName());

//         boolean[] visited = new boolean[m];
//         backtrack(new StringBuilder(), 0, 0, visited);

//         answer.stream().sorted().forEach(System.out::println);
//     }
//     static void backtrack(StringBuilder s, int gatherCount, int vowelCount, boolean[] visited) throws IOException{
// //        System.out.println(s.toString() + gatherCount + vowelCount);
        
//         if(s.length() == n && gatherCount>=1 && vowelCount>=2){
// //            System.out.println(s);
//             char[] temp = s.toString().toCharArray();
//             Arrays.sort(temp);
//             answer.add(new String(temp));
// //            System.out.println(answer);
//             return;
// //            System.exit(0);
//         }
//         for(int i = 0; i<m; i++){
//             if(visited[i]) continue;

//             visited[i] = true;
// //            if(alpha[i]=='a' || alpha[i]=='e' || alpha[i]=='i' || alpha[i]=='o' || alpha[i]=='u'){
//             if(alpha[i].equals("a") || alpha[i].equals("e") ||
//                     alpha[i].equals("i") || alpha[i].equals("o") || alpha[i].equals("u")){
// //                System.out.println("모음");
//                     gatherCount++;
//                 }else{
//                     vowelCount++;
//                 }
//             if(s.length()<n) backtrack(s.append(alpha[i]), gatherCount, vowelCount, visited);

//             visited[i]=false;
//             s.deleteCharAt(s.length()-1);
//         }
//     }
// }