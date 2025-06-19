import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=input;i++) queue.add(i);

        while(queue.size() != 1){
            System.out.print(queue.poll()+" ");
            int temp = queue.poll();
            queue.add(temp);
        }
        System.out.print(queue.peek());
    }
}