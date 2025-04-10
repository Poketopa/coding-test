
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int remove = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=number;i++){
            queue.add(i);
        }
        System.out.print("<");
        while(!queue.isEmpty()){
            for(int i =0;i<remove-1;i++){
                queue.add(queue.poll());
            }
            System.out.print(queue.poll());
            if(queue.size() != 0){
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}