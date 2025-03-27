

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<input;i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0) stack.pop();
            else stack.add(temp);
        }
        int sum=0;
        while(!stack.isEmpty()) sum += stack.pop();
        System.out.println(sum);
    }
}