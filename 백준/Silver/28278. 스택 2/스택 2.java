

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        Stack<Integer> queue = new Stack<>();
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a == 1) queue.add(Integer.parseInt(st.nextToken()));
            if(a == 2){
                if(queue.isEmpty())System.out.println("-1");
                else System.out.println(queue.pop());
            }
            if(a == 3) System.out.println(queue.size());
            if(a == 4){
                if(queue.isEmpty()) System.out.println("1");
                else System.out.println("0");
            }
            if(a == 5){
                if(queue.isEmpty()) System.out.println("-1");
                else System.out.println(queue.peek());
            }
        }
    }
}