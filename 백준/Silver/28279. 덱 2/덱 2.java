
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            if(temp == 1){
                int b = Integer.parseInt(st.nextToken());
                deque.addFirst(b);
            }
            else if(temp == 2){
                int b = Integer.parseInt(st.nextToken());
                deque.addLast(b);
            }
            else if(temp == 3){
                if(deque.isEmpty()) System.out.println("-1");
                else System.out.println(deque.pollFirst());
            }
            else if(temp == 4){
                if(deque.isEmpty()) System.out.println("-1");
                else System.out.println(deque.pollLast());
            }
            else if(temp == 5) System.out.println(deque.size());
            else if(temp == 6){
                if(deque.isEmpty()) System.out.println("1");
                else System.out.println("0");
            }
            else if(temp == 7){
                if(deque.isEmpty()) System.out.println("-1");
                else System.out.println(deque.peekFirst());
            }
            else{
                if(deque.isEmpty()) System.out.println("-1");
                else System.out.println(deque.peekLast());
            }
        }
    }
}