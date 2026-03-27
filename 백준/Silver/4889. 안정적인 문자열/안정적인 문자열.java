import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        while(true){
            String temp = br.readLine();
            if(temp.charAt(0) == '-'){
                return;
            }

            Stack<Character> stack = new Stack<>();
            for(int i=0;i<temp.length();i++){
                if(stack.isEmpty()) stack.add(temp.charAt(i));
                else {
                    char a = stack.peek();
                    char b = temp.charAt(i);

                    if(a == '{' && b == '}') {
                        stack.pop();
                    } else {
                        stack.add(b);
                    }
                }
            }
            int answer = 0;
            while(!stack.isEmpty()){
                char a = stack.pop();
                char b = stack.pop();
                if(a == '{') answer++;
                if(b == '}') answer++;
            }
            count++;
            System.out.println(count + ". " + answer);
        }
    }
}
