import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        String str = br.readLine();
        Stack<Integer> stack = new Stack<>();
        String[] input = str.split("");
        int count = 0;
        for(int i=0;i<input.length;i++){
            // 여는거면 넣음
            if(input[i].equals("(")){
                stack.add(1);
            } else{
                if(input[i-1].equals("(")){
                    stack.pop();
                    count += stack.size();
                }
                else{
                    stack.pop();
                    count++;
                }
            }
            // 닫는거면 경우의 수
            // 이전에 열었으면 (레이저면) 숫자 더함
            // 이전에 여는게 아니었으면 그냥 pop
        }
        System.out.print(count);
    }
}
