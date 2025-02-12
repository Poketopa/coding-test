
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        String temp = "";
        x:
        while(true) {
            String str = br.readLine();
            if(str.charAt(str.length()-1) != '.'){
                temp+=str;
                continue;
            }
            else temp+=str;
            if (temp.equals(".")) return;
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == '(') {
                    stack.add('(');
                }
                else if (temp.charAt(i) == '[') {
                    stack.add('[');
                }
                else if (temp.charAt(i) == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        System.out.println("no");
                        temp = "";
                        continue x;
                    }
                }
                else if (temp.charAt(i) == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        System.out.println("no");
                        temp = "";
                        continue x;
                    }
                }
            }
            if(stack.isEmpty()) System.out.println("yes");
            else System.out.println("no");
            temp = "";
        }


    }
}