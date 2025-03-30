
import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        String target = br.readLine();
        String start = br.readLine();
        StringBuilder sb1 = new StringBuilder(start);


        dfs(sb1,  target);
        if(flag) System.out.println("1");
        else System.out.println("0");
    }
    private static void dfs(StringBuilder start, String target){
        if(start.toString().equals(target)){
            flag = true;
            return;
        }
        if(start.length() < target.length()) return;
        if(flag) return;
        if(start.charAt(start.length()-1) == 'A'){
            StringBuilder next = new StringBuilder(start);
            next.deleteCharAt(next.length() - 1);  // A 제거
            dfs(next, target);
        }
        if(start.charAt(start.length()-1 )== 'B'){
            StringBuilder next = new StringBuilder(start);
            next.deleteCharAt(next.length() - 1); // 마지막 문자 'B' 제거
            next.reverse();
            dfs(next, target);
        }
    }
}